public class Space {
    private String name;
    private Player owner;
    private int spaceNumber;
    public Space(){

    }
    public Space(String spaceName, int spaceNum){
        name = spaceName;
        Player noOne = new Player("no one",0);
        owner = noOne;
        spaceNumber = spaceNum;
    }
    public String getName(){
        return name;
    }
    public Player getOwner(){
        return owner;
    }
    public String getOwnerName(){
        return owner.getName();
    }
    public void changeOwner(Player temp){
        owner = temp;
    }
    public String toString(){
        return("You are on " + name);
    }
    public void landedOn(Player temp)throws InterruptedException{

    }
    public void setMortgaged(boolean set){

    }
    public boolean isMortgaged(){
        return false;
    }
    public int getMortgage(){
        return 0;
    }
    public int getSpaceNumber(){
        return spaceNumber;
    }
}
