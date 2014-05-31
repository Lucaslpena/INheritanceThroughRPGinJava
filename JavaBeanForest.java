package JavaBeanForest;

import java.util.Scanner;
import java.util.Random;
public class JavaBeanForest {

	static Scanner input = new Scanner(System.in);
	static Random generator = new Random();
	public static void main(String[] args)
	{
		Knight myKnight = new Knight();
		System.out.println( "!Welcome to the Java Bean Forest!");
		System.out.println( "...OF DOOM!! \nLets see if your Knight can make it out alive!");
		
		String name;
		int healthNum;
		int weaponNum;
		int armorNum;
		
		int enemyNum = 0;
		int enemyDamage;
		int failure = 0;
		
		final int HIGHESTHEALTH = 100;
		
		int looper = 1;
		
		while(looper !=0)
		{
			System.out.printf( "Enter the Name of your Knight:" );	//read name
			name = input.next();
			
			myKnight.setName(name);
			
			healthNum = generator.nextInt();	//generate n set random int 1-100 to health
			healthNum = Math.abs(healthNum % HIGHESTHEALTH) + 1;
			myKnight.setHealth(healthNum);
			
			armorNum = generator.nextInt();	//generate n set random int 1 or 2 to armor
			armorNum = Math.abs(armorNum % 2) + 1;
			myKnight.setArmor(armorNum);
			
			do //run read function until valid data entered
			{
				weaponNum = weaponRead();
			}
			while (weaponNum == 0);
			
			myKnight.setWeapon(weaponNum);
			
			System.out.printf( "\nSo far...\n%s\nAre you happy with this? enter (n) if No, anything else if Yes: ", myKnight.toString() );
			String response = input.next();
			if (response.equals("n"))
			{
				System.out.printf( "Okay, lets try again my liege\n\n");
				continue;
			}
			looper--;
		}
		
		
		/*enemy count read in below*/
		System.out.printf( "\nHow many total enemies does " + myKnight.getName() + " think he can take on?!"
				+ "\nEnter a number:");
		enemyNum = input.nextInt();
		System.out.printf( "\nYou entered " + enemyNum + " total enemies to fight!\n");
		
		/*combat preparation below*/
		Enemy[] myEnemyList = new Enemy[enemyNum];
		for (int i = 0; i < enemyNum; ++i)
		{
			Enemy myEnemy = Enemy.getRandomEnemy();
			healthNum = generator.nextInt();	//generate n set random int 1-100 to health
			healthNum = Math.abs(healthNum % HIGHESTHEALTH) + 1;
			myEnemy.setHealth(healthNum);
			myEnemyList[i] = myEnemy;
		}
		System.out.printf("Because the Java Bean Forest is so dark your Knight: " + myKnight.getName() +  " always defends first!\n"
				+ "!!PREPARE FOR BATTLE!!\n\n");
		
		/*combat below*/ //**THIS IS 1-vs-1**// contains atleast 1 of the enemy 1/3 chance each time
		for (int i = 0; i < enemyNum; ++i)
		{
			if (i <enemyNum) //standard exception used here
			{
				try
				{
					throw new IndexOutOfBoundsException();
				}
				catch (IndexOutOfBoundsException e)
				{
					e.printStackTrace();
				}
			}
			
			int winner = 0; //0 for knight 1 for enemy
			System.out.printf("Enemy number " + (i+1) + " is:\n%s\n\n", myEnemyList[i].toString() );
			while ((myKnight.getHealth() > 0) && (myEnemyList[i].getHealth() > 0) )
			{
				/*defending round*/
				enemyDamage = myEnemyList[i].fight();
				System.out.printf("%s%d damage!!\n", myEnemyList[i].combatText(), enemyDamage );
				myKnight.takeDamage(enemyDamage);
				if (myKnight.getHealth() <= 0)
				{
					winner = 1;
					break;
				}
				System.out.printf("%s has %d health left!\n\n", myKnight.getName(), myKnight.getHealth());
				
				/*attacking round*/
				System.out.printf("%s attacks %s!\n", myKnight.getName(), myEnemyList[i].getType());
				enemyDamage = myKnight.fight();
				System.out.printf("%s%d damage!!\n", myKnight.combatText(), enemyDamage );
				//!! blades have 80% chance of extra .5 damage if attacking soft armor!![Knights only because they are trained in battle]//////////EXTRA CREDIT
				int rando1 = generator.nextInt();
				rando1 = Math.abs(rando1 % 5) + 1;
				if ((rando1 > 1) && (myEnemyList[i].getArmorType() == 0) && ((myKnight.getWeapon() == 1) || myKnight.getWeapon() == 3))
				{
					int half1 = (enemyDamage / 2);
					System.out.printf("\n%s has a bladed weapon and does an extra %d damage! "
							+ "because  %s  has soft armor!\n", myKnight.getName(), half1, myEnemyList[i].getType() );
					enemyDamage = enemyDamage + half1;
				}
				myEnemyList[i].takeDamage(enemyDamage);
				if (myEnemyList[i].getHealth() <= 0)
				{
					System.out.printf("%s has died!\n\n", myEnemyList[i].getType());
					break;
				}
				System.out.printf("%s has %d health left!\n\n", myEnemyList[i].getType(), myEnemyList[i].getHealth());
			}
			
			if (winner == 1)
			{
				failure = 1;
				break;
			}
			
			System.out.printf(myKnight.getName() +  " has won the battle! But only has " + myKnight.getHealth() + " health left!\n");
			
			if ((i+1) != enemyNum)
			{
				int rando = generator.nextInt();
				rando = Math.abs(rando % 5) + 1;
				if (rando > 1)
				{
					System.out.printf(myKnight.getName() +  " looted a heal potion of 25 health points!!\n");
					myKnight.setHealth(myKnight.getHealth() + 25);
					System.out.printf("and now has " + myKnight.getHealth() + " health points!!\n");
					
				}
				else
					System.out.printf(myKnight.getName() +  " did not get any loot from the batle.\n");
			}
		}
		
		if (failure == 1)
		{
			System.out.printf(myKnight.getName() +  " has died!!!! Thank you for playing!!");
		}
		else
		{
			System.out.printf(myKnight.getName() +  " has survived the Java Bean Forest!!!! Thank you for playing!!");
		}
		
	}


	public static int weaponRead() //method used to read in weapon select uses switch statement
	{
		System.out.printf( "Now select your weapon!  (Choose number)"
			+ "\n1) Long Sword "//damage 5-12 (possible crit on soft armor)
			+ "\n2) Battle Axe" //damage 8-11  
			+ "\n3) Spear"		//damage 0-18  (possible crit on soft armor)
			+ "\n4) Warhammer" 	//damage 0-25 
			+ "\nYour choice my liege?: " );
		int choice;
		choice = input.nextInt();
		switch (choice)
		{
			case 1: 
				System.out.println( "You have chosen 'Long Sword'");
				return 1;
			case 2: System.out.println( "You have chosen 'Battle Axe'");
				return 2;
			case 3: System.out.println( "You have chosen 'Spear'");
				return 3;
			case 4: System.out.println( "You have chosen 'Warhammer'");
				return 4;	
			default:System.out.println( "You have entered an incorrect weapon try again!");
				return 0;
		}
	}
	
}
