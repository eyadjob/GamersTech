package com.appress.ravi.userRegistrationSystem.datastructure;

public class MyArrayList {
    private  int[] myarray;
    private int nElem;

    public MyArrayList(int size){
        myarray = new int[size];
        nElem = 0;
    }

    public void add(int element){
       myarray[nElem] = element;
       nElem++;
    }

    public boolean find(int element){
      for(int i =0;i<nElem;i++){
          if(myarray[i] == element){
              return true;
          }

      }
      return  false;
    }


}
