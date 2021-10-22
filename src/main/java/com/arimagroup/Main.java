package com.arimagroup;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Main {
    public static void main(String[] args) {
        /*Observable.just(1, 2, 3, 4, 5).subscribe(System.out::println);*/
        Thread thread = new Thread(Main::runIt);
        thread.run();
    }

    public static void runIt() {
        System.out.println("Hello World");
    }
}
