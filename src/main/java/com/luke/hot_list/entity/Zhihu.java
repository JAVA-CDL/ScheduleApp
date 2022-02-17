package com.luke.hot_list.entity;

/**
 * 知乎
 * @author luke_long
 * @version 1.0
 * @date 2021/12/27 10:04
 */
public class Zhihu {

    private String url;
    private String content;
    private String grabDate;
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

    public String getGrabDate() {
        return grabDate;
    }

    public void setGrabDate(String grabDate) {
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
