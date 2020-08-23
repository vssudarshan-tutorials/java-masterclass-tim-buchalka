import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    String monsterName;
    StatValues statValues;

    public Monster() {
        this.monsterName = "";
        this.statValues = new StatValues();
    }

    @Override
    public List<String> saveData() {
        List<String> statValuesArrayList = new ArrayList<>();
        statValuesArrayList.add(0, monsterName);
        statValuesArrayList.add(1, String.valueOf(statValues.level));
        statValuesArrayList.add(2, String.valueOf(statValues.healthPoints));
        statValuesArrayList.add(3, String.valueOf(statValues.manaPoints));
        statValuesArrayList.add(4, String.valueOf(statValues.strength));
        statValuesArrayList.add(5, String.valueOf(statValues.agility));
        statValuesArrayList.add(6, String.valueOf(statValues.intelligence));

        return statValuesArrayList;
    }

    @Override
    public void loadData(List<String> statValuesArrayList) {
        if (statValuesArrayList != null) {
            monsterName = statValuesArrayList.get(0);
            statValues.level = Integer.parseInt(statValuesArrayList.get(1));
            statValues.healthPoints = Integer.parseInt(statValuesArrayList.get(2));
            statValues.manaPoints = Integer.parseInt(statValuesArrayList.get(3));
            statValues.strength = Integer.parseInt(statValuesArrayList.get(4));
            statValues.agility = Integer.parseInt(statValuesArrayList.get(5));
            statValues.intelligence = Integer.parseInt(statValuesArrayList.get(6));
        }
    }

}
