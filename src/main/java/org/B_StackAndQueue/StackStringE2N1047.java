package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * example2: 1047
 * remove all adjacent duplicates in string
 * you are given a string s, continuously remove duplicates
 * (two of the same character beside each other)
 * until you cant anymore. return the final string after this.
 * for example given s = "abbaca",
 * you can first remove the "bb" to get "aaca"
 * next you can remove the "aa" to get "ca",
 * this is the final answer
 */
public class StackStringE2N1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            // 每遇到一个新字符，就试图放入栈，如果和栈顶的元素一样，就销毁这两个元素。
            // 如果和栈顶元素不一样，就放入栈
            // 这样把连续的字符都销毁了
            if (stack.isEmpty()) {
                stack.addFirst(curChar);
            } else {
                if (stack.peekFirst() == curChar) {
                    stack.removeFirst();
                } else {
                    stack.addFirst(curChar);
                }
            }
        }

        String s1 = stack.stream()
                .map(Objects::toString)
                .collect(Collectors.joining());

        return new StringBuilder(s1).reverse().toString();
    }
}
