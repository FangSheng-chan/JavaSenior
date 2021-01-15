package t6;

public class test04 {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.managerEmp();


    }
}

class Manager {
    Employees[] employees;

    void managerEmp() {
        int length = this.employees.length;
        this.report();
    }

    void report() {

    }
}
