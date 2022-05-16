package com.appress.ravi.userRegistrationSystem.main;

public class ShelfCheck{
    public static void main(String[] args) {
        Shelf shelf1 = new Shelf(20,20,20);
        shelf1.setOccupied(true);
        System.out.println("Shelf length : " + shelf1.getLength() + " width: " + shelf1.getWidth() + " capacity : " + shelf1.getCapacity() + " occupied : " + shelf1.isOccupied());

        System.out.println("Empty shelf 1 ");
        shelf1.emptyShelf();
        System.out.println("Shelf length : " + shelf1.getLength() + " width: " + shelf1.getWidth() + " capacity : " + shelf1.getCapacity() + " occupied : " + shelf1.isOccupied());
    }
}

class Shelf {
    private int length;
    private int width;
    private int capacity;
    private boolean occupied;


    public Shelf(int length, int width, int capacity) {
        this.length = length;
        this.width = width;
        this.capacity = capacity;
        this.occupied = false;

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void emptyShelf(){
        this.length = 0;
        this.width = 0;
        this.capacity = 0;
        this.occupied = false;
    }



}
