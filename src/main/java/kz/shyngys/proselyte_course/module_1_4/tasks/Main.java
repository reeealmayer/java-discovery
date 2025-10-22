package kz.shyngys.proselyte_course.module_1_4.tasks;

import kz.shyngys.proselyte_course.module_1_4.Tunnel;
import kz.shyngys.proselyte_course.module_1_4.ships.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available number of cores: " + availableProcessors);

        Tunnel tunnel = new Tunnel();

        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);

        PierLoader pierLoader1 = new PierLoader(tunnel, Type.DRESS);
        PierLoader pierLoader2 = new PierLoader(tunnel, Type.BANANA);
        PierLoader pierLoader3 = new PierLoader(tunnel, Type.MEAL);

        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        executorService.execute(shipGenerator);
        executorService.execute(pierLoader1);
        executorService.execute(pierLoader2);
        executorService.execute(pierLoader3);

        executorService.shutdown();
    }
}
