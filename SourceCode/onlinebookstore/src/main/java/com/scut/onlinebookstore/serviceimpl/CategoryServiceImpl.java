package com.scut.onlinebookstore.serviceimpl;

import com.scut.onlinebookstore.models.Category;
import com.scut.onlinebookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Category> getMainCategory() {
        return categoryService.getMainCategory();
    }

    @Override
    public Integer getTagNumber(String tag) {
        return categoryService.getTagNumber(tag);
    }
}
