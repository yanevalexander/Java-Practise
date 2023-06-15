package project;

import project.classes.*;
import project.classes.Machine;
import project.classes.PrintingHouse;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a printing house.
        PrintingHouse printingHouse = new PrintingHouse();
        // Add employees to the printing house.
        printingHouse.addEmployee(new Employee("John", Employee.Role.OPERATOR, 1000));
        printingHouse.addEmployee(new Employee("Mary", Employee.Role.OPERATOR, 1000));
        printingHouse.addEmployee(new Employee("Peter", Employee.Role.MANAGER, 2000));
        // Add machines to the printing house.
        printingHouse.addMachine(new Machine(100));
        printingHouse.addMachine(new Machine(200));
        // Add editions to the printing house.
        printingHouse.addEdition(new Edition("Book", 100, 1, 1));
        printingHouse.addEdition(new Edition("Poster", 10, 2, 2));
        printingHouse.addEdition(new Edition("Newspaper", 1000, 4, 0.5));
        // Print the editions.
        try {
            printingHouse.printEditions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Calculate the income of the printing house.
        double income = printingHouse.calculateIncome();
        System.out.println("Income: " + income);
        // Pay the employees.
        printingHouse.payEmployees();
        // Save the data to a file.
        printingHouse.saveData();
        // Load the data from a file.
        printingHouse.loadData();
    }
}
