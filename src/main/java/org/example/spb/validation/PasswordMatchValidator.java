package org.example.spb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.example.spb.dto.UserDto;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {

	@Override
	public void initialize(PasswordMatch arg0) {
		//	
	}

	@Override
	public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
		final UserDto dto = (UserDto) obj;
		return dto.getPassword().equals(dto.getConfirmedPassword());
	}
}