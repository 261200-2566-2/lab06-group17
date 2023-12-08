public class Main {
    public static void main(String[] args) {

    Character player1 = new Character("Somchai", "Female", "Novice");
    Character player2 = new Character("Sommark", "Male", "Novice");
    
    player1.equipWeapon(Equipment.W001);
    player1.equipAccessory(Equipment.A001, null);
    player2.equipWeapon(Equipment.W002);
    player2.equipAccessory(Equipment.A003, null);

    Action.Attack attack = new Action.Attack(player2, player1);
    Action.Defend defend = new Action.Defend(player1);
    player1.displayInfo();
    player2.displayInfo();

    defend.defendAttack();
    attack.executeAttack();
    player1.displayInfo();
    player2.displayInfo();

    }


}