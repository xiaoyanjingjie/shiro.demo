package com.sojson.common.model;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
/**
 *wan.dj
  *2017.12.19
  *华丽转身 会员详细信息
 */
public class GorgeousturnpeoinfoM implements Serializable{
	private static final long serialVersionUID = 1L;
	//0:不在体制内 没有报道
	public static final Long _0 = new Long(0);
	//1:在体制内 有报道
	public static final Long _1 = new Long(1);
	private Long id;
	private Date createtime;
	private Integer createor;
	private Integer meetingid;
	private String meetingpeoplename;
	private Date mpeopresencetime;
	private Integer mpeotel;
	private String mpeowechat;
	private Byte  issystem;
	private Byte ispresence;
	
	public GorgeousturnpeoinfoM() {}
	
    
    
   


	public GorgeousturnpeoinfoM(GorgeousturnpeoinfoM gorgeousturnpeoinfom) {
		this.id = gorgeousturnpeoinfom.getId();
		this.createtime = gorgeousturnpeoinfom.getCreatetime();
		this.createor =gorgeousturnpeoinfom.getCreateor();
		this.meetingid = gorgeousturnpeoinfom.getMeetingid();
		this.meetingpeoplename =gorgeousturnpeoinfom.getMeetingpeoplename();
		this.mpeopresencetime = gorgeousturnpeoinfom.getMpeopresencetime();
		this.mpeotel = gorgeousturnpeoinfom.getMpeotel();
		this.mpeowechat =gorgeousturnpeoinfom.getMpeowechat();
		this.issystem = gorgeousturnpeoinfom.getIssystem();
		this.ispresence =gorgeousturnpeoinfom.getIspresence();
	}






	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Date getCreatetime() {
		return createtime;
	}




	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}




	public Integer getCreateor() {
		return createor;
	}




	public void setCreateor(Integer createor) {
		this.createor = createor;
	}




	public Integer getMeetingid() {
		return meetingid;
	}




	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;
	}




	public String getMeetingpeoplename() {
		return meetingpeoplename;
	}




	public void setMeetingpeoplename(String meetingpeoplename) {
		this.meetingpeoplename = meetingpeoplename;
	}




	public Date getMpeopresencetime() {
		return mpeopresencetime;
	}




	public void setMpeopresencetime(Date mpeopresencetime) {
		this.mpeopresencetime = mpeopresencetime;
	}




	public Integer getMpeotel() {
		return mpeotel;
	}




	public void setMpeotel(Integer mpeotel) {
		this.mpeotel = mpeotel;
	}




	public String getMpeowechat() {
		return mpeowechat;
	}




	public void setMpeowechat(String mpeowechat) {
		this.mpeowechat = mpeowechat;
	}




	public Byte getIssystem() {
		return issystem;
	}




	public void setIssystem(Byte issystem) {
		this.issystem = issystem;
	}




	public Byte getIspresence() {
		return ispresence;
	}




	public void setIspresence(Byte ispresence) {
		this.ispresence = ispresence;
	}

	   public String toString(){
	    	return JSONObject.fromObject(this).toString();
	    }




}