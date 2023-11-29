package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20 valid parenthese
 * given a string s containing just the characters
 * '( ) { } [ ]', determine if the input string is valid
 *
 * an input string is valid if:
 * open brackets must be closed by the same type of brackets
 * open brackets must be closed in the correct order
 * every close bracket has a corresponding open bracket of the same type
 */
public class StackStringE1N20 {

    // 不匹配就入栈，匹配了就弹出
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if(stack.size() != 0) {
                if (isMatch(stack.peekFirst(), curChar)) {
                    stack.removeFirst();
                } else {
                    stack.addFirst(curChar);
                }
            } else {
                stack.addFirst(curChar);
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character c1, Character c2) {
        if(c1 == '(' && c2 == ')')
            return true;
        if(c1 == '[' && c2 == ']')
            return true;
        if(c1 == '{' && c2 == '}')
            return true;
        return false;
    }
}
