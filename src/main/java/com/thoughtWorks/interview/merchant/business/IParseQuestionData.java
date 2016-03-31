package com.thoughtWorks.interview.merchant.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface IParseQuestionData {
    /**
     *
     * @param questionList
     * @param galaxyUnitMap
     * @param creditValueMap
     * @return
     */
    public List<String> parseQuestionData(List<String> questionList, HashMap<String, String> galaxyUnitMap, HashMap<String, BigDecimal> creditValueMap);
}
