package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IParseGalaxyUnitData;
import com.thoughtWorks.interview.merchant.business.IValidateGalaxyUnitData;

import java.util.HashMap;
import java.util.List;

public class ParseGalaxyUnitDataImpl implements IParseGalaxyUnitData {

    public HashMap<String, String> parseGalaxyUnitData(List<String> galaxyUnitDefinitionList) {
        HashMap<String, String> galaxyUnitMap = new HashMap<String, String>();
        for (String lineStr : galaxyUnitDefinitionList) {
            IValidateGalaxyUnitData galaxyValidator = new ValidateGalaxyUnitDataImpl();
            galaxyValidator.validateGalaxyUnitData(lineStr, galaxyUnitMap);
        }

        return galaxyUnitMap;
    }

}
