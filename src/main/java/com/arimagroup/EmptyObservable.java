package com.arimagroup;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class EmptyObservable {
    public static void main(String[] args) {
//        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    private static void createObservableUsingEmpty() {
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        // Se lanza el evento onComplete() únicamente
    }

    private static void createObservableUsingNever() {
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        pause(3);
        // Con este Observable no se lanza nada
    }

    private static void pause(int duration) {
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
