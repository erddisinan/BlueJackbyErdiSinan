import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Deck d = new Deck();


        Player p1 = new Player(true);
        Player p2 = new Player(true);
        d.distributeCards(p1,p2);
        System.out.println(Arrays.toString(p1.getCards()));

        System.out.println("*******************");
        giveOneCard(p1,d);
        p1.play();
        giveOneCard(p2,d);
        p2.play();
        System.out.println(p1.boardPoints);
        System.out.println(p2.boardPoints);

        while(true){

            giveOneCard(p1,d);

            p1.play();
            giveOneCard(p2,d);
            p2.play();
            //if(check(Player p1, Player p2)){

            //}
            break;
        }
    }

    public static void giveOneCard(Player p,Deck d){
        p.getBoardCards()[p.getBoardCardIndex()]=d.getCards()[d.top];
        p.boardPoints+=d.getCards()[d.top].getNumber();
        p.setBoardCardIndex(p.getBoardCardIndex()+1);
        d.getCards()[d.top]=null;
        d.top++;
    }

    public void check(){

    }
}