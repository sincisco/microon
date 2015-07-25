package com.zijin.microon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zijin.microon.dao.ArticleMapper;
import com.zijin.microon.model.Article;
import com.zijin.microon.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public Article getActicleById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Article article) {
		int result = articleMapper.insert(article);
		
		System.out.println(result);
		return result;
	}

}
