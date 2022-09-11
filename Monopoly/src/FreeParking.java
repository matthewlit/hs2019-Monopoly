public class FreeParking extends Space  implements Landed{
    private static int jackpot;
    private static boolean taxes;
    public FreeParking(){
        jackpot = 0;
        taxes = false;
    }
    public String getName(){
        return "Free parking";
    }
    public void landedOn(Player temp){
        temp.changeMoney(jackpot);
        if(taxes == true)
            jackpot = 0;
    }
    public static void addMoney(int amount){
        if(taxes == true)
            jackpot += amount;
    }
    public static void setTaxes(boolean x, int h){
        taxes = x;
        if(taxes == false)
            jackpot = h;
    }
    public String toString(){
        return("Free Parking: $" + jackpot);
    }

}


