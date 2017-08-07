package com.example.wucaiyan.mytest.javatest;

/**
 * Created by wucaiyan on 17-8-4.
 */

public class Outer {
    static class StaticInter{}


    class Inner{
        public String publicString = "Inner.publicString";
    }

    Other other = new Other();
    public Other getOther(){
        return other;
    }


    public Other getAnonymousOther(){
        return Anonymous;
    }

    Other Anonymous = new Other(){
        public String publicString = "Anonymous Other.publicString";
    };

    class Other {
        public String publicString = "Other.publicString";
    }

    public static void main(String args[]) {
        System.out.println(new Outer().new Inner());
        System.out.println("\t");
        System.out.println(new Outer().getAnonymousOther());
        System.out.println("\t");
        System.out.println(new Outer().getOther());
    }
}
