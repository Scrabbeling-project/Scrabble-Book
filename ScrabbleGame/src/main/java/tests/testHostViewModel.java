package tests;

import ViewModel.HostViewModel;

import java.beans.PropertyChangeSupport;

public class testHostViewModel {

static HostViewModel hostViewModel,hostViewModel2;

    public static void testHostVM() {
        System.out.println("start host view model test");
        hostViewModel.connect();
        HostViewModel hostViewModel2 = new HostViewModel(new PropertyChangeSupport(1));
        hostViewModel2.connect();

    }


}
