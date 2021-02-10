package Problem;

import java.util.Collection;

public interface IGame {

    Collection<IGame> getNeighbors();
    double H();  //Estimation of the distance
    boolean isGoal();
    int G();     //The distance between the start vertex and the vertex 𝑥
    double F();  //G+H
    IGame getPrev();
    void setG(int g);

}