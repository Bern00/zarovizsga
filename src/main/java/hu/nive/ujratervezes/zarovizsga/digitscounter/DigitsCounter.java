package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {
    public int getCountOfDigits(String s){

        if(s == null || "".equals(s.trim())){
            return 0;
        }

        Set<Integer> numbers = new HashSet<>();

        for (char c: s.toCharArray()) {

            int number = Character.getNumericValue(c);
            if(number >= 0 && number <= 9){
                numbers.add(number);
            }

        }
        return numbers.size();
    }
}
