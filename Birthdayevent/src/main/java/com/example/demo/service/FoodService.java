package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.FoodEntity;
import com.example.demo.repository.FoodRepo;
@Service
public class FoodService {

	@Autowired
	FoodRepo pr;
		
		//to get single element
		public FoodEntity saveinfo(FoodEntity ss)
		{
			return pr.save(ss);
		}
		
		
		public List<FoodEntity> showinfo()
		{
			return pr.findAll();
		}
		
		//to get array of elements
		public List<FoodEntity> savedetails(List<FoodEntity>ss)
		{
			return (List<FoodEntity>)pr.saveAll(ss);
		}
		
		//update
		public FoodEntity changeinfo(FoodEntity ss)
		{
			return pr.saveAndFlush(ss);
		}
		
		//to delete a set
		public void deleteinfo(FoodEntity ss)
		{
			pr.delete(ss);
		}

		//to delete by id
		public void deletepid(int id)
		{
			pr.deleteById(id);
		}
		
		public List<FoodEntity> sortinfo(String s)
		{
			return pr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
		}
		public List<FoodEntity> getbypage(int pgno,int pgsize){
			Page<FoodEntity> p=pr.findAll(PageRequest.of(pgno, pgsize));
			return p.getContent();
			
		}
		
		public List<FoodEntity> getfood(int i,String s)
		{
			return pr.getfoodinfo(i,s);
		}	
		
		public int delfood(int id)
		{
			return pr.deletefoodinfo(id);
		}
		
		public int updatefood(int id,int id1)
		{
			return pr.updatefoodinfo(id,id1);
		}
}		
