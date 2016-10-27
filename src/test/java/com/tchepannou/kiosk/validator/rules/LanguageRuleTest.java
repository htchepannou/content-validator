package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import com.tchepannou.kiosk.validator.ValidatorContext;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LanguageRuleTest {
    private ValidatorContext ctx;
    private LanguageRule rule = new LanguageRule();

    @Before
    public void setUp (){
        ctx = mock(ValidatorContext.class);
        when(ctx.getLanguages()).thenReturn(Arrays.asList("fr", "en"));
    }

    @Test
    public void testSuccess() throws Exception {
        assertThat(rule.validate(createValidable("fr"), ctx)).isEqualTo(Validation.success());
        assertThat(rule.validate(createValidable("en"), ctx)).isEqualTo(Validation.success());
    }

    @Test
    public void testFailure() throws Exception {
        final Validation result = rule.validate(createValidable("it"), ctx);

        assertThat(result.isSuccess()).isFalse();
        assertThat(result.getReason()).isEqualTo(LanguageRule.REASON);
    }

    @Test
    public void testNull() throws Exception {
        final Validation result = rule.validate(createValidable(null), ctx);

        assertThat(result.isSuccess()).isFalse();
        assertThat(result.getReason()).isEqualTo(LanguageRule.REASON);
    }

    private Validable createValidable(final String lang){
        Validable validable = mock(Validable.class);
        when(validable.getLanguage()).thenReturn(lang);
        return validable;
    }
}
