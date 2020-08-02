package lpoo.model.settings;

import lpoo.model.Configuration;

import static lpoo.model.settings.SettingsModel.MAX_SIZE;
import static lpoo.model.settings.SettingsModel.MIN_SIZE;

public class WidthField extends Fields {


    public WidthField(Configuration configuration) {
        super(configuration);
    }

    public void increment() {
        int width = configuration.getGameWidth();
        if (width + 1 <= MAX_SIZE)
            configuration.setGameWidth(width + 1);
    }

    public void decrement() {
        int width = configuration.getGameWidth();
        if (width - 1 >= MIN_SIZE)
            configuration.setGameWidth(width - 1);
    }

}
