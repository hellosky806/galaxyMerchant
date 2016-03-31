package com.thoughtWorks.interview.merchant.business;

import java.math.BigDecimal;
import java.util.HashMap;

public interface IValidateCreditUnitData {
    public void validateCreditUnitData(String dataStr, HashMap<String, String> galaxyUnitMap, HashMap<String, BigDecimal> creditUnitMap);
}
