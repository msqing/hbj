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
@Table(name = "JsxmJunGongspjdgg")
public class SaveExamine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String unit;
	private String checkUnit;
	private String title;
	private String index;
	private String content;
	private String time;
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

	@Column(name="XmName")
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

	@Column(name="Ysjcdw")
	public String getCheckUnit() {
		return checkUnit;
	}
	public void setCheckUnit(String checkUnit) {
		this.checkUnit = checkUnit;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Column(name="gsqstime")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name="gsjstime")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
