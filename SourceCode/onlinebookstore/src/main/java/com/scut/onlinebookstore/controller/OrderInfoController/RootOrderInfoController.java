package com.scut.onlinebookstore.controller.OrderInfoController;

import com.fasterxml.jackson.databind.util.Converter;
import com.scut.onlinebookstore.models.*;
import com.scut.onlinebookstore.service.*;
import com.sun.javafx.collections.MappingChange;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class RootOrderInfoController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/exactserch")
    @ResponseBody
    public JSONObject exactSearch(@RequestBody HashMap map)throws Exception{

    	Integer orderId = (Integer) map.get("orderId");
        List<OrderItem> resultList = new ArrayList<>();
        resultList = orderService.findById(orderId);

        return orderItemToJson(resultList);
    }
    
    private  JSONObject orderItemToJson(List<OrderItem> list) throws Exception{
    	JSONObject re = new JSONObject();
    	re.put("amount", list.size());
    	for(int i = 0;i < list.size();i++) {
    		String string = list.get(i).toString();
    		re.put("item"+i, string);
    	}
    	return re;
    }

}