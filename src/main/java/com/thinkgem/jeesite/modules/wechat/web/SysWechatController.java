/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wechat.web;

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
import com.thinkgem.jeesite.modules.wechat.entity.SysWechat;
import com.thinkgem.jeesite.modules.wechat.service.SysWechatService;

/**
 * 微信信息表Controller
 * @author 李浩
 * @version 2016-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/wechat/sysWechat")
public class SysWechatController extends BaseController {

	@Autowired
	private SysWechatService sysWechatService;
	
	@ModelAttribute
	public SysWechat get(@RequestParam(required=false) String id) {
		SysWechat entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysWechatService.get(id);
		}
		if (entity == null){
			entity = new SysWechat();
		}
		return entity;
	}
	
	@RequiresPermissions("wechat:sysWechat:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysWechat sysWechat, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysWechat> page = sysWechatService.findPage(new Page<SysWechat>(request, response), sysWechat); 
		model.addAttribute("page", page);
		return "modules/wechat/sysWechatList";
	}

	@RequiresPermissions("wechat:sysWechat:view")
	@RequestMapping(value = "form")
	public String form(SysWechat sysWechat, Model model) {
		model.addAttribute("sysWechat", sysWechat);
		return "modules/wechat/sysWechatForm";
	}

	@RequiresPermissions("wechat:sysWechat:edit")
	@RequestMapping(value = "save")
	public String save(SysWechat sysWechat, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysWechat)){
			return form(sysWechat, model);
		}
		sysWechatService.save(sysWechat);
		addMessage(redirectAttributes, "保存微信成功");
		return "redirect:"+Global.getAdminPath()+"/wechat/sysWechat/?repage";
	}
	
	@RequiresPermissions("wechat:sysWechat:edit")
	@RequestMapping(value = "delete")
	public String delete(SysWechat sysWechat, RedirectAttributes redirectAttributes) {
		sysWechatService.delete(sysWechat);
		addMessage(redirectAttributes, "删除微信成功");
		return "redirect:"+Global.getAdminPath()+"/wechat/sysWechat/?repage";
	}

}