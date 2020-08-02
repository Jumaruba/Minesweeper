package lpoo.model.menu;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuModelTest {
    @Test
    public void testInGame() {
        MenuModel menuModel = new MenuModel(false);
        assertEquals("NEW GAME", menuModel.enumToString(MenuModel.Option.START));
        menuModel = new MenuModel(true);
        assertEquals("CONTINUE", menuModel.enumToString(MenuModel.Option.START));
    }
}
