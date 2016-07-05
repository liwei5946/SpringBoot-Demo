package com.cloudwide.didaoa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudwide.didaoa.dao.RoleDao;
import com.cloudwide.didaoa.entity.Role;

/**
 * 角色控制类
 * 
 * @author Boya
 */
@Controller
@Transactional
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Role> roles = roleDao.getAll();
		model.addAttribute("roles", roles);
		return "role/list";
	}
	
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("role", new Role());
        return "role/edit";
    }

    @RequestMapping("/edit")
    public String edit(Long id, Model model){
        model.addAttribute("role", roleDao.getById(id));
        return "role/edit";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute Role role, RedirectAttributes redirectAttributes) {
    	if (role.getId()==null) {
    		roleDao.insert(role);
    	} else {
    		roleDao.update(role);
    	}
        redirectAttributes.addFlashAttribute("message", "用户【" + role.getName() + "】操作成功");
        return "redirect:/role/list";
    }


    @RequestMapping("delete")
    public String delete(Long id, RedirectAttributes redirectAttributes) {
        roleDao.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除用户成功");
        return "redirect:/role/list";
    }
	
}
