package com.example.shwetatripathi.mmt;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;
import com.fasterxml.jackson.annotation.JsonProperty;



public class BlogOne{

	@JsonProperty("imgURL")
	private String imgURL;

	@JsonProperty("blogName")
	private String blogName;

	@JsonProperty("blogURL")
	private String blogURL;

	@JsonProperty("id")
	private String id;

	public BlogOne() {
		this.blogName=blogName;
		this.imgURL=imgURL;
	}


	public void setImgURL(String imgURL){
		this.imgURL = imgURL;
	}

	public String getImgURL(){
		return imgURL;
	}

	public void setBlogName(String blogName){
		this.blogName = blogName;
	}

	public String getBlogName(){
		return blogName;
	}

	public void setBlogURL(String blogURL){
		this.blogURL = blogURL;
	}

	public String getBlogURL(){
		return blogURL;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"com.example.shwetatripathi.mmt.BlogOne{" +
			"imgURL = '" + imgURL + '\'' + 
			",blogName = '" + blogName + '\'' + 
			",blogURL = '" + blogURL + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}