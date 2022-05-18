package lotto.infrastructure.common.util;

import lotto.infrastructure.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "    ", "\t", "\n"})
    public void isBlank_true(String text) {
        assertThat(StringUtils.isBlank(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "a", "!"})
    public void isBlank_false(String text) {
        assertThat(StringUtils.isBlank(text)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void isPositiveNumber_양수(String text) {
        assertThat(StringUtils.isPositiveNumber(text)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    public void isPositiveNumber_음수(String text) {
        assertThat(StringUtils.isPositiveNumber(text)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ㄱ", "!"})
    public void isPositiveNumber_숫자가_아닌_문자(String text) {
        assertThat(StringUtils.isPositiveNumber(text)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3", "1\t,\t2,\t3", "1\n,2\n,3\n"})
    public void splitAndTrim(String text) {
        assertThat(StringUtils.splitAndTrim(text, ",")).containsExactly("1", "2", "3");
    }

    @Test
    public void convertInters_성공() {
        assertThat(StringUtils.convertIntegers(Arrays.asList("1", "2", "3"))).containsExactly(1, 2, 3);
    }

    @Test
    public void convertInters_실패() {
        assertThatThrownBy(() -> {
            StringUtils.convertIntegers(Arrays.asList("a", "b", "c"));
        }).isInstanceOf(NumberFormatException.class);
    }
}