package com.entretien.test1.services;

import java.util.List;

import com.entretien.test1.dto.ProductDto;

public interface ProductService {
	public Long saveProduct(ProductDto dto);
	public List<ProductDto> getAllProducts();
	public ProductDto findProductById(Long id);
	public void deleteProductById(Long id);
	
}
