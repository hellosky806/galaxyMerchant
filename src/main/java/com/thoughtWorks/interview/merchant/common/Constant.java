package com.thoughtWorks.interview.merchant.common;

import java.io.File;

public class Constant {
    public static final String CREDIT_FLAG = "Credits";
    public static final String QUESTION_FLAG = "?";
    public static final String GALAXY_LIST = "galaxyUnitDeifinitionList";
    public static final String CREDIT_LIST = "creditUnitDefinitionList";
    public static final String QUESTION_LIST = "quetionList";
    //Error message groups
    public static final String WRONG_FORMAT = "The data's format is wrong, please check output file.";
    public static final String DUPLICATE_DEFINITION = "There are duplicate definitions in galaxy unit.";
    public static final String OUT_RANGE = "The data input doesn't belong to roman numerals.";
    public static final String WRONG_CREDIT_TYPE = "The value of credit should be positive number.";
    public static final String NO_DEFINED_DATA = "The galaxy unit isn't be defined.";
    //Roman numeral serials' rule.
    public static final String ROMAN_DUPLICATE_RULE = "The symbols \"I\", \"X\", \"C\", and \"M\" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) \"D\", \"L\", and \"V\" can never be repeated.";
    public static final String ROMAN_ORDER_RULE = "\"I\" can be subtracted from \"V\" and \"X\" only. \"X\" can be subtracted from \"L\" and \"C\" only. \"C\" can be subtracted from \"D\" and \"M\" only. \"V\", \"L\", and \"D\" can never be subtracted.";

    //question's head
    public static final String VALUE_QUESTION_HEAD = "how much is";
    public static final String CREDIT_QUESTION_HEAD = "how many Credits is";

    //wrong format or input question
    public static final String WRONG_QUESTION = "I have no idea what you are talking about";

    public static final String OUTPUT_FILE_PATH = "E:" + File.separator + "output.txt";

    public enum RomanNumeral {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        private int value;

        private RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

}
