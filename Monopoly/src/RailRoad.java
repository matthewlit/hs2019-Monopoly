public class RailRoad extends Space {
    private int mortgage;
    private boolean mortgaged;
    private int price;

    public RailRoad(String name, int spaceNum) {
        super(name, spaceNum);
        mortgage = 75;
        price = 200;
        mortgaged = false;

    }
    public void landedOn(Player temp, boolean twice)throws InterruptedException{
        if(temp instanceof AI){

        }
        if (!super.getOwnerName().equals("no one")) {
            if(!super.getOwnerName().equals(temp.getName())) {
                chargeRent(temp,twice);
            }
        }
        else{
            int choice;
            choice = temp.calculateBuyProperty(price);
            if(choice == 1){
                temp.changeMoney(-1 * price);
                temp.printMoney();
                changeOwner(temp);
                temp.buyProperty(this);
                Thread.sleep(100);
                System.out.println(temp.getName() + " bought " + super.getName() + " for " + price );
            }
        }
    }
    public void chargeRent(Player temp, boolean twice)throws  InterruptedException {
        //Checks if property is owned or if the player that landed on it already owns it
        int multiplier = 1;
        if(twice == true){
            multiplier = 2;
        }
        int ownedRails = 0;
        for(int i = 5; i < 40; i += 10){
            if (Properties.getSpace(i).getOwner().equals(super.getOwner())) ;
            ownedRails++;
        }
        if(twice == false) {
            if (ownedRails == 1) {
                temp.changeMoney(-1 * 25 * multiplier);
                super.getOwner().changeMoney(25 * multiplier);
                Thread.sleep(100);
                System.out.println(temp.getName() + " paid $" + 25 * multiplier + " in rent to " + getOwnerName() + ".");
            }
            if (ownedRails == 2) {
                temp.changeMoney(-1 * 50 * multiplier);
                super.getOwner().changeMoney(50 * multiplier);
                Thread.sleep(100);
                System.out.println(temp.getName() + " paid $" + 50 * multiplier + " in rent to " + getOwnerName() + ".");
            }
            if (ownedRails == 3) {
                temp.changeMoney(-1 * 100 * multiplier);
                super.getOwner().changeMoney(100 * multiplier);
                System.out.println(temp.getName() + " paid $" + 100 * multiplier + " in rent to " + getOwnerName() + ".");
            }
            if (ownedRails == 4) {
                temp.changeMoney(-1 * 200 * multiplier);
                super.getOwner().changeMoney(200 * multiplier);
                Thread.sleep(100);
                System.out.println(temp.getName() + " paid $" + 200 * multiplier + " in rent to " + getOwnerName() + ".");
            }
        }
    }
    public int getMortgage(){
        return mortgage;
    }
    public void setMortgaged(boolean set){
        mortgaged = set;
    }
    public boolean isMortgaged(){
        return mortgaged;
    }
    public void changeOwner(Player temp) {
        super.changeOwner(temp);
    }
    public String getName(){
        if(mortgaged == true)
            return super.getName() + " (Mortgaged)";
        return super.getName();
    }
}
