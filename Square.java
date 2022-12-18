import java.util.ArrayList;

/*
 * A square on a board game
 * each square has an id, a name, and a reference 
 * to the next square on the board
 */
public class Square
{
    private int id;
    private String name;
    
    // include the association field for square
    ArrayList<Piece> pieces;
    
    /**
     * Constructor for objects of class initiallizeSquares
     */
    public Square(int id, String name)
    {
        this.id = id;
        this.name=name;
        pieces = new ArrayList<>();
    }
    
    // COMPLETE the following so there are getters and setters for all fields
    // and so the equals method works as described
    
    /* ************ added methods ********************
     * get id
     * get pieces
     * set id
     * set pieces
     * add piece
     * remove piece
     * equals
     * *************************************************/
     public int getId(){
         return id;
     }// end get id
     
     public ArrayList<Piece> getPieces(){
         return pieces;
     }// end get pieces
     
     public void setId(int id){
         this.id = id;
     }// end get id
     
     public void setPieces(ArrayList<Piece> pieces){
         this.pieces = pieces;
     }// end set pieces
     
     public void addPiece(Piece p){
         pieces.add(p);
     }// end addpieces
     
     // public void removePiece(){
        // pieces.remove(pieces.size() -1);
     // }// end remove piece
     
     public boolean equals(Square s){
         return this.name.equals(s.name);
     }// end equals
     
    /* ************* end added methods ****************** */
    
    public String toString(){
        return id+"\t" +name;
    }
    
    public String getName(){
        return name;
    }
}
