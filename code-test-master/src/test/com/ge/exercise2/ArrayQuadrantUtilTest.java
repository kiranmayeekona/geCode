package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ArrayQuadrantUtilTest {

    @Before
    public void setUp(){
    }
    //for character values
    // gets the specific row in the array
    @Test
    public void getsSpecificRowTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
        assertArrayEquals(new Character[]{'a', 'b', 'c', 'd'}, util.getsSpecificRow(0, data));
        assertArrayEquals(new Character[]{'e', 'f', 'g', 'h'}, util.getsSpecificRow(1, data));
        assertArrayEquals(new Character[]{'i', 'j', 'k', 'l'}, util.getsSpecificRow(2, data));
        assertArrayEquals(new Character[]{'m', 'n', 'o', 'p'}, util.getsSpecificRow(3, data));
    }

    //for Integer values and array out of bound exception added
    // gets the specific row in the array
    @Test
    public void getsSpecificRowTest1() {
        Integer[][] intData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(intData);
        try {
            assertArrayEquals(new Integer[]{1, 2, 3, 4}, util.getsSpecificRow(0, intData));
            assertArrayEquals(new Integer[]{5, 6, 7, 8}, util.getsSpecificRow(1, intData));
            assertArrayEquals(new Integer[]{9, 10, 11, 12}, util.getsSpecificRow(2, intData));
            assertArrayEquals(new Integer[]{13, 14, 15, 16}, util.getsSpecificRow(3, intData));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    //for Character values and array out of bound exception added
    // gets the specific column in the array
    @Test
    public void getSpecifiedColumnTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };
        try {
            ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
            assertArrayEquals(new Character[]{'a', 'e', 'i', 'm'}, util.getSpecifiedColumn(0, data));
            assertArrayEquals(new Character[]{'b', 'f', 'j', 'n'}, util.getSpecifiedColumn(1, data));
            assertArrayEquals(new Character[]{'c', 'g', 'k', 'o'}, util.getSpecifiedColumn(2, data));
            assertArrayEquals(new Character[]{'d', 'h', 'l', 'p'}, util.getSpecifiedColumn(3, data));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    //for Integer values and array out of bound exception added
    // gets the specific column in the array
    @Test
    public void getSpecifiedColumnTest1() {
        Integer[][] intData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(intData);
        try {
            assertArrayEquals(new Integer[]{1, 5, 9, 13}, util.getSpecifiedColumn(0, intData));
            assertArrayEquals(new Integer[]{2, 6, 10, 14}, util.getSpecifiedColumn(1, intData));
            assertArrayEquals(new Integer[]{3, 7, 11, 15}, util.getSpecifiedColumn(2, intData));
            //throws an exception
            //assertArrayEquals(new Integer[]{4, 8, 12, 16}, util.getSpecifiedColumn(4, intData));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getQuadrantTest(){
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };
        try {
            ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
            assertArrayEquals(new Character[]{'a', 'b','e', 'f'}, util.getQuadrant(data,0,0));
            assertArrayEquals(new Character[]{'e', 'f','i','j'},util.getQuadrant(data,1,0));
            assertArrayEquals(new Character[]{'g','h','k','l'},util.getQuadrant(data,1,2));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getQuadrantTest1(){
        Integer[][] intData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(intData);
        try {
            assertArrayEquals(new Integer[]{1, 2,5, 6}, util.getQuadrant(intData,0,0));
            assertArrayEquals(new Integer[]{7, 8,11, 12}, util.getQuadrant(intData,1,2));
            //throws exception
            //assertArrayEquals(new Integer[]{1, 2, 5, 6}, util.getQuadrant(intData,2,1));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findPartionTest(){
        Integer[][] intData = {
                {1, 2, 3, 4,5, 6, 7, 8},
                {5, 6, 7, 8,5, 6, 7, 8},
                {9, 10, 11, 12,5, 6, 7, 8},
                {13, 14, 15, 16,5, 6, 7, 8},
                {1, 2, 3, 4,5, 6, 7, 8},
                {5, 6, 7, 8,5, 6, 7, 8},
                {9, 10, 11, 12,5, 6, 7, 8},
                {13, 14, 15, 16,5, 6, 7, 8}
        };
        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(intData);
        assertArrayEquals(new Integer[]{2,4},util.findPartion(intData));
    }

    @Test
    public void getPartitionedArray(){
        Integer[][] intData = {
                {1, 2, 3, 4,5, 6, 7, 8},
                {5, 6, 7, 8,5, 6, 7, 8},
                {9, 10, 11, 12,5, 6, 7, 8},
                {13, 14, 15, 16,5, 6, 7, 8},
                {1, 2, 3, 4,5, 6, 7, 8},
                {5, 6, 7, 8,5, 6, 7, 8},
                {9, 10, 11, 12,5, 6, 7, 8},
                {13, 14, 15, 16,5, 6, 7, 8}
        };
        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(intData);
        assertArrayEquals(new Integer[][]{{6,7,8,5},
                {10,11,12,5},{14,15,16,5},{2,3,4,5}},util.getPartitionedArray(intData,1,1));

        Integer[][] partitionedArray = {{6,7,8,5},
                {10,11,12,5},{14,15,16,5},{2,3,4,5}};

        assertArrayEquals(new Integer[]{6,7,8,5},util.getsSpecificRow(0,partitionedArray));
        assertArrayEquals(new Integer[]{6,10,14,2},util.getSpecifiedColumn(0,  partitionedArray));
        assertArrayEquals(new Integer[]{6,7,10,11},util.getQuadrant( partitionedArray,0,0));

    }

}