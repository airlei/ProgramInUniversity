package homewoek16;

import java.util.Stack;

public abstract class AbstractCommand {
    public abstract int execute(int value);
    public abstract int undo();
    public abstract int redo();
}