package com.angusleigh.kaggle.cdi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Img {

	@SerializedName("picture")
	@Expose
	private Picture picture;

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
}