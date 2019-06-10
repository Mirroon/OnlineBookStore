package com.scut.onlinebookstore.dao;

import com.scut.onlinebookstore.models.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 陈振业
 */
@Repository
public interface CategoryDao {
    /**
     * 获取包含图书数量较多的分类
     *
     * @return 分类列表
     */
    List<Category> getMainCategory();

    /**
     * 获取指定tag下图书的数量
     *
     * @param tag 标签名
     * @return Integer 该标签下图书的数量
     */
    Integer getNumByTag(String tag);

}
