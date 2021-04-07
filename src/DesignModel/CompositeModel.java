package DesignModel;


// 组合模式, 又叫部分整体模式, 组合模式一句树形结构来组合对象,用来表示部分及整体层次

// 例子:CompositeModel 使用组合模型类Employee 来添加部门层次结构

import java.util.ArrayList;
import java.util.List;

class Employee{
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<Employee>();
    }

    public void add(Employee employee){
        this.subordinates.add(employee);
    }

    public void remove(Employee employee){
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates(){
        return this.subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
//                ", subordinates=" + subordinates +
                '}';
    }
}


public class CompositeModel {

    public static void main(String[] args) {
        Employee CEO = new Employee("Python", "CEO", 9);

        Employee headSales = new Employee("C#", "Head Sales", 20);

        Employee headMarketing = new Employee("C++", "Head Marketing", 66);

        Employee clerk1 = new Employee("Clerk1", "Marketing", 1);
        Employee clerk2 = new Employee("Clerk2", "Marketing", 1);

        Employee salesExecutive1 = new Employee("sales1", "Sales", 2);
        Employee salesExecutive2 = new Employee("sales2", "Sales", 2);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(CEO);
        for (Employee employee: CEO.getSubordinates()){
            System.out.println(employee);
            for (Employee temp: employee.getSubordinates()){
                System.out.println(temp);
            }
        }
    }

}
