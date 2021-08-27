package com.rvy.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import com.rvy.entity.Product;
import com.rvy.entity.ProductInventory;

@Repository
public class ProducerRepository {

	public static final String HASH_KEY = "Product";
	
	@Autowired
	private RedisTemplate template;
	
	public ProductInventory save(ProductInventory product)
	{
		template.opsForHash().put(HASH_KEY, product.getInventoryId(), product);
		return product;
	}
	
	public List<ProductInventory> findAll(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public ProductInventory findById(Integer id) {
		return (ProductInventory) template.opsForHash().get(HASH_KEY, id);
	}
	
	public Integer deleteCustomer(Integer id) {
		template.opsForHash().delete(HASH_KEY, id);
		return id;
	}
	
	public ProductInventory update(ProductInventory product) {
		template.opsForHash().put(HASH_KEY, product.getInventoryId(), product);
		return product;
	}
}
