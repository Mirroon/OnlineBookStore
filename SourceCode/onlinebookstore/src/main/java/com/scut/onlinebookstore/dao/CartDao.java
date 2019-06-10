package com.scut.onlinebookstore.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {

	void addCart(Integer userId, Integer bookISBN, Integer count);
	
	void removeFromCart(Integer userId, Integer bookISBN);
	
	void clearCart(Integer userId);
}
