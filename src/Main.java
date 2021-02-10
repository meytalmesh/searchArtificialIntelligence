import Problem.IGame;
import Problem.SwitchingNumbers;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        SwitchingNumbers b = new SwitchingNumbers(9);
        int[][] small = {{3, 1, 2}, {4, 5, 6}, {7,8, 9}};
        b.setPuzzle(small);
        System.out.println(b);
        System.out.println(b.H());

//        SwitchingNumbers b = new SwitchingNumbers(9);
//        int[][] small = {{3, 1, 2}, {4, 5, 6}, {7,8, 9}};
//        b.setPuzzle(small);
//
//        Collection<IGame> temp=b.getNeighbors();
//        for (IGame bourd : temp) {
//            System.out.println(bourd);
//        }


    }

}