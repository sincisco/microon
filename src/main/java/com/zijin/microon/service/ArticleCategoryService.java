package com.zijin.microon.service;

import java.util.List;

import com.zijin.microon.model.Article;
import com.zijin.microon.model.ArticleCategory;
import com.zijin.microon.model.ArticleWithBLOBs;

public interface ArticleCategoryService {
	ArticleCategory getActicleCategoryById(int id);
	
	List<ArticleCategory> getArticleCategories();
	
	int insert(ArticleCategory articleCategory);
	
	int update(ArticleCategory articleCategory);
}
