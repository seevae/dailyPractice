package com.qi.diInterface01;/*
    name zhang;
    */

public class ChangetoLowerCase implements ChangeLetter{

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public String change(String str) throws Exception {
        this.str = str;
        return this.str.toLowerCase();
    }
}
