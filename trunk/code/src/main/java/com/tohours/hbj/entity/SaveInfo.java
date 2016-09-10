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
@Table(name = "JunGhjbhysslinfo")
public class SaveInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String unit;
	private String checkUnit;
	private Date startTime;
	private Date endTime;
	private String fileName;
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

	@Column(name="xmmingcheng")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="jsadress")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="jsdw")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name="ysjcdiaochadw")
	public String getCheckUnit() {
		return checkUnit;
	}
	public void setCheckUnit(String checkUnit) {
		this.checkUnit = checkUnit;
	}

	@Column(name="startime")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name="endtime")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name="FilName")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
