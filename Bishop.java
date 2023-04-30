
/**
 * This class handles everything related to Bishop ChessPiece which is a subclass
 * of ChessPiece. It intiliazes Bishop pieec and has method to check for valid
 * moves that ir can move through the ChessBoard.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bishop extends ChessPiece{
     //constructor to intialize the Bishop ChessPiece using color and
    //board reference passed as arguements
    public Bishop(String newColor, Board theBoard){
        //uses super-class constructor to intialize the Bishop Piece
        //using the arguements passed 
        super("Bishop",newColor,theBoard);
        //sets the image of Bishop for ChessBoard using
        //superclass method by passing the location of
        //images as strings
        setGraphics("BishopBlack.png","BishopWhite.png");

    }

    //constructor to intialize Bishop ChessPiece 
    //using the name, color, board reference
    //passed as arguements
    public Bishop(String name,String newColor,Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("BishopBlack.png","BishopWhite.png");
    }

    //This methods checks the current position(start) and desired move(end)
    //passed as arguments to check for the valid moves and
    //set the boolean value if the move is valid or not
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol){
        //variable that holds boolean value whether move is valid or not
        boolean value=false;
        //variables that hold the color of piece at the current position
        //and the piece at the desired location
        String colorStartPiece=getBoard().getPieceColor(startRow,startCol);
        String colorEndPiece=getBoard().getPieceColor(endRow,endCol);
        //this condiiton checks whether desired move is diagonal
        //to the current position
        if( ( (startRow-endRow)==(startCol-endCol) ) ||  ( (startRow-endRow)==(-(startCol-endCol)) ) ){ 
            //it checks whther the tile is empty or not.
            //or does it have opponent's piece
            //and sets the boolean value accordingly
            if(  (getBoard().hasPiece(endRow,endCol)==false || colorStartPiece!=colorEndPiece) )
                value=true;
        }
        
        //returns the value as per conditions above
        return value;
    }
}
