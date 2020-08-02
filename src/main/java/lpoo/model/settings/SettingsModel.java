package lpoo.model.settings;

import lpoo.model.Configuration;
import lpoo.model.Model;

import java.util.ArrayList;

public class SettingsModel implements Model {
    public final static int MIN_SIZE = 6;
    public final static int MAX_SIZE = 36;

    public enum Option {DIF, HEIGHT, WIDTH, BACK}                                           //Enum used to avoid typing errors

    public String[] optString = {"DIFFICULTY", "BOARD HEIGHT", "BOARD WIDTH", "GO BACK"};   //get the string associated to the enumerator

    private ArrayList<Fields> fields;
    Fields selectedField;
    Configuration configuration;
    SettingsModel.Option selected;
    SettingsModel.Option[] opt = SettingsModel.Option.values();


    public Configuration getConfiguration() {
        return configuration;
    }

    public SettingsModel(Configuration configuration) {
        this.selected = Option.DIF;

        selectedField = new DifficultyField(configuration);
        this.configuration = configuration;
        fields = new ArrayList<>();
        fields.add(new DifficultyField(configuration));
        fields.add(new HeightField(configuration));
        fields.add(new WidthField(configuration));
        fields.add(new BackField(configuration));
    }

    public SettingsModel.Option getSelected() {
        return selected;
    }

    public Fields getSelectedField() {
        return selectedField;
    }

    public void incrementField() {
        selectedField.increment();
    }

    public void decrementField() {
        selectedField.decrement();
    }

    public int getPosElem(SettingsModel.Option target) {
        int i = 0;
        for (; opt[i] != target; i++) ;
        return i;
    }

    public String enumToString(SettingsModel.Option menuOption) {
        int position = getPosElem(menuOption);
        return optString[position];
    }

    public void nextSelected() {
        if (selected == Option.BACK) {
            selected = Option.DIF;
            selectedField = fields.get(0);
        } else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i++;
            selected = opt[i];
            selectedField = fields.get(i % fields.size());
        }
    }

    public void previousSelected() {
        if (selected == Option.DIF) {
            selected = Option.BACK;
            selectedField = fields.get(3);
        } else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i--;
            selected = opt[i];
            selectedField = fields.get(i % fields.size());
        }
    }
}
