package com.tohours.hbj.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Slxxgs")
public class EffectInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String unit;
	private String type;
	private String commentOrg;
	private Date startTime;
	private Date endTime;
	private String attachment;
	private String fkId;
	@SuppressWarnings("unused")
	private boolean timeOut;
	
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

	@Column(name="hpxs")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Column(name="hjyxjg")
	public String getCommentOrg() {
		return commentOrg;
	}
	public void setCommentOrg(String commentOrg) {
		this.commentOrg = commentOrg;
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

	@Column(name="Xmfj")
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Column(name="Fkid")
	public String getFkId() {
		return fkId;
	}
	public void setFkId(String fkId) {
		this.fkId = fkId;
	}

	@Transient
	public boolean isTimeOut() {
		Long endTime = getEndTime().getTime();
		Long currentTime = new Date().getTime();
		if(currentTime > endTime){
			return true;
		}else{
			return false;
		}
	}
	public void setTimeOut(boolean timeOut) {
		this.timeOut = timeOut;
	}

	
}
