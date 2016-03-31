package com.thoughtWorks.interview.merchant.business;

public interface IValidateRomanSymbolSerials {
    /**
     * Validate parsed roman symbol serial according to provided rule.
     * @param questionStr
     * @param symbolSerials
     */
    public void validateRomanSymbolSerial(String questionStr, String symbolSerials);
}
