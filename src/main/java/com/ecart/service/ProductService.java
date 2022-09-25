package com.ecart.service;

import com.ecart.dtos.ProductDto;

public interface ProductService {

	Object listAllProducts();
	Object findByProductId(Long id);
	Object deleteById(Long id);
	Object saveProdct(ProductDto productDto);
	Object updateProduct(ProductDto productDto);
	
}
