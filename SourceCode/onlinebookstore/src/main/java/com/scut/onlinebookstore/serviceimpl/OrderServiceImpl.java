package com.scut.onlinebookstore.serviceimpl;

import com.scut.onlinebookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scut.onlinebookstore.DAO.*;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
    @Override
    public void createOrder() {
    	orderDao.createOrder();
    }
	
    @Override
    public void findByUser(Integer userId) {
    	orderDao.findByUser(userId);
    }
	
    @Override
    public void findByBook(Integer bookISBN) {
    	orderDao.findByBook(bookISBN);
    }
	
    @Override
    public void updateStatus(Integer orderId, Integer nowStstus) {
    	orderDao.updateStatus(orderId, nowStstus);
    }
	
    @Override
    public void cancel(Integer orderId) {
    	orderDao.cancel(orderId);
    }

}
