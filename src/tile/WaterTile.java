package tile;

import java.util.Random;

import event.Event;
import event.FindItem;
import event.SpawnWaterMonster;
import javafx.scene.paint.Color;

public class WaterTile extends Tile implements Stepable{

	private static double chanceOfItemEncounter = 0.0;//0.2;
	private static double chanceOfCreatureEncounter = 1.0;//0.1;
	private static Color defaultColor = Color.DARKORANGE;//Color.BLUE;
	
	
	public WaterTile(int x,int y) {
		super(x, y, defaultColor);
	}
	public WaterTile(int x, int y, String iconPath){
		super(x, y, iconPath);
	}

	@Override
	public Event onStep() {
		System.out.println("Water tile");
		Random r = new Random();
		double chance = r.nextDouble();
		if (chance <= chanceOfItemEncounter){
			return new FindItem(super.calculateRarity());
		} else if (chance <= chanceOfCreatureEncounter + chanceOfItemEncounter){ //account for full probability
			return new SpawnWaterMonster();
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " Water";
	}
}
