import java.util.Random;

public class Deck {
    Random r = new Random();
    int top=0;
    int bottom=39;
    private Card[] cards= new Card[40];
    private String[] colours={"Red","Green","Yellow","Blue"};
    Deck(){
        for(int i = 0;i<colours.length;i++){
            for(int a =1;a<=10;a++){
                cards[i*10+a-1]=new Card(colours[i],a);
            }
        }
        shuffle();
    }

    private void shuffle(){
        for(int i = 0; i<cards.length;i++){
            int randomIndex=r.nextInt(40);
            Card temp = cards[i];
            cards[i]=cards[randomIndex];
            cards[randomIndex]=temp;
        }
    }

    public Card[] getCards(){
        return this.cards;
    }

    public void distributeCards(Player p1,Player p2){
        Card[] p1BaseCards = new Card[10];
        Card[] p2BaseCards = new Card[10];

        for(int i = 0; i<5;i++){
            p1BaseCards[i] = cards[i];
            cards[i]=null;
            top++;
        }
        for(int i = 0; i<5;i++){
            p2BaseCards[i] = cards[39-i];
            cards[39-i]=null;
            bottom--;
        }

        for(int i= 5;i<8;i++){
            p1BaseCards[i]= new Card();
            p2BaseCards[i] = new Card();
        }

        for(int i = 8;i<10;i++){
            //these controls will be done for player1
            if(r.nextInt(10)<2){
                //this is 20 percent chance.
                if(r.nextInt(2)==1){
                    //if random number will be 1 than the cards will be flip, otherwise double.
                    //flip assignment will be provided by giving parameter true.
                    p1BaseCards[i]=new Card(true);
                }else{
                    //double assignment will be provided by giving parameter false.
                    p1BaseCards[i]=new Card(false);
                }
            }else{
                //this is 80 percent chance.
                p1BaseCards[i]=new Card();
            }
            //these controls will be done for player2

            if(r.nextInt(10)<2){
                //this is 20 percent chance.
                if(r.nextInt(2)==1){
                    //if random number will be 1 than the cards will be flip, otherwise double.
                    //flip assignment will be provided by giving parameter true.
                    p2BaseCards[i]=new Card(true);
                }else{
                    //double assignment will be provided by giving parameter false.
                    p2BaseCards[i]=new Card(false);
                }
            }else{
                //this is 80 percent chance.
                p2BaseCards[i]=new Card();
            }
        }

        int indexForp1=0;
        int indexForp2=0;

        while(indexForp1<4){

            int randIndex=r.nextInt(10);

            if(p1BaseCards[randIndex]!=null){
                p1.getCards()[indexForp1]=p1BaseCards[randIndex];
                p1BaseCards[randIndex]=null;
                indexForp1++;
            }

        }

        while(indexForp2<4){

            int randIndex=r.nextInt(10);

            if(p2BaseCards[randIndex]!=null){
                p2.getCards()[indexForp2]=p2BaseCards[randIndex];
                p2BaseCards[randIndex]=null;
                indexForp2++;
            }

        }


    }

}
