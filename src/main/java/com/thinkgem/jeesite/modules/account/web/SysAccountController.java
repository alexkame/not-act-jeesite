/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.account.entity.SysAccount;
import com.thinkgem.jeesite.modules.account.service.SysAccountService;

/**
 * 账户信息表Controller
 * @author 李浩
 * @version 2016-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/account/sysAccount")
public class SysAccountController extends BaseController {

	@Autowired
	private SysAccountService sysAccountService;
	
	@ModelAttribute
	public SysAccount get(@RequestParam(required=false) String id) {
		SysAccount entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysAccountService.get(id);
		}
		if (entity == null){
			entity = new SysAccount();
		}
		return entity;
	}
	
	@RequiresPermissions("account:sysAccount:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysAccount sysAccount, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysAccount> page = sysAccountService.findPage(new Page<SysAccount>(request, response), sysAccount); 
		model.addAttribute("page", page);
		return "modules/account/sysAccountList";
	}

	@RequiresPermissions("account:sysAccount:view")
	@RequestMapping(value = "form")
	public String form(SysAccount sysAccount, Model model) {
		model.addAttribute("sysAccount", sysAccount);
		return "modules/account/sysAccountForm";
	}

	@RequiresPermissions("account:sysAccount:edit")
	@RequestMapping(value = "save")
	public String save(SysAccount sysAccount, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysAccount)){
			return form(sysAccount, model);
		}
		sysAccountService.save(sysAccount);
		addMessage(redirectAttributes, "保存账户信息表成功");
		return "redirect:"+Global.getAdminPath()+"/account/sysAccount/?repage";
	}
	
	@RequiresPermissions("account:sysAccount:edit")
	@RequestMapping(value = "delete")
	public String delete(SysAccount sysAccount, RedirectAttributes redirectAttributes) {
		sysAccountService.delete(sysAccount);
		addMessage(redirectAttributes, "删除账户信息表成功");
		return "redirect:"+Global.getAdminPath()+"/account/sysAccount/?repage";
	}

}