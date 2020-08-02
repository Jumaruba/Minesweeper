package lpoo.control;

import lpoo.control.state.ControllerState;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.when;

public class ControlTest {

    public ControllerState Execute(CommandKey.COMMAND command, Controller controller, ControllerState state ) throws IOException, CloneNotSupportedException, ClassNotFoundException {
        CommandKey commandKey = Mockito.mock(CommandKey.class);
        when(commandKey.getCommandEnum()).thenReturn(command );
        when(commandKey.getKey()).thenReturn('a');
        return state.execute(controller,commandKey);
    }
}
