package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateGalaxyUnitData;
import com.thoughtWorks.interview.merchant.common.Constant;
import com.thoughtWorks.interview.merchant.exception.MerchantException;
import com.thoughtWorks.interview.merchant.unit.BusinessUtil;

import java.util.HashMap;

public class ValidateGalaxyUnitDataImpl implements IValidateGalaxyUnitData {
    public void validateGalaxyUnitData(String dataStr, HashMap<String, String> galaxyUnitMap) {
        String[] lineStrArray = dataStr.trim().split("\\s+");
        if (lineStrArray.length != 3 || !lineStrArray[1].equals("is")) {
            BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.WRONG_FORMAT);
            throw new MerchantException(Constant.WRONG_FORMAT);
        }
        if (galaxyUnitMap.containsValue(Constant.RomanNumeral.valueOf(lineStrArray[2]).name()) || galaxyUnitMap.containsKey(lineStrArray[0])) {
            BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.DUPLICATE_DEFINITION);
            throw new MerchantException(Constant.DUPLICATE_DEFINITION);
        }
        try {
            galaxyUnitMap.put(lineStrArray[0], Constant.RomanNumeral.valueOf(lineStrArray[2]).name());
        } catch (IllegalArgumentException ex) {
            BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.OUT_RANGE);
            throw new MerchantException(Constant.OUT_RANGE);
        }

    }
}
