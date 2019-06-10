package com.scut.onlinebookstore.service;

import com.scut.onlinebookstore.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 陈振业
 */
@Service
public interface CategoryService {
    List<Category> getMainCategory();

    Integer getTagNumber(String tag);
}
