package pl.finsys.functions;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

/**
 * (c) 2013 finsys.pl
 * User: jarek
 * Date: 02.04.13
 * Time: 13:20
 */
public class FunctionReverse implements Function<String, String> {
    @Override
    public String apply(String s) {
        return StringUtils.reverse(s);
    }
}
