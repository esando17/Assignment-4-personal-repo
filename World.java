public class World {
    //private properties because of convention 
    //Weather is the type of enum so its weather of type Weather(enum)
    private Weather weather;
    private String harvest;

    //first method needs to return a string
    public Weather getWeather(){
        return weather;
    }
    //first contructor, has parameters of weather
    public World(Weather weather){
        this.weather =  weather ; 
    }
    //setter 
    public void setWeather(Weather weather){
        this.weather = weather;
    }
    
    //methods, contructors, setter and getter for World.harvest
    public World(String harvest){
        this.harvest = harvest;
    }
    public String getHarvest(){
        return harvest;
    }
    public void setHarvest(String harvest){
        this.harvest = harvest; 
    }

}
