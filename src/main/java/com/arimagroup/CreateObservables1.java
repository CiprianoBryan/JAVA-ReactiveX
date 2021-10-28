package com.arimagroup;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class CreateObservables1 {
    public static void main(String[] args) {
        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(System.out::println);
    }

    private static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(100);
            observableEmitter.onNext(200);
            observableEmitter.onNext(300);
            observableEmitter.onNext(400);
            observableEmitter.onNext(500);
//            observableEmitter.onNext(null); -> Si el emitter empuja un valor null da error
            observableEmitter.onComplete();
            observableEmitter.onNext(600); // No se empujará este valor porque ya se lanzó el onComplete()
        });
        observable.subscribe(System.out::println,
                error -> System.out.println("Error: " + error.getLocalizedMessage()),
                () -> System.out.println("Completed"));
    }
}
