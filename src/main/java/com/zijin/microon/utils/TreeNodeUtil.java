package com.zijin.microon.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.zijin.microon.model.ArticleCategory;

public class TreeNodeUtil {
	
	public static String generateJson(List<TreeNode<Integer>> list) {
		Map<Object, TreeNode> map=new HashMap<Object, TreeNode>();
		for (TreeNode treeNode : list) {
			map.put(treeNode.getInnerId(), treeNode);
		}
		for (TreeNode treeNode : list) {
			if (!StringUtils.isEmpty(treeNode.getInnerFather())) {
				TreeNode tempNode= map.get(treeNode.getInnerFather());
				if (tempNode!=null) {
					tempNode.addChild(treeNode);
				}
			}
		}
		List<TreeNode> reTreeNodes=new ArrayList<TreeNode>();
		for (TreeNode treeNode : list) {
			if (StringUtils.isEmpty(treeNode.getInnerFather())||map.get(treeNode.getInnerFather())==null) {
				reTreeNodes.add(treeNode);
			}
		}
		
		return JSON.toJSONString(reTreeNodes);
	}
	
	public TreeNodeUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<TreeNode<Integer>> list=new ArrayList<TreeNode<Integer>>();
		list.add(new ArticleCategory(1, "item1", 0));
		list.add(new ArticleCategory(2, "item1", 1));
		list.add(new ArticleCategory(3, "item1", 1));
		list.add(new ArticleCategory(4, "item1", 2));
		
		System.out.println(TreeNodeUtil.generateJson(list));
	}

}
