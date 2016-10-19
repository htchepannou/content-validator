package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContentLengthRuleTest {
    ContentLengthRule rule;

    @Before
    public void setUp (){
        rule = new ContentLengthRule(5);
    }

    @Test
    public void shouldAccept(){
        Validable doc1 = mock(Validable.class);
        when(doc1.getContentLength()).thenReturn(5);

        Validable doc2 = mock(Validable.class);
        when(doc2.getContentLength()).thenReturn(10);


        assertThat(rule.validate(doc1)).isEqualTo(Validation.success());
        assertThat(rule.validate(doc2)).isEqualTo(Validation.success());
    }

    @Test
    public void shouldReject(){
        Validable doc = mock(Validable.class);
        when(doc.getContentLength()).thenReturn(1);

        assertThat(rule.validate(doc)).isEqualTo(Validation.failure(ContentLengthRule.REASON));
    }
}
