package org.soap.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.soap.entity.Department;
import org.soap.entity.User;

@Component
public class AccountDao extends SqlSessionDaoSupport {

	public Department getDepartmentDetail(Long id) {
		return (Department) getSqlSession().selectOne("Account.getDepartmentDetail", id);
	}

	public User getUser(Long id) {
		return (User) getSqlSession().selectOne("Account.getUser", id);
	}

	public Long saveUser(User user) {
		getSqlSession().insert("Account.saveUser", user);
		return user.getId();
	}

	public List<User> searchUser(Map<String, Object> parameters) {
		List<User> list=new ArrayList<User>();
		User u=new User();
		u.setDepartment(null);
		u.setPassword("1");
		u.setLoginName("1");
		u.setEmail("hh");
		u.setName("name");
		list.add(u);
		return list;
//		return getSqlSession().selectList("Account.searchUser", parameters);
	}
}
