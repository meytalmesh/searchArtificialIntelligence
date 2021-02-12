import Problem.IGame;
import Problem.SwitchingNumbers;
import SearchAlgorithms.AStar;
import SearchAlgorithms.BFS;
import SearchAlgorithms.IDAStar;
import SearchAlgorithms.ProblemSolver;
import com.sun.xml.internal.bind.v2.model.core.ID;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        SwitchingNumbers b = new SwitchingNumbers(9);
//        int[][] small = {{3, 1, 2}, {4, 5, 6}, {7,8, 9}};
//        b.setPuzzle(small);
//        System.out.println(b);
//        System.out.println(b.H());

//        //check getNeighbors function
//        SwitchingNumbers b = new SwitchingNumbers(9);
//        int[][] small = {{3, 1, 2}, {4, 5, 6}, {7,8, 9}};
//        b.setPuzzle(small);
//
//        Collection<IGame> temp=b.getNeighbors();
//        for (IGame bourd : temp) {
//            System.out.println(bourd);
//        }

//        //check is gaol function
//        SwitchingNumbers b = new SwitchingNumbers(9);
//        int[][] small1 = {{3, 1, 2}, {4, 5, 6}, {7,8, 9}};
//        b.setPuzzle(small1);
//        System.out.println(b.isGoal());
//
//        int[][] small2 = {{1, 2,3}, {4, 5, 6}, {7,8, 9}};
//        b.setPuzzle(small2);
//        System.out.println(b.isGoal());


//           //check a star function
//        SwitchingNumbers b = new SwitchingNumbers(9);
//        int[][] small = {{3, 1, 2},{ 5, 6,4}, {7,8, 9}};
//        b.setPuzzle(small);
//        ProblemSolver aStar=new AStar();
//        aStar.solvePuzzle(b);


////         check ida star function
        SwitchingNumbers b = new SwitchingNumbers(100);
        // int[][] small = {{ 5, 6,4},{3, 1, 2}, {7,8, 9}};
        // b.setPuzzle();
        System.out.println(b);

        ProblemSolver aStar=new IDAStar();
        aStar.solvePuzzle(b);
        //test
    }

}