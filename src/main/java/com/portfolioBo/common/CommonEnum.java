package com.portfolioBo.common;

public class CommonEnum {

    // 주문 상태
    public enum OrderStatus {
        PENDING,    // 주문이 접수되었지만 아직 처리되지 않음 , 주문취소가능
        PROCESSING, // 주문이 처리 중임
        SHIPPED,    // 주문이 발송됨
        COMPLETED,  // 주문이 고객에게 배송 완료됨 완료
        CANCELLED   // 주문이 취소됨
    }
    
    // 주문 아이템 상태
    public enum OrderItemStatus {
        PENDING,    // 주문이 접수되었지만 아직 처리되지 않음 , 특정 아이템 주문취소 가능
        PROCESSING, // 주문이 처리 중임
        SHIPPED,    // 주문이 발송됨
        COMPLETED,  // 주문이 고객에게 배송 완료됨 완료
        CANCELLED   // 주문이 취소됨
    }
    public enum reviewSortByStatus {
    	LATEST,
    	OLDEST,
    	HIGHRATING,
    	LOWRATING
    }
    public enum orderItemReviewListType {
    	REVIEWABLE,	//리뷰가 안쓰인 주문상품
    	REVIEWED	//리뷰가 쓰인 주문상품
    }
    public enum FileReferenceType {
    	PRODUCT_IMG
    }
}

