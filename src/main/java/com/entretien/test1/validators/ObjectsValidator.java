package com.entretien.test1.validators;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import com.entretien.test1.exceptions.ObjectValidationException;


@Component
public class ObjectsValidator <T> {

	private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private final Validator validator = factory.getValidator();
	
	public void validate(T objectToValidate) {
		Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
		
		if(!violations.isEmpty()) {
			Set<String> errorMessages = violations.stream()
					.map(ConstraintViolation::getMessage)
					.collect(Collectors.toSet());
			throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
		}
	}
}
