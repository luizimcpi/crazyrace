package com.devlhse.crazyrace.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTests {

    public static final String VALID_LINE_REQUEST = "23:49:08.277      038 – F.MASSA         1		   1:02.852          44,275";
    public static final String VALID_EMPTY_LINE_REQUEST = "";
    public static final String INVALID_LINE_REQUEST = null;

    @Test
    public void shouldSplitValidLineContent(){
        assertEquals(7, StringUtils.splitLineInput(VALID_LINE_REQUEST).length);
    }

    @Test
    public void shouldSplitValidEmptyLineContent(){
        assertEquals(1, StringUtils.splitLineInput(VALID_EMPTY_LINE_REQUEST).length);
    }

    @Test
    public void shouldHasZeroSizeWhenInputIsNull(){
        assertEquals(0, StringUtils.splitLineInput(INVALID_LINE_REQUEST).length);
    }
}
