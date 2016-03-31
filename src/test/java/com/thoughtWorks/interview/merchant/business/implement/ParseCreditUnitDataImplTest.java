package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IParseCreditUnitData;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ParseCreditUnitDataImplTest {

    @Test
    public void testParseCreditUnitData() throws Exception {
        List<String> creditUnitDefinitionList = new ArrayList<String>();
        HashMap<String, String> galaxyUnitMap = new HashMap<String, String>();

        creditUnitDefinitionList.add("glob glob Silver is 34 Credits");
        creditUnitDefinitionList.add("glob prok Gold is 57800 Credits");

        galaxyUnitMap.put("glob", "I");
        galaxyUnitMap.put("prok", "V");
        galaxyUnitMap.put("pish", "X");
        galaxyUnitMap.put("tegi", "L");

        IParseCreditUnitData creditUnitDataParser = new ParseCreditUnitDataImpl();
        HashMap<String, BigDecimal> creditUnitMap = creditUnitDataParser.parseCreditUnitData(creditUnitDefinitionList, galaxyUnitMap);

        HashMap<String, BigDecimal> expectedMap = new HashMap<String, BigDecimal>();
        expectedMap.put("Silver", new BigDecimal(17));
        expectedMap.put("Gold", new BigDecimal(14450));

        Assert.assertEquals(expectedMap, creditUnitMap);
    }
}