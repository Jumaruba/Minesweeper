package lpoo.model.settings;

import lpoo.model.Configuration;

import static lpoo.model.settings.SettingsModel.MAX_SIZE;
import static lpoo.model.settings.SettingsModel.MIN_SIZE;

public class HeightField extends Fields {

    public HeightField(Configuration configuration) {
        super(configuration);
    }

    public void increment() {
        int height = configuration.getGameHeight();
        if (height + 1 <= MAX_SIZE)
            configuration.setGameHeight(height + 1);
    }

    public void decrement() {
        int height = configuration.getGameHeight();
        if (height - 1 >= MIN_SIZE)
            configuration.setGameHeight(height - 1);
    }
}
