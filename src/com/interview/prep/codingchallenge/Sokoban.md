Pushing Boxes (Sokoban)

(ACM International Collegiate Programming Contest 1997/98, Southwestern European Regional Contest)

This is based on an old computer game called Sokoban. Imagine you are standing inside a two-dimensional maze composed of square cells which may or may not be filled with rock. You can move north, south, east or west one cell at a step. These moves are called walks.

One of the empty cells contains a box which can be moved to an adjacent free cell by standing next to the box and then moving in the direction of the box. Such a move is called a push. The box cannot be moved in any other way than by pushing, which means that if you push it into a corner you can never get it out of the corner again.

One of the empty cells is marked as the target cell. Your job is to bring the box to the target cell by a sequence of walks and pushes. As the box is very heavy, you would like to minimize the number of pushes. Can you write a program that will work out the best such sequence?


Solution hint

Construct a graph in which the vertices are tuples (Sx,Sy,Bx,By) describing the current position of the Sokoban player, (Sx,Sy) and the box (Bx,By). Record the minimum cost known for reaching each position and do a BFS using a priority queue to find the shortest path to a position where the box reaches the target cell.

Full solution

.
Input format

The first line consists of two integers r and c (both ≤ 20), representing the number of rows and columns of the maze, respectively.

Following this are r lines each containing c characters. Each character describes one cell of the maze. A cell full of rock is indicated by a '#' and an empty cell is represented by a '.'. Your starting position is symbolized by 'S', the starting position of the box by 'B' and the target cell by 'T'.

Output format

If it is impossible to bring the box to the target cell, print -1.

Otherwise, output two integers P and W on a single line, where P is the number of pushes and W is the number of walks in an optimal solution. (Note that the sequence of pushes and walks in an optimal solution is not unique, but the number of pushes and walks in all optimal solutions is the same).

Test Data:

You may assume that r,c ≤ 20.

Example:

We illustrate the input and output format using the above example:

Sample Input 1:

17 SB....T
Sample Output 1:

5 0
Sample Input 2:

17 SB..#.T
Sample Output 2:

-1
Sample Input 3:

7 11
###########
#T##......#
#.#.#..####
#....B....#
#.######..#
#.....S...#
###########
Sample Output 3:

6 22
Sample Input 4:

8 4
....
.##.
.#..
.#..
.#.B
.##S
....
###T
Sample Output 4:

3 16

Solution
This is clearly a shortest path problem in a graph. What is the graph?

Vertices are (Sx,Sy,Bx,By)
For each outgoing vertex, there are four possible outgoing edges of which at most one is a push. The rest are walks. 

Note that this is a directed graph — if we go from (Sx,Sy,Bx,By) to (S'x,S'y,B'x,B'y), we may not be able to reverse this move, in particular if the move was a push. 

Note that all our earlier algorithms like BFS, DFS, shortest paths work for directed graphs as well, in essentially the same way as for undirected graphs.
Target node is any vertex (Sx,Sy,Bx,By) where (Bx,By) = (Tx,Ty). If we assume that the initial box position is not the target, we have only four possibilities for (Sx,Sy).
Maintain the cost of a path as a pair (P,W) where P is the number of push move and W is the number walks. So, a push move adds cost (1,1) while a walk move adds (0,1). Costs are ordered lexicographically: (P,W)<(P',W') if P<P' or P = P' and W<W'. 

We can also map (P,W) to a single integer. Between each pair of push moves, the Sokoban can make at most N^2 moves. 

So we can map, say, (P,W) to a single integer P*160000 + W. With each push move, we add 160000 and with each walk move we add 1 to the cost.
How do we find the shortest path?

Do BFS, but maintain unexplored configurations with cost in a priority queue (heap), based on cost, rather than in a queue. At each step, the next configuration to be explored is the minimum cost unexplored configuration in the priority queue.
We can label edges between configurations with the cost added by this edge. We can then use Dijkstra's algorithm to calculate shortest path in M log M time, where M is the number of edges, using a heap to store burning times of unburnt edges. Note that the number of edges is small — each vertex has degree at most 4, so the total number of edges is about 2N. 

Notice that if we use a naive implementation of Dijkstra using an adjacency matrix, we have to store N*N entries which is too large. However, the edges are defined implicitly so we don't need to construct an explicit representation. 

As a further optimization, we can use an incremental version of Dijkstra's algorithm where we maintain edges in the heap as we visit them.