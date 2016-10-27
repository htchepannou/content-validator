package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import com.tchepannou.kiosk.validator.ValidatorContext;

public class ContentLengthRule implements Rule {
    public static final String REASON = "document_size";

    public Validation validate(final Validable doc, final ValidatorContext context) {
        return doc.getContentLength() < context.getContentMinLength() ? Validation.failure(REASON) : Validation.success();
    }
}
