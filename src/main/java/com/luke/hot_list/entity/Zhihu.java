package com.luke.hot_list.entity;

import java.util.Date;

/**
 * @author luke_long
 * @version 1.0
 * @date 2021/12/27 10:04
 */
public class Zhihu {

    private String url;
    private String content;
    private Date grabDate;
    private String imageUrl;
    private String title;
    private Integer tag;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGrabDate() {
        return grabDate;
    }

    public void setGrabDate(Date grabDate) {
        this.grabDate = grabDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }
}
