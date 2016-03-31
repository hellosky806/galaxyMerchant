package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.ICountRomanSymbolValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CountRomanSymbolValueImplTest {

    @Test
    public void testCountRomanSymbolValue() throws Exception {
        ICountRomanSymbolValue romanSymbolValueCounter = new CountRomanSymbolValueImpl();
        int sum = romanSymbolValueCounter.countRomanSymbolValue("MCMXLIII");
        assertEquals(1943, sum);
    }
}