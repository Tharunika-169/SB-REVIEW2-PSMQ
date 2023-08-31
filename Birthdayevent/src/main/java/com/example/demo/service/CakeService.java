package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.CakeEntity;

import com.example.demo.repository.CakeRepo;

@Service	
public class CakeService {

	@Autowired
	CakeRepo pr;
		
		//to get single element
		public CakeEntity saveinfo(CakeEntity ss)
		{
			return pr.save(ss);
		}
		
		
		public List<CakeEntity> showinfo()
		{
			return pr.findAll();
		}
		
		//to get array of elements
		public List<CakeEntity> savedetails(List<CakeEntity>ss)
		{
			return (List<CakeEntity>)pr.saveAll(ss);
		}
		
		//update
		public CakeEntity changeinfo(CakeEntity ss)
		{
			return pr.saveAndFlush(ss);
		}
		
		//to delete a set
		public void deleteinfo(CakeEntity ss)
		{
			pr.delete(ss);
		}

		//to delete by id
		public void deletepid(int id)
		{
			pr.deleteById(id);
		}
		
		public List<CakeEntity> sortinfo(String s)
		{
			return pr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
		}
		public List<CakeEntity> getbypage(int pgno,int pgsize){
			Page<CakeEntity> p=pr.findAll(PageRequest.of(pgno, pgsize));
			return p.getContent();
			
		}
		
		public List<CakeEntity> getcake(int i,String s)
		{
			return pr.getcakeinfo(i, s);
		}
		
		public int delcake(int id)
		{
			return pr.deletecakeinfo(id);
		}
		
		public int updatecake(int id,int id1)
		{
			return pr.updatecakeinfo(id,id1);
		}
}
