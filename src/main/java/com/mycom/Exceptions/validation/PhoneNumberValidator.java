package com.mycom.Exceptions.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, Long> {

		@Override
		public boolean isValid(Long phNum, ConstraintValidatorContext context) {
				if (phNum == null) return false;
				Pattern pattern = Pattern.compile("[6789][\\d]{9}");
				Matcher matcher = pattern.matcher(phNum.toString());
				return matcher.matches();
		}

}