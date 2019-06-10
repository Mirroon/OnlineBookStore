package com.scut.onlinebookstore.controller.PersonControllers;

import com.scut.onlinebookstore.service.UserServices;
import com.scut.onlinebookstore.models.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: 何健聪
 * @createTime: 2019/6/4 17:55
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/user")
public class VisitorController {

    @Autowired
    private UserServices userServices;

    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestBody HashMap map){
        String username = (String)map.get("username");
        String password = (String)map.get("password");

        boolean success = userServices.logIn(username, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", success);
        return jsonObject;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public JSONObject logout(@RequestBody HashMap map){
        String username = (String)map.get("username");
        boolean loginState = (boolean)map.get("loginState");

        boolean success = userServices.logOut(username, loginState);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", success);
        return jsonObject;
    }

    @RequestMapping("/registry")
    @ResponseBody
    public JSONObject registry(@RequestBody HashMap map){
        String username = (String)map.get("username");
        String password = (String)map.get("password");
        boolean isAdmin = false;
        boolean loginState = false;
        String name = (String)map.get("name");
        String address = (String)map.get("address");
        String phone = (String)map.get("phone");
        String postcode = (String)map.get("postcode");
        if(name == null){name = "";}
        if(address == null){address ="";}
        if(phone == null){phone = "";}
        if(postcode == null){postcode = "";}
        User user = new User(username, password, isAdmin, loginState, name, address, phone, postcode);
        boolean success = userServices.registry(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", success);
        return jsonObject;
    }
}
