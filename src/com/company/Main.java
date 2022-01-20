package com.company;
import com.company.controller.FlashCardsController;
import com.company.model.Card;
import com.company.model.Quiz;
import com.company.model.User;
import com.company.view.FlashCardsView;
import com.company.view.FlashCardsViewFX;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = entry.nextLine();
        User user = new User(name);
        FlashCardsController flashCardsController = new FlashCardsController(user);

        FlashCardsView view = new FlashCardsView();
        view.consoleView(entry, flashCardsController);

        //FlashCardsViewFX graphicView = new FlashCardsViewFX();
        //graphicView.launchApp();
    }

}
