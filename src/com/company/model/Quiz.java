package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int score;
    private String topic;
    private List<Card> cards;

    public Quiz(String title, int numOfTrials){
        this.score = 0;
        this.topic = title;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public List<Card> getCards(){
        return this.cards;
    }

    public String getTitle(){
        return this.topic;
    }

    public void setTitle(String title){
        this.topic = title;
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

}
