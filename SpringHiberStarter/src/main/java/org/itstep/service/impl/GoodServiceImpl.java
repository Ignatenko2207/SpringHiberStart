package org.itstep.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;

import org.itstep.dao.GoodDAO;
import org.itstep.dao.pojo.Good;
import org.itstep.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	GoodDAO goodDAO;

	@Override
	public Good getGoodById(Long id) {
		return goodDAO.getOne(id);
	}

	@Override
	public Good createAndUpdateGood(Good good) {
		return goodDAO.save(good);
	}

	@Override
	public void deleteGood(long goodId) {
		goodDAO.delete(goodId);
	}

	@Override
	public List<Good> getGoodsByFilter(Map<String, String> filters) {

		String query = getFilter(filters);
		return goodDAO.getGoodsByFilter(query);
	}

	private String getFilter(Map<String, String> filters) {
		Set<String> keys = filters.keySet();
		List<String> filterQureies = new ArrayList<String>();
		for (String key : keys) {
			if(filters.get(key)!=null){
				if(key.equals("PRICE")){
					String filterQuery = key + "<" + filters.get(key);
					filterQureies.add(filterQuery);
					continue;
				}
				String filterQuery = key + "=" + filters.get(key);
				filterQureies.add(filterQuery);
			}
		}
		String filter = "SELECT * FROM GOODS ";
		if(filterQureies.isEmpty()){
			filter +=";";
			return filter;
		}
		filter += "WHERE ";
		for (String query : filterQureies) {
			filter += query;
			filter += " AND ";
		}
		filter.substring(0, filter.length()-4);
		filter += ";";
		return filter;
	}

}
