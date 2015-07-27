package com.zijin.microon.dao;

import java.util.List;

import com.zijin.microon.model.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);
    
    List<Article> queryAllArticle();

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}