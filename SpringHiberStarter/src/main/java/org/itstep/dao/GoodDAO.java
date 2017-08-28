package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Good;
import org.itstep.dao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodDAO extends JpaRepository<Good, Long>{

	@Query(value = "?1", nativeQuery = true)
	List<Good> getGoodsByFilter(String query);

	//	//@Query(value = "SELECT * FROM USERS WHERE EMAIL=?1 AND PASSWORD=?2", nativeQuery = true)
//	public User findOneByEmailAndPassword(String email, String password);

}
