package Problem;

import java.util.Collection;

public interface IGame {

    Collection<IGame> getNeighbors();
    double H();
    boolean isGoal();
    int G();
    double F();  //G+H
    void setG(int g);

}