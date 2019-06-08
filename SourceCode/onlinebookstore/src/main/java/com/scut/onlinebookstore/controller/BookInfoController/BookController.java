package com.scut.onlinebookstore.controller.BookInfoController;

import com.scut.onlinebookstore.models.Book;
import com.scut.onlinebookstore.service.BookService;
import com.sun.javafx.collections.MappingChange;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 陈振业
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/info")
    @ResponseBody
    public JSONObject getBookInfo(@RequestBody HashMap map)throws Exception{
        //获取前端传递的bookIsbn参数
        String bookIsbn = (String) map.get("ISBN");
        Book book = bookService.findByIsbn(bookIsbn);
        String string = book.toString();
        string = string.replace("\n", "<br/>");
        JSONObject jsonObject =  JSONObject.fromObject(string);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }

    @RequestMapping("/test")
    public String test(@RequestBody Map map)throws Exception{
        return "Response!";
    }

    @RequestMapping
    public String home() {
        return "Hello World!";
    }


}
