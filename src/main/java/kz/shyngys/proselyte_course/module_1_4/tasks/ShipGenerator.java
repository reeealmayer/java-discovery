package kz.shyngys.proselyte_course.module_1_4.tasks;

import kz.shyngys.proselyte_course.module_1_4.Tunnel;
import kz.shyngys.proselyte_course.module_1_4.ships.Ship;
import kz.shyngys.proselyte_course.module_1_4.ships.Size;
import kz.shyngys.proselyte_course.module_1_4.ships.Type;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName("Ship generator");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}
