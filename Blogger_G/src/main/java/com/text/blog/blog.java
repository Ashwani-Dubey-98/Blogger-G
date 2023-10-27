package com.text.blog;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class blog {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private int blogid;
	
	@Column
	private String Title;
	
	@Column
	private String blogtext;
	
	@Column
	private Date addeddate;
	
	@Column
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBlogtext() {
		return blogtext;
	}

	public void setBlogtext(String blogtext) {
		this.blogtext = blogtext;
	}

	public Date getAddeddate() {
		return addeddate;
	}

	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
}