package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerEntity;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo pr;
	
	//to get single element
	public CustomerEntity saveinfo(CustomerEntity ss)
	{
		return pr.save(ss);
	}
	
	
	public List<CustomerEntity> showinfo()
	{
		return pr.findAll();
	}
	
	//to get array of elements
	public List<CustomerEntity> savedetails(List<CustomerEntity>ss)
	{
		return (List<CustomerEntity>)pr.saveAll(ss);
	}
	
	//update
	public CustomerEntity changeinfo(CustomerEntity ss)
	{
		return pr.saveAndFlush(ss);
	}
	
	//to delete a set
	public void deleteinfo(CustomerEntity ss)
	{
		pr.delete(ss);
	}

	//to delete by id
	public void deletepid(int id)
	{
		pr.deleteById(id);
	}
	
	
	public List<CustomerEntity> getbypage(int pgno,int pgsize){
		Page<CustomerEntity> p=pr.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
		
	}
	
	public List<CustomerEntity> sortinfo(String s)
	{
		return pr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	
	public List<CustomerEntity> getcust(int i,String s)
	{
		return pr.getcustomerinfo(i, s);
	}
	
	public int delcust(int id)
	{
		return pr.deletecustomerinfo(id);
	}
	
	public int updatecust(int id,int id1)
	{
		return pr.updatecustomerinfo(id,id1);
	}
	
	public CustomerEntity savecustomeriddetail1(CustomerEntity ss)
	{
		return pr.save(ss);
	}
	
	
	public List<CustomerEntity> savecustomeriddetail2(List<CustomerEntity>ss)
	{
		return (List<CustomerEntity>)pr.saveAll(ss);
	}
	
	public List<CustomerEntity> showcustomeridinfo2()
	{
	      return pr.findAll();
	}
}
