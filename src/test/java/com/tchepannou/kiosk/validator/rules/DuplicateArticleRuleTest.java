package com.tchepannou.kiosk.validator.rules;

import com.tchepannou.kiosk.validator.Validable;
import com.tchepannou.kiosk.validator.Validation;
import com.tchepannou.kiosk.validator.ValidatorContext;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DuplicateArticleRuleTest {
    private ValidatorContext ctx;
    private DuplicateArticleRule rule;

    @Before
    public void setUp() {
        rule = new DuplicateArticleRule();

        ctx = mock(ValidatorContext.class);
    }


    @Test
    public void testValidateSuccess() throws Exception {
        final String id = "foo";
        final String title = "bar";
        when(ctx.alreadyPublished(id, title)).thenReturn(false);

        final Validable obj = createValidable(id, title);

        final Validation result = rule.validate(obj, ctx);

        assertThat(result.isSuccess()).isTrue();
    }

    @Test
    public void testValidateFailure() throws Exception {
        final String id = "foo";
        final String title = "bar";
        when(ctx.alreadyPublished(id, title)).thenReturn(true);

        final Validable obj = createValidable(id, title);


        final Validation result = rule.validate(obj, ctx);

        assertThat(result.isSuccess()).isFalse();
        assertThat(result.getReason()).isEqualToIgnoringCase(DuplicateArticleRule.REASON);
    }

    private Validable createValidable(final String id, final String title){
        Validable validable = mock(Validable.class);
        when(validable.getId()).thenReturn(id);
        when(validable.getTitle()).thenReturn(title);
        return validable;
    }

}
