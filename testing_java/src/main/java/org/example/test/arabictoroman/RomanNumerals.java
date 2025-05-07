package org.example.test.arabictoroman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumerals {

    enum RomanNumeral {

        M(1000), CM(900), D(500), CD(400),
        C(100), XC(90), L(50), XL(40),
        X(10), IX(9), V(5), IV(4),
        I(1);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getRomanNumerals(){
            return Arrays.asList(RomanNumeral.values());
        }
    }

    public static String arabicToRoman(int arabicNumber){

        StringBuilder romanNumber = new StringBuilder();
        List<RomanNumeral> romanNumerals = RomanNumeral.getRomanNumerals();
        int i = 0;
        while(arabicNumber>0 && i<romanNumerals.size()){

            if(arabicNumber>=romanNumerals.get(i).getValue()){
                romanNumber.append(romanNumerals.get(i));
                arabicNumber -= romanNumerals.get(i).getValue();
            }else{
                i++;
            }

        }
        return romanNumber.toString();

    }

}
