package com.scut.onlinebookstore.models;

/**
 * @author FatCat
 * @version: 1.0
 * @description: 分类基本信息类
 */
public class Category {
    private String tag;

    private Integer number;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "{" +
                "tag='" + tag + '\'' +
                ", number=" + number +
                '}';
    }
}
