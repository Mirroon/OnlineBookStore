package com.scut.onlinebookstore.serviceimpl;

import com.scut.onlinebookstore.DAO.UserDAO;
import com.scut.onlinebookstore.models.User;
import com.scut.onlinebookstore.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: 何健聪
 * @createTime: 2019/6/4 17:55
 * @version: 1.0
 * @description:
 */
@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean logIn(String username, String password){

        User user = userDAO.findByUsername(username);
        if(user == null){
            return false;
        }else{
            if(password.compareTo(user.getPassword()) != 0){
                return false;
            }else{
                if(user.getLoginState() == true){
                    return false;
                }
            }
        }
        System.out.println(user.toString());
        user.setLoginState(true);
        userDAO.update(user);
        return true;
    }

    @Override
    public boolean logOut(String username, boolean loginState){
        if(loginState == false){
            return false;
        }
        User user = userDAO.findByUsername(username);
        if(user == null){return false;}
        if(user.getLoginState() == false){return false;}
        user.setLoginState(false);
        userDAO.update(user);
        return true;
    }

    @Override
    public boolean registry(User user){
        User checkUser = userDAO.findByUsername(user.getUsername());
        if(checkUser != null){return false;}
        userDAO.insert(user);
        return true;
    }
}
