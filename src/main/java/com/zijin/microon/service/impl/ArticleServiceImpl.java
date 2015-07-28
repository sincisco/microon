package com.zijin.microon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zijin.microon.dao.ArticleMapper;
import com.zijin.microon.model.Article;
import com.zijin.microon.model.ArticleWithBLOBs;
import com.zijin.microon.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public ArticleWithBLOBs getActicleById(int id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return articleMapper.queryAllArticle();
	}

	public int insert(ArticleWithBLOBs article) {
		int result = articleMapper.insert(article);
		return result;
	}

	public int update(ArticleWithBLOBs articleWithBLOBs) {
		articleMapper.updateByPrimaryKeyWithBLOBs(articleWithBLOBs);
		return 0;
	}

}
