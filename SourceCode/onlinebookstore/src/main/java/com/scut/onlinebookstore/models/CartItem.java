package com.scut.onlinebookstore.models;

public class CartItem {
	
	private Integer userId;
	
	private Integer bookISBN;
	
	private Integer count;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(Integer bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.bookISBN = count;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", bookISBN=").append(bookISBN);
        sb.append(", count=").append(count);
        sb.append("]");
        return sb.toString();
    }

}
