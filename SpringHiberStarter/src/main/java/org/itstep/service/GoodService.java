package org.itstep.service;

import java.util.List;
import java.util.Map;

import org.itstep.dao.pojo.Good;

public interface GoodService {
	
	public Good getGoodById(Long id);
	
	public Good createAndUpdateGood(Good good);
	
	public void deleteGood(long goodId);
	
	public List<Good> getGoodsByFilter(Map<String, String> filters);
}
