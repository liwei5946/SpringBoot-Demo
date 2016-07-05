package com.cloudwide.didaoa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudwide.didaoa.entity.User;

/**
 * 用户DAO类
 */
@Repository
public interface UserDao {
	
	public User getById(Long id);

	public List<User> getAll();

	public User findByLoginName(String name);

	public int insert(User user);

	public int update(User user);

	public void delete(Long id);
}
