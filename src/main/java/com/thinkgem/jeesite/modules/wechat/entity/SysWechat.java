/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wechat.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 微信信息表Entity
 * @author 李浩
 * @version 2016-09-05
 */
public class SysWechat extends DataEntity<SysWechat> {
	
	private static final long serialVersionUID = 1L;
	private String subscribe;		// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private String openid;		// 用户的标识，对当前公众号唯一
	private String nickname;		// 微信昵称
	private String sex;		// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String city;		// 用户所在城市
	private String country;		// 用户所在国家
	private String province;		// 用户所在省份
	private String language;		// 用户的语言，简体中文为zh_CN
	private String headimgurl;		// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	private String subscribeTime;		// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private String unionid;		// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	private String remark;		// 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private String groupid;		// 用户所在的分组ID（兼容旧的用户分组接口）
	private String status;		// 已关注
	
	public SysWechat() {
		super();
	}

	public SysWechat(String id){
		super(id);
	}

	@Length(min=0, max=200, message="用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。长度必须介于 0 和 200 之间")
	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	
	@Length(min=1, max=200, message="用户的标识，对当前公众号唯一长度必须介于 1 和 200 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=200, message="微信昵称长度必须介于 0 和 200 之间")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=200, message="用户的性别，值为1时是男性，值为2时是女性，值为0时是未知长度必须介于 0 和 200 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=200, message="用户所在城市长度必须介于 0 和 200 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=200, message="用户所在国家长度必须介于 0 和 200 之间")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Length(min=0, max=200, message="用户所在省份长度必须介于 0 和 200 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=200, message="用户的语言，简体中文为zh_CN长度必须介于 0 和 200 之间")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Length(min=0, max=200, message="用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。长度必须介于 0 和 200 之间")
	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	@Length(min=0, max=200, message="用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间长度必须介于 0 和 200 之间")
	public String getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	
	@Length(min=0, max=200, message="只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。长度必须介于 0 和 200 之间")
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Length(min=0, max=200, message="公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注长度必须介于 0 和 200 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Length(min=0, max=200, message="用户所在的分组ID（兼容旧的用户分组接口）长度必须介于 0 和 200 之间")
	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	@Length(min=1, max=1, message="已关注长度必须介于 1 和 1 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}