package com.tchepannou.kiosk.validator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidatorTest {
    @Test
    public void testAccept() throws Exception {
        final Rule r1 = mock(Rule.class);
        final Rule r2 = mock(Rule.class);
        final Rule r3 = mock(Rule.class);
        ValidatorContext ctx =  createContext(r1, r2, r3);

        final Validable doc = mock(Validable.class);
        when(r1.validate(doc, ctx)).thenReturn(Validation.success());
        when(r2.validate(doc, ctx)).thenReturn(Validation.success());
        when(r3.validate(doc, ctx)).thenReturn(Validation.success());

        Validation result = new Validator().validate(doc, ctx);

        assertThat(result).isEqualTo(Validation.success());
    }

    @Test
    public void testReject() throws Exception {
        final Rule r1 = mock(Rule.class);
        final Rule r2 = mock(Rule.class);
        final Rule r3 = mock(Rule.class);
        ValidatorContext ctx = createContext(r1, r2, r3);

        final Validable doc = mock(Validable.class);
        when(r1.validate(doc, ctx)).thenReturn(Validation.success());
        when(r2.validate(doc, ctx)).thenReturn(Validation.failure("foo"));
        when(r3.validate(doc, ctx)).thenReturn(Validation.success());

        Validation result = new Validator().validate(doc, ctx);

        assertThat(result).isEqualTo(Validation.failure("foo"));
    }

    private ValidatorContext createContext(Rule...rules){
        return new ValidatorContext() {
            @Override
            public List<Rule> getRules() {
                return Arrays.asList(rules);
            }

            @Override
            public List<String> getLanguages() {
                return null;
            }

            @Override
            public int getContentMinLength() {
                return 0;
            }

            @Override
            public boolean alreadyPublished(final String id, final String title) {
                return false;
            }
        };
    }
}
