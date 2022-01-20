package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String level;
    private List<Quiz> quizzes;

    public User(String name){
        this.name = name;
        quizzes = new ArrayList<Quiz>();
    }

    public String getLevel(){
        return this.level;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public String getName(){
        return this.name;
    }

    public List<Quiz> getQuizzes(){
        return this.quizzes;
    }
}
