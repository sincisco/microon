package com.zijin.microon.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public abstract class TreeNode<T> {

	@JSONField(serialize=false)
	private T innerId;
	
	@JSONField(serialize=false)
	private T innerFather;
	
	private List<TreeNode<T>> children;
	public TreeNode() {
	}
	
	public abstract T getId();
	
	public abstract String getText();
	
	public abstract T getInnerId();

	public abstract T getInnerFather();
	
	public List<TreeNode<T>> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}
	
	public void addChild(TreeNode<T> treeNode)
	{
		if (children==null) {
			children=new ArrayList<TreeNode<T>>();
		}
		children.add(treeNode);
	}



}
