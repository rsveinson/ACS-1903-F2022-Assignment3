
/**
 * A piece corresponds to an object that a player moves
 * from square to square around a board.
 * 
 * A piece has an id, a name, and knows the square upon which it sits
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piece
{
    private int id;
    private String name;
    private Square whereAt;

    /**
     * Constructors 
     */
    public Piece()
    {
        this.id = 0;
        this.name="";
        this.whereAt=null;
    }

    public Piece(int id, String name,Square liesOn)
    {
        this.id = id;
        this.name=name;
        this.whereAt=liesOn;
    }
    
    // COMPLETE the following so there are getters and setters for all fields
    // and so the equals method works as described

    /* ********* added methods ****************** */
    public int getId(){
        return this.id;
    }// end get id
    
    // setters
    public void setId(int id){
        this.id = id;
    }// end set id
    
    public void setName(String name){
        this.name = name;
    }// end get name
    
    public void setWhereAt(Square liesOn){
        this.whereAt = liesOn;
    }// end set where at
    
    public boolean equals(Piece otherPiece){
        return this.name.equals(otherPiece.name);
    }// end equals
    
    // ******************** end of added methods ****************
       
    public String getName(){
        return name;
    }

    public String getWhereAt(){
        return whereAt.getName();
    }

    public String toString ()
    {
        return id+" "+name+" "+whereAt;
    }

}
