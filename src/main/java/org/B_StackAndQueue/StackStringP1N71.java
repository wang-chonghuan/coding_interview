package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. Simplify Path
 *
 * 这个问题要求编写一个函数，输入一个字符串path，它是一个Unix风格文件系统的绝对路径（以斜杠'/'开始），函数的目标是将其转换为简化的规范路径。
 *
 * 在Unix风格的文件系统中：
 *
 * 单个句点'.'指的是当前目录，
 * 双句点'..'指的是上一级目录，
 * 任何连续的多个斜杠（例如'//'）都被视为单个斜杠'/'。
 * 对于这个问题来说，其他格式的句点（如'...'）被视为文件/目录名。
 * 简化后的规范路径应该符合以下格式：
 *
 * 路径以单个斜杠'/'开始。
 * 任意两个目录由单个斜杠'/'分隔。
 * 路径不以尾部斜杠'/'结束。
 * 路径只包含从根目录到目标文件或目录的路径中的目录（即，没有单个句点'.'或双句点'..'）。
 * 你的任务是返回这个简化后的规范路径。
 */
public class StackStringP1N71 {
    /**
     * 这题的诀窍是根据斜杠拆分字符串，千万不要一个字符一个字符的分析
     * for deque还是逆序的，因为栈顶在first，所以要removeLast
     * 比较字符串必须用equal
     */

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] strList = path.split("/");
        for(var s : strList) {
            // 遇到//或者/./要无视，不入栈
            if(s.equals("") || s.equals(".")) {
                continue;
            }
            // 遇到/../要删除上一个
            else if(s.equals("..")) {
                if(stack.size() > 0) {
                    stack.removeFirst();
                }
            }
            // 遇到其他的，入栈
            else {
                stack.addFirst(s);
            }
        }
        var sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append('/');
            sb.append(stack.removeLast());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
