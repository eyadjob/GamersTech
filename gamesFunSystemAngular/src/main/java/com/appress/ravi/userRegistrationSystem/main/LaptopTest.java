package com.appress.ravi.userRegistrationSystem.main;

public class LaptopTest {
    public static void main(String[] args) {
        Laptop myLaptop1 = new Laptop("HP","lIT20",2010);
        myLaptop1.setMake("Lit200");
        myLaptop1.setYear(2011);
        myLaptop1.setModel("HP Model");

        Laptop myLaptop2 = new Laptop("Lenovo","lIT2222",2010);
        myLaptop2.setMake("lIT2222");
        myLaptop2.setYear(2010);
        myLaptop2.setModel("Lenovo 2");

        System.out.println("My Laptop 1 " + myLaptop1.getModel() + " " + myLaptop1.getMake() + " " +myLaptop1.getYear() );
        System.out.println("My Laptop 2 " + myLaptop2.getModel() + " " + myLaptop2.getMake() + " " +myLaptop2.getYear() );
    }
}

class Laptop{

    private String model;
    private String make;
    private int year;

    public Laptop(String model, String make, int year) {
        this.model = model;
        this.make = make;
        this.year = year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
