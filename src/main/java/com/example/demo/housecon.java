package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class housecon {
	@Autowired
	houserep repo;
	@PostMapping("/saveHouse")
	public house enter(@RequestBody house h)
	{
		repo.save(h);
		return h;
	}
	@GetMapping("/getAllHouse")
	public List<house> getall()
	{
		return (List<house>) repo.findAll();
	}
	@GetMapping("/getById")
	public Optional<house> getid(@RequestParam("id") int id)
	{
		return repo.findById(id);
	}
	@DeleteMapping("/deleteHouse")
	public String deleteid(@RequestParam("id") int houseId)
	{
		house h=repo.getById(houseId);
		repo.delete(h);
		return "deleted";
	}
	@GetMapping("/getByType")
	public List<house> bytype(@RequestParam("type") String type)
	{
		return repo.findByType(type);
	}
	

}
