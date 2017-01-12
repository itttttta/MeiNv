package com.wd.Enity;

import java.util.Date;

public class Meinv {
    private Integer id;

    private String title;

    private String imgUrl;

    private Date imgTime;

    private Date createTime;

    private String originUrl;

    private String catalogue;

    private Integer size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getImgTime() {
        return imgTime;
    }

    public void setImgTime(Date imgTime) {
        this.imgTime = imgTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl == null ? null : originUrl.trim();
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue == null ? null : catalogue.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

	@Override
	public String toString() {
		return "Meinv [id=" + id + ", title=" + title + ", imgUrl=" + imgUrl + ", imgTime=" + imgTime + ", createTime="
				+ createTime + ", originUrl=" + originUrl + ", catalogue=" + catalogue + ", size=" + size + "]";
	}
    
}