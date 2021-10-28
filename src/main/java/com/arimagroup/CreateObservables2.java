package com.arimagroup;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class CreateObservables2 {
    public static void main(String[] args) {
//        createColdObservable();
//        createHotAndConnectableObservable();
        createHotObservable();
    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(item -> System.out.println("Observer 1:" + item));
        pause(3);
        observable.subscribe(item -> System.out.println("Observer 2:" + item));
    }

    private static void createHotAndConnectableObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();
        observable.subscribe(item -> System.out.println("Observer 1: " + item)); // se lanza de inmediato, al suscribirse
        observable.subscribe(item -> System.out.println("Observer 2: " + item)); // se lanza de inmediato, al suscribirse
        observable.connect();
    }

    private static void createHotObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();
        observable.subscribe(i -> System.out.println("First Subscription: " + i)); // no se lanza
        System.out.println("Before Pause for 5 seconds");
        pause(5);
        System.out.println("After Pause for 5 seconds"); // no se lanza
        observable.subscribe(i -> System.out.println("Second Subscription: " + i));
        observable.connect(); // Se ejecutan todos los observer
    }

    private static void pause(int duration) {
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
