package com.scut.onlinebookstore.serviceimpl;

import com.scut.onlinebookstore.service.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scut.onlinebookstore.dao.*;
import com.scut.onlinebookstore.models.Order;
import com.scut.onlinebookstore.models.OrderItem;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
    @Override
    public void createOrder(Integer orderId, Integer userId, Double totalprice, Integer status, String orderTime, Boolean isCanceled) {
    	orderDao.createOrder(orderId,  userId,  totalprice,  status,  orderTime,  isCanceled);
    }
	
    @Override
    public List<Order> findByUser(Integer userId) {
    	return orderDao.findByUser(userId);
    }
	
    /*@Override
    public void findByBook(Integer bookISBN) {
    	orderDao.findByBook(bookISBN);
    }*/
    
    @Override
    public List<OrderItem> findById(Integer orderId) {
    	return orderDao.findById(orderId);
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
