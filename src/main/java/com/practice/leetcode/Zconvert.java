package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class Zconvert {

    public String convert(String s, int numRows) {
        if(numRows<=0){
            throw new RuntimeException("numRows不能小于0");
        }
        if(numRows==1){
            return s;
        }
        List<StringBuffer> sbList = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            sbList.add(new StringBuffer());
        }
        StringBuffer sb = new StringBuffer();
        boolean inorder = false;
        int cur = 0;
        for(char c:s.toCharArray()){
            sbList.get(cur).append(c);
            if(cur ==0||cur==numRows-1){
                inorder = !inorder;
            }
            cur = inorder?cur+1:cur-1;
        }
        sbList.forEach(list->{
            sb.append(list.toString());
        });
        return sb.toString();
    }
}
