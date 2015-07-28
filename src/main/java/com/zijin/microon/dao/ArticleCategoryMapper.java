package com.zijin.microon.dao;

import java.util.List;

import com.zijin.microon.model.ArticleCategory;

public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Integer id);
    
    List<ArticleCategory> queryAllArticleCategories();

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);
}