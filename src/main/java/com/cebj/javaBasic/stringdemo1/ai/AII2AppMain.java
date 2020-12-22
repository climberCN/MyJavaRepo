package com.cebj.javaBasic.stringdemo1.ai;

import java.util.Scanner;

public class AII2AppMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AI2 ai = new AI2();
        String ret = null;
        while (true) {
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("再见");
                break;
            }
            ret = ai.answer(input);
            System.out.println(ret);
        }

    }
}
