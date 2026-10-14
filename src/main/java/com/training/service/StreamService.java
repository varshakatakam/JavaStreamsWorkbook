package com.training.service;

import com.training.dto.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;

public class StreamService {

    public void solveP1(){

        List<Transaction_P1> transactions = Arrays.asList(
                new Transaction_P1("C1","CREDIT",1000),
                new Transaction_P1("C1","DEBIT",200),
                new Transaction_P1("C2","CREDIT",500),
                new Transaction_P1("C1","CREDIT",300)
        );
        Map<String,List<Transaction_P1>>grouped=transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction_P1::getCustomerId)
                );
        grouped.entrySet().stream()
                .sorted((e1, e2) -> {
                    double balance1 = e1.getValue().stream()
                            .mapToDouble(t -> t.getType().equals("CREDIT")
                                    ? t.getAmount() : -t.getAmount())
                            .sum();

                    double balance2 = e2.getValue().stream()
                            .mapToDouble(t -> t.getType().equals("CREDIT")
                                    ? t.getAmount() : -t.getAmount())
                            .sum();

                    return Double.compare(balance2, balance1);
                })
                .forEach(entry -> {
                    String customerId = entry.getKey();
                    List<Transaction_P1> customerTransactions = entry.getValue();

            double credits =customerTransactions.stream()
                    .filter(t ->t.getType().equals("CREDIT"))
                    .mapToDouble(Transaction_P1::getAmount)
                    .sum();


            double debits =customerTransactions.stream()
                    .filter(t ->t.getType().equals("DEBIT"))
                    .mapToDouble(Transaction_P1::getAmount)
                    .sum();

                    double balance =credits - debits;

                    System.out.println(customerId
                    +"-> Credits="+credits
                    +"-> Debits="+debits
                    +"-> Balance="+balance);
        });
    }
    public void solveP2(){

        List<Order_P2> orders = Arrays.asList(
                new Order_P2("O1","C1",100),
                new Order_P2("O2","C1",200),
                new Order_P2("O3","C2",150)
        );

        Map<String,List<Order_P2>>groupedOrders =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order_P2::getCustomerId
                        ));
        groupedOrders.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->{
                    String customerId =entry.getKey();
                    List<Order_P2> customerOrders = entry.getValue();

                    long totalOrders =
                            customerOrders.stream()
                                    .count();

                    double totalAmount=
                            customerOrders.stream()
                                    .mapToDouble(Order_P2::getAmount)
                                    .sum();

                    System.out.println(customerId
                    +"-> TotalOrders="+totalOrders
                    +"-> TotalAmount="+totalAmount);
                });
    }
    public void solveP3(){
        List<String> logs =Arrays.asList(
                "ERROR DB Failed",
                "INFO Login Success",
                "ERROR Timeout",
                "WARN Disk High"
        );

        Map<String,Long>logCounts = logs.stream()
                .collect(Collectors.groupingBy(
                        log -> log.split(" ")[0],
                        Collectors.counting()
                ));

        logCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(entry.getKey()
                        +"->"+entry.getValue()));
    }
    public void solveP4(){
        String paragraph = "java spring java kafka spring java redis";

        Map<String,Long> wordCounts =
                Arrays.stream(paragraph.split("\\s+"))
                        .collect(Collectors.groupingBy(
                                word -> word, Collectors.counting()
                        ));
        wordCounts.entrySet().stream()
                .sorted(
                        Map.Entry.<String,Long>comparingByValue()
                                .reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .limit(3)
                .forEach(entry ->
                        System.out.println(entry.getKey()
                        +"="+entry.getValue()
                        )
                );
    }
    public void solveP5(){

        List<String> words =Arrays.asList(
                "eat","tea","ate",
                "tan","nat","bat"
        );
        Map<String,List<String>> groupedAnagrams=
                words.stream()
                        .collect(Collectors.groupingBy(
                                word-> {
                                    char[] letters =
                                            word.toCharArray();
                                    Arrays.sort(letters);
                                    return new String(letters);
                                },
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));
        List<List<String>> result =
                new
                        ArrayList<>(groupedAnagrams.values());
        System.out.println(result);
    }
    public void solveP6(){

        List<Inventory_P6>warehouse = Arrays.asList(
                new Inventory_P6("P1",100),
                new Inventory_P6("P2",200)
        );

        List<Inventory_P6> store = Arrays.asList(
                new Inventory_P6("P1",90),
                new Inventory_P6("P2",200)
        );

        Map<String,Integer>storeMap =store.stream()
                .collect(Collectors.toMap(
                        Inventory_P6::getProductId,
                        Inventory_P6::getQuantity
                ));
        warehouse.stream()
                .filter(item ->
                        storeMap.containsKey(item.getProductId())
                                && item.getQuantity() !=
                                storeMap.get(item.getProductId())
                )
                                .forEach(item ->
                                        System.out.println(
                                                item.getProductId()
                                                +"Quantity Mismatch Expected="
                                                +item.getQuantity()
                                                +"Actual="
                                                +storeMap.get(item.getProductId())
                                        )
                                );

    }
    public void solveP7(){

        String input ="aabacbebebe";
        int k =3;

        Map<Character,Integer>charCount =new HashMap<>();

        int left=0;
        int maxLength=0;
        int startIndex=0;

        for (int right =0;right<input.length();right++){
            char currentChar = input.charAt(right);

            charCount.put(currentChar,
                    charCount.getOrDefault(currentChar,0) +
                            1);

            while (charCount.size() > k) {

                char leftChar = input.charAt(left);

                charCount.put(
                        leftChar,
                        charCount.get(leftChar) - 1
                );

                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }

                left++;
            }

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = left;
            }
        }
        String longestSubstring =
                input.substring(startIndex, startIndex + maxLength);

        System.out.println("Longest Substring = " + longestSubstring);
        System.out.println("Length = " + maxLength);
    }

    public void solveP8() {

        List<Employee_P8> employees = Arrays.asList(
                new Employee_P8(1, "CEO", null),
                new Employee_P8(2, "Manager", 1),
                new Employee_P8(3, "Dev1", 2),
                new Employee_P8(4, "Dev2", 2)
        );

        Map<Integer, List<Employee_P8>> employeesByManager =
                employees.stream()
                        .filter(employee -> employee.getManagerId() != null)
                        .collect(Collectors.groupingBy(
                                Employee_P8::getManagerId
                        ));
        Employee_P8 ceo = employees.stream()
                .filter(employee -> employee.getManagerId() == null)
                .findFirst()
                .orElse(null);


        if (ceo != null) {
            System.out.println(ceo.getEmployeeName());

            employeesByManager
                    .getOrDefault(ceo.getEmployeeId(), Collections.emptyList())
                    .stream()

                    .forEach(manager -> {

                        System.out.println("    " + manager.getEmployeeName());

                        employeesByManager
                                .getOrDefault(manager.getEmployeeId(), Collections.emptyList())
                                .stream()
                                .forEach(employee ->
                                        System.out.println("        " + employee.getEmployeeName())
                                );

                    });
        }
    }
    public void solveP9() {

        List<Employee_P9> employees = Arrays.asList(
                new Employee_P9("John", "IT", 10, 4.5),
                new Employee_P9("Alice", "IT", 10, 4.8),
                new Employee_P9("Bob", "HR", 12, 4.7)
        );
        employees.stream()
                .sorted(
                        Comparator.comparing(Employee_P9::getDepartment)
                                .thenComparing(
                                        Comparator.comparingInt(Employee_P9::getExperience)
                                                .reversed()
                                )
                                .thenComparing(
                                        Comparator.comparingDouble(Employee_P9::getRating)
                                                .reversed()
                                )
                                .thenComparing(Employee_P9::getEmployeeName)
                )
                .forEach(employee ->
                        System.out.println(
                                employee.getEmployeeName() + " "
                                        + employee.getDepartment() + " "
                                        + employee.getExperience() + " "
                                        + employee.getRating()
                        )
                );
    }

    public void solveP10() {

        List<AccountTransaction_P10> transactions = Arrays.asList(
                new AccountTransaction_P10("A1", "CREDIT", 1000),
                new AccountTransaction_P10("A1", "DEBIT", 400),
                new AccountTransaction_P10("A2", "CREDIT", 700)
        );
        Map<String, Double> accountBalances =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                AccountTransaction_P10::getAccountId,
                                Collectors.summingDouble(transaction ->
                                        transaction.getTransactionType().equals("CREDIT")
                                                ? transaction.getAmount()
                                                : -transaction.getAmount()
                                )
                        ));
        accountBalances.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " Balance="
                                        + entry.getValue().intValue()
                        )
                );
        accountBalances.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println("Top Account=" + entry.getKey())
                );
    }
    public void solveP11() {

        Map<String, String> dependencies = new LinkedHashMap<>();

        dependencies.put("A", "B");
        dependencies.put("B", "C");
        dependencies.put("C", "A");

        Set<String> visited = new HashSet<>();

        boolean cycleDetected = false;
        List<String> components = dependencies.keySet()
                .stream()
                .collect(Collectors.toList());
        for (String component : components) {

            Set<String> currentPath = new HashSet<>();

            String current = component;

            while (current != null) {

                if (!currentPath.add(current)) {
                    cycleDetected = true;
                    break;
                }

                if (visited.contains(current)) {
                    break;
                }

                current = dependencies.get(current);
            }

            visited.addAll(currentPath);

            if (cycleDetected) {
                break;
            }
        }
        System.out.println(
                "Cycle Detected = " + (cycleDetected ? "TRUE" : "FALSE")
        );
    }
    public void solveP12() {

        List<Session_P12> sessions = Arrays.asList(
                new Session_P12("U1", "LOGIN", LocalTime.of(10, 0)),
                new Session_P12("U1", "LOGOUT", LocalTime.of(10, 45)),
                new Session_P12("U2", "LOGIN", LocalTime.of(11, 0)),
                new Session_P12("U2", "LOGOUT", LocalTime.of(12, 30))
        );

        Map<String, List<Session_P12>> sessionsByUser =
                sessions.stream()
                        .collect(Collectors.groupingBy(
                                Session_P12::getUserId
                        ));
        Map<String, Long> sessionDurations =
                sessionsByUser.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> {
                                    List<Session_P12> events = entry.getValue();

                                    LocalTime loginTime = events.stream()
                                            .filter(event -> event.getEventType().equals("LOGIN"))
                                            .map(Session_P12::getEventTime)
                                            .findFirst()
                                            .orElseThrow(IllegalStateException::new);

                                    LocalTime logoutTime = events.stream()
                                            .filter(event -> event.getEventType().equals("LOGOUT"))
                                            .map(Session_P12::getEventTime)
                                            .findFirst()
                                            .orElseThrow(IllegalStateException::new);

                                    return Duration.between(loginTime, logoutTime).toMinutes();
                                }
                        ));

        sessionDurations.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " Session="
                                        + entry.getValue() + " mins"
                        )
                );

        double averageSession = sessionDurations.values().stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0.0);

        System.out.println("Average Session=" + averageSession + " mins");
    }
}