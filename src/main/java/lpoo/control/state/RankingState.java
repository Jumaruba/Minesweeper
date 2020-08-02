package lpoo.control.state;

import lpoo.control.CommandKey;
import lpoo.control.Controller;
import lpoo.model.Configuration;
import lpoo.model.ranking.RankingModel;
import lpoo.view.View;
import lpoo.view.ranking.RankingView;

import java.io.IOException;

public class RankingState extends ControllerState<RankingModel> {
    Boolean inGame;
    RankingModel rankingModel;
    RankingView rankingView;

    public RankingState(FactoryState factory, Configuration configuration, Boolean inGame, RankingModel rankingModel, RankingView rankingView) {
        super(factory, configuration);
        this.inGame = inGame;
        this.rankingModel = rankingModel;
        this.rankingView = rankingView;
        this.graphics = rankingView.initGraphics();
    }

    @Override
    public View<RankingModel> getView() {
        return rankingView;
    }

    @Override
    public ControllerState<?> execute(Controller controller, CommandKey readCommand) throws IOException {
        ControllerState<?> nextState = this;
        switch (readCommand.getCommandEnum()) {
            case CLICK:
                nextState = factory.genMenuState(configuration, inGame);
                break;
            case QUIT:
                nextState = null;
        }
        return goToState(nextState);
    }

}

