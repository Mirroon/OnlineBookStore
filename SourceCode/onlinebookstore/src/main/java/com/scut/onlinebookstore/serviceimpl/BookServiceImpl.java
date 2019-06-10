package com.scut.onlinebookstore.serviceimpl;

import com.scut.onlinebookstore.dao.BookDao;
import com.scut.onlinebookstore.models.Book;
import com.scut.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findByIsbn(String bookIsbn) {
        return bookDao.findBookByIsbn(bookIsbn);
    }

    @Override
    public List<Book> findByName(String bookName) {
        return bookDao.findBookByName(bookName);
    }

    @Override
    public List<Book> findByAuthor(String bookAuthor) {
        return bookDao.findBookByAuthor(bookAuthor);
    }

    @Override
    public List<Book> findByCategory(String category) {
        return bookDao.findBookByCategory(category);
    }

    @Override
    public List<Book> getBookList() {
        return bookDao.selectAll();
    }

    @Override
    public int update(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int delete(String bookIsbn) {
        return bookDao.deleteBook(bookIsbn);
    }

    @Override
    public int create(Book book) {
        return bookDao.insertBook(book);
    }
}
