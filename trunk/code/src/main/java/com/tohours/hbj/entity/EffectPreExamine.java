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
@Table(name = "Nspgs")
public class EffectPreExamine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String unit;
	private String org;
	private String time;
	private String basicFacts;
	private String policyAttachment;
	private String participateInfo;
	private String promiseAttachment;
	private String decision;
	private String reason;
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

	@Column(name="gstime")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Column(name="Jsxmgk")
	public String getBasicFacts() {
		return basicFacts;
	}
	public void setBasicFacts(String basicFacts) {
		this.basicFacts = basicFacts;
	}

	@Column(name="hjdccs")
	public String getPolicyAttachment() {
		return policyAttachment;
	}
	public void setPolicyAttachment(String policyAttachment) {
		this.policyAttachment = policyAttachment;
	}

	@Column(name="gzcy")
	public String getParticipateInfo() {
		return participateInfo;
	}
	public void setParticipateInfo(String participateInfo) {
		this.participateInfo = participateInfo;
	}

	@Column(name="jsdwbhcswj")
	public String getPromiseAttachment() {
		return promiseAttachment;
	}
	public void setPromiseAttachment(String promiseAttachment) {
		this.promiseAttachment = promiseAttachment;
	}

	@Column(name="nspjd")
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}

	@Column(name="nobuyr")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
