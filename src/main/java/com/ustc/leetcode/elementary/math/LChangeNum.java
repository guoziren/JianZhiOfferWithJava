package com.ustc.leetcode.elementary.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 初级算法， 罗马数字转数字
 */
public class LChangeNum {

    private Map<Character, RomaNumber> map = new HashMap<>();

    public LChangeNum() {
        initMap();
    }

    static class RomaNumber {
        Character character;
        int value;
        int order;

        public RomaNumber(Character character, int value, int order) {
            this.character = character;
            this.value = value;
            this.order = order;
        }
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i + 1 < charArray.length) {
                RomaNumber romaNumber = map.get(charArray[i]);
                RomaNumber romaNumber1 = map.get(charArray[i + 1]);
                if (romaNumber.order < romaNumber1.order) {
                    if ((romaNumber.character == 'I' && (romaNumber1.character == 'V' || romaNumber1.character == 'X'))
                            || (romaNumber.character == 'X' && (romaNumber1.character == 'L' || romaNumber1.character == 'C'))
                            || (romaNumber.character == 'C' && (romaNumber1.character == 'D' || romaNumber1.character == 'M'))) {
                        result += map.get(charArray[i]).value * -1;
                    } else {
                        result += map.get(charArray[i]).value;
                    }
                } else {
                    result += map.get(charArray[i]).value;
                }
            } else {
                result += map.get(charArray[i]).value;
            }
        }
        return result;
    }

    private void initMap() {
        map.put('I', new RomaNumber('I', 1, 1));
        map.put('V', new RomaNumber('V', 5, 2));
        map.put('X', new RomaNumber('X', 10, 3));
        map.put('L', new RomaNumber('L', 50, 4));
        map.put('C', new RomaNumber('C', 100, 5));
        map.put('D', new RomaNumber('D', 500, 6));
        map.put('M', new RomaNumber('M', 1000, 7));
    }
}
