package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateValueQuestionData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateValueQuestionDataImplTest {

    @Test
    public void testValidateValueQuestionData() throws Exception {
        String questionStr = "how much is pish tegj glob glob ?";
        HashMap<String, String> galaxyUnitMap = new HashMap<String, String>();
        galaxyUnitMap.put("glob", "I");
        galaxyUnitMap.put("pish", "X");
        galaxyUnitMap.put("tegj", "L");
        galaxyUnitMap.put("prok", "V");

        List<String> resultList = new ArrayList<String>();

        IValidateValueQuestionData valueQuestionDataValidator = new ValidateValueQuestionDataImpl();
        String resultString = valueQuestionDataValidator.validateValueQuestionData(questionStr, galaxyUnitMap, resultList);

        String expectedString = "XLII";

        Assert.assertEquals(resultString, expectedString);
    }
}