package com.scut.onlinebookstore.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao {
    /**
     * 创建评论
     * @return 状态信息
     */
    int createComment();

    /**
     * 删除评论
     *
     * @param commentId 评论id
     * @return 状态信息
     */
    int deleteComment(Integer commentId);
}
