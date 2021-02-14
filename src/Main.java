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
        ProblemSolver idaStar=new IDAStar();
        ProblemSolver aStar=new AStar();

        System.out.println("Board Size 9");
        SwitchingNumbers b9 = new SwitchingNumbers(9);
        System.out.println(b9);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b9);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b9);

        System.out.println("\n"+"Board Size 16");
        SwitchingNumbers b16 = new SwitchingNumbers(16);
        System.out.println(b16);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b16);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b16);

        System.out.println("\n"+"Board Size 25");
        SwitchingNumbers b25 = new SwitchingNumbers(25);
        System.out.println(b25);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b25);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b25);

        System.out.println("\n"+"Board Size 36");
        SwitchingNumbers b36 = new SwitchingNumbers(36);
        System.out.println(b36);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b36);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b36);

        System.out.println("\n"+"Board Size 64");
        SwitchingNumbers b64 = new SwitchingNumbers(64);
        System.out.println(b64);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b64);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b64);

        System.out.println("\n"+"Board Size 81");
        SwitchingNumbers b81 = new SwitchingNumbers(81);
        System.out.println(b81);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b81);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b81);

        System.out.println("\n"+"Board Size 100");
        SwitchingNumbers b100 = new SwitchingNumbers(100);
        System.out.println(b100);
        System.out.println("------A* Result------");
        aStar.solvePuzzle(b100);
        System.out.println();
        System.out.println("------IDA* Result------");
        idaStar.solvePuzzle(b100);

    }

}