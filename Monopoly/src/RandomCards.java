import java.util.ArrayList;
import java.util.Random;

public class RandomCards {
    private static ArrayList <Chance> chanceCards;
    private static ArrayList <Chance> chanceCardsLeft;
    private static ArrayList <CommunityChest> communityChestCards;
    private static ArrayList <CommunityChest> communityChestCardsLeft;

    public RandomCards(){
        chanceCards = new ArrayList<>();
        chanceCards.add(new Chance("Advance to the nearest railroad. \nIf unowned, you may buy it from the bank.\nIf owned, pay owner twice the rent.",3));
        chanceCards.add(new Chance("Advance to the nearest railroad. \nIf unowned, you may buy it from the bank.\nIf owned, pay owner twice the rent.",3));
        chanceCards.add(new Chance("Advance to GO.\n(Collect $"+ Player.getPassGo() +")",1,0,true));
        chanceCards.add(new Chance("Advance to Illinois Ave.",1,24,false));
        chanceCards.add(new Chance("Advance to nearest Utility.\n If unowned, you may buy it from the Bank.\n If owned, throw dice and pay owner a total ten times the amount thrown.",4));
        chanceCards.add(new Chance("Advance to St. Charles Place.\nIf you pass Go, collect $"+ Player.getPassGo() + ".",1,11,true));
        chanceCards.add(new Chance("Bank pays you dividend of $50.",2,50));
        chanceCards.add(new Chance("Go back 3 spaces.",6));
        chanceCards.add(new Chance("Go directly to Jail.\nDo not pass Go, do not collect $"+ Player.getPassGo() + ".",1,10,false));
        chanceCards.add(new Chance("Make general repairs on all your property.\nFor each house pay $25.\n For each hotel $100.",7));
        chanceCards.add(new Chance("Pay poor tax of $15.",2,15));
        chanceCards.add(new Chance("Take a trip to Reading Railroad.\n If you pass Go collect $"+ Player.getPassGo() + ".",1,5,true));
        chanceCards.add(new Chance("Take a walk on the Boardwalk.\nAdvance token to Boardwalk.",1,39,false));
        chanceCards.add(new Chance("You have been elected chairman of the board.\nPay each player $50.",8));
        chanceCards.add(new Chance("Your building loan matures.\nCollect $150.",2,150));
        chanceCards.add(new Chance("You won a raffle.\nCollect $100.",2,100));
        chanceCardsLeft = chanceCards;

        communityChestCards = new ArrayList<>();
        communityChestCards.add(new CommunityChest("Advance to GO.\n(Collect $"+ Player.getPassGo() +")",1,0,true));
        communityChestCards.add(new CommunityChest("Bank error in your favor.\nCollect $75.",2,75));
        communityChestCards.add(new CommunityChest("Doctor's fees.\nPay $50.",2,-50));
        communityChestCards.add(new CommunityChest("Go to jail.\nGo directly to jail.\nDo not pass GO, do not collect $"+ Player.getPassGo() + ".",1,0,false));
        communityChestCards.add(new CommunityChest("It is your birthday.\nCollect $10 from each player.",3,10));
        communityChestCards.add(new CommunityChest("Grand Opera Night.\nCollect $50 from every player for opening night seats.",3,50));
        communityChestCards.add(new CommunityChest("Income Tax refund.\nCollect $20.",2,20));
        communityChestCards.add(new CommunityChest("Life Insurance Matures.\nCollect $100.",2,100));
        communityChestCards.add(new CommunityChest("Pay Hospital Fees of $100.",2,-100));
        communityChestCards.add(new CommunityChest("Pay School Fees of $50.",2,-50));
        communityChestCards.add(new CommunityChest("Receive $25 Consultancy Fee.",2,25));
        communityChestCards.add(new CommunityChest("You are assessed for street repairs.\n$40 per house, $115 per hotel.",5));
        communityChestCards.add(new CommunityChest("You have won second prize in a beauty contest.Collect $10.",2,10));
        communityChestCards.add(new CommunityChest("You inherit $100.",2,100));
        communityChestCards.add(new CommunityChest("From sale of stock you get $50.",2,50));
        communityChestCards.add(new CommunityChest("Holiday Fund matures.\nReceive $100",2,100));
        communityChestCardsLeft = communityChestCards;
    }
    public static Chance getRandomChance(){
        checkChanceDeck();
        Random rand = new Random();
        int g = rand.nextInt(chanceCardsLeft.size());
        Chance temp = chanceCardsLeft.get(g);
        return temp;
    }
    public static void checkChanceDeck(){
        if(chanceCardsLeft.size() <= 1){
            chanceCardsLeft = chanceCards;
        }
    }
    public static CommunityChest getRandomChest(){
        checkChestDeck();
        Random rand = new Random();
        int g = rand.nextInt(communityChestCardsLeft.size());
        CommunityChest temp = communityChestCardsLeft.get(g);
        return temp;
    }
    public static void checkChestDeck(){
        if(communityChestCardsLeft.size() <= 1){
            communityChestCardsLeft = communityChestCards;
        }
    }
}
