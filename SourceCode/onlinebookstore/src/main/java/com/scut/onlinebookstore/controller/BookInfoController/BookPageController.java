package com.scut.onlinebookstore.controller.BookInfoController;

import com.fasterxml.jackson.databind.util.Converter;
import com.scut.onlinebookstore.models.Book;
import com.scut.onlinebookstore.models.Category;
import com.scut.onlinebookstore.service.BookService;
import com.scut.onlinebookstore.service.CategoryService;
import com.sun.javafx.collections.MappingChange;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/books")
public class BookPageController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/exactsearch")
    @ResponseBody
    public JSONObject exactSearch(@RequestBody HashMap map)throws Exception{
        //获取前端传递的bookIsbn参数
        String isbn = (String) map.get("ISBN");
        String bookName = (String) map.get("name");
        String bookAuthor = (String) map.get("author");
        String bookCategory = (String) map.get("category");
        List<Book> resultList = new ArrayList<>();
        Book book = bookService.findByIsbn(isbn);
        if(book!=null) {
            resultList.add(book);
        }
        List<Book> tempList = bookService.findByName(bookName);
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
        JSONObject jsonObject =  bookInfoToJson(resultList);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }

    private JSONObject bookInfoToJson(List<Book> list) throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", list.size());
        for(int i =0;i<list.size();i++){
            String string = list.get(i).toString();
            string = string.replace("\n", "<br/>");
            jsonObject.put("Book"+i,string);
        }
        return jsonObject;
    }

    @RequestMapping("/all")
    @ResponseBody
    public JSONObject getAll()throws Exception{
        List<Book> resultList = bookService.getBookList();
        JSONObject jsonObject =  bookInfoToJson(resultList);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }

    @RequestMapping("/tag")
    @ResponseBody
    public JSONObject getMainTag() throws Exception{
        List<Category> categories = categoryService.getMainCategory();
        JSONObject jsonObject = tagListToJson(categories);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }

    private JSONObject tagListToJson(List<Category> list) throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", list.size());
        for(int i =0;i<list.size();i++){
            String string = list.get(i).toString();
            string = string.replace("\n", "<br/>");
            jsonObject.put("Tag"+i,string);
        }
        return jsonObject;
    }

    @RequestMapping(value =" /{tag}")
    public JSONObject getBookListofTag(@PathVariable("tag") String tag) throws Exception{
        List<Book> resultList = bookService.findByCategory(tag);
        JSONObject jsonObject = bookInfoToJson(resultList);
        jsonObject.put("success", true);
        jsonObject.put("msg", "获取成功");
        return jsonObject;
    }
}
