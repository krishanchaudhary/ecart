package com.ecart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.dtos.ProductDto;
import com.ecart.entity.Product;
import com.ecart.repo.ProductRepository;
import com.ecart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Object listAllProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productsList = new ArrayList<>();
		for(Product product : products) {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setPrice(product.getPrice());
			productDto.setQuantity(product.getQuantity());
			productDto.setDiscount(product.getDiscount());
			productsList.add(productDto);
		}
		return productsList;
	}

	@Override
	public Object findByProductId(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		Product product  = productOptional.orElse(null);
		if(product!=null) {
			ProductDto productDto = new ProductDto();
			productDto.setId(product.getId());
			productDto.setDiscount(product.getDiscount());
			productDto.setName(product.getName());
			productDto.setPrice(product.getPrice());
			productDto.setQuantity(product.getQuantity());
			return product;
		}
		return null;
	}

	@Override
	public Object deleteById(Long id) {
		productRepository.deleteById(id);
		return "Product Delete Successfully";
	}

	@Override
	public Object saveProdct(ProductDto productDto) {
		Product product = new Product();
		product.setDiscount(productDto.getDiscount());
		product.setPrice(productDto.getPrice());
		product.setName(productDto.getName());
		product.setQuantity(productDto.getQuantity());
		productRepository.save(product);
		return "Product Save Successfull";
	}

	@Override
	public Object updateProduct(ProductDto productDto) {
		Optional<Product> productOpt = productRepository.findById(productDto.getId());
		Product product = productOpt.orElse(null);
		if(product!=null) {
			if(productDto.getName()!=null) {
				product.setName(productDto.getName());	
			}
			if(productDto.getPrice()!=null) {
				product.setPrice(productDto.getPrice());	
			}
			if(productDto.getDiscount()!=null) {
				product.setDiscount(productDto.getDiscount());	
			}
			if(productDto.getQuantity()!=null) {
				product.setQuantity(productDto.getQuantity());	
			}
			productRepository.save(product);
			return "Product Save SuccessfullY";
		}
		return null;
	}
}
