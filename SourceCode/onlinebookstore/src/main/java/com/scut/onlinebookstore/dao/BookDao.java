package com.scut.onlinebookstore.DAO;

import java.util.List;
import com.scut.onlinebookstore.models.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author 陈振业
 */
@Repository
public interface BookDao {

    int deleteBook(String bookIsbn);

    int insertBook(Book bookInfo);

    Book findBookByIsbn(String bookIsbn);

    List<Book> selectAll();

    int updateBook(Book bookInfo);

    List<Book> findBookByCategory(String bookCategory);

    List<Book> findBookByAuthor(String bookAuthor);
}
