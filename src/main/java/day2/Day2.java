package main.java.day2;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day2 {

    private File input;
    private HashMap<String, String> rps;

    public Day2() {
        loadMap();
        try {
            this.input = new File("src/main/resources/day2/input.txt");
        } catch (Exception e) {
            System.out.println("An error has occurred, no file found," + e.getLocalizedMessage());
        }
    }

    private void loadMap() {
        rps = new HashMap<>();
        rps.put("A", "rock");
        rps.put("B", "paper");
        rps.put("C", "siz");
        rps.put("X", "rock");
        rps.put("Y", "paper");
        rps.put("Z", "siz");
    }

    public int calculateScore() {
        int score = 0;
        try {
            Scanner myReader = new Scanner(this.input);

            while(myReader.hasNextLine()) {
                String[] guide = myReader.nextLine().split(" ");
                score += calculateOutcomeForPart2(guide[1]);
                String mychoice = calculateMyChoiceForPart2(rps.get(guide[0]),guide[1]);
                score += getChoiceScore(mychoice);
            }
        } catch (Exception e) {
            System.out.println("An error has occurred in calculate," + e.getLocalizedMessage());
        }
        return score;
    }

    private int calculateOutcome(String input, String selection) {
        String oppChoice = rps.get(input);
        String myChoice = rps.get(selection);

        if(oppChoice.equals(myChoice)) {
            return 3;
        } else if (didFirstArgWin(myChoice, oppChoice)) {
            return 6;
        } else if (didFirstArgWin(oppChoice, myChoice)) {
            return 0;
        }
        return 0;
    }

    private int calculateOutcomeForPart2(String outcome) {
        switch (outcome) {
            case "Y":
                return 3;
            case "Z":
                return 6;
            default:
                return 0;
        }
    }

    private String calculateMyChoiceForPart2(String input, String outcome) {
        switch (outcome) {
            case "Y":
                return input;
            case "X":
                if(input.equals("siz")) {
                    return "paper";
                }
                if(input.equals("paper")) {
                    return "rock";
                }
                if(input.equals("rock")) {
                    return "siz";
                }
                return "";
            case "Z":
                if(input.equals("paper")) {
                    return "siz";
                }
                if(input.equals("rock")) {
                    return "paper";
                }
                if(input.equals("siz")) {
                    return "rock";
                }
                return "";
            default:
                return "";
        }
    }

    private boolean didFirstArgWin(String first, String second) {
        return ((first.equals("siz") && second.equals("paper"))
                || (first.equals("paper") && second.equals("rock"))
                || (first.equals("rock") && second.equals("siz"))
                );
    }

    private int getChoiceScore(String selection) {
        switch (selection) {
            case "Y":
                return 2;
            case "X":
                return 1;
            case "Z":
                return 3;
            case "paper":
                return 2;
            case "rock":
                return 1;
            case "siz":
                return 3;
            default:
                return 0;
        }
    }


}
