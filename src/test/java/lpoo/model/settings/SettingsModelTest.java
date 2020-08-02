package lpoo.model.settings;

import lpoo.model.Configuration;
import org.junit.Test;
import org.mockito.Mockito;

import static lpoo.model.settings.SettingsModel.Option.*;
import static lpoo.model.settings.SettingsModel.Option.HEIGHT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class SettingsModelTest {

    @Test
    public void nextSelected() {
        Configuration conf1 = Mockito.mock(Configuration.class);
        SettingsModel model1 = new SettingsModel(conf1);

        //DIF
        model1.nextSelected();
        assertSame(HeightField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.HEIGHT, model1.getSelected());

        //HEIGHT
        model1.nextSelected();

        assertSame(WidthField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.WIDTH, model1.getSelected());

        //WIDTH
        model1.nextSelected();
        assertSame(BackField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.BACK, model1.getSelected());
        //BACK
        model1.nextSelected();
        assertSame(DifficultyField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.DIF, model1.getSelected());
    }


    @Test
    public void previousSelected() {
        Configuration conf1 = Mockito.mock(Configuration.class);
        SettingsModel model1 = new SettingsModel(conf1);

        //DIF
        model1.previousSelected();
        assertSame(BackField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.BACK, model1.getSelected());

        //BACK
        model1.previousSelected();

        assertSame(WidthField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.WIDTH, model1.getSelected());

        //WIDTH
        model1.previousSelected();
        assertSame(HeightField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.HEIGHT, model1.getSelected());

        //BACK
        model1.previousSelected();
        assertSame(DifficultyField.class, model1.getSelectedField().getClass());
        assertSame(SettingsModel.Option.DIF, model1.getSelected());
    }

    @Test
    public void testNextSettings() {
        SettingsModel model = new SettingsModel(new Configuration(1, 1, Configuration.Difficulty.EASY));
        SettingsModel.Option actual = model.getSelected();
        assertEquals(DIF, actual);
        model.nextSelected();
        assertEquals(HEIGHT, model.getSelected());
        model.nextSelected();
        model.nextSelected();
        assertEquals(BACK, model.getSelected());
        model.nextSelected();
        assertEquals(actual, model.getSelected());
    }

    @Test
    public void testPreviousSettings() {
        SettingsModel model = new SettingsModel(new Configuration(1, 1, Configuration.Difficulty.EASY));
        SettingsModel.Option actual = model.getSelected();
        assertEquals(DIF, actual);
        model.previousSelected();
        assertEquals(BACK, model.getSelected());
        model.previousSelected();
        model.previousSelected();
        assertEquals(HEIGHT, model.getSelected());
        model.previousSelected();
        assertEquals(actual, model.getSelected());
    }

}
