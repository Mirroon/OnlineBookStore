package com.scut.onlinebookstore.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scut.onlinebookstore.service.*;
import com.scut.onlinebookstore.DAO.*;

@Service
public class CartServiceImpl implements CartService{

	
	@Autowired
    private CartDao cartDao;
	
    @Override
	public void addCart(Integer userId, Integer bookISBN, Integer count) {
		cartDao.addCart(userId, bookISBN, count);
	}
	
    @Override
	public void removeFromCart(Integer userId, Integer bookISBN, Integer count) {
		cartDao.removeFromCart(userId, bookISBN, count);
	}
	
    @Override
	public void clearCart(Integer userId) {
		cartDao.clearCart(userId);
	}
	
}
