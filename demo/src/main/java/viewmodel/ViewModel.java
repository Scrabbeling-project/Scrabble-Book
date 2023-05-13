package viewmodel;

import javafx.beans.property.DoubleProperty;
import model.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel implements Observer {
    Model m;
    // DoubleProperty

    public ViewModel(Model m) {
        this.m = m;
        m.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
