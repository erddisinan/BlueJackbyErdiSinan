import java.util.Scanner;
public class Player {
    Scanner sc = new Scanner(System.in);
    private boolean isHuman;
    int boardPoints=0;
    int score=0;
    private int scoreOfBoard;
    private Card[] boardCards=new Card[20];
    private int boardCardIndex=0;
    private Card[] currentCards=new Card[4];

    Player(boolean isHuman){
        this.isHuman=isHuman;
    }

    public Card[] getCards(){
        return this.currentCards;
    }
    public Card[] getBoardCards(){
        return this.boardCards;
    }

    public int getBoardCardIndex() {
        return boardCardIndex;
    }

    public void setBoardCardIndex(int boardCardIndex){
        this.boardCardIndex=boardCardIndex;
    }

    
}
