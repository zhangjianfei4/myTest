package org.soap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.soap.dao.AccountDao;
import org.soap.dao.RechargeDAO;
import org.soap.entity.Department;
import org.soap.entity.Recharge;
import org.soap.entity.User;
import org.springside.modules.beanvalidator.BeanValidators;

import com.google.common.collect.Maps;

/**
 * 帐号管理类.
 * 
 * 实现领域对象用户及其相关实体的所有业务管理函数. 使用Spring annotation定义事务管理.
 * 
 * @author
 */
// Spring Service Bean的标识.
@Component
// 默认将类中的所有函数纳入事务管理.
@Transactional(readOnly = true)
public class AccountManager {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private Validator validator;
	@Autowired
	private RechargeDAO rechargeDAO;

	public Department getDepartmentDetail(Long id) {
		Validate.notNull(id, "id参数为空");
		return accountDao.getDepartmentDetail(id);
	}

	public User getUser(Long id) {
		Validate.notNull(id, "id参数为空");
		return accountDao.getUser(id);
	}

	public List<User> searchUser(String loginName, String name) {
		Map<String, Object> parameters = Maps.newHashMap();
		parameters.put("loginName", loginName);
		parameters.put("name", name);
		return accountDao.searchUser(parameters);
	}

	public List<Recharge> rechargeInfo(String endTime,
			String startTime, int user_id,String user_name) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("endTime", endTime);
		parameters.put("startTime", startTime);
		parameters.put("user_id", user_id);
		parameters.put("user_name", user_name);
		List<Recharge> list = rechargeDAO.rechargeInfo(parameters);
		return list;
	}

	@Transactional(readOnly = false)
	public Long saveUser(User user) throws ConstraintViolationException {
		Validate.notNull(user, "用户参数为空");
		// 使用Hibernate Validator校验请求参数
		BeanValidators.validateWithException(validator, user);

		return accountDao.saveUser(user);
	}
}
