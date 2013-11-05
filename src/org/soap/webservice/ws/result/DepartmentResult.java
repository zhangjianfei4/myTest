package org.soap.webservice.ws.result;

import javax.xml.bind.annotation.XmlType;

import org.soap.webservice.WsConstants;
import org.soap.webservice.dto.DepartmentDTO;
import org.soap.webservice.ws.result.base.WSResult;

/**
 * GetDepartment方法的返回结果.
 * 
 
 */
@XmlType(name = "DepartmentResult", namespace = WsConstants.NS)
public class DepartmentResult extends WSResult {

	private DepartmentDTO department;

	public DepartmentResult() {
	}

	public DepartmentResult(DepartmentDTO department) {
		this.department = department;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
}
