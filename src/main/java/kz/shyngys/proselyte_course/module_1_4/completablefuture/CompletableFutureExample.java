package kz.shyngys.proselyte_course.module_1_4.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, world!");
//        CompletableFuture<String> transformedFuture = future.thenApply(result -> result.toUpperCase());
//        transformedFuture.thenAccept(System.out::println);
//        future.thenRun(() -> System.out.println("Task completed"));
//
        CompletableFuture<Double> result = getUsername("123")
                .thenCompose(username -> getUserRating(username));
        result.thenAccept(rating -> System.out.println("rating: " + rating));


        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return 65.0;
        });

        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return 175.0;
        });

        CompletableFuture<Double> bmiFuture = weightInKgFuture.thenCombine(heightInCmFuture, (weight, height) -> {
            double heightInMeters = height / 100;
            return weight / (heightInMeters * heightInMeters);
        });

        bmiFuture.thenAccept(bmi -> System.out.println("BMI: " + bmi));


        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("task 1 completed"));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("task 2 completed"));
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.thenRun(() -> System.out.println("Все задачи выполнены"));

        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Something went wrong");
            }
            return "Success";
        }).exceptionally(_ -> {
            System.out.println("Exception processed");
            return "Recovery";
        });
        exceptionally.thenAccept(s -> System.out.println(s));

        CompletableFuture<String> handle = CompletableFuture.supplyAsync(() -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Something went wrong");
            }
            return "handle success";
        }).handle((s, ex) -> {
            if (ex != null) {
                System.out.println("Exception processing: " + ex.getMessage());
                return "recovery";
            }
            return s;
        });

        handle.thenAccept(System.out::println);

        CompletableFuture<String> completeOnTimeout = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "timeout Success";
        }).completeOnTimeout("Time-out", 1, TimeUnit.SECONDS);
        completeOnTimeout.thenAccept((s) -> System.out.println("result: " + s));
    }

    static CompletableFuture<String> getUsername(String userId) {
        return CompletableFuture.supplyAsync(() -> userId + "_login");
    }

    static CompletableFuture<Double> getUserRating(String username) {
        return CompletableFuture.supplyAsync(() -> 2.0);
    }


}
