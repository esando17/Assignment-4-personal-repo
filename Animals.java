import java.util.Random;

public class Animals{
    private int weight = new Random().nextInt(40,200);
    private boolean reproductionChance = new Random().nextBoolean();


    //getters and setters for weight 
    public int getWeight(){
        return weight; 
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    
    //getters and setters for reproductionChance
    public boolean getReproductionChance(){
        return reproductionChance;
    }
    public void setReproductionChance(boolean reproductionChance){
        this.reproductionChance = reproductionChance;
    }
}
