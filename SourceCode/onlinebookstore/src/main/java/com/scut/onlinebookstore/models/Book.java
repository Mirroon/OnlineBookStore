package com.scut.onlinebookstore.models;

import java.util.List;

/**
 * @author FatCat
 * @version: 1.0
 * @description: 图书基本信息类
 */
public class Book {

    private String lsbn;

    private Boolean isOnShow = true;

    private Boolean isOnShowale = true;

    private String name;

    private String author;

    private String translator;

    private String publisher;

    private String publishDate;

    private Float price;

    private String bookIntro;

    private String authorIntro;

    private String content;

    private Integer num;

    private List tags;

    public String getLsbn() {
        return lsbn;
    }

    public void setLsbn(String lsbn) {
        this.lsbn = lsbn;
    }

    public void setOnShow(Boolean onShow) {
        isOnShow = onShow;
    }

    public void setOnShowale(Boolean onShowale) {
        isOnShowale = onShowale;
    }

    public boolean isOnShow() {
        return isOnShow;
    }

    public boolean isOnShowale() {
        return isOnShowale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List getTags() {
        return tags;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

}
