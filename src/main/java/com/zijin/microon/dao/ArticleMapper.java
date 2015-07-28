package com.zijin.microon.dao;

import java.util.List;

import com.zijin.microon.model.Article;
import com.zijin.microon.model.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(Integer id);
    
    List<Article> queryAllArticle();

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
}   