package com.tohours.hbj.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Spjdgg")
public class EffectExamine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String unit;
	private String org;
	private String title;
	private String index;
	private String content;
	private Date time;
	private String gTime;
	private Date startTime;
	private Date endTime;

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="Xmname")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="Jsaddress")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="Jsdw")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name="hjyxjg")
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}

	@Column(name="pwname")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="pwid")
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}

	@Column(name="pwtext")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="pwtime")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name="ggtime")
	public String getgTime() {
		return gTime;
	}
	public void setgTime(String gTime) {
		this.gTime = gTime;
	}

	@Column(name="qstime")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name="jstime")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
