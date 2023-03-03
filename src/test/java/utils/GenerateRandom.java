package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandom {

    public String generatePhoneNumber(){
        int length = 8;
        boolean useLetters = false;
        boolean useNumbers = true;
        return "07" + RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
