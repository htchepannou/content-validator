package com.tchepannou.kiosk.validator;

public interface Rule {
    Validation validate(Validable doc);
}
