package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TitleLengthRuleTest {
    Rule rule = new TitleLengthRule();

    @Test
    public void shouldAccept(){
        Validable doc1 = mock(Validable.class);
        when(doc1.getTitle()).thenReturn("Hello world");


        assertThat(rule.validate(doc1)).isEqualTo(Validation.success());
    }

    @Test
    public void shouldReject(){
        Validable doc1 = mock(Validable.class);
        when(doc1.getTitle()).thenReturn("");

        Validable doc2 = mock(Validable.class);
        when(doc2.getTitle()).thenReturn(null);

        assertThat(rule.validate(doc1)).isEqualTo(Validation.failure(TitleLengthRule.REASON));
        assertThat(rule.validate(doc2)).isEqualTo(Validation.failure(TitleLengthRule.REASON));
    }
}
