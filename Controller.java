import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public Weather randomWeather(){
        int num = new Random().nextInt(Weather.values().length);
        return Weather.values()[num];
    }

    private String randomLastName(){
        //reads the name.txt file
        BufferedReader strReader = null;
        String label = "";
        try{
            String strCurrentLine;
            strReader = new BufferedReader(new FileReader("./name.txt"));
            while((strCurrentLine = strReader.readLine()) != null){
                label = label + strCurrentLine;
            } 
        
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if (strReader != null)
                strReader.close();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        String [] lastName = label.split(",");

        int num = new Random().nextInt(lastName.length);
        return lastName[num].replaceAll("\"", ""); 
    }
    private String firstName(){
        String name=""; 
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
            try {
                 name = reader.readLine();
            } catch (IOException e) {
                System.err.println("Please input a valid name");
                e.printStackTrace();
            }
            return name;
    }

    public void start(){
        System.out.println("Welcome to the Farming Game, you will test out your luck for Survival. Each round you will get weather, harvest, and meat animal stats, if you are lucky you will survive the season. To begin playing enter your name, we will assign a last name. May the odds be in your favor");
        
        System.out.println("player name:"+ firstName()+" "+ randomLastName());

            
            
            
        //uses the contructor and the randomWeather() gives the value that is used for it 
        World world = new World(randomWeather());
        System.out.println(world.getWeather());

        //logic for determining the type of harvest your person will be getting
        if(world.getWeather() == Weather.FLASH_FLOOD){
            world.setHarvest("The flood Damaged your soil.You will starve by next season, Sorry!");
            System.out.println(world.getHarvest());
            System.exit(0);
        }
        else if(world.getWeather() == Weather.LOW_RAIN_FALL){
            world.setHarvest("Some crops survived, you have enough until next season.");
            System.out.println(world.getHarvest());
        }
        else if(world.getWeather() == Weather.GOOD_RAIN_FAL){
            world.setHarvest("Good weather means good crops. You have an abundnce of food until next season");
            System.out.println(world.getHarvest());
        }
        else if(world.getWeather() == Weather.HAIL || world.getWeather() == Weather.FROST){
            world.setHarvest("Bad conditions will damage all your crops. You will starve by next season, Sorry!");
            System.out.println(world.getHarvest());
            System.exit(0);
        }
        System.out.println("Round 2: Animal meat");

        Animals animals = new Animals();
        if (animals.getWeight() <= 60){
            System.out.println("Your animal is too skinny and will die.You will starve by next season. Sorry!");
            System.exit(0);
        }
        else if(animals.getReproductionChance() == true){
            System.out.println("Your animal is at a healthy weight and it reproduced!");
        }
        else if(animals.getReproductionChance() == false){
            System.err.println("Your animal is a healthy weight but could not reproduce. You will starve by next season. Sorry!");
            System.exit(0);
        }
        System.out.println("Round 3: reproduction");

        Person person = new Person();
        if(person.getReproduce() == false){
            System.out.println("You had favorable weather leading to a season harvest that let you feed yourself and your animals, but you could not reproduce. You lost the Farming Game.");
            System.exit(0);
        }
        else if(person.getReproduce() == true){
            System.out.println("Congratulations! You had enough food, animal meat, and offspring to survive this season. You win!");
        }

        


    }

    
}
