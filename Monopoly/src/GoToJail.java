public class GoToJail extends Space  implements Landed{

    public void landedOn(Player temp)throws InterruptedException{
        temp.setInJail(true);
    }
    public String getName() {
        return "Go To Jail";
    }

    public String toString(){
        return "You are on Go To Jail.";
    }

}

