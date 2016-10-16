package com.ligstd.homework;

import com.ligstd.homework.controllers.MainController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       MainController mainController = new MainController(System.in, System.out);
        while(true){
            try {
                mainController.AcquireInput();
            }
            catch (ArithmeticException exception){
                System.out.println(exception.getMessage());
            }
        }

    }
}
