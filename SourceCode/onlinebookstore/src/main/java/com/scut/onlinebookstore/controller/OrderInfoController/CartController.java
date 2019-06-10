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
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/clearCart")
    @ResponseBody
    public void clearCart(@RequestBody HashMap map)throws Exception{

    	Integer userId = (Integer) map.get("userId");
    	cartService.clearCart(userId);

    }

}