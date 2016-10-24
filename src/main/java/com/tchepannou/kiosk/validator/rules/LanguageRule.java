package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;

import java.util.Collection;

public class LanguageRule implements Rule {
    public static final String REASON = "invalid_language";

    private final Collection<String> languages;

    public LanguageRule(final Collection<String> languages) {
        this.languages = languages;
    }

    @Override
    public Validation validate(final Validable doc) {
        final String lang = doc.getLanguage();
        return lang != null && languages.contains(lang)
                ? Validation.success()
                : Validation.failure(REASON);
    }

}
