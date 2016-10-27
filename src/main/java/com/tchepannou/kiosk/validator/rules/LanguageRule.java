package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import com.tchepannou.kiosk.validator.ValidatorContext;

public class LanguageRule implements Rule {
    public static final String REASON = "invalid_language";

    @Override
    public Validation validate(final Validable doc, final ValidatorContext context) {
        final String lang = doc.getLanguage();
        return lang != null && context.getLanguages().contains(lang)
                ? Validation.success()
                : Validation.failure(REASON);
    }

}
