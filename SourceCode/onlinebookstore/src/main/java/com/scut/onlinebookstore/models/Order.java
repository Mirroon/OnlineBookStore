package com.scut.onlinebookstore.models;

/**
 * @author: xiekun
 * @createTime: 2019/6/7 19:50
 * @version: 1.0
 * @description:
 */

public class Order {
	
	private Integer orderId;
	
	private Integer userId;
	
	private Boolean isCanceled;
	
	private Double totalPrice;
			
	private Integer status;
	//status：1未支付，2待发货，3待收货，4待评价,-1已取消
	private String orderTime;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Boolean getIsCanceled() {
		return isCanceled;
	}
	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", status=").append(status);
        sb.append(", orderTime=").append(orderTime);
        sb.append("]");
        return sb.toString();
    }

}
