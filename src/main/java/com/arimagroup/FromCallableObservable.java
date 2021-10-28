package com.arimagroup;

import io.reactivex.Observable;

public class FromCallableObservable {
    public static void main(String[] args) {
        /* ----------------   Caso 1 -------------------*/
//        Observable<Integer> observable = Observable.just(getNumber());
        // Con just() se realizan las operaciones del método (imprime el mensaje, multiplica el 3*5)
        // pero no se muestra el resultado 15, esto solo pasa cuando se agregue un observer como en el caso 2.
        /* ----------------   Caso 2 -------------------*/
//        Observable<Integer> observable = Observable.just(getNumber());
//        observable.subscribe(System.out::println,
//                error -> System.out.println("An Exception ocurred: " + error.getLocalizedMessage()));
        // En caso ocurra un error, como que se devuelva un 1/0, el onError() no lo captura

//         En los casos anteriores, con just() se realizaban las acciones, operaciones del método que invocaba, y
//           si este contiene errores, entonces se cae la aplicación, en caso sea correcto
        /* ----------------   Caso 3 -------------------*/
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling Method");
            return getNumber();
        });
        observable.subscribe(System.out::println,
                error -> System.out.println("An Exception ocurred: " + error.getLocalizedMessage()));

        // Con fromCallable() todas las operaciones, acciones dentro se ejecutaran solo cuando se suscriba
        // Se podria decir que es una forma perezosa.
    }

    private static int getNumber() {
        System.out.println("Generating Value");
        //        return 1/0; -- caso 1, 2, 3
        return 3*5;
    }
}
