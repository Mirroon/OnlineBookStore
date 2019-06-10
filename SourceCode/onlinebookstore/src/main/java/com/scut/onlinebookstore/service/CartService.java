package com.scut.onlinebookstore.service;

import com.scut.onlinebookstore.models.*;

public interface CartService {
	
	void addCart(Integer userId, Integer bookISBN, Integer count);
	
	void removeFromCart(Integer userId, Integer bookISBN);
	
	void clearCart(Integer userId);

}
