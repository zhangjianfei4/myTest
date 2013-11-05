package org.soap.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.soap.entity.Recharge;
import org.springframework.stereotype.Component;
@Component
public class RechargeDAO extends SqlSessionDaoSupport{
	public List<Recharge> rechargeInfo(Map<String, Object> parameters)	{
		return getSqlSession().selectList("RechargeInfo.rechargeInfoById", parameters );
	}
}
