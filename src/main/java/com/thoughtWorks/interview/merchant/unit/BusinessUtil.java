package com.thoughtWorks.interview.merchant.unit;

import com.thoughtWorks.interview.merchant.business.IWriteOutputData;
import com.thoughtWorks.interview.merchant.business.implement.WriteOutputDataImpl;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusinessUtil {
    public static String prepareValueOutPut(String questionStr, int value) {
        questionStr = questionStr.replaceFirst(Constant.VALUE_QUESTION_HEAD, "");
        questionStr = questionStr.substring(0, questionStr.lastIndexOf(Constant.QUESTION_FLAG));
        String outputString = questionStr.trim() + " is " + value;
        return outputString;
    }

    public static String prepareCreditOutPut(String questionStr, BigDecimal value) {
        questionStr = questionStr.replaceFirst(Constant.CREDIT_QUESTION_HEAD, "");
        questionStr = questionStr.substring(0, questionStr.lastIndexOf(Constant.QUESTION_FLAG));
        String outputString = questionStr.trim() + " is " + value + " " + Constant.CREDIT_FLAG;
        return outputString;
    }

    public static void prepareWrongInfoOutput(String lineString, String wrongInfo) {
        StringBuffer wrongOutPutBf = new StringBuffer();
        List<String> resultList = new ArrayList<String>();
        resultList.add(wrongInfo);
        resultList.add("The wrong input is as follows: ");
        resultList.add(lineString);
        resultList.add(wrongOutPutBf.toString());
        IWriteOutputData outputDataWriter = new WriteOutputDataImpl();
        outputDataWriter.writeOutputData(resultList);
    }

}
