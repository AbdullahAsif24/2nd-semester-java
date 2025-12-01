// list 10 java collections
// and (&&) has higher prescendence than OR(||)
// difference in abstract class and normal class
// abbreviation code
// The DataOutputStream.writeInt(4096) method will send 4 bytes representing the value

import java.util.Date;

public class oop_paper{
    public static void main(String[] args) {
        
    }
}

/* tell answers of these lines

(new b(5).print())

A bobj = new B(9);

bobj.print()

A abobj = (A) new B(10)

abobj.print ()
 */
class A {
    protected int x; // Use protected for access in B

    public A(int x) {
        this.x = x;
        System.out.println("A constructor called with x = " + this.x);
    }

    public void print() {
        System.out.println("A.print() called. Result: " + (x + 1));
    }
}

class B extends A {
    protected int y; // y is specific to B

    public B(int y) {
        // 1. Call the superclass constructor with y - 1
        super(y - 1); 
        // 2. Assign the passed value 'y' to B's 'y' field
        this.y = y; 
        System.out.println("B constructor called with y = " + this.y + 
                           ", A.x is set to: " + this.x);
    }

    // B overrides the print method from A
    @Override
    public void print() {
        System.out.println("B.print() called. Result: " + (y - 1));
    }
}

// Q --> there is a Employee class, make manager class in which add department var, and call super class toString method to make string and appennd department
class Employee{
    protected String name;
    protected Date dateOfBirth;
    protected int salary;

    public Employee(String name, Date dateOfBirth, int Salary){
        this.salary = Salary;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString(){
        return "Name:" + name + " DOB: " + dateOfBirth + " salary: " + salary;
    }
}

class Manager extends Employee {
    private String department;

    // Constructor that calls the superclass constructor
    public Manager(String name, Date dateOfBirth, int salary, String department) {
        // Call the constructor of the Employee class
        super(name, dateOfBirth, salary);
        this.department = department;
    }

    // Override the toString method to include department
    @Override
    public String toString() {
        // 1. Get the Employee's information using super.toString()
        String employeeInfo = super.toString();
        
        // 2. Append the department information
        return employeeInfo + " | Department: " + department;
    }
}