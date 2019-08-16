package com.hyg.service.impl;

import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.pojo.ChargeType;
import com.hyg.service.ChargeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * 罪名分类表 service
 */
@Service("chargeTypeServiceImpl")
public class ChargeTypeServiceImpl implements ChargeTypeService
{
	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper chargeTypeMapper;

	/**
	 * 添加一个罪名分类
	 * 前端传来的数据：chargeTypeName
	 * 需要添加的数据：chargeTypeName、editDate、count、deleteFlag
	 * @param chargeType
	 * @return
	 */
	@Override
	public boolean insertOneChargeType(ChargeType chargeType)
	{
		chargeType.setEditDate(new Timestamp(System.currentTimeMillis()));
		chargeType.setCount(0);
		chargeType.setDeleteFlag("0");

		try
		{
			chargeTypeMapper.insertOneChargeType(chargeType);
		}
		catch (Exception e)
		{
			System.out.println("++++++++++++++发生异常++++++++++++++");
			e.printStackTrace();
			return false;
		}

		return true;
	}
}