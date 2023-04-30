import java.io.*;
import java.util.Scanner;
/**
 *  This class handles everything related to reading from a file
 *  and assigning to an array
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoardLoader
{
    //this method handles every method in this class
    public static void loadBoardState(Board theBoard,String fileName){
        //it assigns the aaray by calling parseFile
        String[][] boardCodes=parseFile(".\\Boards\\StandardBoard.txt");
        //creates a new instance of Board Class
        Board targetBoard=new Board();
        //this intialiazes the board with the boardcodes
        loadPiecesFromString(targetBoard,boardCodes);
    }

    //this method handles everything related to file
    //reading and parsing
    private static String[][] parseFile(String fileName){

        //array to hold boardcodes extraceted from the file
        String[][] boardCodes=null;
        try{
            FileReader inFile=new FileReader(fileName);   
            BufferedReader fileReader= new BufferedReader(inFile);
            Scanner lineReader=new Scanner(inFile);
            //these variables hole the no. of rows and columns
            //for the ChessBoard
            int rowNum=lineReader.nextInt();
            int colNum=lineReader.nextInt();
            
            lineReader.nextLine();
            //intializes the array as per the no. of rows and columns
            boardCodes=new String[rowNum][colNum];

            //loop that traverses thought he file and adds it to the array(parse)
            for(int i=0;i<rowNum;i++){
                for(int j=0;j<colNum;j++)
                    boardCodes[i][j]=lineReader.next();//parse
            }

            
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(e.toString());
        }

        //returns the array that has been intialized with data
        //from the file
        return boardCodes;
    }

    //this method adds the boardcodes into the specific Board instance
    private static void loadPiecesFromString(Board targetBoard, String[][] boardCodes){
        //creating a chessPiece instance
        ChessPiece pieceVar=null;
        //this traveses through the array that has
        //data from the file. And inputs into the
        //board instance using another method
        for(int i=0;i<boardCodes.length;i++){
            for(int j=0;j<boardCodes[j].length;j++){
                pieceVar=loadChessPiece(targetBoard,boardCodes[i][j]);
                targetBoard.setTile(i,j,pieceVar);
            }

        }

    }

    //this method individually creates a new ChessPiece with
    //the help of data from the file
    private static ChessPiece loadChessPiece(Board targetBoard,String code){
        //variable of ChessPiece that will hold a new instance as per code
        ChessPiece temp=null;
        //variable to hold the color
        String color;
        //this condtions checks the first character of boardcode and
        //assigns color according to it
        if(code.charAt(0)=='B')
            color="BLACK";
        else
            color="WHITE";

        //this conditions checks the second character of the boardcod
        //assigns an instance of any oy six chess piece to the ChessPiece
        //variable
        if(code.charAt(1)=='C')
            temp=new Castle(color,targetBoard);
        else if(code.charAt(1)=='N')
            temp=new Knight(color,targetBoard);
        else if(code.charAt(1)=='B')
            temp=new Bishop(color,targetBoard);
        else if(code.charAt(1)=='K')
            temp=new King(color,targetBoard);
        else if(code.charAt(1)=='Q')
            temp=new Queen(color,targetBoard);
        else if(code.charAt(1)=='P')
            temp=new Pawn(color,targetBoard);
            
        //this variable will contain a new instance as per the boardcode    
        return temp;    
        
    }
}


