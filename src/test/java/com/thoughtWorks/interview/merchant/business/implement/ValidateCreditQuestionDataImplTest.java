package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateCreditQuestionData;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateCreditQuestionDataImplTest {

    @Test
    public void testCreditQuestionDataValidator() throws Exception {
        String questionString = "how many Credits is glob prok Silver ?";
        HashMap<String, String> galaxyUnitMap = new HashMap<String, String>();
        galaxyUnitMap.put("glob", "I");
        galaxyUnitMap.put("pish", "X");
        galaxyUnitMap.put("tegj", "L");
        galaxyUnitMap.put("prok", "V");

        HashMap<String, BigDecimal> creditValueMap = new HashMap<String, BigDecimal>();
        creditValueMap.put("Silver", new BigDecimal(15));
        List<String> resultList = new ArrayList<String>();
        IValidateCreditQuestionData creditUnitDataVaidator = new ValidateCreditQuestionDataImpl();
        List<String> dealedDataList = creditUnitDataVaidator.CreditQuestionDataValidator(questionString, galaxyUnitMap, creditValueMap, resultList);
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Silver");
        expectedList.add("IV");

        Assert.assertEquals(dealedDataList, expectedList);
    }
}