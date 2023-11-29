package org.C_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together.

For example, given strs = ["eat","tea","tan","ate","nat","bat"], return [["bat"],["nat","tan"],["ate","eat","tea"]].

解决这个问题的核心思路是利用哈希映射来对变位词进行分组，具体实现时，我们遍历输入的字符串数组，对于每一个字符串，计算其每个字母的出现次数，并将这个字母计数信息转换成一个字符串作为键，这样，所有的变位词就会具有相同的键。创建一个哈希映射，以这个键作为映射的键，并用一个列表作为映射的值，存放具有相同键的字符串。接着，我们将每个输入字符串按照其字母计数信息生成的键添加到对应的列表中。最后，哈希映射中的每个键值对的值（即每个列表）就是一组变位词。
 */
public class MoreE1N49 {

    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        var ans = new HashMap<String, List>();
        for(var s : strs) {
            var charArr = s.toCharArray();
            Arrays.sort(charArr);
            var key = String.valueOf(charArr);
            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 当输入的字符串数组为空时，直接返回一个空的列表
        if(strs.length == 0)
            return new ArrayList<>();
        // 使用hash存储分组的变位词
        // 键是排序后的字符串或字符计数的一种编码，值是原字符串的列表
        var ans = new HashMap<String, List>();
        // count用于存储每个字符串中26个字母出现的次数
        var count = new int[26];

        // 遍历输入的字符串数组
        for(var s : strs) {
            // 每处理一个字符串，就将count清零
            Arrays.fill(count, 0);
            // 遍历s中每一个字符，更新count数组
            for(var c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // 使用StringBuilder创建一个字符串key
            // 它包含一个由#和字符串计数拼接而成的字符串
            // 例如 aabb -> #2#2#0#0#0...#0
            var sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            var key = sb.toString();
            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
