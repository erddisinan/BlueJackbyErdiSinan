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
    public void play(){

        if(isHuman){
            boolean willPlay=true;
            boolean end;
            boolean stand;





            if(willPlay){
                System.out.println("This is your board");
                for(int i = 0;i<boardCardIndex;i++){
                    System.out.print((i+1)+" "+boardCards[i]+"|");
                }
                System.out.println();
                System.out.println("Which cards do you want to play?");
                for(int i = 0; i<currentCards.length;i++){
                    if(currentCards[i]!=null){
                        System.out.print((i+1)+" "+currentCards[i]+"|");
                    }
                }
                int choice = sc.nextInt();
                boardCards[boardCardIndex++]=currentCards[choice-1];
                currentCards[choice-1]=null;
                System.out.println();
                boardPoints+= boardCards[boardCardIndex-1].getNumber();

            }

        }
    }
}
