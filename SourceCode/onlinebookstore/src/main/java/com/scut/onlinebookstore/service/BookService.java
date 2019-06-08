package com.scut.onlinebookstore.service;

import com.scut.onlinebookstore.models.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈振业
 */
@Service
public interface BookService {

    /**
     * 根据ISBN查找图书
     *
     * @param bookIsbn 图书的国际书号
     * @return Book
     */
    Book findByIsbn(String bookIsbn);

    /**
     * 查找指定作者的所有图书
     *
     * @param bookAuthor 图书的作者
     * @return 图书列表
     */
    List<Book> findByAuthor(String bookAuthor);

    /**
     * 查找指定分类下的所有图书
     *
     * @param category 类别
     * @return 图书列表
     */
    List<Book> findByCategory(String category);

    /**
     * 获得全部图书的列表
     *
     * @return 图书列表
     */
    List<Book> getBookList();

    /**
     * 更新图书信息
     *
     * @param book 图书信息
     * @return 状态信息
     */
    int update(Book book);

    /**
     * 删除图书信息
     *
     * @param bookIsbn 图书的国际书号
     * @return 状态信息
     */
    int delete(String bookIsbn);

    /**
     * 创建图书信息
     *
     * @param book 图书
     * @return 状态信息
     */
    int  create(Book book);

}
