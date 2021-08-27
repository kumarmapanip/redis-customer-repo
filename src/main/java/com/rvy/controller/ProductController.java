package com.rvy.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rvy.entity.Product;
import com.rvy.entity.ProductInventory;
import com.rvy.repo.ProducerRepository;

@RestController
@RequestMapping("/rvy/api/pis/v1/")
public class ProductController {
	
	@Autowired
	private ProducerRepository repository;
	
	@GetMapping("/products")
	public List<ProductInventory> getAllCustomer()
	{
		return repository.findAll();
	}
	
	@PostMapping("/products")
	public ProductInventory addProduct(@RequestBody ProductInventory product)
	{
		Integer firstLayerRandomness =  ThreadLocalRandom.current().nextInt(1000001,100000004)%999999;
		Integer secondLayerRandomness = ThreadLocalRandom.current().nextInt(999,999978);
		Integer cipherKey = ThreadLocalRandom.current().nextInt(1000,5000);
		Integer encodedId = (firstLayerRandomness*cipherKey%firstLayerRandomness + secondLayerRandomness)%firstLayerRandomness;
		product.setInventoryId(Math.abs(encodedId));
		return repository.save(product);
	}
	
	@GetMapping("/products/{id}")
	public ProductInventory getById(@PathVariable("id") Integer id)
	{
		return repository.findById(id);
	}
	
	@PutMapping("/products")
	public ProductInventory updateProduct(@RequestBody ProductInventory prod)
	{
		return repository.update(prod);
	}
	
	@DeleteMapping("/products/{id}")
	public Integer deleteById(@PathVariable("id") Integer id)
	{
		return repository.deleteCustomer(id);
	}
	
}
