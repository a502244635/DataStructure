package com.wenwen.learn.match;

public class ViolentMatch {
    public static void main(String[] args) {
        String str1 = "喀喀喀is先看下哦哦逻辑上的历史阶段";
        String str2 = "哦哦逻辑上的历";
        int index = violentMatch(str1,str2);
        System.out.println(index);
    }
    public static int violentMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;//索引指向s1
        int j = 0;//索引指向s2

        while (i < s1Len && j < s2Len){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else{
                i = i - (j-1);
                j = 0;
            }
        }
        //判断是否匹配成功
        if (j == s2Len){
            return i-j;
        }else{
            return -1;
        }
    }
}
