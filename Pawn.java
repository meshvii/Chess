
/**
 * This Class handles everything related to Pawn ChessPiece intializes 
 * Pawn ChessPiece and has a method that defines valid moves for Pawn
 * throughout the ChessBoard.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pawn extends ChessPiece{

    //constructor to intialize the Pawn ChessPiece using color and
    //board reference passed as arguements
    public Pawn(String newColor, Board theBoard){
        //uses super-class constructor to intialize the Pawn Piece
        //using the arguements passed 
        super("Pawn",newColor,theBoard);
        //sets the image of Pawn for ChessBoard using
        //superclass method by passing the location of
        //images as strings
        setGraphics("PawnBlack.png","PawnWhite.png");

    }

    //constructor to incitliaze the Pawn ChessPiece using name,
    //color and board reference passed as arguements
    public Pawn(String name,String newColor,Board theBoard){
        //uses super-class constructor to intialize the Pawn Piece
        //usifn the arguements passed
        super(name,newColor,theBoard);
        //sets the image of Pawn by using super-class method by passing
        //location as parameters
        setGraphics("PawnBlack.png","PawnWhite.png");
    }

    //This method uses current position(start) adn desired move(end) passed as
    //arguements to check whether the move is valid or not.
    //and returns the boolean value accordingly
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol){
        //variable that holds the boolean value to
        //see whether move is valid or not
        boolean value=false;

        //variables to hold the color of the current piece and piece
        //at the desired tile
        String pieceColor=getBoard().getPieceColor(startRow,startCol);
        String endPieceColor=getBoard().getPieceColor(endRow,endCol);

        //this condition is for WHITE pieces
        if(pieceColor=="WHITE"){
            //this checks whether the tile is in the same column
            if(endCol==startCol){
                //this condition is for the first move
                if(startRow==1){
                    //this condition checks whether end position
                    //is two/one rows away from the current position
                    if(endRow==startRow+2 || endRow==startRow+1){
                        //this condition checks whether the tile is empty or not.
                        //and if it is empty it will set the value to be true
                        if(getBoard().hasPiece(endRow,endCol)==false)    
                            value=true;
                    }
                }
                else{
                    //this condtion applies to Pawn after it's very first move
                    //it checks for the file one row forward to the current
                    //position
                    if(endRow==startRow+1)
                    //if the desired tile is empty or not
                    //and sets the boolean to true if it is
                    //empty
                        if(getBoard().hasPiece(endRow,endCol)==false)
                            value=true;
                }
            }

        }
        //this condition applies for all BLACK pieces
        else{
            //this condition checks whether Pawn is in the same column
            if(endCol==startCol){
                //this condition is for Pawn's very first move
                if(startRow==6){
                    //this checks whether desired move is two rows/ one row ahead
                    //of the current position
                    if(endRow==startRow-2 || endRow==startRow-1)
                    // if the desired tile is empty it will set the boolean
                    //to be true
                        if(getBoard().hasPiece(endRow,endCol)==false)
                            value=true;
                }
                //this condition is for Pawn's every move after the very first one
                else{
                    //this checks whether desired move is one row ahead of
                    //current position or not
                    if(endRow==startRow-1)
                    //this checks whether the tile is empty or not.
                    //And if it is empty it will set the boolean to true
                        if(getBoard().hasPiece(endRow,endCol)==false)
                            value=true;
                }
            }
        }
    
        //This condition checks for the opponent's piece on the diagonal of the Pawn's position
        if( pieceColor=="WHITE" ){
            if( (endRow==startRow+1 && endCol==startCol+1 )
            ||( endRow==startRow+1 && endCol==startCol-1 ) )
            //if the tile has a piece of opponent's then it will set the
            //value to true
                if(getBoard().hasPiece(endRow,endCol)==true && pieceColor!=endPieceColor)
                    value=true;
        }
        //this condition is for BLACK pieces
        else{
            if ( ( endRow==startRow-1 && endCol==startCol+1)
            ||( endRow==startRow-1 && endCol==startCol-1) )
            //this checks whether desired tile has opponent's piece or not
            //and if it has then it will set boolean to true
                if(getBoard().hasPiece(endRow,endCol)==true && pieceColor!=endPieceColor)
                    value=true;
        }
        
        //this will return the boolean value according to the conditions
        return value;

    }
}
