package org.soap.webservice.ws.result;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.soap.entity.Recharge;
import org.soap.webservice.ws.result.base.WSResult;
import org.soap.webservice.WsConstants;

//
//import org.springside.examples.miniservice.webservice.WsConstants;
//import org.springside.examples.miniservice.webservice.dto.UserDTO;
//import org.springside.examples.miniservice.webservice.ws.result.base.WSResult;

/**
 * 
 * 
 * 
 */
@XmlType(name = "RechargeResult", namespace = WsConstants.NS)
public class RechargeListResult extends WSResult {

	private List<Recharge> rechargeInfoList;
	
	public RechargeListResult(){
	}
	
	public RechargeListResult(List<Recharge> rechargeInfoList){
		this.rechargeInfoList = rechargeInfoList;
	}
	
	@XmlElementWrapper(name = "rechargeInfoList")
	@XmlElement(name = "rechargeInfo")
	public List<Recharge> getRechargeInfoList() {
		return rechargeInfoList;
	}

	public void setRechargeInfoList(List<Recharge> rechargeInfoList) {
		this.rechargeInfoList = rechargeInfoList;
	}
	

	
	

	


}
