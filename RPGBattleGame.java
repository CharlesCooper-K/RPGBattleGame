package rpg;

import java.util.Scanner;

public class RPGBattleGame {
	public static void main(String[] args) {
		// initialize and declare variables
		int choice1, choice2, battleChoice;
		int attack = 0; 
		int defense = 0;
		String name = "";
		int potion = 3;
		Player player = new Player(name, 100, attack, defense);
		Enemy enemy = new Enemy("Dort", 100, 10, 10);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please create your player");
		System.out.print("Enter your name: ");
		name = input.next();
		player.setName(name);
		System.out.println("Choose your attack and defensive stats.\n1. 25 Attack Power/10 Defense\n2. 15 Attack Power/5 Defense\n"
				+ "3. 10 Attack Power/10 Defense\n4. 30 Attack Power/0 Defense");
		System.out.print("Choose an option: ");
		choice2 = input.nextInt();
		
		switch (choice2) {
		case 1:
			attack = 25;
			player.setAttackPow(attack);
			defense = 10;
			player.setDefense(defense);
			break;
			
		case 2:
			attack = 15;
			player.setAttackPow(attack);
			defense = 5;
			player.setDefense(defense);
			break;
			
		case 3:
			attack = 10;
			player.setAttackPow(attack);
			defense = 10;
			player.setDefense(defense);
			break;
			
		case 4:
			attack = 30;
			player.setAttackPow(attack);
			defense = 0;
			player.setDefense(defense);
			break;
		}
		
		do {
			System.out.println("===== RPG BATTLE =====");
			System.out.println("1. Fight\n2. Use Potion\n3. View Stats\n4. Run Away\n");
			System.out.print("\nChoose an option: ");
			choice1 = input.nextInt();
			
			switch (choice1) {
			case 1:
				do {
					System.out.println("===== BATTLE =====");
					System.out.printf("Player HP: %d%nEnemy HP: %d%n", player.getHealth(), enemy.getHealth());
					System.out.print("\n1. Attack\n2. Use Potion\n3. Run\nChoose an option: ");
					battleChoice = input.nextInt();
					
					switch (battleChoice) {
					case 1:
						System.out.printf("%s attacked!%n", player.getName());
						int rawPower = player.getAttackPow();
						int enemyDefense = enemy.getDefense();
						
						int damageDealt = rawPower - enemyDefense;
						if (damageDealt < 1) {
							damageDealt = 1;
						}
						
						enemy.takeDamage(damageDealt);
						System.out.printf("%s took %d damage!%nHealth is now %d%n", enemy.getName(), damageDealt, enemy.getHealth());
						
						if (!enemy.isDefeated()) {
							System.out.printf("%s attacks!%n", enemy.getName());
							int enemyPower = enemy.getAttackPow();
							int playerDefense = player.getDefense();
							
							int damageTaken = enemyPower - playerDefense;
							if (damageTaken < 1) {
								damageTaken = 1;
							}
							
							player.takeDamage(damageTaken);
							System.out.printf("%s took %d damage!%nHealth is now %d%n", player.getName(), damageTaken, player.getHealth());
						}				
						break;
						
					case 2:
						// check to make sure there are still potions available
						if (potion > 0) {
							player.usePotion();
							potion--;
							
							 System.out.printf("Your health is now %d", player.getHealth());
						} else {
							System.out.println("No more potions.");
						}
					break;
			
					case 3:
						System.out.println("You have successfully ran away.");
						break;
						
					default:
						System.out.println("Invalid choice");
						} 
					} while (battleChoice != 3 && !enemy.isDefeated() && player.getHealth() > 0);
				
				if (enemy.isDefeated()) {
					System.out.printf("%s defeated %s", player.getName(), enemy.getName());
				} else if (player.getHealth() < 1) {
					System.out.printf("%s was defeated in battle", player.getName());
				}
				
				break;
				
			case 2:
				if (potion > 0) {
					System.out.println("You have used a potion.");
					player.usePotion();
					potion--;
					
					System.out.printf("Your health is now %d", player.getHealth());
				} else {
					System.out.println("There are no more potions.");
				}
				
				break;
				
			case 3:
				System.out.println("===== Player Stats =====");
				System.out.printf("Name: %s%nHealth: %d%nAttack Power: %d%nDefense: %d%n", 
						player.getName(), player.getHealth(), player.getAttackPow(), player.getDefense());
				break;
				
			case 4:
				System.out.println("You've escaped!");
				break;
				
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice1 != 4);
		System.out.println("Thank you for playing!");
	}
}