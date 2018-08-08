package com.hy.dto;

import java.util.List;

public class PhotoDTO {

	private int tm_no;
	private String tm_nick;
	private String tm_content;
	private String tm_userimg;
	private String tm_img;
	private int id_no;
	private List<TagDTO> tags;
	private List<CommentsDTO> comments;
	private List<UserDTO> likes;

	public List<UserDTO> getLikes() {
		return likes;
	}
	public void setLikes(List<UserDTO> likes) {
		this.likes = likes;
	}
	public List<TagDTO> getTags() {
		return tags;
	}
	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}
	public List<CommentsDTO> getComments() {
		return comments;
	}
	public int getId_no() {
		return id_no;
	}
	public void setId_no(int id_no) {
		this.id_no = id_no;
	}
	public void setComments(List<CommentsDTO> comments) {
		this.comments = comments;
	}
	public int getTm_no() {
		return tm_no;
	}
	public void setTm_no(int tm_no) {
		this.tm_no = tm_no;
	}
	public String getTm_nick() {
		return tm_nick;
	}
	public void setTm_nick(String tm_nick) {
		this.tm_nick = tm_nick;
	}
	public String getTm_content() {
		return tm_content;
	}
	public void setTm_content(String tm_content) {
		this.tm_content = tm_content;
	}

	public String getTm_userimg() {
		return tm_userimg;
	}
	public void setTm_userimg(String tm_userimg) {
		this.tm_userimg = tm_userimg;
	}
	public String getTm_img() {
		return tm_img;
	}
	public void setTm_img(String tm_img) {
		this.tm_img = tm_img;
	}



}
