package com.thoughtWorks.interview.merchant.business.implement;

import com.thoughtWorks.interview.merchant.business.IReadInputData;
import com.thoughtWorks.interview.merchant.exception.MerchantException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadInputDataImpl implements IReadInputData {

    public List<String> readInputData() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> inputDataList = new ArrayList<String>();
        String lineString;
        try {
            while ((lineString = reader.readLine()) != null) {
                inputDataList.add(lineString);
            }
        } catch (IOException ex) {
            throw new MerchantException("Error happend when read input data");
        }
        return inputDataList;
    }
}
