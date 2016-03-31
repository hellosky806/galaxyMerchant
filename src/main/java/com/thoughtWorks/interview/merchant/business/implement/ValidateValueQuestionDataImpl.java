package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateRomanSymbolSerials;
import com.thoughtWorks.interview.merchant.business.IValidateValueQuestionData;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class ValidateValueQuestionDataImpl implements IValidateValueQuestionData {
    public String validateValueQuestionData(String questionStr, HashMap<String, String> galaxyUnitMap, List<String> resultList) {
        questionStr = questionStr.replaceFirst(Constant.VALUE_QUESTION_HEAD, "");
        questionStr = questionStr.substring(0, questionStr.lastIndexOf(Constant.QUESTION_FLAG));

        String[] galaxyUnitArray = questionStr.trim().split("\\s+");
        List<String> galaxyUnitList = Arrays.asList(galaxyUnitArray);
        StringBuffer romanSymbolSerialBf = new StringBuffer();

        for (String tmpStr : galaxyUnitList) {
            if (!galaxyUnitMap.containsKey(tmpStr)) {
                resultList.add(Constant.WRONG_QUESTION);
                return "";
            }
            romanSymbolSerialBf.append(galaxyUnitMap.get(tmpStr));
        }

        IValidateRomanSymbolSerials romanSymbolSerialsValidator = new ValidateRomanSymbolSerialsImpl();
        romanSymbolSerialsValidator.validateRomanSymbolSerial(questionStr, romanSymbolSerialBf.toString());
        return romanSymbolSerialBf.toString();
    }
}
