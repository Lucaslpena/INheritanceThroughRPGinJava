package JavaBeanForest;

import java.util.Random;
public class Sorcerer extends Enemy
{
	String weaponStr;
	static Random generator = new Random();
	public Sorcerer()
	{
		setType("Sorcerer");
		int armorNum = generator.nextInt();	//generate n set random int 1 - 4 to armor
		armorNum = Math.abs(armorNum % 4) + 1;
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
			case 1: weaponStr = "Fire Staff";
				break;
			case 2: weaponStr = "Ice Staff";
				break;
			case 3: weaponStr = "Thunder Staff";
				break;
			default: weaponStr = "none!";
		}
		
		String armorStr;
		switch (armor)
		{
			case 1: armorStr = "Metal Battle Robes"; armorType = 1;
				break;
			default: armorStr = "Cloth Robes";	armorType = 0;
		}
		
		String stats = ( "Sorcerer \n is equipped with "
				+ armorStr + " for armor, \n is weilding a " + weaponStr + " , \n and has "
				+ health + " health!");
		return stats;
	}
	
	public int fight()
	{
		Random makeRando = new Random();
		int rando = makeRando.nextInt();
		if (weapon == 1)
		{
			rando = Math.abs(rando % 6) + 10;
		}
		if (weapon == 2)
		{
			rando = Math.abs(rando % 20) + 1;
		}
		if (weapon == 3)
		{
			rando = Math.abs(rando % 15) + 5;
		}
		return rando;
	}
	
	public String combatText()
	{
		String text = "Sorcerer weilding " + weaponStr +" delivers: ";
		return text;
	}
}
