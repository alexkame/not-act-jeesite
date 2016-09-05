/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.account.entity.SysAccount;

/**
 * 账户信息表DAO接口
 * @author 李浩
 * @version 2016-09-05
 */
@MyBatisDao
public interface SysAccountDao extends CrudDao<SysAccount> {
	
}