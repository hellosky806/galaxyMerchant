package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IParseCreditUnitData;
import com.thoughtWorks.interview.merchant.business.IValidateCreditUnitData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class ParseCreditUnitDataImpl implements IParseCreditUnitData {
    public HashMap<String, BigDecimal> parseCreditUnitData(List<String> creditUnitDefinitionList, HashMap<String, String> galaxyUnitMap) {
        HashMap<String, BigDecimal> creditUnitMap = new HashMap<String, BigDecimal>();
        for (String lineStr : creditUnitDefinitionList) {
            IValidateCreditUnitData creditUnitValidator = new ValidateCreditUnitDataImpl();
            creditUnitValidator.validateCreditUnitData(lineStr, galaxyUnitMap, creditUnitMap);
        }
        return creditUnitMap;
    }
}
