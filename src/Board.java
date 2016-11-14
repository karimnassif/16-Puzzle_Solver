
public class Board {

    int xposition;
    int yposition;
    int board[][];
    int distance;

    public Board(int[][] step, int x, int y, int dist) {
        this.board = step;
        this.xposition = x;
        this.yposition = y;
        this.distance = dist;
    }


    public int[][] copyArray = new int[4][4];
    public int temp;

    //Some values of boardArray[] may come out null
    public Board[] getNeighbours() {
        Board[] boardArray = new Board[4];


        if (yposition > 0) //moves tile right into blank
        {
            for (int i = 0; i < 4; i++) //Copying board into a temporary array
            {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = this.board[i][j];
                }
            }

            //Switching values
            temp=copyArray[xposition][yposition];
            copyArray[xposition][yposition] = this.board[this.xposition][(yposition - 1)];
            copyArray[this.xposition][(this.yposition - 1)] = temp;


            //Saving new board
            boardArray[0] = new Board(copyArray, this.xposition, (this.yposition - 1), this.distance + 1);
        }


        if (this.xposition > 0) //moves tile right into blank
        {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = this.board[i][j];
                }
            }
            temp=copyArray[xposition][yposition];
            copyArray[xposition][yposition] = this.board[this.xposition - 1][(this.yposition)];
            copyArray[this.xposition - 1][this.yposition] = temp;


            boardArray[1] = new Board(copyArray, (this.xposition - 1), this.yposition, this.distance + 1);
        }


        if (this.xposition < 3) //moves tile left into blank
        {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = this.board[i][j];
                }
            }

            temp=copyArray[xposition][yposition];
            copyArray[this.xposition][this.yposition] = this.board[this.xposition + 1][(this.yposition)];
            copyArray[this.xposition + 1][this.yposition] = temp;


            boardArray[2] = new Board(copyArray, (this.xposition + 1), this.yposition, distance + 1);
        }


        if (this.yposition < 3) //moves tile up into blank
        {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    copyArray[i][j] = this.board[i][j];
                }
            }
            temp=copyArray[xposition][yposition];
            copyArray[xposition][yposition] = this.board[xposition][yposition + 1];
            copyArray[xposition][yposition + 1] = temp;


            boardArray[3] = new Board(copyArray, xposition, (yposition + 1), distance + 1);
        }
        return boardArray;
    }


    public void getValues() { //method to print a board
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
