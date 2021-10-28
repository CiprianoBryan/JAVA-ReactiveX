package com.arimagroup;

import io.reactivex.Observable;

public class RangeObservable {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(5, 5);
        observable.subscribe(System.out::println);
    }
}
