package SearchAlgorithms;

import Problem.IGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class IDAStar implements ProblemSolver{

    private Stack<IGame> open_list;
    private int minF=0;

    HashMap<IGame, Double> open_list_hash;
    HashSet<IGame> closed_list_hash;

    @Override
    public void solvePuzzle(IGame game) {
        long start = System.currentTimeMillis();

    }
}
