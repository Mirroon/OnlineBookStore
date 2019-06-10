package com.scut.onlinebookstore.service;
import com.scut.onlinebookstore.models.User;
import org.springframework.stereotype.Service;

/**
 * @author: 何健聪
 * @createTime: 2019/6/4 17:55
 * @version: 1.0
 * @description:
 */
@Service
public interface UserServices {

    boolean logIn(String username, String password);

    boolean logOut(String username, boolean loginState);

    boolean registry(User user);

}
