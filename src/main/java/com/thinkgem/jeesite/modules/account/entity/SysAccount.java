/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.wechat.entity.SysWechat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 账户信息表Entity
 * @author 李浩
 * @version 2016-09-05
 */
public class SysAccount extends DataEntity<SysAccount> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String email;		// 邮箱
	private String phone;		// 电话
	private String mobile;		// 手机
	private String userType;		// 用户类型
	private String photo;		// 用户头像
	private String qq;		// QQ
	private SysWechat wechat;		// 微信
	
	public SysAccount() {
		super();
	}

	public SysAccount(String id){
		super(id);
	}

	@Length(min=1, max=100, message="姓名长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="邮箱长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=200, message="电话长度必须介于 0 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=200, message="手机长度必须介于 0 和 200 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=1, message="用户类型长度必须介于 0 和 1 之间")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Length(min=0, max=1000, message="用户头像长度必须介于 0 和 1000 之间")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Length(min=0, max=64, message="QQ长度必须介于 0 和 64 之间")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public SysWechat getWechat() {
		return wechat;
	}

	public void setWechat(SysWechat wechat) {
		this.wechat = wechat;
	}
	
}