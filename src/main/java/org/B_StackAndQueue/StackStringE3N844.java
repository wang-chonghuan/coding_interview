package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * 844 backspace string compare
 * given two strings s and t, return true if they are equal
 * when both are typed into empty text editors
 * # means a backspace character
 * Note that after backspacing an empty text
 * the text will continue empty
 */
public class StackStringE3N844 {
    public boolean isEqual(String s, String t) {
        return clean(s).equals(clean(t));
    }

    private String clean(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if(curChar == '#') {
                if(!stack.isEmpty()) {
                    stack.removeFirst();
                }
            } else {
                stack.addFirst(curChar);
            }
        }
        return stack.stream().map(Object::toString)
                .collect(Collectors.joining());
    }
}
