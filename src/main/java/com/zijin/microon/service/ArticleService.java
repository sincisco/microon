package com.zijin.microon.service;

import java.util.List;

import com.zijin.microon.model.Article;

public interface ArticleService {
	Article getActicleById(int id);
	
	List<Article> getArticles();
	
	int insert(Article article);
}
