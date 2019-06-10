package com.scut.onlinebookstore.models;

/**
 * @author: 何健聪
 * @createTime: 2019/6/4 15:52
 * @version: 1.0
 * @description:
 */
public class User {
    private Integer userID;

    private String username;

    private String password;

    private boolean isAdmin;

    private boolean loginState;

    private String name;

    private String address;

    private String phone;

    private String postcode;

    public static final User nullUser = new User();

    public User() {
        userID = -1;
        username = "null";
        password = "null";
        isAdmin = false;
        loginState = false;
        name = "";
        address = "";
        phone = "";
        postcode = "";
    }

    public User(String pUsername, String pPassword, boolean pIsAdmin, boolean pLoginState, String pName, String pAddress, String pPhone, String pPostcode){
        setUsername(pUsername);
        setPassword(pPassword);
        isAdmin = pIsAdmin;
        loginState = pLoginState;
        setName(pName);
        setAddress(pAddress);
        setPhone(pPhone);
        setPostcode(pPostcode);
    }

    public Integer getUserID() {
        return userID;
    }

    public boolean setUserID(Integer userID) {
        if (Integer.compare(userID.intValue(), 0) >= 0) {
            this.userID = userID;
            return true;
        }
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() <= 32) {
            this.password = password;
        } else {
            this.password = password.substring(0, 31);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() <= 256) {
            this.username = username;
        } else {
            this.username = username.substring(0, 255);
        }
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }

    public boolean getLoginState(){
        return loginState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 256) {
            this.name = name;
        } else {
            this.name = name.substring(0, 255);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.length() <= 1024) {
            this.address = address;
        } else {
            this.address = address.substring(0, 1023);
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.length() <= 16) {
            this.phone = phone;
        } else {
            this.phone = phone.substring(0, 15);
        }
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        if (postcode.length() <= 6) {
            this.postcode = postcode;
        } else {
            this.postcode = postcode.substring(0, 5);
        }
    }

    @Override
    public String toString() {
        return "{userID:"+ userID + ", username:" + username + ", password:" +
                password + ", isAdmin:" + isAdmin + ", loginState:" + loginState +
                ", name:" + name + ", address:" + address + ", phone:" + phone +
                ", postcode:" + postcode + "}";
    }
}
