package com.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.dtos.ProductDto;
import com.ecart.dtos.Response;
import com.ecart.service.ProductService;

@RestController
public class ProductController {
	

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Object> listAllProducts(){
		Object obj = productService.listAllProducts();
		Response res = new Response();
		res.setData(obj);
		res.setResponseCode("0");
		res.setResposneDesc("List fetch Success");
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto){
		Object obj = productService.saveProdct(productDto);
		Response res = new Response();
		res.setData(obj);
		res.setResponseCode("0");
		res.setResposneDesc(obj.toString());
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/updateproduct")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto){
		Object obj = productService.updateProduct(productDto);
		Response res = new Response();
		res.setData(obj);
		res.setResponseCode("0");
		res.setResposneDesc(obj.toString());
		return ResponseEntity.ok(res);
	}
	
	@PostMapping("/deleteproduct/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id){
		Object obj = productService.deleteById(id);
		Response res = new Response();
		res.setData(obj);
		res.setResponseCode("0");
		res.setResposneDesc(obj.toString());
		return ResponseEntity.ok(res);
	}
	@PostMapping("/byId/{id}")
	public ResponseEntity<Object> findByProductById(@PathVariable("id") Long id){
		Object obj = productService.findByProductId(id);
		Response res = new Response();
		res.setData(obj);
		res.setResponseCode("0");
		res.setResposneDesc("Fetch Product");
		return ResponseEntity.ok(res);
	}
}