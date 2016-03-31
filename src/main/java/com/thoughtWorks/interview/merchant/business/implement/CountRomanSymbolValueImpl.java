package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.ICountRomanSymbolValue;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.util.ArrayList;
import java.util.List;

public class CountRomanSymbolValueImpl implements ICountRomanSymbolValue {
    public int countRomanSymbolValue(String romanSymboSerial) {
        char[] numeralArray = romanSymboSerial.toCharArray();
        int index = 0;
        List<Integer> dealedRomanSymbolValueList = new ArrayList<Integer>();
        while (index + 1 <= numeralArray.length - 1) {
            int previousValue = Constant.RomanNumeral.valueOf(String.valueOf(numeralArray[index])).getValue();
            int nextValue = Constant.RomanNumeral.valueOf(String.valueOf(numeralArray[index + 1])).getValue();
            if (previousValue < nextValue) {
                dealedRomanSymbolValueList.add(nextValue - previousValue);
                index += 2;
            } else {
                dealedRomanSymbolValueList.add(previousValue);
                index++;
            }
        }
        //Add the last value according to index's position.
        if (index == numeralArray.length - 1) {
            dealedRomanSymbolValueList.add(Constant.RomanNumeral.valueOf(String.valueOf(numeralArray[index])).getValue());
        }

        int sumOfRomanSymbolValue = 0;
        for (Integer tmpInt : dealedRomanSymbolValueList) {
            sumOfRomanSymbolValue += tmpInt;
        }
        return sumOfRomanSymbolValue;
    }
}
