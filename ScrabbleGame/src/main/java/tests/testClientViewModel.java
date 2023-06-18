package tests;

import Model.HostModel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class testClientViewModel {

    public static void testClientVM() {
        HostModel hostModel = new HostModel();
        ExecutorService executorServiceHost = Executors.newFixedThreadPool(1);
        Future<HostModel> hostServerFuture = executorServiceHost.submit(new Callable<HostModel>() {
            @Override
            public HostModel call() throws Exception {
                return hostModel;
            }
        });
        executorServiceHost.shutdown();
    }



    public static void main(String[] args) {
        System.out.println("start ViewModel test");
//        TestViewModel.testHostViewModel();
        testClientVM();

        System.out.println("done test - View Model");
    }

}



