package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.ICountRomanSymbolValue;
import com.thoughtWorks.interview.merchant.business.IParseQuestionData;
import com.thoughtWorks.interview.merchant.business.IValidateCreditQuestionData;
import com.thoughtWorks.interview.merchant.business.IValidateValueQuestionData;
import com.thoughtWorks.interview.merchant.common.Constant;
import com.thoughtWorks.interview.merchant.unit.BusinessUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ParseQuestionDataImpl implements IParseQuestionData {
    public List<String> parseQuestionData(List<String> questionList, HashMap<String, String> galaxyUnitMap, HashMap<String, BigDecimal> creditValueMap) {
        List<String> resultList = new ArrayList<String>();
        for (String questionStr : questionList) {
            if (questionStr.startsWith(Constant.VALUE_QUESTION_HEAD)) {

                IValidateValueQuestionData valueQuestionDataValidator = new ValidateValueQuestionDataImpl();
                String romanSymbolSerial = valueQuestionDataValidator.validateValueQuestionData(questionStr, galaxyUnitMap, resultList);

                if (romanSymbolSerial.length() > 0) {
                    ICountRomanSymbolValue romanSymbolValueCounter = new CountRomanSymbolValueImpl();
                    int countResult = romanSymbolValueCounter.countRomanSymbolValue(romanSymbolSerial);
                    resultList.add(BusinessUtil.prepareValueOutPut(questionStr, countResult));
                }

            } else if (questionStr.startsWith(Constant.CREDIT_QUESTION_HEAD)) {
                IValidateCreditQuestionData crediteQuestionDataValidator = new ValidateCreditQuestionDataImpl();
                List<String> dealedDataList = crediteQuestionDataValidator.CreditQuestionDataValidator(questionStr, galaxyUnitMap, creditValueMap, resultList);
                if (dealedDataList != null && dealedDataList.size() > 0) {
                    BigDecimal countResult = countCreditResult(creditValueMap, dealedDataList);
                    resultList.add(BusinessUtil.prepareCreditOutPut(questionStr, countResult));
                }
            } else {
                resultList.add(Constant.WRONG_QUESTION);
            }
        }
        return resultList;
    }

    protected BigDecimal countCreditResult(HashMap<String, BigDecimal> creditValueMap, List<String> dealedDataList) {
        BigDecimal creditUnitValue = creditValueMap.get(dealedDataList.get(0));
        String romanSymbolSerial = dealedDataList.get(1);
        ICountRomanSymbolValue romanSymbolValueCounter = new CountRomanSymbolValueImpl();
        int countRomanResult = romanSymbolValueCounter.countRomanSymbolValue(romanSymbolSerial);
        BigDecimal countResult = creditUnitValue.multiply(BigDecimal.valueOf(countRomanResult));
        return countResult;
    }
}
