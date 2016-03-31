package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IAnalyzeInputData;
import com.thoughtWorks.interview.merchant.common.Constant;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AnalyzeInputDataImplTest {

    @Test
    public void testAnalyzeInputData() throws Exception {
        List<String> inputDataList = new ArrayList<String>();
        inputDataList.add("glob is V");
        inputDataList.add("glob glob Silver is 34 Credits");
        inputDataList.add("how many Credits is glob prok Iron ?");
        HashMap<String, List<String>> expectedMap = new HashMap<String, List<String>>();
        List<String> galaxyList = new ArrayList<String>();
        galaxyList.add("glob is V");
        List<String> creditList = new ArrayList<String>();
        creditList.add("glob glob Silver is 34 Credits");
        List<String> questionList = new ArrayList<String>();
        questionList.add("how many Credits is glob prok Iron ?");
        expectedMap.put(Constant.GALAXY_LIST, galaxyList);
        expectedMap.put(Constant.CREDIT_LIST, creditList);
        expectedMap.put(Constant.QUESTION_LIST, questionList);

        IAnalyzeInputData inputDataAnalyzer = new AnalyzeInputDataImpl();
        HashMap<String, List<String>> dealedMap = inputDataAnalyzer.analyzeInputData(inputDataList);

        Assert.assertEquals(expectedMap, dealedMap);
    }
}