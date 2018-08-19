package com.example.shwetatripathi.mmt;

@Deprecated

public class listitem {
    private String blog_name;
    private String img_url;

    public listitem(String blog_name, String img_url) {
        this.blog_name = blog_name;
        this.img_url = img_url;
    }

    public listitem() {
    }

    public String getBlog_name() {
        return blog_name;
    }

    public void setBlog_name(String blog_name) {
        this.blog_name = blog_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
