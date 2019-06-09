package com.scut.onlinebookstore.service;

public interface OrderService {
	
	void createOrder();
	
	void findByUser(Integer userId);
	
	void findByBook(Integer bookISBN);
	
	void updateStatus(Integer orderId, Integer nowStstus);
	
	void cancel(Integer orderId);

}
