package com.company.controller;

import com.company.model.Card;
import com.company.model.Choice;
import com.company.model.Quiz;
import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class FlashCardsController {

    private List<Quiz> quizzes;
    private User user;

    public FlashCardsController(User user){
        this.user = user;
        this.quizzes = new ArrayList<>();
    }

    public void addCard(Card card, int quizNum){
        this.quizzes.get(quizNum).addCard(card);
    }

    public void addQuiz(Quiz quiz){
        this.quizzes.add(quiz);
    }

    public List<Quiz> getQuizList(){
        return this.quizzes;
    }

    public List<Card> getCardList(int quizNum){
        return this.quizzes.get(quizNum).getCards();
    }

    public void removeCard(int quizNum, Card card){
        this.quizzes.get(quizNum).removeCard(card);
    }

    public int playQuiz(int quizNum){
        Quiz quiz = this.quizzes.get(quizNum);
        for (int i=0; i<quiz.getCards().size();i++) {
            quiz.setScore(quiz.getScore() + play(quiz.getCards().get(i), true));
        }
        return quiz.getScore();
    }

    public static int play(Card card, boolean status){
        if(status)
            return card.getPoints();
        else
            return 0;
    }

}
