import java.util.*;
public class Properties  {
    private static ArrayList <Space> spaces;
    public Properties(){
        spaces = new ArrayList<>();
        /* 0 */ spaces.add(new Space("GO", 0));
        /* 1 */ spaces.add(new Property("Mediterranean Avenue", 60 ,2,  10, 30, 90, 160, 250, 50, 1));
        /* 2 */ spaces.add(new CommunityChest());
        /* 3 */ spaces.add(new Property("Baltic Avenue", 60, 4, 20, 60, 180, 320, 450, 50, 3));
        /* 4 */ spaces.add(new Tax("Income tax", 200, 4));
        /* 5 */ spaces.add(new RailRoad("Reading Railroad", 5));
        /* 6 */ spaces.add(new Property("Oriental Avenue",100,6, 30, 90, 270, 400, 550, 50, 6));
        /* 7 */ spaces.add(new Chance());
        /* 8 */ spaces.add(new Property("Vermont Avenue", 100, 6, 30, 90, 270, 400, 550, 50, 8));
        /* 9 */ spaces.add(new Property("Connecticut Avenue", 120, 8, 40, 100, 300, 450, 600, 50, 9));
        /* 10 */spaces.add(new Jail());
        /* 11 */spaces.add(new Property("St. Charles Place", 140, 10,50, 150, 450, 625, 750, 100, 11));
        /* 12 */spaces.add(new Utility("Electric Company", 12));
        /* 13 */spaces.add(new Property("States Avenue", 140, 10,  50, 150, 450, 625, 750, 100, 13));
        /* 14 */spaces.add(new Property("Virginia Avenue", 160, 12,  60, 180, 500, 700, 900, 100,14));
        /* 15 */spaces.add(new RailRoad("Pennsylvania Railroad", 15));
        /* 16 */spaces.add(new Property("St. James Place", 180, 14,  70, 200, 550, 750, 950, 100, 16));
        /* 17 */spaces.add(new CommunityChest());
        /* 18 */spaces.add(new Property("Tennessee Avenue", 180, 14, 70, 200, 550, 750, 950, 100, 18));
        /* 19 */spaces.add(new Property("New York Avenue", 200, 16, 800, 220, 600, 800, 1000, 100, 19));
        /* 20 */spaces.add(new FreeParking());
        /* 21 */spaces.add(new Property("Kentucky Avenue", 220, 18, 90, 250, 700, 875, 1050, 150, 21));
        /* 22 */spaces.add(new Chance());
        /* 23 */spaces.add(new Property("Indiana Avenue", 220, 18, 90, 250, 700, 875, 1050, 150, 23));
        /* 24 */spaces.add(new Property("Illinois Avenue", 240, 20,100,300,750,925,1100, 150, 24));
        /* 25 */spaces.add(new RailRoad("B.&O. Railroad", 25));
        /* 26 */spaces.add(new Property("Atlantic Avenue", 260, 22,110,330,800,975,1150, 150, 26));
        /* 27 */spaces.add(new Property("Ventor Avenue", 260, 22,110,330,800,975,1150, 150, 27));
        /* 28 */spaces.add(new Utility("Water Works", 28));
        /* 29 */spaces.add(new Property("Marvin Gardens", 280, 24, 120, 360, 850, 1025, 1200, 150, 29));
        /* 30 */spaces.add(new GoToJail());
        /* 31 */spaces.add(new Property("Pacific Avenue", 300, 26,130, 390, 900, 1100, 1275, 200, 31));
        /* 32 */spaces.add(new Property("North Carolina Avenue", 300, 26,130, 390, 900, 110, 1275, 200, 32));
        /* 33 */spaces.add(new CommunityChest());
        /* 34 */spaces.add(new Property("Pennsylvania Avenue", 320, 28, 150, 450, 1000, 1200, 1400, 200, 34));
        /* 35 */spaces.add(new RailRoad("Short Line", 35));
        /* 36 */spaces.add(new Chance());
        /* 37 */spaces.add(new Property("Park Place", 350, 35, 175, 500, 1100, 1300, 1500, 200, 37));
        /* 38 */spaces.add(new Tax("Luxury Tax", 100, 38));
        /* 39 */spaces.add(new Property("Boardwalk", 500, 50, 200, 600, 1400, 1700, 2000, 200, 39));

    }
    public static Space getSpace(int space){
        return spaces.get(space);
    }
}
