package org.ljb.entity.sys;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

	private Integer id;
	private String name;
	private Integer parentId;
	private List<MenuItem> child;

	public MenuItem() {
		this.child = new ArrayList<MenuItem>();
	}

	public MenuItem(Integer id, String name,Integer parentId) {
		this.id = id;
		this.name = name;
		this.parentId=parentId;
		this.child = new ArrayList<MenuItem>();
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
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<MenuItem> getChild() {
		return child;
	}

	public void setChild(List<MenuItem> child) {
		this.child = child;
	}
	
	public void addChild(MenuItem child){
		this.child.add(child);
	}

}
