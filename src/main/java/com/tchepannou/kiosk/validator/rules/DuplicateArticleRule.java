package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import com.tchepannou.kiosk.validator.ValidatorContext;

public class DuplicateArticleRule implements Rule{
    public static final String REASON = "duplicate";

    @Override
    public Validation validate(final Validable doc, final ValidatorContext ctx) {
        return ctx.alreadyPublished(doc.getId(), doc.getTitle())
                ? Validation.failure(REASON)
                : Validation.success();
    }
}
