package project.classes;

import project.classes.Edition;
import project.classes.Machine;
import project.classes.Employee;

import java.io.*;
import java.util.*;

public class PrintingHouse {
    private List<Employee> employees;
    private List<Machine> machines;
    private List<Edition> editions;
    public PrintingHouse() {
        this.employees = new ArrayList<>();
        this.machines = new ArrayList<>();
        this.editions = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    public void addMachine(Machine machine) {
        this.machines.add(machine);
    }
    public void addEdition(Edition edition) {
        this.editions.add(edition);
    }
    public void printEditions() throws Exception {
        for (Edition edition : this.editions) {
            // Check if there is enough paper to print the edition.
            if (!this.hasEnoughPaper(edition)) {
                throw new Exception("Not enough paper to print edition " + edition.getName());
            }
            // Print the edition on the machines.
            for (Machine machine : this.machines) {
                machine.printEdition(edition);
            }
        }
    }
    private boolean hasEnoughPaper(Edition edition) {
        int totalPaperRequired = edition.getNumberOfPages() * edition.getPageSize();
        for (Machine machine : this.machines) {
            totalPaperRequired -= machine.getRemainingPaper();
        }
        return totalPaperRequired <= 0;
    }
    public double calculateIncome() {
        // Calculate the total cost of printing the editions.
        double totalCost = 0;
        for (Edition edition : this.editions) {
            totalCost += edition.getPricePerPage() * edition.getNumberOfPages();
        }
        // Calculate the total discount for the editions.
        double totalDiscount = 0;
        if (this.editions.size() > 100) {
            totalDiscount = this.editions.size() * 0.1;
        }

        // Calculate the total income.
        return totalCost - totalDiscount;
    }
    public void payEmployees() {
        double totalIncome = this.calculateIncome();
        for (Employee employee : this.employees) {
            employee.pay(employee.getSalary());
        }
        // Managers get a bonus if the revenue of the printing house is more than a certain value.
        if (totalIncome > 10000) {
            for (Employee employee : this.employees) {
                if (employee.getRole() == Employee.Role.MANAGER) {
                    employee.pay(employee.getSalary() * 0.1);
                }
            }
        }
    }
    public void saveData() {
        // Save the data about the printed editions, income and expenses to a file.
    }
    public void loadData() {
        // Load the data about the printed editions, income and expenses from a file.
    }
}
