package com.zijin.microon.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zijin.microon.model.Article;
import com.zijin.microon.model.ArticleWithBLOBs;
import com.zijin.microon.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	private static Log log=LogFactory.getLog(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/saveArticle")
	public String saveArticle(ModelMap modelMap, HttpServletRequest request) {
		ArticleWithBLOBs article = new ArticleWithBLOBs();
		article.setIssuedate(new Date());
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		article.setOutline(request.getParameter("outline"));
		articleService.insert(article);
		modelMap.addAttribute("article", article);
		return "json";
	}

	@RequestMapping("/viewArticle/{articleNo}")
	public String getArticle(ModelMap modelMap, 
			HttpServletRequest request, @PathVariable Integer articleNo) {
		List<Article> articles=articleService.getArticles();
		Article article=articleService.getActicleById(articleNo);
		modelMap.addAttribute("article", article);
		modelMap.addAttribute("articleList", articles);
		log.info("article Num"+articles.size());
		return "article/articleTemplate";
	}
	
	@RequestMapping("/editArticle/{articleNo}")
	public String editArticle(ModelMap modelMap, 
			HttpServletRequest request, @PathVariable Integer articleNo) {
		Article article=articleService.getActicleById(articleNo);
		modelMap.addAttribute("article", article);
		return "article/editArticle";
	}
	
	@RequestMapping("/updateArticle")
	public String updateArticle(ModelMap modelMap, HttpServletRequest request) {
		ArticleWithBLOBs articleWithBLOBs = new ArticleWithBLOBs();
		articleWithBLOBs.setIssuedate(new Date());
		articleWithBLOBs.setId(Integer.parseInt(request.getParameter("id")));
		articleWithBLOBs.setTitle(request.getParameter("title"));
		articleWithBLOBs.setContent(request.getParameter("content"));
		articleWithBLOBs.setOutline(request.getParameter("outline"));
		articleService.update(articleWithBLOBs);
		modelMap.addAttribute("json", "{}");
		return "json";
	}

}
