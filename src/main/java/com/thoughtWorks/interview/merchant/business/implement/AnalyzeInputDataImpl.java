package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IAnalyzeInputData;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyzeInputDataImpl implements IAnalyzeInputData {

    public HashMap<String, List<String>> analyzeInputData(List<String> inputDataList) {
        HashMap<String, List<String>> analyzedDataMap = new HashMap<String, List<String>>();
        analyzedDataMap.put(Constant.GALAXY_LIST, new ArrayList<String>());
        analyzedDataMap.put(Constant.CREDIT_LIST, new ArrayList<String>());
        analyzedDataMap.put(Constant.QUESTION_LIST, new ArrayList<String>());
        for (String lineStr : inputDataList) {
            identifyInputData(lineStr, analyzedDataMap);
        }
        return analyzedDataMap;
    }

    private void identifyInputData(String lineStr, HashMap<String, List<String>> analyzedDataMap) {
        if (lineStr.endsWith(Constant.CREDIT_FLAG)) {
            analyzedDataMap.get(Constant.CREDIT_LIST).add(lineStr);
            return;
        }
        if (lineStr.endsWith(Constant.QUESTION_FLAG)) {
            analyzedDataMap.get(Constant.QUESTION_LIST).add(lineStr);
            return;
        }
        analyzedDataMap.get(Constant.GALAXY_LIST).add(lineStr);
    }
}
