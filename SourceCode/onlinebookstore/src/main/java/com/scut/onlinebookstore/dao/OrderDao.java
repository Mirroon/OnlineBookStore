package com.scut.onlinebookstore.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.scut.onlinebookstore.models.*;

@Repository
public interface OrderDao {
	
	void createOrder(Integer orderId, Integer userId, Double totalprice, Integer status, String orderTime, Boolean isCanceled);
	
	List<Order> findByUser(Integer userId);
	
	//void findByBook(Integer bookISBN);
	
	List<OrderItem> findById(Integer orderId);
	
	void updateStatus(Integer orderId, Integer nowStstus);
	
	void cancel(Integer orderId);

}
