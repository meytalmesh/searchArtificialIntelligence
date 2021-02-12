package SearchAlgorithms;

import Problem.IGame;
import Problem.SwitchingNumbers;

import java.util.*;

public class BFS implements ProblemSolver {
    private LinkedList<IGame> open_list;
    HashMap<IGame, Double> open_list_hash;
    HashSet<IGame> closed_list_hash;
    private int g=0;
    @Override
    public void solvePuzzle(IGame game) {
        long start = System.currentTimeMillis();
        open_list = new LinkedList<IGame> ();

        open_list_hash = new HashMap<>();
        closed_list_hash = new HashSet<>();
        open_list.add(game);
        IGame goal = null;
        long end = 0;
        while (!open_list.isEmpty()){
            IGame current = open_list.poll();
            if(current.isGoal()){
                goal = current;
                end = System.currentTimeMillis();
                System.out.println("Goal found!");
                break;
            }
            if(closed_list_hash.contains(current)){
                System.exit(-1);
            }
            for (IGame neighbor : current.getNeighbors()) {
                neighbor.setG(g);
                double neighbor_cost = neighbor.F();
                if(closed_list_hash.contains(neighbor)){
                    System.out.println(neighbor);
                    continue;
                }
                if(!open_list_hash.containsKey(neighbor)){
                    open_list_hash.put(neighbor, neighbor.F());
                    open_list.add(neighbor);
                }else{
                    double old_f = open_list_hash.get(neighbor);
                    if(old_f <= neighbor_cost){
                        continue;
                    }else{
                        open_list_hash.remove(neighbor);
                        open_list.remove(neighbor);
                        open_list.add(neighbor);
                        open_list_hash.put(neighbor, neighbor.F());

                    }
                }
            }
            closed_list_hash.add(current);
            g++;
        }
        int cost = 0;
        cost= (int) goal.F();

        float sec = (end - start) / 1000F;
        System.out.println("Time To Solve: "+sec + " seconds");
        System.out.println("Solution cost: "+cost);
        System.out.println("Open size: "+ open_list.size());
        System.out.println("Expended: "+ closed_list_hash.size());
    }


}
