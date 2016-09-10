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
@Table(name = "Jsxmjghjbhysnspgs")
public class SavePreExamine implements Serializable{

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
	private String overview;
	private String resultInfo;
	private String joinInfo;
	private String decision;
	private String reason;
	private String suggest;
	private Date endTime;
	private String fkId;
	@SuppressWarnings("unused")
	private boolean timeOut;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="xmmc")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="jsdd")
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

	@Column(name="ysjcdcdw")
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

	@Column(name="xmgk")
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Column(name="hbcslsqk")
	public String getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	@Column(name="gzcyqk")
	public String getJoinInfo() {
		return joinInfo;
	}
	public void setJoinInfo(String joinInfo) {
		this.joinInfo = joinInfo;
	}

	@Column(name="nzcdspjd")
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}

	@Column(name="nysbhgdyy")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name="gzfkyj")
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	@Column(name="endtime")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
