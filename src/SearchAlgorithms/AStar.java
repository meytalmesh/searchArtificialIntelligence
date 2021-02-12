package SearchAlgorithms;

import Problem.IGame;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStar implements ProblemSolver{

    private PriorityQueue<IGame> open_size;
    HashMap<IGame, Double> open_list;
    HashSet<IGame> closed_list_hash;
    private int g=0;
    @Override
    public void solvePuzzle(IGame game) {
        long start = System.currentTimeMillis();
        open_size = new PriorityQueue<>(new Comparator<IGame>() {
            @Override
            public int compare(IGame o1, IGame o2) {
                double o1_cost = o1.F();
                double o2_cost = o2.F();
                return (int) (o1_cost - o2_cost);
            }
        });

        open_list = new HashMap<>();
        closed_list_hash = new HashSet<>();
        open_size.add(game);
        IGame goal = null;
        long end = 0;
        while (!open_size.isEmpty()){
            IGame current = open_size.poll();
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
                    continue;
                }
                if(!open_list.containsKey(neighbor)){
                    open_list.put(neighbor, neighbor.F());
                    open_size.add(neighbor);
                }else{
                    double old_f = open_list.get(neighbor);
                    if(old_f <= neighbor_cost){
                        continue;
                    }else{
                        open_list.remove(neighbor);
                        open_size.remove(neighbor);
                        open_size.add(neighbor);
                        open_list.put(neighbor, neighbor.F());

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
        System.out.println("Open size: "+ open_size.size());
        System.out.println("Expended: "+ closed_list_hash.size());



    }
}