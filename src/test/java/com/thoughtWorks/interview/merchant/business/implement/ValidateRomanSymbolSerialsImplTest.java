package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateRomanSymbolSerials;
import com.thoughtWorks.interview.merchant.exception.MerchantException;
import org.junit.Test;

/**
 * Created by sunye on 2016/3/30.
 */
public class ValidateRomanSymbolSerialsImplTest {
    @Test(expected = MerchantException.class)
    public void testGetInvertOrderSymbol() throws Exception {
        String question = "";
        String romanSymbolSerial = "LVXVX";
        IValidateRomanSymbolSerials instance = new ValidateRomanSymbolSerialsImpl();
        instance.validateRomanSymbolSerial(question, romanSymbolSerial);
    }
}