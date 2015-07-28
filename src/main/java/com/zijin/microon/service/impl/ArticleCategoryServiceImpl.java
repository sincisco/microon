package com.zijin.microon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zijin.microon.dao.ArticleCategoryMapper;
import com.zijin.microon.model.ArticleCategory;
import com.zijin.microon.service.ArticleCategoryService;

@Service("articleCategoryService")
public class ArticleCategoryServiceImpl   implements ArticleCategoryService {

	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	
	public ArticleCategory getActicleCategoryById(int id) {
		return articleCategoryMapper.selectByPrimaryKey(id);
	}

	public List<ArticleCategory> getArticleCategories() {
		return articleCategoryMapper.queryAllArticleCategories();
	}

	public int insert(ArticleCategory articleCategory) {
		return articleCategoryMapper.insert(articleCategory);
	}

	public int update(ArticleCategory articleCategory) {
		return articleCategoryMapper.updateByPrimaryKey(articleCategory);
	}

}
