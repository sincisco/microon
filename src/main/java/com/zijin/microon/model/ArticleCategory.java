package com.zijin.microon.model;

import java.util.Date;

import com.zijin.microon.utils.TreeNode;

public class ArticleCategory extends TreeNode<Integer>{
    private Integer id;

    private String name;

    private Integer parentid;

    private Date createdatetime;

    private Integer creator;
    
    

    public ArticleCategory() {
		super();
	}

	public ArticleCategory(Integer id, String name, Integer parentid) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

	@Override
	public Integer getInnerId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public Integer getInnerFather() {
		// TODO Auto-generated method stub
		return parentid;
	}

	@Override
	public String getText() {
		return name;
	}

}