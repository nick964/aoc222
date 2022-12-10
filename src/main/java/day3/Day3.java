package main.java.day3;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {

    private File input;
    private HashMap<Character, Integer> charMap;

    public Day3() {
        charMap = new HashMap<>();
        loadMap();
        try {
            this.input = new File("src/main/resources/day3/input.txt");


        } catch (Exception e) {
            System.out.println("An error has occurred, no file found," + e.getLocalizedMessage());
        }
    }

    public String calljk() {
        int sum = 0;
        try {
            Scanner myReader = new Scanner(this.input);
            int flip = 0;

            String[] stringHolder = new String[10];
            while(myReader.hasNextLine()) {
                String guide = myReader.nextLine();


                stringHolder[flip] = guide;

                if(flip == 2) {
                    char result = findCommanality(stringHolder[0], stringHolder[1], stringHolder[2]);
                    sum += charMap.get(result);

                    Arrays.fill(stringHolder, null);
                    flip = 0;
                } else {
                    flip++;
                }
            }
        } catch (Exception e) {
            System.out.println("An error has occurred in calculate," + e.getLocalizedMessage());
        }
        System.out.println("Printing sum");
        System.out.println(sum);
        return "";
    }

    private int convertFromCharcter(char j) {
        return (j- 'a' + 1);
    }


    private char findCommanality(String compart1, String compart2) {
        for(char j : compart1.toCharArray()) {
            for (char k : compart2.toCharArray()) {
                if(j == k) {
                    if(convertFromCharcter(j) <= 0 || convertFromCharcter(k) <= 0) {
                        System.out.println(j);
                    }
                    return j;
                }
            }
        }
        return 'a';
    }

    private char findCommanality(String compart1, String compart2, String compart3) {
        for(char j : compart1.toCharArray()) {
            for (char k : compart2.toCharArray()) {
                if(j == k) {
                    for(char l : compart3.toCharArray()) {
                        if(k == l) {
                            return l;
                        }
                    }
                }
            }
        }
        return 'a';
    }


    private void loadMap() {
        charMap.put('a',1);
        charMap.put('b',2);
        charMap.put('c',3);
        charMap.put('d',4);
        charMap.put('e',5);
        charMap.put('f',6);
        charMap.put('g',7);
        charMap.put('h',8);
        charMap.put('i',9);
        charMap.put('j',10);
        charMap.put('k',11);
        charMap.put('l',12);
        charMap.put('m',13);
        charMap.put('n',14);
        charMap.put('o',15);
        charMap.put('p',16);
        charMap.put('q',17);
        charMap.put('r',18);
        charMap.put('s',19);
        charMap.put('t',20);
        charMap.put('u',21);
        charMap.put('v',22);
        charMap.put('w',23);
        charMap.put('x',24);
        charMap.put('y',25);
        charMap.put('z',26);
        charMap.put('A',27);
        charMap.put('B',28);
        charMap.put('C',29);
        charMap.put('D',30);
        charMap.put('E',31);
        charMap.put('F',32);
        charMap.put('G',33);
        charMap.put('H',34);
        charMap.put('I',35);
        charMap.put('J',36);
        charMap.put('K',37);
        charMap.put('L',38);
        charMap.put('M',39);
        charMap.put('N',40);
        charMap.put('O',41);
        charMap.put('P',42);
        charMap.put('Q',43);
        charMap.put('R',44);
        charMap.put('S',45);
        charMap.put('T',46);
        charMap.put('U',47);
        charMap.put('V',48);
        charMap.put('W',49);
        charMap.put('X',50);
        charMap.put('Y',51);
        charMap.put('Z',52);
    }

}
