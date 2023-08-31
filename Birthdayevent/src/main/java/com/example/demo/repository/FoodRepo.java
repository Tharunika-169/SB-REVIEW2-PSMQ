package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FoodEntity;

import jakarta.transaction.Transactional;
@Repository

public interface FoodRepo extends JpaRepository<FoodEntity, Integer>{

	@Query(value="select * from Food where foodid=:foodid or briyani=:briyani",nativeQuery=true)
	public List<FoodEntity> getfoodinfo(@Param("foodid") int foodid,@Param("briyani") String briyani);
	
	@Modifying
	@Transactional
	@Query(value="delete from Food where foodid=:foodid",nativeQuery=true)
	public int deletefoodinfo(@Param("foodid")int foodid);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Food SET foodid = ?1 WHERE foodid = ?2", nativeQuery = true)
	public int updatefoodinfo(int newid, int oldid);
}
