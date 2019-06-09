package com.scut.onlinebookstore.DAO;

import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {

	void addCart(Integer userId, Integer bookISBN, Integer count);
	
	void removeFromCart(Integer userId, Integer bookISBN, Integer count);
	
	void clearCart(Integer userId);
}
