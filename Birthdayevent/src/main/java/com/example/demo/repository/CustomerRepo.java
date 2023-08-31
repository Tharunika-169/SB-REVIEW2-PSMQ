package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerEntity;

import jakarta.transaction.Transactional;
@Repository

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {
	
	@Query(value="select * from Customer where custid=:custid or custname=:custname",nativeQuery=true)
	public List<CustomerEntity> getcustomerinfo(@Param("custid") int custid,@Param("custname") String custname);
	
	@Modifying
	@Transactional
	@Query(value="delete from Customer where custid=:custid",nativeQuery=true)
	public int deletecustomerinfo(@Param("custid")int custid);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Customer SET custid = ?1 WHERE custid = ?2", nativeQuery = true)
	public int updatecustomerinfo(int newid, int oldid);

}
