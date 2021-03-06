## Written By
Meytal Yaniv and Yasmin Avraham

## The Problem
The problem we will explore with these algorithms is Switching Puzzle.
The game board is a two-dimensional array with N * N cells. The sequence of numbers from 1 to N * N are arranged randomly between the cells of the array. Each time you can select a pair of neighboring cells and switch between them. The goal is to arrange the numbers in ascending order from left to right and from top to bottom at minimal cost.

## The Solution
A* and IDA* search are a set of state space searching algorithms that find an optimal path from a beginning state to a known destination state. They can be used to solve a variety of problems from solving a puzzle with the least amount of steps to find the quickest path through a puzzle.
Both these algorithms are similar in nature in that they try to intelligently select the order of the paths they explore. They both do this by using a heuristic function that scores how close (in terms of steps to reach the goal node) a node is to the goal node. The general idea is that we want to explore paths that lead to nodes that are more similar to the goal node and have a short path from and starting node. To achieve this both algorithms use a f value to score nodes and the f value is the sum of the nodes heuristic value and the length of the path to get this node. We explore nodes with a smaller f value before looking at ones with a larger f value. This pushes us to nodes that are getting more similar to the goal node while also having a shorter path.

### A quick abstract example on how to use the searchers:
```
SwitchingNumbers game = new SwitchingNumbers(9);
ProblemSolver idaStar = new IDAStar();
idaStar.solvePuzzle(game);
ProblemSolver aStar = new AStar();
aStar.solvePuzzle(game);
```
