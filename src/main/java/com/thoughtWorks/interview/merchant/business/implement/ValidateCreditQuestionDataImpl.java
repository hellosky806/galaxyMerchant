package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateCreditQuestionData;
import com.thoughtWorks.interview.merchant.business.IValidateRomanSymbolSerials;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidateCreditQuestionDataImpl implements IValidateCreditQuestionData {
    public List<String> CreditQuestionDataValidator(String questionStr, HashMap<String, String> galaxyUnitMap, HashMap<String, BigDecimal> creditValueMap, List<String> resultList) {
        //index 0 put currency unit, index 1 put roman symbols serial.
        List<String> dealedDataList = new ArrayList<String>();

        questionStr = questionStr.replaceFirst(Constant.CREDIT_QUESTION_HEAD, "");
        questionStr = questionStr.substring(0, questionStr.lastIndexOf(Constant.QUESTION_FLAG));

        String[] creditUnitArray = questionStr.trim().split("\\s+");
        List<String> creditUnitList = new ArrayList<String>(Arrays.asList(creditUnitArray));
        StringBuffer romanSymbolSerialBf = new StringBuffer();
        String creditUnit = creditUnitList.get(creditUnitList.size() - 1);

        if (!creditValueMap.containsKey(creditUnit)) {
            resultList.add(Constant.WRONG_QUESTION);
            return null;
        }
        dealedDataList.add(creditUnit);
        creditUnitList.remove(creditUnitList.size() - 1);

        for (String tmpStr : creditUnitList) {
            if (!galaxyUnitMap.containsKey(tmpStr)) {
                resultList.add(Constant.WRONG_QUESTION);
                return null;
            }
            romanSymbolSerialBf.append(galaxyUnitMap.get(tmpStr));
        }
        String romanSymbolSerialStr = romanSymbolSerialBf.toString();

        IValidateRomanSymbolSerials romanSymbolSerialsValidator = new ValidateRomanSymbolSerialsImpl();
        romanSymbolSerialsValidator.validateRomanSymbolSerial(questionStr, romanSymbolSerialStr);
        dealedDataList.add(romanSymbolSerialStr);
        return dealedDataList;
    }
}
