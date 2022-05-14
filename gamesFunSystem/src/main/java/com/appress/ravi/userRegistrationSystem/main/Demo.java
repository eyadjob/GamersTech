package com.appress.ravi.userRegistrationSystem.main;

import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
    /*    Address address1 = new Address("King abdulla street","Zarqa","Jordan");
        Patient patient1 = new Patient("Mahmoud",address1,"123","0796914374");

        Address address2 = new Address("abdulla ghosheh ","Amman","Jordan");
        Patient patient2 = new Patient("Odai ",address2,"111","0785228955");


        Patient patient3 = new Patient("Eyad ",address2,"222","0785228966");

        System.out.println("Patient 1 Info \n" );
        System.out.println(patient1 + "\n");

        System.out.println("Patient 2 Info \n" );
        System.out.println(patient2 );

        System.out.println("Patient 3 Info \n" );
        System.out.println(patient3 );*/
        Base b = new Derived();
        b.show();

        int [] a = {1,2,3};
        "aaaa".trim();

        TipWorker tipWorker = new TipWorker("","",2.0,20.0,2.0);
       // tipWorker.setHours(10.2);

    }
}

interface  aaa{}

class bb implements aaa{

}


 class Base {
    public void show() {
        System.out.println("Base::show() called");
    }
}
 class Derived extends Base {
    public void show() {
        System.out.println("Derived::show() called");
    }
}


class Employee{

    private String lastName;
    private String firstName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String toString() {
        return "Employee{" +
                "lastName=" + lastName  +
                ", firstName=" + firstName  +
                '}';
    }

    public double earning(){
        return 0.0;
    }
}



class TipWorker extends Employee{

    private double wage;
    private double hours;
    private  double tips;

    public void setWage(double wage) throws Exception {
        if(wage < 0){
            throw new Exception("Invalid wage value.");
        }
        this.wage = wage;
    }

    public void setHours(double hours) throws Exception {
        if(!(hours > 0 && hours < 168)){
            throw new Exception("Invalid hours value. ");
        }
        this.hours = hours;
    }

    public void setTips(double tips) throws Exception {
        if(tips < 0){
            throw new Exception("Invalid wage value.");
        }
        this.tips = tips;
    }



    public TipWorker(String firstName, String lastName, double wage, double hours, double tips) {
        super(firstName, lastName);
        this.wage = wage;
        this.hours = hours;
        this.tips = tips;
    }


    public double earning(){
        double pay = this.wage*this.hours + this.tips;
        return pay;
    }


    public String toString() {

        return "TipWorker{" +
                ", firstName =" + this.getFirstName() +
                ", lastName=" + this.getLastName() +
                "wage=" + this.wage +
                ", hours=" + this.hours +
                ", tips=" + this.tips +
                '}';
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        TipWorker tipWorker = (TipWorker) o;
        if(tipWorker.earning() == this.earning()){
            return true;
        }else {
            return false;
        }

    }


}


abstract class Member{
    private String name;
    private String address;
    public abstract int getFee();

}