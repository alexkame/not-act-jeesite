/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.account.entity.SysAccount;
import com.thinkgem.jeesite.modules.account.dao.SysAccountDao;

/**
 * 账户信息表Service
 * @author 李浩
 * @version 2016-09-05
 */
@Service
@Transactional(readOnly = true)
public class SysAccountService extends CrudService<SysAccountDao, SysAccount> {

	public SysAccount get(String id) {
		return super.get(id);
	}
	
	public List<SysAccount> findList(SysAccount sysAccount) {
		return super.findList(sysAccount);
	}
	
	public Page<SysAccount> findPage(Page<SysAccount> page, SysAccount sysAccount) {
		return super.findPage(page, sysAccount);
	}
	
	@Transactional(readOnly = false)
	public void save(SysAccount sysAccount) {
		super.save(sysAccount);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysAccount sysAccount) {
		super.delete(sysAccount);
	}
	
}