package com.tchepannou.kiosk.validator;

public class Validator  {
    public Validation validate(final Validable doc , final ValidatorContext context) {
        for (final Rule rule : context.getRules()) {
            final Validation validation = rule.validate(doc);
            if (!validation.isSuccess()) {
                return validation;
            }
        }
        return Validation.success();
    }
}
