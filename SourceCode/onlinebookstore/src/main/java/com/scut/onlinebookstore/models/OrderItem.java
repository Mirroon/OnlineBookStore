package com.scut.onlinebookstore.models;

public class OrderItem {

	private String bookISBN;
	
	private Integer count;
	
	private Integer orderId;
	
	public String getBookISBN() {
		return bookISBN;
	}
	
	public void setBookISBN(String isbn) {
		this.bookISBN = isbn;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookISBN=").append(bookISBN);
        sb.append(", count=").append(count);
        sb.append(", orderId=").append(orderId);
        sb.append("]");
        return sb.toString();
    }
	
}
