/**
 * The Action class contains nested classes representing actions related to character combat.
 */
class Action {
    private static boolean isDefend = false;

    /**
     * The Defend class represents defending actions taken by characters.
     */
    static class Defend {
        Character defender;

        public Defend(Character defender) {
            this.defender = defender;
        }

        /**
         * Method to perform defense during an attack.
         *
         * @return Whether the defense action was successful.
         */
        public boolean defendAttack() {
            return isDefend = true;
        }
    }

    /**
     * The Attack class represents actions related to character attacks.
     */
    static class Attack {
        Character attacker;
        Character defender;
        int damage;
        int shield;
        int hp;

        public Attack(Character attacker, Character defender) {
            this.attacker = attacker;
            this.defender = defender;
            this.damage = attacker.getDamage();
            this.hp = defender.getHp();
            this.shield = defender.getShield();
        }

        /**
         * Method to calculate and apply damage during an attack.
         *
         * @param damage The amount of damage to be inflicted.
         */
        public void takeDamage(int damage) {
            hp = hp - damage;
            if (isDefend) {
                if (shield - damage <= 0) {
                    hp = hp + shield;
                    defender.setHp(hp);
                    defender.setShield(0);
                    if (hp <= 0) {
                        defender.setHp(0);
                    }
                } else {
                    shield = shield - damage;
                    defender.setShield(shield);
                }
            } else {
                if (hp <= 0) {
                    defender.setHp(0);
                } else {
                    defender.setHp(hp);
                }
            }
        }

        /**
         * Method to execute an attack and apply damage to the defender.
         */
        public void executeAttack() {
            takeDamage(damage);
        }
    }
}
