package com.scut.onlinebookstore.service;

import java.util.List;
import com.scut.onlinebookstore.models.*;


public interface OrderService {
	
	void createOrder(Integer orderId, Integer userId, Double totalprice, Integer status, String orderTime, Boolean isCanceled);
	
	List<Order> findByUser(Integer userId);
	
	//void findByBook(Integer bookISBN);
	
	List<OrderItem> findById(Integer orderId);
	
	void updateStatus(Integer orderId, Integer nowStstus);
	
	void cancel(Integer orderId);
	

}
