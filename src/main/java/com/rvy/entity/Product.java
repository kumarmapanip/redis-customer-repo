package com.rvy.entity;

import java.io.Serializable;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer productId;
	
	private String category;
	private String type;
	private String brand;
	private String productName;
	private Byte[] image;

	private ProductDesc productDesc;
	
}
