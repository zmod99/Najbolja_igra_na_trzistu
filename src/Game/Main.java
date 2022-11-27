
package Game;

import Game.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           //Creating a new object of class Scanner and I'm passing on system input to that object
        Avatar yourAvatar = new Avatar();                    // new Avatar object
        Avatar wolf = new Avatar();
        wolf.agility = 8;
        wolf.defense = 5;
        wolf.damage = 18;
        wolf.health = 100;
        wolf.armor = 6;                                    //just assigning some combat stats to my game characters or Avatar class objects
        wolf.level = 1;
        wolf.animal = "wolf";

        Avatar bear = new Avatar();
        bear.agility = 3;
        bear.defense = 5;
        bear.damage = 48;
        bear.health = 100;
        bear.armor = 8;
        bear.level = 1;
        bear.animal = "bear";

        Avatar lizard = new Avatar();
        lizard.agility = 9;
        lizard.defense = 2;
        lizard.damage = 6;
        lizard.health = 100;
        lizard.armor = 4;
        lizard.level = 1;
        lizard.animal = "lizard";

        Avatar rat = new Avatar();
        rat.agility = 9;
        rat.defense = 5;
        rat.damage = 7;
        rat.health = 100;
        rat.armor = 2;
        rat.level = 1;
        rat.animal = "rat";

        while (yourAvatar.health == 0) {
            yourAvatar = Menu.showMenu1(yourAvatar, wolf, bear, lizard, rat); //sprema mi izabrani pick avatara
        }
        while (!Menu.showMenu3(yourAvatar, wolf, bear, lizard, rat) ){

        }
    }


}

