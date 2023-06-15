package project.classes;
public class Employee {
    public enum Role {
        OPERATOR,
        MANAGER
    }
    private String name;
    private Role role;
    private double salary;
    public Employee(String name, Role role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public Role getRole() {
        return role;
    }
    public double getSalary() {
        return salary;
    }
    public void pay(double amount) {
        this.salary += amount;
    }
}