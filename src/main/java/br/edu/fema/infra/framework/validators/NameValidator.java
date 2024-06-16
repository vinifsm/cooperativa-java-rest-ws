package br.edu.fema.infra.framework.validators;

import br.edu.fema.infra.framework.annotations.NameValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import java.util.Objects;

public class NameValidator implements ConstraintValidator<NameValidation, String> {

    private int parts;
    private boolean addExtraConstraint;

    @Override
    public void initialize(NameValidation constraintAnnotation) {
        this.parts = constraintAnnotation.parts();
        this.addExtraConstraint = constraintAnnotation.addExtraConstraint();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (Objects.isNull(name)) {
            return true;
        }

        final String[] parts = name.trim().split(" ");

        final boolean validated = parts.length >= this.parts;

        if (!validated) {
            ((ConstraintValidatorContextImpl) context)
                    .addMessageParameter("parts", this.parts)
                    .addMessageParameter("name", name);

            if (this.addExtraConstraint) {
                ((ConstraintValidatorContextImpl) context)
                        .buildConstraintViolationWithTemplate(
                                "Critical: Nome inválido")
                        .addConstraintViolation();
            }
        }

        return validated;
    }
}
