package JavaBeanForest;

import java.util.Random;
public class Troll extends Enemy
{
	String weaponStr;
	static Random generator = new Random();
	public Troll()
	{
		setType("Troll");
		int armorNum = generator.nextInt();	//generate n set random int 1 - 3 to armor
		armorNum = Math.abs(armorNum % 3) + 1;
		setArmor(armorNum);
		
		int weaponGen = generator.nextInt();	//generate n set random int 1-3 to weapon
		weaponGen = Math.abs(weaponGen % 3) + 1;
		setWeapon(weaponGen);
		toString(); //to init weaponStr;
	}
	
	public String toString()
	{
		switch (weapon)
		{
			case 1: weaponStr = "Short Sword";
				break;
			case 2: weaponStr = "Spear";
				break;
			case 3: weaponStr = "Staff";
				break;
			default: weaponStr = "none!";
		}
		
		String armorStr;
		switch (armor)
		{
			case 1: armorStr = "Metal Armor"; armorType = 1;
				break;
			case 2: armorStr = "Rags"; armorType = 0;
				break;
			case 3: armorStr = "Wooden Shield"; armorType = 1;
				break;
			default: armorStr = "none!"; armorType = 0;
		}
		
		String stats = ( "Troll \n is equipped with "
				+ armorStr + " , \n is weilding a " + weaponStr + " , \n and has "
				+ health + " health!");
		return stats;
	}
	
	public int fight()
	{
		Random makeRando = new Random();
		int rando = makeRando.nextInt();
		if (weapon == 1)
		{
			rando = Math.abs(rando % 3) + 5;
		}
		if (weapon == 2)
		{
			rando = Math.abs(rando % 10) + 5;
		}
		if (weapon == 3)
		{
			rando = Math.abs(rando % 5) + 2;
		}
		return rando;
	}
	
	public String combatText()
	{
		String text = "Troll weilding " + weaponStr +" delivers: ";
		return text;
	}
}
