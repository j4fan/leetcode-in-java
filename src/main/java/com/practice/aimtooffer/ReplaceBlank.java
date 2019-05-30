package com.practice.aimtooffer;

/**
 * task16请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlank {
    public static String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        int countOfBlank = 0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)==' '){
                countOfBlank++;
            }
        }
        int numberOfBlank=0;
        int newLength = oldLength+countOfBlank*2;
        str.setLength(newLength);
        for(int i=0;i<oldLength;i++){
            if(str.charAt(oldLength-i-1)==' '){
                str.setCharAt(newLength-i-1-numberOfBlank*2,'0');
                str.setCharAt(newLength-i-2-numberOfBlank*2,'2');
                str.setCharAt(newLength-i-3-numberOfBlank*2,'%');
                numberOfBlank++;
            }else{
                str.setCharAt(newLength-i-1-numberOfBlank*2,str.charAt(oldLength-i-1));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
