package org.soap.webservice.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.soap.webservice.WsConstants;
import org.soap.webservice.dto.UserDTO;
import org.soap.webservice.ws.result.DepartmentResult;
import org.soap.webservice.ws.result.RechargeListResult;
import org.soap.webservice.ws.result.UserListResult;
import org.soap.webservice.ws.result.base.IdResult;


/**
 * JAX-WS2.0的WebService接口定义类.
 * 
 * 使用JAX-WS2.0 annotation设置WSDL中的定义. 使用WSResult及其子类类包裹返回结果.
 * 使用DTO传输对象隔绝系统内部领域对象的修改对外系统的影响.
 * 
 * @author
 */
@WebService(name = "AccountService", targetNamespace = WsConstants.NS)
public interface AccountWebService {
	/**
	 * 获取部门的详细信息.
	 */
	DepartmentResult getDepartmentDetail(@WebParam(name = "id") Long id);

	/**
	 * 搜索用户信息.
	 */
	UserListResult searchUser(@WebParam(name = "loginName") String loginName,
			@WebParam(name = "name") String name);

	/**
	 * 新建用户.
	 */
	IdResult createUser(@WebParam(name = "user") UserDTO user);

	// test
	int add(@WebParam(name = "user") int user);

	/**获取充值记录
	 * @param endTime
	 * @param startTime
	 * @param user_id
	 * @return
	 */
	RechargeListResult rechargeInfo(@WebParam(name = "endTime") String endTime,
			@WebParam(name = "startTime") String startTime,
			@WebParam(name = "user_id") int user_id,
			@WebParam(name="user_name") String user_name);                
	


}
