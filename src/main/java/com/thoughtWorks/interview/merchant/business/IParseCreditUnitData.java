package com.thoughtWorks.interview.merchant.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface IParseCreditUnitData {
    /**
     * Put valid data into map, in order to be easy to processed.
     * @param creditUnitDefinitionList
     * @param galaxyUnitMap
     * @return
     */
    public HashMap<String, BigDecimal> parseCreditUnitData(List<String> creditUnitDefinitionList, HashMap<String, String> galaxyUnitMap);
}
