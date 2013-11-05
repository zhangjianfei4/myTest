package org.soap.webservice.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.soap.entity.Department;
import org.soap.entity.Recharge;
import org.soap.entity.User;
import org.soap.service.AccountManager;
import org.soap.webservice.WsConstants;
import org.soap.webservice.dto.DepartmentDTO;
import org.soap.webservice.dto.UserDTO;
import org.soap.webservice.ws.AccountWebService;
import org.soap.webservice.ws.result.DepartmentResult;
import org.soap.webservice.ws.result.RechargeListResult;
import org.soap.webservice.ws.result.UserListResult;
import org.soap.webservice.ws.result.base.IdResult;
import org.soap.webservice.ws.result.base.WSResult;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.mapper.BeanMapper;

/**
 * WebService服务端实现类.
 * 
 * 客户端实现见功能测试用例.
 * 
 * @author
 */
// serviceName与portName属性指明WSDL中的名称, endpointInterface属性指向Interface定义类.
@WebService(serviceName = "AccountService", portName = "AccountServicePort", endpointInterface = "org.soap.webservice.ws.AccountWebService", targetNamespace = WsConstants.NS)
public class AccountWebServiceImpl implements AccountWebService {

	private static Logger logger = LoggerFactory
			.getLogger(AccountWebServiceImpl.class);
	@Autowired
	private AccountManager accountManager;

	/**
	 * @see AccountWebService#getDepartmentDetail()
	 */
	public DepartmentResult getDepartmentDetail(Long id) {
		try {
			Department entity = accountManager.getDepartmentDetail(id);

			Validate.notNull(entity, "部门不存在(id:" + id + ")");

			DepartmentDTO dto = BeanMapper.map(entity, DepartmentDTO.class);

			return new DepartmentResult(dto);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			return new DepartmentResult().setError(WSResult.PARAMETER_ERROR, e
					.getMessage());
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new DepartmentResult().setDefaultError();
		}
	}

	/**
	 * @see AccountWebService#searchUser()
	 */
	public UserListResult searchUser(String loginName, String name) {
		try {
			List<User> entityList = accountManager.searchUser(loginName, name);

			List<UserDTO> dtoList = BeanMapper.mapList(entityList,
					UserDTO.class);
			UserListResult u = new UserListResult(dtoList);
			return u;
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new UserListResult().setDefaultError();
		}
	}

	/**
	 * @see AccountWebService#createUser()
	 */
	public IdResult createUser(UserDTO user) {
		try {
			User userEntity = BeanMapper.map(user, User.class);

			Long userId = accountManager.saveUser(userEntity);

			return new IdResult(userId);
		} catch (ConstraintViolationException e) {
			String message = StringUtils.join(BeanValidators
					.extractPropertyAndMessage(e), "\n");
			return new IdResult().setError(WSResult.PARAMETER_ERROR, message);
		} catch (DataIntegrityViolationException e) {
			String message = "新建用户参数存在唯一性冲突(用户:" + user + ")";
			logger.error(message, e);
			return new IdResult().setError(WSResult.PARAMETER_ERROR, message);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new IdResult().setDefaultError();
		}
	}

	public int add(int n) {
		return 11110;
	}

	public RechargeListResult rechargeInfo(String endTime, String startTime,
			int user_id,String user_name) {
		RechargeListResult list = new RechargeListResult();
		
		List<Recharge> rechargeInfos = new ArrayList<Recharge>();
		rechargeInfos = accountManager.rechargeInfo(endTime, startTime, user_id,user_name);
		
		
		
//		r.setAdmin_user_name("王老虎机");
//		r.setClear_status(1);
//		List<RechargeInfoModel> lis = new ArrayList<RechargeInfoModel>();
//		lis.add(r);
		list.setRechargeInfoList(rechargeInfos);
		return list;
	}
}
