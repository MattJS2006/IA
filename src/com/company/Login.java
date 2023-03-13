package com.company;

public class Login {

    public boolean binarySearchRecursion(String[] data, String n, int startPos, int endPos){
        int mid = (startPos+endPos)/2;
        if (data[mid].equals(n)){
            return true;
        } else if(data[mid].compareTo(n) > 0){
            return binarySearchRecursion(data,n,startPos,mid);
        } else if(data[mid].compareTo(n) < 0){
            return binarySearchRecursion(data,n,mid,endPos);
        }
        return false;
    }
    /*
    public void mergeSort(String[] data){
        String[] array =
    }
    */
}

