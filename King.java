
/**
 * This class handles everything related to King ChessPiece which is a subclass
 * of ChessPiece, has methods that defines the moves for the King to able
 * to make throughout the ChessBoard.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class King extends ChessPiece{
    
    //constructor that intializes the King ChessPiece with
    //color and board reference provided as parameters
     public King(String newColor, Board theBoard){
        //uses super class constructor to intialize King Piece
        super("King",newColor,theBoard);
        //uses super class method to set the image for King on
        //the ChessBoard
        setGraphics("KingBlack.png","KingWhite.png");
    }
    
    //constructor that intializes the King ChessPiece by using
    //name, color and board refernce passed as arguements
    public King(String name,String newColor,Board theBoard){
        //uses superclass constructor to intialize the King Piece 
        super(name,newColor,theBoard);
        //uses supeclass method to set the image of King for
        //the ChessBoard
        setGraphics("King.png","KingWhite.png");
    }
    
    //this method is used for defining the moves for King ChessPiece.
    //It accepts the current position (start) possiion of King and the desired
    //move(end) and checks if it is valid or not 
    //and returns the boolean value as per the condition provided 
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol){
        //variable that holds boolean value if the move is valid or not
        boolean value=false;
        
        //this condition checks whether the end desired position is one row or column
        //above below the current position
        if(endRow>=startRow-1 && endRow<=startRow+1 && endCol>=startCol-1 && endCol<=startCol+1 ){
            //this condition checks whether the the tile is empty or not
            //and if it has an opponent's piece
            //and if the condition is true then it sets value to be to true
            if(getBoard().hasPiece(endRow,endCol)==false  || ( getBoard().hasPiece(endRow,endCol)==true && getBoard().getPieceColor(startRow,startCol)!=getBoard().getPieceColor(endRow,endCol) ) )
            value=true;
        }
        
        //returns the value as per the conditions
        return value;
    }
}
