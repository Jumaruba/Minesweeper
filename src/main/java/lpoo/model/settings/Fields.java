package lpoo.model.settings;


import lpoo.model.Configuration;

public abstract class Fields {
    Configuration configuration;

    public Fields(Configuration configuration) {
        this.configuration = configuration;
    }

    public abstract void increment();

    public abstract void decrement();
}
