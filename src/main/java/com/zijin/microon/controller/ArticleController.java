package com.zijin.microon.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zijin.microon.model.Article;
import com.zijin.microon.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("/saveArticle")
	public String saveArticle(ModelMap modelMap, HttpServletRequest request) {
		Article article = new Article();
		article.setIssuedate(new Date());
		article.setTitle("未知");
		article.setContent(request.getParameter("content"));
		articleService.insert(article);
		modelMap.addAttribute("article", article);
		return "json";
	}

	@RequestMapping("/viewArticle/{articleNo}")
	public String getArticle(ModelMap modelMap, 
			HttpServletRequest request, @PathVariable Integer articleNo) {
		Article article=articleService.getActicleById(articleNo);
		modelMap.addAttribute("article", article);
		return "article/articleTemplate";
	}

}
