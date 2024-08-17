package com.portfolioBo.file.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portfolioBo.common.CommonEnum;
import com.portfolioBo.exception.CustomException;
import com.portfolioBo.file.dao.FileDao;
import com.portfolioBo.file.dto.FileDto.FileSaveQuery;
import com.portfolioBo.file.dto.FileServiceDto.FileSaveServiceDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
	
	
	@Value("${img.upload.dir}")
    private String imageDir;
	
	@Value("${img.upload.size}")
    private int imageMaxSize;
	
	@Autowired
	FileDao fileDao;
	
	@Override
	public boolean saveImgFile(FileSaveServiceDto rq) throws IllegalStateException, IOException {
		InputStream inputStream = null;

		try {			
			MultipartFile file=rq.getFile();
			if(file.isEmpty()) {
				throw new CustomException("업로드 파일이 비어있습니다");
			}
	        Path directoryPath = Paths.get(imageDir).normalize();
	        File directory = directoryPath.toFile();
	        if (!directory.exists()) {
	            boolean dirCreated = directory.mkdirs(); // 디렉토리 생성
	            if (!dirCreated) {
	                throw new IOException("디렉토리를 생성할 수 없습니다: " + directoryPath);
	            }
	        }
	        
	        if (file.getSize() > imageMaxSize) {
	            throw new CustomException("파일 크기가 너무 큽니다. 최대 5MB입니다.");
	        }

			String fileExtension=getExtensionFromContentType(file.getContentType());
			if(fileExtension==null) {
	            throw new CustomException("허용되지 않은 파일 형식입니다. JPEG 또는 PNG 파일만 업로드 가능합니다.");
			}
	        String uniqueFileId = UUID.randomUUID().toString()+ "_" + System.currentTimeMillis();
	        
	        Path originalFilePath = Paths.get(imageDir).resolve(uniqueFileId+fileExtension).normalize();
	        File originalFile = originalFilePath.toFile();
	        inputStream=file.getInputStream();
	        BufferedImage uploadImage = ImageIO.read(inputStream);
	        BufferedImage resizedImage = resizeImage(uploadImage, 400, 400);
	        ImageIO.write(resizedImage, fileExtension.replace(".", ""), originalFile);

			FileSaveQuery imgFileSaveQuery=new FileSaveQuery();
			imgFileSaveQuery.setFileId(uniqueFileId);
			imgFileSaveQuery.setFileName(file.getOriginalFilename());
			imgFileSaveQuery.setFilePath(originalFilePath.toString());
			imgFileSaveQuery.setFileSize(originalFile.length());
			imgFileSaveQuery.setFileType(fileExtension.replace(".", ""));
			imgFileSaveQuery.setReferenceId(rq.getReferenceId());
			imgFileSaveQuery.setReferenceType(CommonEnum.FileReferenceType.PRODUCT_IMG.name());
			fileDao.insertFile(imgFileSaveQuery);
			return true;
		}catch(IOException e) {
			log.error(e.toString());
			throw new CustomException("이미지 처리 중 오류가 발생했습니다.");
		}finally {
		    if (inputStream != null) {
		        try {
		            inputStream.close();
		            log.error("인풋스트림 close");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
	    Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	    Graphics2D g2d = resizedImage.createGraphics();
	    g2d.drawImage(scaledImage, 0, 0, null);
	    g2d.dispose();

	    return resizedImage;
	}
    private String getExtensionFromContentType(String contentType) {
        if ("image/jpeg".equals(contentType)) {
            return ".jpg";
        } else if ("image/png".equals(contentType)) {
            return ".png";
        } else {
        	return null;
        }
        
    }

}
