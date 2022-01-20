package com.company.model;

public class Choice {
    private int num;
    private String content;
    private boolean status;

    public Choice(int num, String content, boolean status){
        this.num = num;
        this.content = content;
        this.status = status;
    }

    public int getNum(){
        return this.num;
    }

    public String getContent(){
        return this.content;
    }

    public boolean getStatus(){
        return this.status;
    }
}
