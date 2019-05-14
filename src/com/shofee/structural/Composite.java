package com.shofee.structural;

import java.util.ArrayList;
import java.util.List;

//Interface component
interface Employee {
    void showEmployeeDetails();
}

//Leaf
class Developer implements Employee {
    int id;
    String name;
    String position;

    Developer(int _id, String _name, String _position) {
        this.id = _id;
        this.name = _name;
        this.position = _position;
    }

    public void showEmployeeDetails() {
        System.out.println(this.id + " " + this.name + " " + this.position);
    }
}

//Leaf
class Manager implements Employee {
    int id;
    String name;
    String position;

    Manager(int _id, String _name, String _position) {
        this.id = _id;
        this.name = _name;
        this.position = _position;
    }

    public void showEmployeeDetails() {
        System.out.println(this.id + " " + this.name + " " + this.position);
    }
}

//Composite
class OrgDirectory implements Employee {
    List<Employee> employees = new ArrayList<Employee>();

    public void showEmployeeDetails() {
        for(Employee emp : employees) {
            emp.showEmployeeDetails();
        }
    }

    public void add(Employee emp) {
        employees.add(emp);
    }

    public void remove(Employee emp) {
        employees.remove(emp);
    }
}

//Client
public class Composite {
    public static void main(String args[]) {
        Employee dev1 = new Developer(5656, "Shoyeb", "Developer");
        Employee dev2 = new Developer(6776, "Guru", "UX");
        OrgDirectory devDirectory = new OrgDirectory();
        devDirectory.add(dev1);
        devDirectory.add(dev2);

        Employee mgr1 = new Manager(9454, "Mohit", "Team Lead");
        Employee mgr2 = new Manager(8997, "Sumit", "Operational manager");
        OrgDirectory mgrDirectory = new OrgDirectory();
        mgrDirectory.add(mgr1);
        mgrDirectory.add(mgr2);

        OrgDirectory orgDirectory = new OrgDirectory();
        orgDirectory.add(devDirectory);
        orgDirectory.add(mgrDirectory);
        orgDirectory.showEmployeeDetails();
    }
}
