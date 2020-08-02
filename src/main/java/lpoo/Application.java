package lpoo;

import lpoo.control.Controller;
import lpoo.control.state.FactoryState;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException, CloneNotSupportedException, ClassNotFoundException {
        Controller controller = new Controller(new FactoryState());
        controller.start();
    }
}
