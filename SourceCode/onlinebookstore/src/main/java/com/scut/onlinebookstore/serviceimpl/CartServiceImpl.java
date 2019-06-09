package com.scut.onlinebookstore.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.scut.onlinebookstore.service.*;

public class CartServiceImpl implements CartService{

	
	@Autowired
    private CartDao cartDao;
	
    @Override
	public void addCart(Integer userId, Integer bookISBN, Integer count) {
		
	}
	
    @Override
	public void removeFromCart(Integer userId, Integer bookISBN, Integer count) {
		
	}
	
    @Override
	public void clearCart(Integer userId) {
		
	}
	
}
