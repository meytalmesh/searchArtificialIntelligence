package Problem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class SwitchingNumbers implements IGame{

    private final int[][] copyArr;
    private int N;
    private int g = 0;

    public void setG(int g) {
        this.g = g;
    }

    // cache
    private int hashCode = -1;

    private Collection<IGame> neighbors;

    @Override
    public Collection<IGame> getNeighbors() {
        return null;
    }

    @Override
    public double H() {
        return this.calculateManhattanDistance();

    }

    @Override
    public boolean isGoal() {

        if (tileAt(N-1, N-1) != 0) return false;        // prune
        for (int i = 0; i < (N * N) - 1; i++) {
            int row = (int) Math.floor((i) / N);
            int col = i % N;
            if(tileAt(row, col) != i + 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public int G() {
        return this.g;
    }

    @Override
    public double F() {
        return G() + H();
    }

    public IGame getPrev() {
        return prev;
    }

    private IGame prev = null;

    public SwitchingNumbers(int n) {
        //this.N = tiles.length;
        this.N = (int) Math.sqrt(n + 1);
        this.copyArr = new int[N][N];
        // defensive copy
        for (int i = 0; i < n; i++) {
            int row = (int) Math.floor((i) / N);
            int col = i % N;
            this.copyArr[row][col] = i + 1;
        }
        this.shuffle();
        while(!isSolvable()){
            this.shuffle();
        }
    }

    private void shuffle(){
        Random random = new Random();

        for (int i = this.copyArr.length - 1; i > 0; i--) {
            for (int j = this.copyArr[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);
                int temp = this.copyArr[i][j];
                this.copyArr[i][j] = this.copyArr[m][n];
                this.copyArr[m][n] = temp;
            }
        }
    }


    public boolean isSolvable() {
        int inversions = 0;

        for (int i = 0; i < this.size() * this.size(); i++) {
            int currentRow = i / this.size();
            int currentCol = i % this.size();

            for (int j = i; j < this.size() * this.size(); j++) {
                int row = j / this.size();
                int col = j % this.size();

                if (tileAt(row, col) != 0 && tileAt(row, col) < tileAt(currentRow, currentCol)) {
                    inversions++;
                }
            }
        }

        if (copyArr.length % 2 != 0 && inversions % 2 != 0) return false;
        if (copyArr.length % 2 == 0 && (inversions) % 2 == 0) return false;

        return true;
    }

    public int tileAt(int row, int col) {
        if (row < 0 || row > N - 1) throw new IndexOutOfBoundsException
                ("row should be between 0 and N - 1");
        if (col < 0 || col > N - 1) throw new IndexOutOfBoundsException
                ("col should be between 0 and N - 1");

        return copyArr[row][col];
    }


    public int size() {
        return N;
    }


    public String toString() {
        StringBuilder s = new StringBuilder(4 * N * N);     // optimization?
//      s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        return s.toString();
    }

    private int calculateManhattanDistance() {
        int sum=0;
        int manhattanDistanceSum = 0;
        for (int x = 0; x < N; x++) { // x-dimension, traversing rows (i)
            for (int y = 0; y < N; y++) { // y-dimension, traversing cols (j)
                int value = this.copyArr[x][y]; // tiles array contains board elements
                int targetX = (value - 1) / N; // expected x-coordinate (row)
                int targetY = (value - 1) % N; // expected y-coordinate (col)
                int dx = x - targetX; // x-distance to expected coordinate
                int dy = y - targetY; // y-distance to expected coordinate
                manhattanDistanceSum = Math.abs(dx) + Math.abs(dy);
                sum += manhattanDistanceSum * value;

            }
        }
        double res = (double)sum/2;
        return (int)Math.ceil(res);
    }

    public void setPuzzle(int[][] tiles){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] >= 1 && tiles[i][j] <= N*N) copyArr[i][j] = tiles[i][j];
                else {
                    System.out.printf("Illegal tile value at (%d, %d): "
                            + "should be between 1 and N^2 .", i, j);
                    System.exit(1);
                }
            }
        }
        if(!isSolvable()){
            System.out.println("cannot be solved");
            System.exit(-1);
        }
    }

}
