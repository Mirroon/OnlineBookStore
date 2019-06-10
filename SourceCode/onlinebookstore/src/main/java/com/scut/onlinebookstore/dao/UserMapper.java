package com.scut.onlinebookstore.dao;

import com.scut.onlinebookstore.models.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 何健聪
 * @createTime: 2019/6/4 17:50
 * @version: 1.0
 * @description:
 */

@Mapper
public interface UserMapper {
    public void insert(User user);

    public void update(User user);

    public void delete(int id);

    public User findByUserID(int id);

    public User findByUsername(String username);

    public void updateLoginState(User user, boolean loginState);
}
