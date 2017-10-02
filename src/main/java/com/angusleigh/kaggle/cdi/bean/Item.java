package com.angusleigh.kaggle.cdi.bean;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

	@SerializedName("_id")
	@Expose
	private Integer id;
	@SerializedName("imgs")
	@Expose
	private List<Img> imgs = null;
	@SerializedName("category_id")
	@Expose
	private Integer categoryId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Img> getImgs() {
		return imgs;
	}

	public void setImgs(List<Img> imgs) {
		this.imgs = imgs;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
