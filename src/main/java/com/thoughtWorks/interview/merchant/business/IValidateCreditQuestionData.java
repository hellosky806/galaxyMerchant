package com.thoughtWorks.interview.merchant.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface IValidateCreditQuestionData {
    public List<String> CreditQuestionDataValidator(String questionStr, HashMap<String, String> galaxyUnitMap, HashMap<String, BigDecimal> creditValueMap, List<String> resultList);
}
