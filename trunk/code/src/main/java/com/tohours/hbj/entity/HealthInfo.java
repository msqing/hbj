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
@Table(name = "jiankanchaxun")
public class HealthInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String bh;
	private String jcjg;
	private Date cssj;
	private String lx;
	private String shzt;
	private String cardId;
	private String name;
	private String dw;
	private String sex;
	private Long nl;
	private String zy;
	private Double sg;
	private Double tz;
	private Double bmi;
	private Double fhl;
	private Double wl;
	private Double zlqq;
	private Double fys;
	private Long bydz;
	private Double ct;
	private Long fwc;
	private Long ywqz;
	private Double tjzs;
	private Long szy;
	private Long ssy;
	private Long mb;
	private Long wcb;
	private Long bbm;
	private Long yqm;
	private Long smzp;
	private Long wsm;
	private Long xs;
	private Long wq;
	private Long phm;
	private Long hjt;
	private Long ldty;
	private Long wfp;
	private Long bl;
	private Long rtsf;
	private Long dbz;
	private Long kwz;
	private Long zf;
	private Long glj;
	private Long ybb;
	private Long jcdx;
	private Long sos;
	private Long bua;
	private Long bqi;
	private Long tscore;
	private Long zscore;
	private Long tration;
	private Long zration;
	private Long xw;
	private Long yw;
	private Long pw;
	private Double ybbzs;
	private Double tzl;
	private Long spbtz;
	private Long jjbpz;
	private Long fbpzhd;
	private Long sgbzt;
	private Long fhlpf;
	private Long tjzspf;
	private Long ctpf;
	private Long wlpf;
	private Long zwtqpf;
	private Long bydtzpf;
	private Long xzfyspf;
	private Long fwcpf;
	private Long yfzyw;
	private Long rtxt;
	private Double rtjn;
	private Double rtsz;
	private Long zhzf;
	private Long zhpj;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="bh")
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}

	@Column(name="jcjg")
	public String getJcjg() {
		return jcjg;
	}
	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}

	@Column(name="cssj")
	public Date getCssj() {
		return cssj;
	}
	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}

	@Column(name="lx")
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}

	@Column(name="shzt")
	public String getShzt() {
		return shzt;
	}
	public void setShzt(String shzt) {
		this.shzt = shzt;
	}

	@Column(name="cardId")
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="dw")
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}

	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="nl")
	public Long getNl() {
		return nl;
	}
	public void setNl(Long nl) {
		this.nl = nl;
	}

	@Column(name="zy")
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}

	@Column(name="sg")
	public Double getSg() {
		return sg;
	}
	public void setSg(Double sg) {
		this.sg = sg;
	}

	@Column(name="tz")
	public Double getTz() {
		return tz;
	}
	public void setTz(Double tz) {
		this.tz = tz;
	}

	@Column(name="bmi")
	public Double getBmi() {
		return bmi;
	}
	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Column(name="fhl")
	public Double getFhl() {
		return fhl;
	}
	public void setFhl(Double fhl) {
		this.fhl = fhl;
	}

	@Column(name="wl")
	public Double getWl() {
		return wl;
	}
	public void setWl(Double wl) {
		this.wl = wl;
	}

	@Column(name="zlqq")
	public Double getZlqq() {
		return zlqq;
	}
	public void setZlqq(Double zlqq) {
		this.zlqq = zlqq;
	}

	@Column(name="fys")
	public Double getFys() {
		return fys;
	}
	public void setFys(Double fys) {
		this.fys = fys;
	}

	@Column(name="bydz")
	public Long getBydz() {
		return bydz;
	}
	public void setBydz(Long bydz) {
		this.bydz = bydz;
	}

	@Column(name="ct")
	public Double getCt() {
		return ct;
	}
	public void setCt(Double ct) {
		this.ct = ct;
	}

	@Column(name="fwc")
	public Long getFwc() {
		return fwc;
	}
	public void setFwc(Long fwc) {
		this.fwc = fwc;
	}

	@Column(name="ywqz")
	public Long getYwqz() {
		return ywqz;
	}
	public void setYwqz(Long ywqz) {
		this.ywqz = ywqz;
	}

	@Column(name="tjzs")
	public Double getTjzs() {
		return tjzs;
	}
	public void setTjzs(Double tjzs) {
		this.tjzs = tjzs;
	}

	@Column(name="szy")
	public Long getSzy() {
		return szy;
	}
	public void setSzy(Long szy) {
		this.szy = szy;
	}

	@Column(name="ssy")
	public Long getSsy() {
		return ssy;
	}
	public void setSsy(Long ssy) {
		this.ssy = ssy;
	}

	@Column(name="mb")
	public Long getMb() {
		return mb;
	}
	public void setMb(Long mb) {
		this.mb = mb;
	}

	@Column(name="wcb")
	public Long getWcb() {
		return wcb;
	}
	public void setWcb(Long wcb) {
		this.wcb = wcb;
	}

	@Column(name="bbm")
	public Long getBbm() {
		return bbm;
	}
	public void setBbm(Long bbm) {
		this.bbm = bbm;
	}

	@Column(name="yqm")
	public Long getYqm() {
		return yqm;
	}
	public void setYqm(Long yqm) {
		this.yqm = yqm;
	}

	@Column(name="smzp")
	public Long getSmzp() {
		return smzp;
	}
	public void setSmzp(Long smzp) {
		this.smzp = smzp;
	}

	@Column(name="wsm")
	public Long getWsm() {
		return wsm;
	}
	public void setWsm(Long wsm) {
		this.wsm = wsm;
	}

	@Column(name="xs")
	public Long getXs() {
		return xs;
	}
	public void setXs(Long xs) {
		this.xs = xs;
	}

	@Column(name="wq")
	public Long getWq() {
		return wq;
	}
	public void setWq(Long wq) {
		this.wq = wq;
	}

	@Column(name="phm")
	public Long getPhm() {
		return phm;
	}
	public void setPhm(Long phm) {
		this.phm = phm;
	}

	@Column(name="hjt")
	public Long getHjt() {
		return hjt;
	}
	public void setHjt(Long hjt) {
		this.hjt = hjt;
	}

	@Column(name="ldty")
	public Long getLdty() {
		return ldty;
	}
	public void setLdty(Long ldty) {
		this.ldty = ldty;
	}

	@Column(name="wfp")
	public Long getWfp() {
		return wfp;
	}
	public void setWfp(Long wfp) {
		this.wfp = wfp;
	}

	@Column(name="bl")
	public Long getBl() {
		return bl;
	}
	public void setBl(Long bl) {
		this.bl = bl;
	}

	@Column(name="rtsf")
	public Long getRtsf() {
		return rtsf;
	}
	public void setRtsf(Long rtsf) {
		this.rtsf = rtsf;
	}

	@Column(name="dbz")
	public Long getDbz() {
		return dbz;
	}
	public void setDbz(Long dbz) {
		this.dbz = dbz;
	}

	@Column(name="kwz")
	public Long getKwz() {
		return kwz;
	}
	public void setKwz(Long kwz) {
		this.kwz = kwz;
	}

	@Column(name="zf")
	public Long getZf() {
		return zf;
	}
	public void setZf(Long zf) {
		this.zf = zf;
	}

	@Column(name="glj")
	public Long getGlj() {
		return glj;
	}
	public void setGlj(Long glj) {
		this.glj = glj;
	}

	@Column(name="ybb")
	public Long getYbb() {
		return ybb;
	}
	public void setYbb(Long ybb) {
		this.ybb = ybb;
	}

	@Column(name="jcdx")
	public Long getJcdx() {
		return jcdx;
	}
	public void setJcdx(Long jcdx) {
		this.jcdx = jcdx;
	}

	@Column(name="sos")
	public Long getSos() {
		return sos;
	}
	public void setSos(Long sos) {
		this.sos = sos;
	}

	@Column(name="bua")
	public Long getBua() {
		return bua;
	}
	public void setBua(Long bua) {
		this.bua = bua;
	}

	@Column(name="bqi")
	public Long getBqi() {
		return bqi;
	}
	public void setBqi(Long bqi) {
		this.bqi = bqi;
	}

	@Column(name="tscore")
	public Long getTscore() {
		return tscore;
	}
	public void setTscore(Long tscore) {
		this.tscore = tscore;
	}

	@Column(name="zscore")
	public Long getZscore() {
		return zscore;
	}
	public void setZscore(Long zscore) {
		this.zscore = zscore;
	}

	@Column(name="tration")
	public Long getTration() {
		return tration;
	}
	public void setTration(Long tration) {
		this.tration = tration;
	}

	@Column(name="zration")
	public Long getZration() {
		return zration;
	}
	public void setZration(Long zration) {
		this.zration = zration;
	}

	@Column(name="xw")
	public Long getXw() {
		return xw;
	}
	public void setXw(Long xw) {
		this.xw = xw;
	}

	@Column(name="yw")
	public Long getYw() {
		return yw;
	}
	public void setYw(Long yw) {
		this.yw = yw;
	}

	@Column(name="pw")
	public Long getPw() {
		return pw;
	}
	public void setPw(Long pw) {
		this.pw = pw;
	}

	@Column(name="ybbzs")
	public Double getYbbzs() {
		return ybbzs;
	}
	public void setYbbzs(Double ybbzs) {
		this.ybbzs = ybbzs;
	}

	@Column(name="tzl")
	public Double getTzl() {
		return tzl;
	}
	public void setTzl(Double tzl) {
		this.tzl = tzl;
	}

	@Column(name="spbtz")
	public Long getSpbtz() {
		return spbtz;
	}
	public void setSpbtz(Long spbtz) {
		this.spbtz = spbtz;
	}

	@Column(name="jjbpz")
	public Long getJjbpz() {
		return jjbpz;
	}
	public void setJjbpz(Long jjbpz) {
		this.jjbpz = jjbpz;
	}

	@Column(name="fbpzhd")
	public Long getFbpzhd() {
		return fbpzhd;
	}
	public void setFbpzhd(Long fbpzhd) {
		this.fbpzhd = fbpzhd;
	}

	@Column(name="sgbzt")
	public Long getSgbzt() {
		return sgbzt;
	}
	public void setSgbzt(Long sgbzt) {
		this.sgbzt = sgbzt;
	}
	
	@Column(name="fhlpf")
	public Long getFhlpf() {
		return fhlpf;
	}
	public void setFhlpf(Long fhlpf) {
		this.fhlpf = fhlpf;
	}

	@Column(name="tjzspf")
	public Long getTjzspf() {
		return tjzspf;
	}
	public void setTjzspf(Long tjzspf) {
		this.tjzspf = tjzspf;
	}

	@Column(name="ctpf")
	public Long getCtpf() {
		return ctpf;
	}
	public void setCtpf(Long ctpf) {
		this.ctpf = ctpf;
	}

	@Column(name="wlpf")
	public Long getWlpf() {
		return wlpf;
	}
	public void setWlpf(Long wlpf) {
		this.wlpf = wlpf;
	}

	@Column(name="zwtqpf")
	public Long getZwtqpf() {
		return zwtqpf;
	}
	public void setZwtqpf(Long zwtqpf) {
		this.zwtqpf = zwtqpf;
	}

	@Column(name="bydtzpf")
	public Long getBydtzpf() {
		return bydtzpf;
	}
	public void setBydtzpf(Long bydtzpf) {
		this.bydtzpf = bydtzpf;
	}

	@Column(name="xzfyspf")
	public Long getXzfyspf() {
		return xzfyspf;
	}
	public void setXzfyspf(Long xzfyspf) {
		this.xzfyspf = xzfyspf;
	}

	@Column(name="fwcpf")
	public Long getFwcpf() {
		return fwcpf;
	}
	public void setFwcpf(Long fwcpf) {
		this.fwcpf = fwcpf;
	}

	@Column(name="yfzyw")
	public Long getYfzyw() {
		return yfzyw;
	}
	public void setYfzyw(Long yfzyw) {
		this.yfzyw = yfzyw;
	}

	@Column(name="rtxt")
	public Long getRtxt() {
		return rtxt;
	}
	public void setRtxt(Long rtxt) {
		this.rtxt = rtxt;
	}

	@Column(name="rtjn")
	public Double getRtjn() {
		return rtjn;
	}
	public void setRtjn(Double rtjn) {
		this.rtjn = rtjn;
	}

	@Column(name="rtsz")
	public Double getRtsz() {
		return rtsz;
	}
	public void setRtsz(Double rtsz) {
		this.rtsz = rtsz;
	}

	@Column(name="zhzf")
	public Long getZhzf() {
		return zhzf;
	}
	public void setZhzf(Long zhzf) {
		this.zhzf = zhzf;
	}

	@Column(name="zhpj")
	public Long getZhpj() {
		return zhpj;
	}
	public void setZhpj(Long zhpj) {
		this.zhpj = zhpj;
	}

}
