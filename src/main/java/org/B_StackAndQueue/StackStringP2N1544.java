package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackStringP2N1544 {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char curChar : s.toCharArray()) {
            if(!stack.isEmpty()
                    && Math.abs(stack.peekFirst() - curChar) == 32) {
                stack.removeFirst();
            } else {
                stack.addFirst(curChar);
            }
        }
        var sb = new StringBuilder();
        for(char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
