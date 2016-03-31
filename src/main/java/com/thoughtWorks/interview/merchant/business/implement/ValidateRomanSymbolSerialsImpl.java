package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IValidateRomanSymbolSerials;
import com.thoughtWorks.interview.merchant.common.Constant;
import com.thoughtWorks.interview.merchant.exception.MerchantException;
import com.thoughtWorks.interview.merchant.unit.BusinessUtil;

import java.util.ArrayList;
import java.util.List;

public class ValidateRomanSymbolSerialsImpl implements IValidateRomanSymbolSerials {

    /**
     * validate the roman symbol serials if conform to the rules provided.
     *
     * @param questionStr
     * @param symbolSerials
     */
    public void validateRomanSymbolSerial(String questionStr, String symbolSerials) {
        judgeDuplicateSymbol(questionStr, symbolSerials);
        List<char[]> invertOrderSymbolList = getInvertOrderSymbolCouple(symbolSerials);
        //if there are more than one small-value symbol then validate symbol order value, else no need  to do that validation.
        if (invertOrderSymbolList.size() > 1) {
            judgeSymbolOrder(questionStr, invertOrderSymbolList);
        }
    }

    protected void judgeSymbolOrder(String questionStr, List<char[]> invertOrderSymbolList) {
        for (char[] tmpCharArray : invertOrderSymbolList) {
            String samllOne = String.valueOf(tmpCharArray[0]);
            String bigOne = String.valueOf(tmpCharArray[1]);
            if (samllOne.equals(Constant.RomanNumeral.I.name()) && !(bigOne.equals(Constant.RomanNumeral.V.name()) || bigOne.equals(Constant.RomanNumeral.X.name()))) {
                BusinessUtil.prepareWrongInfoOutput(questionStr, Constant.ROMAN_ORDER_RULE);
                throw new MerchantException(Constant.ROMAN_ORDER_RULE);
            }
            if (samllOne.equals(Constant.RomanNumeral.X.name()) && !(bigOne.equals(Constant.RomanNumeral.L.name()) || bigOne.equals(Constant.RomanNumeral.C.name()))) {
                BusinessUtil.prepareWrongInfoOutput(questionStr, Constant.ROMAN_ORDER_RULE);
                throw new MerchantException(Constant.ROMAN_ORDER_RULE);
            }
            if (samllOne.equals(Constant.RomanNumeral.C.name()) && !(bigOne.equals(Constant.RomanNumeral.D.name()) || bigOne.equals(Constant.RomanNumeral.M.name()))) {
                BusinessUtil.prepareWrongInfoOutput(questionStr, Constant.ROMAN_ORDER_RULE);
                throw new MerchantException(Constant.ROMAN_ORDER_RULE);
            }

            if (samllOne.equals(Constant.RomanNumeral.V.name()) ||
                    samllOne.equals(Constant.RomanNumeral.L.name()) ||
                    samllOne.equals(Constant.RomanNumeral.D.name())) {
                BusinessUtil.prepareWrongInfoOutput(questionStr, Constant.ROMAN_ORDER_RULE);
                throw new MerchantException(Constant.ROMAN_ORDER_RULE);
            }
        }
    }

    protected List<char[]> getInvertOrderSymbolCouple(String symbolSerials) {
        List<char[]> invertOrderSymbolList = new ArrayList<char[]>();
        char[] numeralArray = symbolSerials.toCharArray();
        int index = 0;
        while (index + 1 <= numeralArray.length - 1) {
            int previousValue = Constant.RomanNumeral.valueOf(String.valueOf(numeralArray[index])).getValue();
            int nextValue = Constant.RomanNumeral.valueOf(String.valueOf(numeralArray[index + 1])).getValue();
            if (previousValue < nextValue) {
                char[] invertOrderSymbolArray = new char[2];
                invertOrderSymbolArray[0] = numeralArray[index];
                invertOrderSymbolArray[1] = numeralArray[index + 1];
                invertOrderSymbolList.add(invertOrderSymbolArray);
                index += 2;
            } else {
                index++;
            }
        }
        return invertOrderSymbolList;
    }


    protected void judgeDuplicateSymbol(String questionStr, String symbolSerials) {
        String iDuplicateStr = "IIII";
        String xDuplicateStr = "XXXX";
        String cDuplicateStr = "CCCC";
        String mDuplicateStr = "MMMM";
        String dDuplicateStr = "DD";
        String lDuplicateStr = "LL";
        String vDuplicateStr = "VV";
        if (symbolSerials.contains(iDuplicateStr) || symbolSerials.contains(xDuplicateStr) ||
                symbolSerials.contains(cDuplicateStr) || symbolSerials.contains(mDuplicateStr) ||
                symbolSerials.contains(dDuplicateStr) || symbolSerials.contains(lDuplicateStr) ||
                symbolSerials.contains(vDuplicateStr)) {
            BusinessUtil.prepareWrongInfoOutput(questionStr, Constant.ROMAN_DUPLICATE_RULE);
            throw new MerchantException(Constant.ROMAN_DUPLICATE_RULE);
        }
    }
}
