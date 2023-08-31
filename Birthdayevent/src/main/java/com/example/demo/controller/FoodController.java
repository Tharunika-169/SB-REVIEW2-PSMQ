package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.FoodEntity;

import com.example.demo.service.FoodService;

@RestController
public class FoodController {

	@Autowired
	FoodService sser;
		@PostMapping ("/addfoods")
		public FoodEntity add(@RequestBody FoodEntity ss)
		{
			return sser.saveinfo(ss);
		}
		
		@PostMapping ("/addnfoods")
		public List<FoodEntity> addndetails (@RequestBody List<FoodEntity> ss)
		{
			return sser.savedetails(ss);
		}
		
		@GetMapping("showfood")
		public List<FoodEntity> show()
		{
			return sser.showinfo();
		}
		
		@PutMapping("/updatefood")
		public FoodEntity modify(@RequestBody FoodEntity ss)
		{
			return sser.changeinfo(ss);
		}
		
		@DeleteMapping("deletefood")
		public String del(@RequestBody FoodEntity ss)
		{
			sser.deleteinfo(ss);
			return "/Deleted successfully";
		}
		

		@DeleteMapping ("/deleteparamfood")
		public void deletebyparamid(@RequestParam("foodid") int id)
		{
			sser.deletepid(id);
			
		}
		@GetMapping("sort2/{briyani}")
		public List<FoodEntity> getsortinfo(@PathVariable String briyani){
			return sser.sortinfo(briyani);
		}
		
		@GetMapping("paging1/{pagenumber}/{pagesi}")
		public List<FoodEntity> showpageinfo(@PathVariable int pagenumber,@PathVariable int pagesi)
		{
			return sser.getbypage(pagenumber,pagesi);
		}
		
		
		//query
		@GetMapping("showqueryfood/{foodid}/{briyani}")
		public 	List<FoodEntity> showfooddetails(@PathVariable int foodid,@PathVariable String briyani)
		{
			return sser.getfood(foodid, briyani);
		}
		@DeleteMapping("deletequerys/{foodid}")
		
		public String delfoodtails(@PathVariable int foodid)
		{
			return sser.delfood(foodid)+"deleted";
		}
		@PutMapping("updatequerys/{newid1}/{oldid1}")
		public String updatefooddetails(@PathVariable int newid1,@PathVariable int oldid1)
		{
			return sser.updatefood(newid1, oldid1)+"updated";
		}
}
