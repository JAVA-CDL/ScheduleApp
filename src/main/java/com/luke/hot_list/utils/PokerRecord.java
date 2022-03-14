package com.luke.hot_list.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PokerRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> totalPoker = new ArrayList<>(Arrays.asList("X", "S", "2", "2", "2", "2", "A", "A", "A", "A", "K", "K", "K", "K", "Q", "Q", "Q", "Q",
                "J", "J", "J", "J", "0", "0", "0", "0", "9", "9", "9", "9", "8", "8", "8", "8",
                "7", "7", "7", "7", "6", "6", "6", "6", "5", "5", "5", "5", "4", "4", "4", "4", "3", "3", "3", "3"));
        System.out.print("please input you poker list : ");
        String myPoker = scanner.nextLine();
        changePoker(totalPoker, myPoker);
        printInfo(totalPoker);
        while (true) {
            System.out.print("input remove poker list : ");
            String poker = scanner.nextLine();
            if ("exit".equals(poker)) {
                break;
            }
            changePoker(totalPoker, poker);
            printInfo(totalPoker);
        }
    }

    private static void printInfo(List<String> totalPoker) {
        System.out.println(String.join(" ", totalPoker));
    }

    private static void changePoker(List<String> totalPoker, String pokers) {
        for (String poker : pokers.replace("10", "0").replace(" ", "").split("")){
            totalPoker.remove(poker);
        }
    }
}
