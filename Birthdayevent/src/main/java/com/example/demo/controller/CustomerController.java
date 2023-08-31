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

import com.example.demo.model.CustomerEntity;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService sser;
	
	@PostMapping("/addcustomer")
	public CustomerEntity add(@RequestBody CustomerEntity ss)
	{
		return sser.saveinfo(ss);
	}
	
	@PostMapping("/addncustomer")
	public List<CustomerEntity> addndetails (@RequestBody List<CustomerEntity> ss)
	{
		return sser.savedetails(ss);
	}
	
	@GetMapping("showdetails")
	public List<CustomerEntity> show()
	{
		return sser.showinfo();
	}
	
	@PutMapping("/updatecustomer")
	public CustomerEntity modify(@RequestBody CustomerEntity ss)
	{
		return sser.changeinfo(ss);
	}
	
	@DeleteMapping("deletedetails")
	public String del(@RequestBody CustomerEntity ss)
	{
		sser.deleteinfo(ss);
		return "/Deleted successfully";
	}
	

	@DeleteMapping ("/deleteparamid")
	public void deletebyparamid(@RequestParam("theme") int id)
	{
		sser.deletepid(id);
	}
	
	@GetMapping("sorting/{theme}")
	public List<CustomerEntity> getsortinfo(@PathVariable String theme){
		return sser.sortinfo(theme);
	}
	
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<CustomerEntity> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return sser.getbypage(pageno,pagesize);
	}
	
	//query
	@GetMapping("showquery/{custid}/{custname}")
	public 	List<CustomerEntity> showcustdetails(@PathVariable int custid,@PathVariable String custname)
	{
		return sser.getcust(custid, custname);
	}
	@DeleteMapping("deletequery/{custid}")
	
	public String delcustdetails(@PathVariable int custid)
	{
		return sser.delcust(custid)+"deleted";
	}
	@PutMapping("updatequery/{newid}/{oldid}")
	public String updatecustdetails(@PathVariable int newid,@PathVariable int oldid)
	{
		return sser.updatecust(newid, oldid)+"updated";
	}
	
	//one to one
	@PostMapping("addcustomerfood")
	public CustomerEntity add11(@RequestBody CustomerEntity ss)
	{
		return sser.saveinfo(ss);
	}
	@PostMapping("addncustomerfood")
	public List<CustomerEntity> add2(@RequestBody List<CustomerEntity> ss) {		
		return sser.savecustomeriddetail2(ss);
	}
	@GetMapping("showdetails2")
	public List<CustomerEntity> show2()
	{
		return sser.showcustomeridinfo2();
	}
}
