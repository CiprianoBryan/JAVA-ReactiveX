package com.arimagroup;

import io.reactivex.Observable;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IntervalObservable {
    public static void main(String[] args) {
        /* --------------- caso 1 ------------- */
//        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
//        observable.subscribe(item -> System.out.println("Observer 1: " + item));
//        pause(5);
        // imprime un número autoincrementable desde 0, por cada intervalo de tiempo
        // hasta que finalice la función principal
        /* --------------- caso 2 ------------- */
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        pause(2);
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
        pause(5);
        // El primer observer se sigue ejecutando hasta q finalice la clase principal
        // Es por eso que con el segundo pause(5 seconds), se seguirá ejecutando junto al observer 2
    }

    private static void pause(int duration) {
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
