package com.devlhse.crazyrace.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    
    @Test
    public void shouldConvertValidStringToInt(){
    	String VALID_STRING_NUMBER = "1";
        assertEquals(1, StringUtils.convertToInt(VALID_STRING_NUMBER));
    }
    
    @Test
    public void shouldReturnZeroWhenReceivesInvalidStringToConversion(){
    	String INVALID_STRING_NUMBER = "A";
        assertEquals(0, StringUtils.convertToInt(INVALID_STRING_NUMBER));
    }
    
    @Test
    public void shouldConvertValidStringToDouble(){
    	String VALID_STRING_NUMBER = "44.275";
    	assertTrue(44.275 == StringUtils.convertToDouble(VALID_STRING_NUMBER));
    }
    
    @Test
    public void shouldReturnZeroWhenReceivesIncalidDoubleStringToConversion(){
    	String INVALID_STRING_NUMBER = "44.B";
    	assertTrue(0 == StringUtils.convertToDouble(INVALID_STRING_NUMBER));
    }
}
