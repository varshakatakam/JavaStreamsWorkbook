package com.training.main;

import com.training.service.StreamService;

public class Main {

    public static void main (String[] args){

        StreamService service =new StreamService();

        System.out.println("===== Problem 1: Customer Transaction Aggregator =====");
        service.solveP1();

        System.out.println("===== Problem 2: Group Orders by Customer =====");
        service.solveP2();

        System.out.println("===== Problem 3:Log Analytics =====");
        service.solveP3();

        System.out.println("===== Problem 4:Top 3 Frequent Words =====");
        service.solveP4();

        System.out.println("===== Problem 5: Group Anagrams =====");
        service.solveP5();

        System.out.println("===== Problem 6: Inventory Reconciliation =====");
        service.solveP6();

        System.out.println("===== Problem 7: Longest Substring with K Distinct Characters =====");
        service.solveP7();

        System.out.println("\n===== Problem 8: Employee Hierarchy Builder =====");
        service.solveP8();

        System.out.println("===== Problem 9: Multi-Level Employee Sorting =====");
        service.solveP9();

        System.out.println("\n===== Problem 10 : Account Balance Processor =====");
        service.solveP10();

        System.out.println("\n===== Problem 11 : Detect Circular Dependency =====");
        service.solveP11();

        System.out.println("\n===== Problem 12 : Session Analytics =====");
        service.solveP12();
    }
}
