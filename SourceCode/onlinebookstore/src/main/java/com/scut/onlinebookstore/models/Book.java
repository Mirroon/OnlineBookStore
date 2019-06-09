package com.scut.onlinebookstore.models;

import java.util.List;

/**
 * @author FatCat
 * @version: 1.0
 * @description: 图书基本信息类
 */
public class Book {

    private String isbn;

    private Boolean onShow = true;

    private Boolean onSale = true;

    private String name;

    private String author;

    private String translator;

    private String publisher;

    private String publishDate;

    private Float price;

//    private String cover;

    private String bookIntro;

    private String authorIntro;

    private String content;

    private Integer number;

//    private List tags;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setOnShow(Boolean onShow) {
        this.onShow = onShow;
    }

    public void setOnShowale(Boolean onShowale) {
        onSale = onShowale;
    }

    public boolean isOnShow() {
        return onShow;
    }

    public boolean isOnShowale() {
        return onSale;
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

//    public String getCover() {
//        return cover;
//    }
//
//    public void setCover(String cover) {
//        this.cover = cover;
//    }

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

    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

//    public List getTags() {
//        return tags;
//    }

//    public void setTags(List tags) {
//        this.tags = tags;
//    }

    @Override
    public String toString() {
        return "{" +
                "isbn='" + isbn + '\'' +
                ", onShow=" + onShow +
                ", onSale=" + onSale +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", price=" + price +
//                ", cover='" + cover + '\'' +
                ", bookIntro='" + bookIntro + '\'' +
                ", authorIntro='" + authorIntro + '\'' +
                ", content='" + content + '\'' +
                ", number=" + number +
//                ", tags=" + tags +
                '}';
    }
}
