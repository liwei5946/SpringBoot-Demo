package com.cloudwide.didaoa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloudwide.didaoa.dao.RoleDao;
import com.cloudwide.didaoa.dao.UserDao;
import com.cloudwide.didaoa.entity.Role;
import com.cloudwide.didaoa.entity.User;
import com.github.pagehelper.PageHelper;

/**
 * 用户控制类
 * 
 * @author Boya
 */
@Controller
@Transactional
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@RequestMapping("/list")
	public String list(Integer pno, Integer psize, Model model) {
		//分页演示
		if (pno!=null && psize!=null) {
			PageHelper.startPage(pno, psize);
		}
		List<User> users = userDao.getAll();
		model.addAttribute("users", users);
		return "user/list";
	}
	
    @RequestMapping("/create")
    public String create(Model model) {
    	model.addAttribute("user", new User());
        model.addAttribute("roles", roleDao.getAll());
        return "user/edit";
    }

    @RequestMapping("/edit")
    public String edit(Long id, Model model){
        model.addAttribute("user", userDao.getById(id));
        model.addAttribute("roles", roleDao.getAll());
        return "user/edit";
    }

    @RequestMapping("/save")
    public String save(User user, RedirectAttributes redirectAttributes) {
    	if (user.getId()==null) {
    		userDao.insert(user);	
    	} else {
    		userDao.update(user);
    	}
        
        redirectAttributes.addFlashAttribute("message", "用户【" + user.getName() + "】操作成功");
        return "redirect:/user/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id, RedirectAttributes redirectAttributes) {
        userDao.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除用户成功");
        return "redirect:/user/list";
    }
	
}
