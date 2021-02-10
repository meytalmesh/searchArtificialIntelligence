package SearchAlgorithms;

import Problem.IGame;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStar implements ProblemSolver{

    private PriorityQueue<IGame> open_list;
    HashMap<IGame, Double> open_list_hash;
    HashSet<IGame> closed_list_hash;

    @Override
    public void solvePuzzle(IGame game) {

        long start = System.currentTimeMillis();
        open_list = new PriorityQueue<>(new Comparator<IGame>() {
            @Override
            public int compare(IGame o1, IGame o2) {
                double o1_cost = o1.F();
                double o2_cost = o2.F();
                return (int) (o1_cost - o2_cost);
            }
        });

        open_list_hash = new HashMap<>();
        closed_list_hash = new HashSet<>();
        open_list.add(game);
        IGame goal = null;
        long end = 0;



    }
}