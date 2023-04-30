
/**
 * This class handles Castle(ChessPiece) which is a subclass of ChessPiece, intializes Castle and 
 * has methods to check for the moves it is able to make throughout the board
 * @author (your name)
 * @version (a version number or a date)
 */
public class Castle extends ChessPiece{

    //constructor that accepts color of Castle and
    //board refernce and intializes it
    public Castle(String newColor, Board theBoard){
        //uses superclass constructor to intialize the variables 
        super("Castle",newColor,theBoard);
        //calls superclass method to set the images of pieces 
        //for the board
        setGraphics("CastleBlack.png","CastleWhite.png");

    }

    //constructor that accepts name, color and
    //board reference to intialize Castle Piece
    public Castle(String name,String newColor,Board theBoard){
        //uses the superclass sonstructor but passes the name,color
        //board refernce 
        //passed as an arguement 
        super(name,newColor,theBoard);
        //sets the image using the super class method
        setGraphics("CastleBlack.png","CastleWhite.png");
    }
    
    //This method is used to check the specific move for Castle Piece.
    //it accepts the start coordinates(current position) and uses this method
    //to check the possible move for the piece according to the end position
    //provided as arguement and returns boolean value if the move can be
    //implemented or not.
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol){
        //the boolean value that stores the value if the
        //move is valid or not
        boolean value=false;
        //this condtions checks whether desired move is in
        //same column or same row as the intial position of
        //the Castle ChessPiece
        if( endRow==startRow || endCol==startCol ){
            //this condition checks whether the desired box is empty or
            //has  a chessPiece already and is of the same team or not.
            //if this box is empty or has a chessPiece of the opposition team 
            //this will set the value to be true
         if(getBoard().hasPiece(endRow,endCol)==false  || ( getBoard().hasPiece(endRow,endCol)==true && getColor()!=getBoard().getPieceColor(endRow,endCol))){
             value=true;
         }
         
        } 
        //returns the value as per condition
        return value;
    }
}  
    // JUMP CODE FOR CASTLE PIECE
    /* This method is commented out because it didn't suffice the given condition
       mentioned in the question*/
       // it works perfectly fine for bothe horizontal and vertical positions
       // but it also blocks the opposition piece. So we can't capture that.
     /*public boolean isValidMove(int startRow, int startCol, int endRow, int endCol){
        
         boolean value=false; 
        
         int countVerticalUp=0; //variable that increments itself when there is a piece above the intial chessPiece
         int countVerticalDown=0; //variable if there is a piece below it and increments it
         int countHorizontalRight=0;//variable if there is a piece right to it and increments it
         int countHorizontalLeft=0; //variable if there is a piece left to it and increments it
    
         String pieceColor=getBoard().getPieceColor(startRow,startCol); //variable to store color of the current ChessPiece
        
        //variable to hold color of the piece we are trying to capture
         String endPieceColor=getBoard().getPieceColor(endRow,endCol); 
        
         //this condition checks whether the move is in
         //same column or same row
         if( endRow==startRow || endCol==startCol ){
             //this condition checks whether the move is empty or
             //has the piece of the opposition
             if(getBoard().hasPiece(endRow,endCol)==false  || ( getBoard().hasPiece(endRow,endCol)==true && pieceColor!=endPieceColor ) ) {
 
                 //this loop will run from the row above current row position
                 //untill the end row(desired move) position ( from the bottom till the top )
                 //this condition won't work if as the array will go outOfBounds
                 if(startRow!=8){
                     //it checks every tile between the current position and desired move
                     //it increments the row and checks whether the tile has a piece or not.
                     
                     for(int i=startRow+1;i<=endRow;i++){
                         //if certain tile has a piece
                         //variable will increment itself
                         if((getBoard().hasPiece(i,endCol))){
                             countVerticalUp++;    
                         }
                     }
                 } 
                 //this loop will run from the row below the current row position
                 //till the desired row(end)  postion (from the top till bottom)
                 
                 //this conditon won't work if the current row position is the most bottom one.
                 //as the array will go outOfBounds
                   if(startRow!=0){
                    //it checks every tile from start till end value and checks whether
                    //it has a piece or not
                     for(int i=startRow-1;i>=endRow;i--){
                         //if a certain tile has a piece
                         //this will increment itself
                         if( (getBoard().hasPiece(i,endCol))){
                             countVerticalDown++;
                         }
                     }
                 } 
                 
                 //this workd the same way as it works vertically
                 if(startCol!=8){
                     for(int j=startCol+1;j<=endCol;j++){
                         if( (getBoard().hasPiece(endRow,j) ) ){
                             countHorizontalRight++;
                         }
                     }
                 } 
                 if(startCol!=0){
                     for(int j=startCol-1;j>=endCol;j--){
                         if( (getBoard().hasPiece(endRow,j) ) ){
                             countHorizontalLeft++;
                         }
                     }
                 }
                 
                 //this condition checks whether the specific move has met every condition
                 //if the variable is not being incremented that means the desired move has no pieces
                 //between itself and current position
                 //sets the value to be true if all conditions are met
                 if( (countVerticalUp+countHorizontalRight+countVerticalDown+countHorizontalLeft==0)){
                 value=true;
                
             }
                
                

             } 
         } 

         return value;
     }
*/