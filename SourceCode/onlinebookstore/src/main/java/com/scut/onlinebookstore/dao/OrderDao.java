package com.scut.onlinebookstore.DAO;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
	
	void createOrder();
	
	void findByUser(Integer userId);
	
	void findByBook(Integer bookISBN);
	
	void updateStatus(Integer orderId, Integer nowStstus);
	
	void cancel(Integer orderId);

}
