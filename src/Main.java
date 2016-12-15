
import java.util.LinkedList;
import java.util.*;


public class Main {

    static int[][] Board1 =      {{1,2,3,4},   //initial board
                                 {5,0,7,8},
                                 {9,6,10,11},
                                 {13,14,15,12}};
    static int[][] solution = {{1,2,3,4},
                               {5,6,7,8},
                               {9,10,11,12},
                               {13,14,15,0}};
    static int xposition=1;
    static int yposition=1;
    static int distance=0;
    static Board current;


    static Board[] placeHolder = new Board[4];


    public static void main(String[] args) {


        Board current= new Board(Board1, xposition, yposition, distance); //Initial board fed with initial values
        Queue<Board> queue = new LinkedList<>(); //Queue of boards

        Hashtable<Board, Board> ht = new Hashtable<>(); //Used for backtracking at the end of program, saves child and parent


        queue.add(current);



        do {                            //Breadth-First Search

            current = queue.remove(); //Retrieve head of list, give value to board current

            if(!(Arrays.deepEquals(solution, current.board))) { //Checks if the current board != solution
                placeHolder = current.getNeighbours(); //Finds all neighbours
                for (int i = 0; i < 4; i++) {
                    if (placeHolder[i] != null) { //Places all neighbours in the queue
                        queue.add(placeHolder[i]);
                        ht.put(placeHolder[i], current); //Puts neighbours in hashtable with their parent in form (c,p) (for backtracking)
                    }
                }
            }
            else if(Arrays.deepEquals(solution, current.board))
            {
                current.getValues(); //If the solution is found, prints it and begins backtracking
                while(!(Arrays.deepEquals(current.board, Board1)))
                {
                    current=ht.get(current); //Gets the parent of each board until the parent equals the initial board
                    current.getValues();    //and prints each of these boards.
                }
            }
        } while(!queue.isEmpty());

    }


@Override
public int hashCode() {
    Board b = new Board(current.board, xposition, yposition, distance);
    int sum = 0;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            sum = sum + (current.board[i][j] * i * j);
        }
    }
    return sum;
}
}






