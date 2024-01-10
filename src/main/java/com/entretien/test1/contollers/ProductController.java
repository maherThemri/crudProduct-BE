package com.entretien.test1.contollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entretien.test1.dto.ProductDto;
import com.entretien.test1.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;
	
	@PostMapping("/save-product")
	public ResponseEntity<Long> saveProduct(@RequestBody ProductDto dto){
		return ResponseEntity.ok(service.saveProduct(dto));
	}
	@GetMapping("/find-all-products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		return ResponseEntity.ok(service.getAllProducts());
	}
	@GetMapping("/get-product/{id}")
	public ResponseEntity<ProductDto> findUserById(@PathVariable Long id){
		return ResponseEntity.ok(service.findProductById(id));
	}
	
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
		service.deleteProductById(id);
		return ResponseEntity.ok().build();
	}

}
