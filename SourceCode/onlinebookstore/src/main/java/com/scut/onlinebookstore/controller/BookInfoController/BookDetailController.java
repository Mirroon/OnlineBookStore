package com.scut.onlinebookstore.controller.BookInfoController;

import com.scut.onlinebookstore.models.Book;
import com.scut.onlinebookstore.service.BookService;
import com.scut.onlinebookstore.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookDetailController {
    @Autowired
    private BookService bookService;

//    @Autowired
//    private CommentService commentService;

    @RequestMapping("/{isbn}")
    public JSONObject getBookListofTag(@PathVariable("isbn") String isbn) throws Exception{
        Book book = bookService.findByIsbn(isbn);
        JSONObject jsonObject = JSONObject.fromObject(book);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }

}
