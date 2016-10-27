package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Rule;
import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import com.tchepannou.kiosk.validator.ValidatorContext;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NoTitleRuleTest {
    private ValidatorContext ctx;
    private Rule rule = new NoTitleRule();

    @Before
    public void setUp (){
        ctx = mock(ValidatorContext.class);
    }

    @Test
    public void shouldAccept(){
        Validable doc1 = mock(Validable.class);
        when(doc1.getTitle()).thenReturn("Hello world");


        assertThat(rule.validate(doc1, ctx)).isEqualTo(Validation.success());
    }

    @Test
    public void shouldReject(){
        Validable doc1 = mock(Validable.class);
        when(doc1.getTitle()).thenReturn("");

        Validable doc2 = mock(Validable.class);
        when(doc2.getTitle()).thenReturn(null);

        assertThat(rule.validate(doc1, ctx)).isEqualTo(Validation.failure(NoTitleRule.REASON));
        assertThat(rule.validate(doc2, ctx)).isEqualTo(Validation.failure(NoTitleRule.REASON));
    }
}
