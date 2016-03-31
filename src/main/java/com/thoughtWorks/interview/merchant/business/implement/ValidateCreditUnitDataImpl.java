package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.ICountRomanSymbolValue;
import com.thoughtWorks.interview.merchant.business.IValidateCreditUnitData;
import com.thoughtWorks.interview.merchant.business.IValidateRomanSymbolSerials;
import com.thoughtWorks.interview.merchant.common.Constant;
import com.thoughtWorks.interview.merchant.exception.MerchantException;
import com.thoughtWorks.interview.merchant.unit.BusinessUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidateCreditUnitDataImpl implements IValidateCreditUnitData {
    public void validateCreditUnitData(String dataStr, HashMap<String, String> galaxyUnitMap, HashMap<String, BigDecimal> creditUnitMap) {
        String[] lineStrArray = dataStr.trim().split("\\s+");
        List<String> lineStrList = Arrays.asList(lineStrArray);
        int creditIndex = lineStrList.indexOf(Constant.CREDIT_FLAG);
        int creditValueIndex = creditIndex - 1;
        // Gold, silver, iron's index
        int creditUnitIndex = creditIndex - 3;
        String creditUnit = lineStrList.get(creditUnitIndex);
        List<String> romanSymbolSerialList = lineStrList.subList(0, creditUnitIndex);

        String symbolSerials = mapGalaxyUnitToRomanSymbol(dataStr, romanSymbolSerialList, galaxyUnitMap);

        BigDecimal creditValue = validateCreditValue(dataStr, lineStrList, creditValueIndex);

        if (!lineStrList.get(creditIndex - 2).equals("is")) {
            BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.WRONG_FORMAT);
            throw new MerchantException(Constant.WRONG_FORMAT);
        }

        IValidateRomanSymbolSerials romanSymbolSerialsValidator = new ValidateRomanSymbolSerialsImpl();
        romanSymbolSerialsValidator.validateRomanSymbolSerial(dataStr, symbolSerials);

        if (creditUnitMap.containsValue(creditUnit)) {
            BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.DUPLICATE_DEFINITION);
            throw new MerchantException(Constant.DUPLICATE_DEFINITION);
        }

        BigDecimal creditUnitValue = getCreditUnitValue(creditValue, symbolSerials);
        creditUnitMap.put(creditUnit, creditUnitValue);

    }

    protected BigDecimal getCreditUnitValue(BigDecimal creditValuel, String symbolSerials) {
        MathContext mc = new MathContext(5, RoundingMode.HALF_DOWN);
        ICountRomanSymbolValue romanSymbolValueCounter = new CountRomanSymbolValueImpl();
        int sumOfRomanSymbolValue = romanSymbolValueCounter.countRomanSymbolValue(symbolSerials);
        BigDecimal creditUnitValue = creditValuel.divide(BigDecimal.valueOf(sumOfRomanSymbolValue), mc);
        return creditUnitValue;
    }

    protected BigDecimal validateCreditValue(String dataStr, List<String> lineStrList, int creditValueIndex) {
        BigDecimal creditValue;
        try {
            creditValue = new BigDecimal(lineStrList.get(creditValueIndex));
            if (creditValue.compareTo(BigDecimal.valueOf(0)) != 1) {
                BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.WRONG_CREDIT_TYPE);
                throw new MerchantException(Constant.WRONG_CREDIT_TYPE);
            }
        } catch (NumberFormatException ex) {
            BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.WRONG_CREDIT_TYPE);
            throw new MerchantException(Constant.WRONG_CREDIT_TYPE);
        }
        return creditValue;
    }

    protected String mapGalaxyUnitToRomanSymbol(String dataStr, List<String> romanlSymbolSerialList, HashMap<String, String> creditUnitMap) {
        StringBuffer mapedRomanSymbolBf = new StringBuffer();
        for (String galaxyUnitStr : romanlSymbolSerialList) {
            if (creditUnitMap.get(galaxyUnitStr) == null) {
                BusinessUtil.prepareWrongInfoOutput(dataStr, Constant.NO_DEFINED_DATA);
                throw new MerchantException(Constant.NO_DEFINED_DATA);
            }
            mapedRomanSymbolBf.append(creditUnitMap.get(galaxyUnitStr));
        }
        return mapedRomanSymbolBf.toString();
    }
}
