package com.arimagroup;

import io.reactivex.Observable;

public class ErrorObservable {
    public static void main(String[] args) {
//        throwException();
        throwExceptionUsingCallable();
    }

    private static void throwException() {
        Observable observable = Observable.error(new Exception("An exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

    private static void throwExceptionUsingCallable() {
//        Observable observable = Observable.error(() -> new Exception("An exception"));
        Observable observable = Observable.error(() -> {
            System.out.println("New Exception Created");
            return new Exception("An exception");
        }); // Usando lambda para retornar el Exception, se crea una nueva instancia para cada error.
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }
}
