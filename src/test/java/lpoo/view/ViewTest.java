package lpoo.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.model.Model;

public abstract class ViewTest<T extends Model> {
    protected TextGraphics graphics;
    protected T model;
    protected View<T> view;
}
