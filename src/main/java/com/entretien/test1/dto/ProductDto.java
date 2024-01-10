package com.entretien.test1.dto;


import javax.validation.constraints.Size;

import com.entretien.test1.models.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
	
	private Long id;
	
	@Size(min=3,max=12, message="Product name is not valid")
	private String name;
	
	@Size(min=6, message="Description is not valid")
	private String description;
	
	private float price;
	
	public static ProductDto fromEntity(Product product) {
		return ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
	public static Product toEntity(ProductDto dto) {
		return Product.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.price(dto.getPrice())
				.build();
	}

}
