package com.rvy.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RedisHash("Product")
public class ProductInventory implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer inventoryId;

	private Double buyingPrice;
	private Double minimumSellingPrice;

	private String batchcode;

	private LocalDate batchdate;

	private Integer quantity;

	private Integer reorderLevel;

	private String status;

	private Integer storeId;

	private Product product;
}