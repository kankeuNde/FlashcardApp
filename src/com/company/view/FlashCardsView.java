package com.company.view;
import com.company.controller.FlashCardsController;
import com.company.model.*;
import com.company.utils.Frequency;

import java.util.List;
import java.util.Scanner;

public class FlashCardsView {

    public void consoleView(Scanner scanner, FlashCardsController flashCardsControl){
        Scanner entry = scanner;
        FlashCardsController flashCardsController = flashCardsControl;
        int numberOfTrials = 5;
        message();
        String option = entry.nextLine();
        while(!option.equals("X")){
            switch (option){
                case "Q":
                    String ansQ = "Y";
                    System.out.println("Quiz creation:");
                    while(ansQ.equals("Y")){
                        System.out.print("Enter the quiz title:");
                        String title = entry.nextLine();
                        Quiz quiz = new Quiz(title, numberOfTrials);
                        flashCardsController.addQuiz(quiz);
                        System.out.println("Another Quiz? N to close, Y to continue");
                        ansQ = entry.nextLine();
                    }
                    break;
                case "C":{
                    String ansC = "Y";
                    System.out.println("Quiz list:");
                    for(int i=0; i<flashCardsController.getQuizList().size();i++)
                        System.out.println((i+1) + ": " + flashCardsController.getQuizList().get(i).getTitle());
                    System.out.println("Add Cards:");
                    System.out.print("Enter the quiz number:");
                    int num = Integer.parseInt(entry.nextLine()) -1;

                    while(ansC.equals("Y")){
                        System.out.print("Give a title card: ");
                        String title = entry.nextLine();

                        System.out.print("Enter the question: ");
                        String question = entry.nextLine();

                        System.out.println("Enter options with it's status: \n\tTrue if part of the answer \n\tFalse if not ");

                        String ansO = "Y";
                        int option_num = 1;
                        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(question);
                        while(ansO.equals("Y")){
                            System.out.print("Enter the option answer");
                            String answer = entry.nextLine();
                            System.out.println("Enter the Status (T/F)");
                            String status = entry.nextLine();
                            boolean status_B = false;
                            if(status.equals("T")||status.equalsIgnoreCase("true"))
                                status_B = true;
                            Choice choice = new Choice(option_num,answer,status_B);
                            mcq.addChoice(choice);
                            option_num++;
                            System.out.println("Add more choice ? Y/N");
                            ansO = entry.nextLine();
                        }


                        System.out.print("Enter the points value: ");
                        int points = Integer.parseInt(entry.nextLine());

                        System.out.println("Enter the frequency of the card: \n\t1 --> Low \n\t2 --> MEDIUM\n\t3 --> HIGH");
                        String freq = entry.nextLine();
                        Card card = null;
                        switch (freq){
                            case "1":
                                card = new Card(title, mcq, points, Frequency.LOW);
                                break;
                            case "2":
                                card = new Card(title, mcq, points, Frequency.MEDIUM);
                                break;
                            case "3":
                                card = new Card(title, mcq, points, Frequency.HIGH);
                                break;
                        }

                        flashCardsController.getQuizList().get(num).addCard(card);
                        System.out.println("Add more cards? Y or N");
                        ansC = entry.nextLine();
                    }
                    break;
                }
                case "P":{
                    System.out.println("Choose the level: \n\t[B] -> Beginner, \n\t[I] -> Intermediate, \n\t[A] -> Advanced");
                    String level = entry.nextLine();
                    String ansP = "Y";
                    while(ansP.equals("Y")) {
                        System.out.println("Quiz topics:");
                        for(int i=0; i<flashCardsController.getQuizList().size();i++)
                            System.out.println((i+1) + ": " + flashCardsController.getQuizList().get(i).getTitle());
                        System.out.print("Give quiz number: ");
                        int num = Integer.parseInt(entry.nextLine()) -1;
                        Quiz quiz = flashCardsController.getQuizList().get(num);

                        for (int i = 0; i < quiz.getCards().size(); i++) {
                            System.out.println("30 seconds left for Answer:");
                            //display the list of possible choices
                            Card card = quiz.getCards().get(i);
                            for(Choice choice:card.getListOfChoices()){
                                System.out.println(choice.getNum() + " : " + choice.getContent());
                            }
                            // get the user's choices
                            // And the same time decreasing time
                            System.out.println("Choose all that apply: Enter the number separated by ',' ex: 1,3,4... then press enter to validate your answer");
                            String answer = entry.nextLine().trim();
                            String[] choosed = answer.split(",");

                            for(int j=10; j>0; j--){
                                try {
                                    Thread.sleep(3_000);
                                    System.out.println("Tic Tac Tic Tac .......: " + j + " seconds left!");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            for(Choice choice: card.getListOfAnswer()){
                                System.out.println(choice.getNum() + " : " + choice.getContent());
                            }

                            if(card.gotItRight(choosed)){
                                quiz.setScore(quiz.getScore()+quiz.getCards().get(i).getPoints());
                            }

                        }
                        System.out.println("Score: " + quiz.getScore());
                        System.out.println("Play again? Y or N");
                        ansP = entry.nextLine();
                    }
                    break;
                }
                default:
                    System.out.println("Entry not recognized!");
                    break;
            }
            message();
            option = entry.nextLine();
        }
    }
    /*public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = entry.nextLine();
        User user = new User(name);
        FlashCardsController flashCardsController = new FlashCardsController(user);

        message();
        String option = entry.nextLine();
        while(!option.equals("X")){
            switch (option){
                case "Q":
                    String ansQ = "Y";
                    System.out.println("Quiz creation:");
                    while(ansQ.equals("Y")){
                    System.out.print("Enter the quiz title:");
                    String title = entry.nextLine();
                    Quiz quiz = new Quiz(title);
                    flashCardsController.addQuiz(quiz);
                    System.out.println("Another Quiz? N to close, Y to continue");
                    ansQ = entry.nextLine();
                    }
                    break;
                case "C":{
                    String ansC = "Y";
                    System.out.println("Quiz list:");
                    for(int i=0; i<flashCardsController.getQuizList().size();i++)
                        System.out.println((i+1) + ": " + flashCardsController.getQuizList().get(i).getTitle());
                    System.out.println("Add Cards:");
                    System.out.print("Enter the quiz number:");
                    int num = Integer.parseInt(entry.nextLine()) -1;

                    while(ansC.equals("Y")){
                        System.out.print("Give a title card: ");
                        String title = entry.nextLine();

                        System.out.print("Enter the question: ");
                        String question = entry.nextLine();

                        System.out.print("Enter the answer: ");
                        String answer = entry.nextLine();

                        System.out.print("Enter the points value: ");
                        int points = Integer.parseInt(entry.nextLine());

                        Card card = new Card(title, question, answer, points);
                        flashCardsController.getQuizList().get(num).addCard(card);

                        System.out.println("Add more? Y or N");
                        ansC = entry.nextLine();
                    }
                    break;
                }
                case "P":{
                    String ansP = "Y";
                    while(ansP.equals("Y")) {
                        System.out.println("Quiz list:");
                        for(int i=0; i<flashCardsController.getQuizList().size();i++)
                            System.out.println((i+1) + ": " + flashCardsController.getQuizList().get(i).getTitle());
                        System.out.print("Give quiz number: ");
                        int num = Integer.parseInt(entry.nextLine()) -1;
                        Quiz quiz = flashCardsController.getQuizList().get(num);

                        for (int i = 0; i < quiz.getCards().size(); i++) {
                            System.out.println("30 seconds left for Answer:");
                            System.out.println(quiz.getCards().get(i).getQuestion());
                            for(int j=10; j>0; j--){
                                try {
                                    Thread.sleep(3_000);
                                    System.out.println("Tic Tac Tic Tac .......: " + j + "seconds left!");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(quiz.getCards().get(i).getAnswer());
                            System.out.println("Got it? Y or N");
                            String ansGot = entry.nextLine();
                            if(ansGot.equals("Y")){
                                quiz.setScore(quiz.getScore()+quiz.getCards().get(i).getPoints());
                            }

                        }
                        System.out.println("Score: " + quiz.getScore());
                        System.out.println("Play again? Y or N");
                        ansP = entry.nextLine();
                    }
                    break;
                }
                default:
                    System.out.println("Entry not recognized!");
                    break;
            }
            message();
            option = entry.nextLine();
        }
    }*/

    private static void message() {
        System.out.println("Q ====> Create a quiz");
        System.out.println("C ====> Add a cards");
        System.out.println("P ====> play quiz");
        System.out.println("X ====> close the game");
        System.out.print("Choose an action: ");
    }
}
