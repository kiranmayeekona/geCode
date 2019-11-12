package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ArrayQuadrantUtil<T> {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    private T[][] data;

    public ArrayQuadrantUtil(T[][] data) {
        this.data = data;
    }

    public T[] getsSpecificRow(int row,T[][] data){
        T[] resultRow= (T[]) new Object[data.length];
            for (int j = 0; j <resultRow.length ; j++) {
                resultRow[j]=data[row][j];
            }
      return resultRow;
    }

    public T[] getSpecifiedColumn(int column,T[][] data){
        T[] resultRow= (T[]) new Object[data[0].length];
        for (int i = 0; i < resultRow.length ; i++) {
            resultRow[i]=data[i][column];
        }
        return resultRow;
    }

    public T[] getQuadrant(T[][] data,int row ,int column){
        ArrayList<T> list=new ArrayList<>();
        for (int i = row; i <=row+1 ; i++) {
            for (int j = column; j <=column+1 ; j++) {
                list.add(data[i][j]);
            }
        }
        return (T[]) list.toArray();
    }

    public T[] findPartion(T[][] data) {
        ArrayList<Integer> list=new ArrayList<>();
        if(data.length==data[0].length){
            for (int i = 2; i < data.length; i++) {
                if(data.length%i==0){
                    list.add(i);
                }
            }
        }
        return (T[]) list.toArray();
    }

    public T[][] getPartitionedArray(T[][] data,int row,int column){
        T[] partionArraySize =  findPartion(data);
        int length= (int) partionArraySize[1];
        T[][] resultArray= (T[][]) new Object[length][length];
        int k=0;
        for (int i = row; i <data.length && k<length; i++) {
            int l=0;
            for (int j = column; j <data[0].length && l<length ; j++) {
                resultArray[k][l] = data[i][j];
                l++;
            }
            k++;
        }
       return resultArray;
    }
}
