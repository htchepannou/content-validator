package com.tchepannou.kiosk.validator;

import java.util.List;

public interface ValidatorContext {
    List<Rule> getRules();
    List<String> getLanguages();
    int getContentMinLength();
    boolean alreadyPublished(String id, String title);
}
