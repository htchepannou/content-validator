package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;

public class ContentLengthRule implements Rule {
    public static final String REASON = "document_size";
    private final int minLength;

    public ContentLengthRule(final int minLength) {
        this.minLength = minLength;
    }

    public Validation validate(final Validable doc) {
        return doc.getContentLength() < minLength ? Validation.failure(REASON) : Validation.success();
    }
}
