package com.tchepannou.kiosk.validator;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidatorTest {
    @Test
    public void testAccept() throws Exception {
        final Rule r1 = mock(Rule.class);
        final Rule r2 = mock(Rule.class);
        final Rule r3 = mock(Rule.class);
        ValidatorContext ctx = () -> Arrays.asList(r1, r2, r3);

        final Validable doc = mock(Validable.class);
        when(r1.validate(doc)).thenReturn(Validation.success());
        when(r2.validate(doc)).thenReturn(Validation.success());
        when(r3.validate(doc)).thenReturn(Validation.success());

        Validation result = new Validator().validate(doc, ctx);

        assertThat(result).isEqualTo(Validation.success());
    }

    @Test
    public void testReject() throws Exception {
        final Rule r1 = mock(Rule.class);
        final Rule r2 = mock(Rule.class);
        final Rule r3 = mock(Rule.class);
        ValidatorContext ctx = () -> Arrays.asList(r1, r2, r3);

        final Validable doc = mock(Validable.class);
        when(r1.validate(doc)).thenReturn(Validation.success());
        when(r2.validate(doc)).thenReturn(Validation.failure("foo"));
        when(r3.validate(doc)).thenReturn(Validation.success());

        Validation result = new Validator().validate(doc, ctx);

        assertThat(result).isEqualTo(Validation.failure("foo"));
    }
}
