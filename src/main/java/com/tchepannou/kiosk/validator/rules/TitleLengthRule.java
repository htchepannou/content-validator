package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import org.jsoup.helper.StringUtil;

public class TitleLengthRule implements Rule{
    public static final String REASON = "title_empty";

    @Override
    public Validation validate(final Validable doc) {
        return  StringUtil.isBlank(doc.getTitle()) ? Validation.failure(REASON) : Validation.success();
    }
}
