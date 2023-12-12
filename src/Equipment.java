/**
 * Equipment class represents various types of in-game equipment including swords, 
 * shields, daggers, wands, and accessories.
 */
class Equipment {
    //ประกาศค่าต่างๆเอาไว้ใช้ในคลาส
    private String name;    
    private String type;    
    private int level;
    private int reducesDamage;
    private int damage;
    private int weight;
    private int bonusHp;
    private int bonusSpeed;
    private int bonusMana;

     /**
     * Constructor to create an Equipment object with specified characteristics.
     *
     * @param type The type of equipment ("sword," "shield," "dagger," or "wand").
     * @param name The name of the equipment.
     * @param level The level of the equipment.
     * @param dmgOrRdmg The damage or damage reduction of the equipment.
     * @param weight The weight of the equipment.
     * @param bonusHp The bonus hit points provided by the equipment.
     * @param bonusSpeed The bonus speed provided by the equipment.
     * @param bonusMana The bonus mana provided by the equipment.
     *
     * Preconditions:
     * - The type parameter must be a non-null and non-empty string representing the type of equipment.
     * - The name parameter must be a non-null and non-empty string representing the name of the equipment.
     * - The level parameter must be a non-negative integer representing the level of the equipment.
     * - The dmgOrRdmg parameter must be a non-negative integer representing either the damage or damage reduction.
     * - The weight parameter must be a non-negative integer representing the weight of the equipment.
     * - The bonusHp, bonusSpeed, and bonusMana parameters must be non-negative integers.
     *
     * Postconditions:
     * - An Equipment object is created with the specified characteristics.
     * - The name, type, level, damage, reducesDamage, weight, bonusHp, bonusSpeed, and bonusMana fields are appropriately initialized.
     *
     * Side Effects:
     * - The state of the Equipment object is modified.
     */

    //โดยการสร้างอุปกรณ์จะเป็นการเรียกใช้ฟังก์ชั่นมาใช้สร้างเลยเพื่อประหยัดเวลาไม่ต้องเขียนโค้ดซ้ำๆเยอะๆ
    // weapon -อาวุธ มี3ชนิด ดาบ มีด คทา
    public static Equipment W001 = new Equipment("Sword", "Wooden Sword", 1, 10, 20, 0, 0, 0);
    public static Equipment W002 = new Equipment("Sword", "Iron Sword", 1, 15, 25, 0, 0, 0);
    public static Equipment W003 = new Equipment("Dagger", "Obsidian Dagger", 1, 69, 40, 0, 0, 0);
    public static Equipment W004 = new Equipment("Wand", "Evil Bone Wand", 1, 70, 50, 0, 0, 50);
    
    // shield -โล่
    public static Equipment S001 = new Equipment("Shield", "Wooden Shield", 1, 5, 15, 0, 0, 0);
    public static Equipment S002 = new Equipment("Shield", "Iron Shield", 1, 10, 20, 0, 0, 0);
    public static Equipment S003 = new Equipment("Shield", "Book of OOP", 1, 10, 50, 0, 0, 0);
    
    // accessory - มีแหวน
    public static Equipment A001 = new Equipment("Accessory", "Ring of Strength", 1, 0, 1, 50, 0, 0);
    public static Equipment A002 = new Equipment("Accessory", "Ring of Speed", 1, 0, 1, 0, 20, 0);
    public static Equipment A003 = new Equipment("Accessory", "Ring of Mana", 1, 0, 1, 0, 0, 100);
    public static Equipment A004 = new Equipment("Accessory", "Ring of all", 1, 0, 1, 100, 20, 50);    

    // create equipment
    public Equipment(String type, String name, int level, int dmgOrRdmg, int weight, int bonusHp, int bonusSpeed, int bonusMana) {
        this.name = name;
        this.level = level;
        this.type = type.toLowerCase();
        
        if(this.type.equals("sword") || this.type.equals("dagger") || this.type.equals("wand")){
            this.damage = dmgOrRdmg * (2 + level);
        }
        if(this.type.equals("shield")){
            this.reducesDamage = dmgOrRdmg + (3 * level);
        }
        this.weight = weight;
        this.bonusHp = bonusHp;
        this.bonusSpeed = bonusSpeed;
        this.bonusMana = bonusMana;
    }

      /**
     * Get the type of the equipment.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - Returns a string representing the type of the equipment.
     *
     * Side Effects:
     * - None
     */
    public String  getType(){return type;} 
    public int getWeight(){return weight;}
    public int getDamage(){return damage;}
    public int getBonusHp() {return bonusHp;}
    public int getBonusSpeed(){return bonusSpeed;}
    public int getBonusMana() {return bonusMana;}
    public double getReduceDamage(){return reducesDamage;}

    // Methods for retrieving various characteristics of the equipment...
    /**
     * Print information about the equipment based on its type.
     *
     * Preconditions:
     * - None
     *
     * Postconditions:
     * - Outputs information about the equipment to the console.
     *
     * Side Effects:
     * - Prints information to the console.
     */
    
    public void getWeaponInfo(){
        if("sword".equals(type)){
            System.out.println("Name: " + name + "\tLevel: " + level + "\tDamage: " 
            + damage + "\tWeight: " + weight);
        }
        if("shield".equals(type)){
            System.out.println("Name: " + name + "\tLevel: " + level + "\tReduces Damage: " 
            + reducesDamage + "\tWeight: " + weight);
        }
        if("dagger".equals(type) || "wand".equals(type) || "accessory".equals(type)){
            System.out.println("Name: " + name + "\tLevel: " + level + "\tDamage: " 
            + damage + "\tWeight: " + weight + "\tBounsHp: " + bonusHp + "\tBounsSpeed: " + bonusSpeed + "\tBonseMana: " + bonusMana);
        }
    }
}