package SearchAlgorithms;

import Problem.IGame;
import Problem.SwitchingNumbers;

import java.util.*;

public class IDAStar implements ProblemSolver{

    private PriorityQueue<IGame> open_size;
    private int minF=0;
    private int g=0;

    HashMap<IGame, Double> open_list;
    HashSet<IGame> closed_list_hash;

    @Override
    public void solvePuzzle(IGame game) {
        minF=50;

        closed_list_hash = new HashSet<>();
        int numIteration=0;
        IGame goal= null;
        long start = System.currentTimeMillis();
        IGame foundSolution=null;
        while(foundSolution == null){
            foundSolution=iteration(game);
            minF++;
            numIteration++;
        }
        goal=foundSolution;

        long end = System.currentTimeMillis();
        int cost = 0;
        cost= (int) goal.F();

        float sec = (end - start) / 1000F;
        System.out.println("Time To Solve: "+sec + " seconds");
        System.out.println("Iteration Number: "+numIteration);
        System.out.println("Solution cost: "+cost);
        System.out.println("Open size: "+ open_size.size());
        System.out.println("Expended: "+ closed_list_hash.size());

    }
    private IGame iteration (IGame game){
        g=0;
        open_size = new PriorityQueue<>(new Comparator<IGame>() {
            @Override
            public int compare(IGame o1, IGame o2) {
                double o1_cost = o1.F();
                double o2_cost = o2.F();
                return (int) (o1_cost - o2_cost);
            }
        });

        open_list = new HashMap<>();

        open_size.add(game);
        IGame goal = null;
        long end = 0;
        while (!open_size.isEmpty()){
            IGame current = open_size.poll();
            if(current.isGoal()){
                goal = current;
                System.out.println("Goal found!");
                return goal;
//                break;
            }
/*            if(closed_list_hash.contains(current)){
                System.exit(-1);
            }*/
            for (IGame neighbor : current.getNeighbors()) {
                neighbor.setG(g);
                double neighbor_cost = neighbor.F();

                if(closed_list_hash.contains(neighbor) || neighbor_cost>=minF){
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
        return goal;
    }
}