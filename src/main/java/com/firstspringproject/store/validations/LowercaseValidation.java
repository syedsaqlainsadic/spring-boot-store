package com.firstspringproject.store.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LowercaseValidation implements ConstraintValidator<Lowercase,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        // TODO Auto-generated method stub
        if(value == null) return true;
       return value.equals(value.toLowerCase());
    }

}
