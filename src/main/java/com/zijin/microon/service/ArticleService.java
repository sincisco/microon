package com.zijin.microon.service;

import java.util.List;

import com.zijin.microon.model.Article;
import com.zijin.microon.model.ArticleWithBLOBs;

public interface ArticleService {
	ArticleWithBLOBs getActicleById(int id);
	
	List<Article> getArticles();
	
	int insert(ArticleWithBLOBs articleWithBLOBs);
	
	int update(ArticleWithBLOBs articleWithBLOBs);
}
