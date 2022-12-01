package main.java.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    private File input;

    public Day1() {
        try {
            this.input = new File("src/main/resources/day1/day1.txt");
        } catch (Exception e) {
            System.out.println("An error has occurred, no file found," + e.getLocalizedMessage());
        }
    }


    public Integer doWork() {
        ArrayList<Integer> list = new ArrayList<>();
        Integer elfPostion = 1;
        Integer calorieCount = 0;
        Integer maxCalorieCount = 0;
        Integer maxElfCount = 1;
        try {
            Scanner myReader = new Scanner(this.input);
            while(myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(!line.isEmpty()) {
                    calorieCount += Integer.parseInt(line);
                } else {
                    if(calorieCount > maxCalorieCount) {
                        maxElfCount = elfPostion;
                        maxCalorieCount = calorieCount;
                    }
                    list.add(calorieCount);
                    elfPostion++;
                    calorieCount = 0;
                }
            }
            Collections.sort(list, Collections.reverseOrder());
        } catch (Exception e) {
            System.out.println("An error has occurred in do work," + e.getLocalizedMessage());
        }
        return (list.get(0) + list.get(1) + list.get(2));
    }





}
