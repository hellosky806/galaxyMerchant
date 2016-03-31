package com.thoughtWorks.interview.merchant.business;

import java.util.HashMap;
import java.util.List;

public interface IAnalyzeInputData {
    /**
     * Analyze input Data, divide them into different List, in order to be easy to processed.
     *
     * @param inputDataList
     * @return
     */
    public HashMap<String, List<String>> analyzeInputData(List<String> inputDataList);
}
