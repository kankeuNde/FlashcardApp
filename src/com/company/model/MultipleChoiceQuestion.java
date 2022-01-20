package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion {
    private String question;
    private List<Choice> choices;

    public MultipleChoiceQuestion(String question){
        this.question = question;
        this.choices = new ArrayList<>();
    }

    public void addChoice(Choice option){
        this.choices.add(option);
    }

    public List<Choice> getChoices(){
        return this.choices;
    }
}
