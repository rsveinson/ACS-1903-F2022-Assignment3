import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
/**
 * A board consists of many squares. 
 * On each square there may sit a piece.
 *
 * @author (your name..................)
 * @version (a version number or a date)
 */
public class Board
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //initiallize the board using the squares file
        ArrayList<Square> board = new ArrayList<>();
        Scanner squares = new Scanner(new File("squares.txt"));
        while (squares.hasNext()){
            board.add(new Square(squares.nextInt(),squares.next()));
        }
        // the sequence of squares in the arraylist corresponds
        // to the sequence of squares on the board

        // display squares on the board 
        System.out.println("Board squares are:\nid\tname");
        for (Square s: board) System.out.println(s);

        // initiallize each piece placing it on the start square
        Scanner pieces = new Scanner(new File("pieces.txt"));
        ArrayList<Piece> gamePieces =  new ArrayList<>();
        while (pieces.hasNext()){
            Piece p = new Piece(pieces.nextInt(), pieces.next(), board.get(0));
            gamePieces.add(p);
        }
        
        // COMPLETE THIS:
        // move each piece randomly and separately
        int numberOfMoves;
        Random r = new Random();
        for(Piece p: gamePieces){
        // enter your code that moves each piece a random number of squares
        // in the clockwise direction
        // step 1: random number from 1-24
        numberOfMoves = r.nextInt(24) + 1;
        //System.out.println("roll: " + numberOfMoves);
        
        //Step 2: find out what square the piece should be on
        // use mod board.size() arithmetic
        numberOfMoves %= board.size();
        //System.out.println("move to square: " + numberOfMoves);
        
        // Step 3: set the association between new Squaer and Piece
        setPieceOnSquare(board.get(numberOfMoves), p);
        }// end for
        
        System.out.println("\n\nPieces have moved from their starting positions");
        for(Piece p: gamePieces){
            System.out.println(p.getName()+" is on "+p.getWhereAt());
        }
        
    }// end main
    public static void setPieceOnSquare(Square s, Piece p){
            p.setWhereAt(s);
            s.addPiece(p);
        }
}
