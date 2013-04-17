package pl.agilecoders;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import pl.agilecoders.functions.FunctionReverse;

import java.util.function.Function;

import static org.fest.assertions.Assertions.assertThat;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 02.04.13
 * Time: 13:12
 */
public class FunctionTest {

    @Test
    public void shouldReverseString() {
        Function<String, String> functionReverse = new FunctionReverse();
        assertThat(functionReverse.apply("alamakota")).isEqualTo(StringUtils.reverse("alamakota"));
    }


}
