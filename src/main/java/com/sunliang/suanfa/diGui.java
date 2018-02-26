package com.sunliang.suanfa;

/**
 * @author sunliang
 * @desc 递归算法
 * @create 2017-12-18 15:34
 **/
public class diGui {


    public static int foo(int result,int endpoint){
        if(result<=endpoint){
            System.out.println(result);
            foo(++result,endpoint);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(foo(1,100));
    }
}
