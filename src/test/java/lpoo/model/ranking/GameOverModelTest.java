package lpoo.model.ranking;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doCallRealMethod;

public class GameOverModelTest {
    GameOverModel modelToSave;
    GameOverModel modelNotToSave;
    RankingModel ranking = new RankingModel();

    public void initModel() throws IOException {
        modelToSave = mock(GameOverModel.class);
        doCallRealMethod().when(modelToSave).saveScores();
        doCallRealMethod().when(modelToSave).setName(anyString());
        when(modelToSave.getName()).thenCallRealMethod();
        doCallRealMethod().when(modelToSave).setScore(anyInt());
        doCallRealMethod().when(modelToSave).setRankingModel(any(RankingModel.class));
        doCallRealMethod().when(modelToSave).setHighScore(anyBoolean());
        doCallRealMethod().when(modelToSave).addChar(anyChar());
        doCallRealMethod().when(modelToSave).deleteLastLetter();

        modelToSave.setName("AAA");
        modelToSave.setScore(300);
        modelToSave.setRankingModel(ranking);
        modelToSave.setHighScore(true);

        modelNotToSave = new GameOverModel(100, false, ranking);
    }

    @Test
    public void saveScores() throws IOException {
        initModel();
        modelToSave = mock(GameOverModel.class);
        doCallRealMethod().when(modelToSave).saveScores();
        doCallRealMethod().when(modelToSave).setName(anyString());
        when(modelToSave.getName()).thenCallRealMethod();
        doCallRealMethod().when(modelToSave).setScore(anyInt());
        doCallRealMethod().when(modelToSave).setRankingModel(any(RankingModel.class));
        doCallRealMethod().when(modelToSave).setHighScore(anyBoolean());
        doCallRealMethod().when(modelToSave).addChar(anyChar());
        doCallRealMethod().when(modelToSave).deleteLastLetter();

        modelToSave.setName("AAA");
        modelToSave.setScore(300);
        modelToSave.setRankingModel(ranking);
        modelToSave.setHighScore(true);

        modelNotToSave = new GameOverModel(100, false, ranking);

        modelToSave.saveScores();
        assertEquals(1, ranking.getPeople().size());
        modelNotToSave.saveScores();
        assertEquals(1, ranking.getPeople().size());
    }

    @Test
    public void testName() throws IOException {
        initModel();
        modelToSave.addChar('a');
        assertEquals("AAA", modelToSave.getName());
        modelToSave.deleteLastLetter();
        modelToSave.deleteLastLetter();
        assertEquals("A", modelToSave.getName());
        modelToSave.addChar('&');
        assertEquals("A", modelToSave.getName());
    }

    @Test
    public void addCharTest() {
        RankingModel rankingModel = Mockito.mock(RankingModel.class);
        GameOverModel model = new GameOverModel(12, true, rankingModel);

        model.addChar('m');
        assertEquals("M", model.getName());
        model.addChar('l');
        assertEquals("ML", model.getName());
        model.addChar('k');
        assertEquals("MLK", model.getName());
        model.addChar('j');
        assertEquals("MLK", model.getName());
    }

    @Test
    public void deleteLastLetter() {

        RankingModel rankingModel = Mockito.mock(RankingModel.class);
        GameOverModel model = new GameOverModel(12, true, rankingModel);

        model.setName("MLK");
        model.deleteLastLetter();
        assertEquals("ML", model.getName());
        model.setName("M");
        model.deleteLastLetter();
        assertEquals("", model.getName());
        model.setName("");
        model.deleteLastLetter();
        assertEquals("", model.getName());
    }
}
