package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateGalaxyUnitData;
import com.thoughtWorks.interview.merchant.exception.MerchantException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ValidateGalaxyUnitDataImplTest {

    @Test(expected = MerchantException.class)
    public void testValidateGalaxyUnitData() throws Exception {
        HashMap<String, String> galaxyUnitMap = new HashMap<String, String>();
        galaxyUnitMap.put("glob", "I");
        String dataStr = "tegi is is V";
        IValidateGalaxyUnitData galaxyUnitDataValidator = new ValidateGalaxyUnitDataImpl();
        galaxyUnitDataValidator.validateGalaxyUnitData(dataStr, galaxyUnitMap);
    }
}