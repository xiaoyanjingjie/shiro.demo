package com.sojson.common.model;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
/**
 *wan.dj
 *2017.12.19
 *华丽转身 model
 */
public class GorgeousturnM implements Serializable{
	private static final long serialVersionUID = 1L;
	//0:禁止登录
	public static final Long _0 = new Long(0);
	//1:有效
	public static final Long _1 = new Long(1);
	private Long id;
	private String createtime;
	private Long createtor;
	private String meetingtime;
	private Long meetingnum;
	
	public  GorgeousturnM() {}
	public GorgeousturnM(GorgeousturnM gorgeousturnm) {
		this.id = gorgeousturnm.getId();
		this.createtime = gorgeousturnm.getCreatetime();
		this.createtor = gorgeousturnm.getCreatetor();
		this.meetingtime = gorgeousturnm.getMeetingtime();
		this.meetingnum = gorgeousturnm.getMeetingnum();
		this.meetingtitle = gorgeousturnm.getMeetingtitle();
		this.meetingremark = gorgeousturnm.getMeetingremark();
	}

	public Long getCreatetor() {
		return createtor;
	}
	public void setCreatetor(Long createtor) {
		this.createtor = createtor;
	}
	public Long getMeetingnum() {
		return meetingnum;
	}
	public void setMeetingnum(Long meetingnum) {
		this.meetingnum = meetingnum;
	}
	private String meetingtitle;
	private String meetingremark;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getMeetingtime() {
		return meetingtime;
	}
	public void setMeetingtime(String meetingtime) {
		this.meetingtime = meetingtime;
	}
	public String getMeetingtitle() {
		return meetingtitle;
	}
	public void setMeetingtitle(String meetingtitle) {
		this.meetingtitle = meetingtitle;
	}
	

	   public String getMeetingremark() {
		return meetingremark;
	}
	public void setMeetingremark(String meetingremark) {
		this.meetingremark = meetingremark;
	}
	public String toString(){
	    	return JSONObject.fromObject(this).toString();
	    }
    
}