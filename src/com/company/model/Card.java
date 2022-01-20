package com.company.model;

import com.company.utils.Frequency;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String title;
    private MultipleChoiceQuestion mcq;
    private int points;
    private Frequency frequency;

    public Card(String title){
        this.title = title;
        this.points = 0;
    }

    public Card(String title, MultipleChoiceQuestion mcq, int points, Frequency frequency){
        this.title = title;
        this.mcq = mcq;
        this.points = points;
        this.frequency = frequency;
    }

    public void setPoints(int points){
        this.points = points;
    }
    public int getPoints(){
        return this.points;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public MultipleChoiceQuestion getMcq(){
        return this.mcq;
    }
    public List<Choice> getListOfChoices(){
        return this.getMcq().getChoices();
    }

    public List<Choice> getListOfAnswer(){
        List<Choice> answers = new ArrayList<Choice>();
        for(Choice choice:this.getMcq().getChoices()){
            if(choice.getStatus()==true)
                answers.add(choice);
        }
        return answers;
    }

    private String[] getListOfAnswerA(){
        String[] result = new String[this.getMcq().getChoices().size()];
        for(int i=0; i<result.length; i++){
            if(this.getMcq().getChoices().get(i).getStatus()==true)
                result[i] = String.valueOf(this.getMcq().getChoices().get(i).getNum());
        }
        return result;
    }

    public boolean gotItRight(String[] listOfChoices){
        return this.getListOfAnswerA().equals(listOfChoices);
    }
}
