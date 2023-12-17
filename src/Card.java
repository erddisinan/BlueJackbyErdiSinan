import java.util.Random;
public class Card {
    Random r = new Random();

    private String color;
    private int number;
    private boolean isPositive;
    private boolean isFlip=false;
    private boolean isDouble=false;
    private String[] colours={"Red","Green","Yellow","Blue"};

    Card(String color,int number){
        //This is for normal card.
        this.color=color;
        this.number=number;
    }

    Card(){
        //This is for signed card.
        this.number=r.nextInt(6)+1;
        this.isPositive=r.nextInt(2)==1;
        this.color=colours[r.nextInt(colours.length)];
    }

    Card(boolean isFlip){
        if(isFlip){
            this.isFlip=true;
        }else{
            this.isDouble=true;
        }
    }

    public String toString(){
        if(isDouble) return "x2";
        if(isFlip) return "+/-";
        return this.color + "-" +this.number;
    }
    public int getNumber(){
        return number;
    }



}
