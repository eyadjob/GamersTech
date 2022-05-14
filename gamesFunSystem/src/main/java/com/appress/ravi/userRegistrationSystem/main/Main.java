package com.appress.ravi.userRegistrationSystem.main;


import org.apache.tomcat.util.codec.binary.Base64;

import java.util.*;

public class Main {
    public static void main(String[] args) {
      /*  String userOPass = "user:password";
        String encPass = new String(Base64.encodeBase64(userOPass.getBytes()));
        System.out.println("Base " + encPass);

        String name = "odai";
        System.out.println(name.charAt(name.length() - 1));

        OnlineExam q1 = new OnlineExam(1);
        OnlineExam q2 = new OnlineExam(1);
        System.out.println(q1.equals(q2));

        int[] list = new int[10];
    }*/

        Product p1 = new Product(1, "java");
        Product p2 = new Product(2, "c++");
        Product p3 = new Product(1, "java");

        Set productSet = new HashSet();
        productSet.add(p1);
        productSet.add(p2);
        productSet.add(p3);

        Iterator<Product> productIterator = productSet.iterator();
        while (productIterator.hasNext()){
            System.out.println(productIterator.next());
        }


        Set myset = new LinkedHashSet();
        myset.add("odai");
        myset.add("odai");
        myset.add("ali");
        myset.add("ahmad");
        myset.add(null);
        myset.add(null);

        Iterator mySetItr = myset.iterator();
        while(mySetItr.hasNext()){
            System.out.println(mySetItr.next());
        }

        CupBoard<Integer> mycup = new CupBoard<Integer>(10);
        CupBoard<String> mycup2 = new CupBoard<String>("odai dahmos");
        CupBoard<Float> mycup3 = new CupBoard<Float>(10.0f);


        String n1 = "cat";
        String n2 = "ca".concat("t");

        System.out.println(n1.equals( n2));

        List<Integer> myInteger = new ArrayList<>();
        myInteger.add(10);
        myInteger.add(-1);
        myInteger.add(20);
        myInteger.add(30);

        Collections.sort(myInteger,new MyRevers());

         int sum = 1;

         for(int i =1;i<= 4;i++){
             sum *= i;
         }
         System.out.println("[[" + sum + "]]");

System.out.println(myInteger);

int fact = 1;

for(int i =1;i<=5;i++){
    fact = fact * i;
}

System.out.println(fact);
        System.out.println(factorial(5));


    }

    public static int factorial(int number){
        if(number == 0){
            return 1;
        }else{
            return number * factorial(number - 1);
        }
    }
}

class Test{
    Test(){
        super();
        //this();
    }
}


class Product implements Comparable<Product>{
    private int id;
    private String name;

    public Product(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Product)){
            return false;
        }
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return this.id - product.id;
    }
}


interface CreditInterface{
    public String getNumber();
    public void setNumber(double number);
}

class CreditCard implements CreditInterface{
    private String number;
    private double balance;

    public String getNumber(){
        return number;
    }
    public void setNumber(double number){

    }

    public CreditCard(String number,double balance){
        this.number = number;
        this.balance = balance;
    }


    public String toString() {
        return "CreditCard{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        CreditCard that = (CreditCard) o;
        if(that.balance == this.balance && that.number == this.number ){
            return true;
        } else{
            return false;
        }

    }


}

class Term {
    private int m;
    public Term(int m){ this.m = m;}
    public void test(){ Term a = new Term (10);  }
}


class Person {
    private int age;
    public int getAge() {
        return age;
    }

    public static double avgAge(Person[] persons){
        int sum = 0;
        for(int i=0;i<persons.length;i++){
            sum += persons[i].getAge();
        }
        return sum / persons.length;
    }
}

class OnlineExam
{   private int x;
    public OnlineExam  (int newValue)
    {    x = newValue;   }
}



class CupBoard<T>{
    private T Item;

    CupBoard(T item){
        this.Item = item;
    }


    @Override
    public String toString() {
        return "CupBoard{" +
                "Item=" + Item +
                '}';
    }
}

class MyRevers implements Comparator<Integer>{


    @Override
    public int compare(Integer obj1, Integer obj2) {
        return obj1 -obj2;
    }
}


abstract class myAbstract {

    public abstract void display();
}

class myAbstractImpl extends myAbstract {


    @Override
    public void display() {

    }
}

