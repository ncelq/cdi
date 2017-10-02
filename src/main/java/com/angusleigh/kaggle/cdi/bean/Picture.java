package com.angusleigh.kaggle.cdi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {

	@SerializedName("$binary")
	@Expose
	private String binary;
	@SerializedName("$type")
	@Expose
	private Integer type;

	public String getBinary() {
		return binary;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}