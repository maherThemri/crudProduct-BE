package com.entretien.test1.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.entretien.test1.dto.ProductDto;
import com.entretien.test1.models.Product;
import com.entretien.test1.repositories.ProductRepository;
import com.entretien.test1.services.ProductService;
import com.entretien.test1.validators.ObjectsValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

	private final ProductRepository repository;
	private final ObjectsValidator<ProductDto> validator;
	
	@Override
	public Long saveProduct(ProductDto dto) {
		validator.validate(dto);
		Product product = ProductDto.toEntity(dto);
		return repository.save(product).getId();
	}

	@Override
	public List<ProductDto> getAllProducts() {
		return repository.findAll()
				.stream()
				.map(ProductDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto findProductById(Long id) {
		return repository.findById(id)
				.map(ProductDto::fromEntity)
				.orElseThrow(()->new EntityNotFoundException("No product with this provided id: "+id));
	}

	@Override
	public void deleteProductById(Long id) {
		repository.deleteById(id);
	}

}
