
/**
 * This Class handles Queen ChessPiece which is a sub-class of ChessPiece which intializes Queen,
 * has methods to check whether it's moves are valid or not.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queen extends ChessPiece{
    //constructor to intialize the Queen ChessPiece using color and
    //board reference passed as arguements
    public Queen(String newColor, Board theBoard){
        //uses super-class(ChessPiece) constructor to intialize the Queen Piece
        super("Queen",newColor,theBoard);
        //uses super-class method to set the image of Queen for the game-board
        setGraphics("QueenBlack.png","QueenWhite.png");
    }

    //constructor that accepts arguements for the color of the Queen, name and
    //board refernce to intiliaze the Queen ChessPiece
    public Queen(String name,String newColor,Board theBoard){
        //uses super-class to intialize by passing the arguements
        super(name,newColor,theBoard);
        //uses super-class method to set the images for ChessBoard
        setGraphics("QueenBlack.png","QueenWhite.png");
    }

     //This method is used to check the specific move for Queen Piece.
    //it accepts the start coordinates(current position) and uses this method
    //to check the possible move for the piece according to the end position
    //provided as arguement and returns boolean value if the move can be
    //implemented or not.
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol){
        //varibale to hold the boolean value if
        //the move is valid or not
        boolean value=false;
        
        //variables that hold the color of the piece at current position
        //and the color of piece on the tile we want to move
        String colorStartPiece=getBoard().getPieceColor(startRow,startCol);
        String colorEndPiece=getBoard().getPieceColor(endRow,endCol);
        
        //this condition checks whether the desired move is in the same row
        //or same column(vertically or horizontally)
        //it checks whether the tile has a piece or not, and if 
        //it has whether if it is of the oppostion or not
        //and if the condition is fulfilled it sets the value to be true.
        if(endRow==startRow || endCol==startCol){
            if(  (getBoard().hasPiece(endRow,endCol)==false || colorStartPiece!=colorEndPiece) )
                value=true;
        }
        else{
            //this condtion is for the diagonals
            //if the desired move coordinates(endRow,endCol) and 
            //current position(startRow,startCol) lies on the diagonal or not
            //for eg. if one of the diagonal tile is (3,6) and
            //my position is(2,5)
            //the difference of both coordinates will give the same answer and 
            //this forms an a mathematical expression
            //which I have used in my condition.
            //It will check whether the tile contains a piece of opposition or not 
            //or whether it is empty
            if( ( (startRow-endRow)==(startCol-endCol) ) ||  ( (startRow-endRow)==(-(startCol-endCol)) ) ){ 
                //if the tile is empty or has a piece of the opponent
                //the value will be set to true.
                if(  (getBoard().hasPiece(endRow,endCol)==false || colorStartPiece!=colorEndPiece) )
                    value=true;
            }
        }

        //returns the value as per it is set in the method
        return value;
    }
}
