package com.scut.onlinebookstore.controller.BookInfoController;

import com.fasterxml.jackson.databind.util.Converter;
import com.scut.onlinebookstore.models.Book;
import com.scut.onlinebookstore.service.BookService;
import com.sun.javafx.collections.MappingChange;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @RequestMapping("/exactserch")
    @ResponseBody
    public JSONObject exactSearch(@RequestBody HashMap map)throws Exception{
        //获取前端传递的bookIsbn参数
        String bookIsbn = (String) map.get("ISBN");
        String bookAuthor = (String) map.get("author");
        String bookCategory = (String) map.get("category");
        List<Book> resultList = new ArrayList<>();
        Book book = bookService.findByIsbn(bookIsbn);
        if(book!=null) {
            resultList.add(bookService.findByIsbn(bookIsbn));
        }
        List<Book> tempList = bookService.findByAuthor(bookAuthor);
        if(tempList.size()!=0){
            resultList.addAll(tempList);
        }
        tempList = bookService.findByAuthor(bookAuthor);
        if(tempList.size()!=0){
            resultList.addAll(tempList);
        }
        tempList = bookService.findByCategory(bookCategory);
        if(tempList.size()!=0){
            resultList.addAll(tempList);
        }
        String string = book.toString();
        string = string.replace("\n", "<br/>");
        JSONObject jsonObject =  JSONObject.fromObject(string);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }

    private JSONObject bookInfoToJson(List<Book> list) throws Exception{
        JSONObject jsonObject = new JSONObject();
        for(Book){
            String string = list.get(i).toString();

        }

    }

}
