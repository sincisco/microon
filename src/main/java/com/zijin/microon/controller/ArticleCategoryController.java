package com.zijin.microon.controller;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSON;
import com.zijin.microon.model.ArticleCategory;
import com.zijin.microon.model.ArticleWithBLOBs;
import com.zijin.microon.service.ArticleCategoryService;
import com.zijin.microon.utils.TreeNode;
import com.zijin.microon.utils.TreeNodeUtil;

@Controller
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

	private static Log log = LogFactory.getLog(ArticleCategoryController.class);

	@Autowired
	private ArticleCategoryService articleCategoryService;

	@RequestMapping("/articleCategoryManage")
	public String articleCategoryManage(ModelMap modelMap, HttpServletRequest request) {
		return "json";
	}
	
	@RequestMapping("/saveArticleCategory")
	public String saveArticle(ModelMap modelMap, HttpServletRequest request) {
		ArticleCategory articleCategory = new ArticleCategory();
		articleCategory.setCreatedatetime(new Date());
		articleCategory.setName(request.getParameter("name"));
		articleCategory.setParentid(Integer.parseInt(request.getParameter("parentId")));
		articleCategoryService.insert(articleCategory);
		return "json";
	}

	@RequestMapping("/getArticleCategory/{categoryNo}")
	public String getArticleCategoryById(ModelMap modelMap, HttpServletRequest request,
			@PathVariable Integer categoryNo) {
		ArticleCategory articleCategory = articleCategoryService.getActicleCategoryById(categoryNo);
		modelMap.addAttribute("json", JSON.toJSONString(articleCategory));
		return "json";
	}
	
	@RequestMapping("/getAllArticleCategories")
	public String getArticleCategories(ModelMap modelMap, HttpServletRequest request) {
		List<ArticleCategory> articleCategories = articleCategoryService.getArticleCategories();
		List<TreeNode<Integer>> treeNodes=new ArrayList<TreeNode<Integer>>();
		treeNodes.addAll(articleCategories);
		modelMap.addAttribute("json", TreeNodeUtil.generateJson(treeNodes));
		return "json";
	}

	@RequestMapping("/updateArticle")
	public String updateArticle(ModelMap modelMap, HttpServletRequest request) {
		ArticleWithBLOBs articleWithBLOBs = new ArticleWithBLOBs();
		articleWithBLOBs.setIssuedate(new Date());
		articleWithBLOBs.setId(Integer.parseInt(request.getParameter("id")));
		articleWithBLOBs.setTitle(request.getParameter("title"));
		articleWithBLOBs.setContent(request.getParameter("content"));
		articleWithBLOBs.setOutline(request.getParameter("outline"));
		//articleService.update(articleWithBLOBs);
		modelMap.addAttribute("json", "{}");
		return "json";
	}

}
