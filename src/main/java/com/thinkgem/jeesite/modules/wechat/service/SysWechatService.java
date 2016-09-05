/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wechat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wechat.entity.SysWechat;
import com.thinkgem.jeesite.modules.wechat.dao.SysWechatDao;

/**
 * 微信信息表Service
 * @author 李浩
 * @version 2016-09-05
 */
@Service
@Transactional(readOnly = true)
public class SysWechatService extends CrudService<SysWechatDao, SysWechat> {

	public SysWechat get(String id) {
		return super.get(id);
	}
	
	public List<SysWechat> findList(SysWechat sysWechat) {
		return super.findList(sysWechat);
	}
	
	public Page<SysWechat> findPage(Page<SysWechat> page, SysWechat sysWechat) {
		return super.findPage(page, sysWechat);
	}
	
	@Transactional(readOnly = false)
	public void save(SysWechat sysWechat) {
		super.save(sysWechat);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysWechat sysWechat) {
		super.delete(sysWechat);
	}
	
}