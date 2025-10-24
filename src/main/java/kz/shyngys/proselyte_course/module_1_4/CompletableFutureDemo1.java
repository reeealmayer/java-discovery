package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo1 {
    public static void main(String[] args) {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "String");
        stringCompletableFuture.thenAccept((a) -> System.out.println("string: " + a));
        CompletableFuture<Integer> integerCompletableFuture = stringCompletableFuture.thenApply((s) -> Integer.parseInt(s));

        CompletableFuture<Long> longCompletableFuture = CompletableFuture.completedFuture(42L);
        CompletableFuture<Long> longCompletableFuture1 = CompletableFuture.supplyAsync(() -> 42L); //вычисляет в дефолтном тред-пулле
    }
}
