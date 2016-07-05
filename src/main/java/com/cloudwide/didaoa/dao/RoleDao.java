package com.cloudwide.didaoa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudwide.didaoa.entity.Role;


/**
 * 用户DAO类
 */
@Repository
public interface RoleDao {

	public Role getById(Long id);
	
	public List<Role> getAll();
	
	public int insert(Role role);
	
	public int update(Role role);
	
	public void delete(Long id);
}
