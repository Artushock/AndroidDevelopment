package java_core_for_android.lesson5_oop_intriduction;/*
    @author Artiom Ponomariov
*/

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван Иванович",
                "Руководитель отдела",
                "ivanov_ivan@company.com",
                "+38(093)123-0000",
                5000,
                45);

        employees[1] = new Employee("Петров Петр Петрович",
                "зам. руководителя отдела",
                "petrov_petr@company.com",
                "+38(093)123-0001",
                3500,
                39);

        employees[2] = new Employee("Курочкин Игнат Арнольдович",
                "Ведущий менеджер пректа",
                "chiken_ignat@company.com",
                "+38(093)123-0010",
                2500,
                35);

        employees[2] = new Employee("Курочкин Игнат Арнольдович",
                "Ведущий менеджер пректа",
                "hen's_ignat@company.com",
                "+38(093)123-0010",
                2500,
                35);

        employees[3] = new Employee("Белова Белла Алексеевна",
                "Уборщица",
                "bella@company.com",
                "+38(093)113-1111",
                1000,
                57);

        employees[4] = new Employee("Воронин Анатолий Дмитриевич",
                "Электрик",
                "electric_ot_boga@company.com",
                "+38(093)123-4567",
                1500,
                48);

        for (Employee employee: employees) {
            if (employee.getAge() > 40){
                employee.printInfo();
            }
        }
    }
}
