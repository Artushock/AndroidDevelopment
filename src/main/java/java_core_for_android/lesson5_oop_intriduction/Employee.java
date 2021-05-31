package java_core_for_android.lesson5_oop_intriduction;
/*
    @author Artiom Ponomariov
*/

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + position);
        System.out.println("email: " + email);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    public int getAge() {
        return age;
    }
}
