package JavaBeanForest;

import java.util.Random;
public class Ogre extends Enemy
{
	String weaponStr;
	static Random generator = new Random();
	public Ogre()
	{
		setType("Ogre");
		int armorNum = generator.nextInt();	//generate n set random int 1 or 2 to armor
		armorNum = Math.abs(armorNum % 2) + 1;
		setArmor(armorNum);
		
		int weaponGen = generator.nextInt();	//generate n set random int 1-4 to weapon
		weaponGen = Math.abs(weaponGen % 4) + 1;
		setWeapon(weaponGen);
		toString(); //to init weaponStr;
	}
	
	public String toString()
	{
		switch (weapon)
		{
			case 1: weaponStr = "Battle Axe";
				break;
			case 2: weaponStr = "Warhammer";
				break;
			case 3: weaponStr = "Club";
				break;
			case 4: weaponStr = "Tree Branch";
				break;
			default: weaponStr = "none!";
		}
		
		String armorStr;
		switch (armor)
		{
			case 1: armorStr = "Leather"; armorType = 0;
				break;
			case 2: armorStr = "Rags for"; armorType = 0;
				break;
			default: armorStr = "none!"; armorType = 0;
		}
		
		String stats = ( "Ogre \n is equipped with "
				+ armorStr + " armor, \n is weilding a " + weaponStr + " , \n and has "
				+ health + " health!");
		return stats;
	}
	
	public int fight()
	{
		Random makeRando = new Random();
		int rando = makeRando.nextInt();
		if (weapon == 1)
		{
			rando = Math.abs(rando % 3) + 8;
		}
		if (weapon == 2)
		{
			rando = Math.abs(rando % 25) + 1;
		}
		if (weapon == 3)
		{
			rando = Math.abs(rando % 5) + 12;
		}
		if (weapon == 4)
		{
			rando = Math.abs(rando % 5) + 3;
		}
		return rando;
	}
	
	public String combatText()
	{
		String text = "Ogre weilding " + weaponStr +" delivers: ";
		return text;
	}
}
