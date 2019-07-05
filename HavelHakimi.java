package havelhakimi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HavelHakimi {

    public static ArrayList<Integer> Answers = new ArrayList<Integer>();
    public static int Largest;
    public static boolean truth;
    public static boolean solved = false;
    // public static short SubLen = 4;

    public static void main(String[] args) {
        populateList();
        System.out.println(Answers);

        while (solved == false) {
            elimZero(Answers);
            System.out.println(Answers);
            if (Answers.isEmpty()) {
                truth = true;
                solved = true;
                break;
            }

            Largest = descSort(Answers);
            Answers.remove(0);
            System.out.println(Answers);
            System.out.println(Largest);

            if (lenCheck(Answers, Largest)) {
                truth = false;
                solved = true;
                break;
            }

            frontElim(Answers, Largest);
            System.out.println(Answers);
        }
        System.out.println(truth);

    }

    // Step 1: remove zeros
    private static void elimZero(ArrayList Answers) {
        for (int i = 0; i < Answers.size(); i++) {
            if (Answers.get(i).equals(0)) {
                Answers.remove(i);
            }
        }
    }

    //Step 2: Descending Sort
    private static int descSort(ArrayList Answers) {
        Collections.sort(Answers, Collections.reverseOrder());
        return (int) Answers.get(0);
    }

    //Step 3: Length Check
    private static boolean lenCheck(ArrayList Answers, int Largest) {
        return Largest > Answers.size();
    }

    //Step 4: Front Elimination
    private static void frontElim(ArrayList Answers, int SubLen) {
        for (int i = 0; i < SubLen; i++) {
            int ele = (int) Answers.get(i) - 1;
            Answers.set(i, ele);
        }
    }

    private static void populateList() {
        Answers.add(5);
        Answers.add(3);
        Answers.add(0);
        Answers.add(2);
        Answers.add(6);
        Answers.add(2);
        Answers.add(0);
        Answers.add(7);
        Answers.add(2);
        Answers.add(5);
    }

}
