package lpoo.model.settings;

import lpoo.model.Configuration;


public class DifficultyField extends Fields {
    Configuration.Difficulty[] dif = Configuration.Difficulty.values();

    public DifficultyField(Configuration configuration) {
        super(configuration);
    }

    public void increment() {
        Configuration.Difficulty difficulty = configuration.getDifficulty();
        if (difficulty == Configuration.Difficulty.HARD)
            configuration.setDifficulty(Configuration.Difficulty.EASY);
        else {
            //find the position of this.selected in the opt array
            int i = 0;
            for (; dif[i] != difficulty; i++) ;
            i++;
            configuration.setDifficulty(dif[i]);
        }
    }

    public void decrement() {
        Configuration.Difficulty difficulty = configuration.getDifficulty();
        if (difficulty == Configuration.Difficulty.EASY)
            configuration.setDifficulty(Configuration.Difficulty.HARD);
        else {
            //find the position of this.selected in the opt array
            int i = 0;
            for (; dif[i] != difficulty; i++) ;
            i--;
            configuration.setDifficulty(dif[i]);
        }
    }

}
