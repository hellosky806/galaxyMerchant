package com.thoughtWorks.interview.merchant;

import com.thoughtWorks.interview.merchant.business.*;
import com.thoughtWorks.interview.merchant.business.implement.*;
import com.thoughtWorks.interview.merchant.common.Constant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class MerchantBusiness {
    //key is galaxy unit, value is roman symbol
    public HashMap<String, String> galaxyUnitMap;
    //key is currency(gold,silver,iron etc.)unit, value is credit value
    public HashMap<String, BigDecimal> creditValueMap;

    public void doBusiness() {
        //Read input data from specified file;
        IReadInputData dataReader = new ReadInputDataImpl();
        List<String> inputDataList = dataReader.readInputData();

        //Analyze input data, divide the data into three parts.
        IAnalyzeInputData dataAnalyzer = new AnalyzeInputDataImpl();
        HashMap<String, List<String>> analyzedDataMap = dataAnalyzer.analyzeInputData(inputDataList);

        //validate the input of galaxy symbol part, and calculate the map relation.
        IParseGalaxyUnitData galaxyUnitDataParser = new ParseGalaxyUnitDataImpl();
        galaxyUnitMap = galaxyUnitDataParser.parseGalaxyUnitData(analyzedDataMap.get(Constant.GALAXY_LIST));

        //validate the input of credit per currency(silver, gold, iron) unit, and calculate the map relation
        IParseCreditUnitData creditUnitDataParser = new ParseCreditUnitDataImpl();
        creditValueMap = creditUnitDataParser.parseCreditUnitData(analyzedDataMap.get(Constant.CREDIT_LIST), galaxyUnitMap);

        IParseQuestionData questionDataParser = new ParseQuestionDataImpl();
        List<String> resultList = questionDataParser.parseQuestionData(analyzedDataMap.get(Constant.QUESTION_LIST), galaxyUnitMap, creditValueMap);

        IWriteOutputData outputDataWriter = new WriteOutputDataImpl();
        outputDataWriter.writeOutputData(resultList);
    }
}
