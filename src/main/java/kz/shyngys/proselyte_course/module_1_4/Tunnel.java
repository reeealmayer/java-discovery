package kz.shyngys.proselyte_course.module_1_4;

import kz.shyngys.proselyte_course.module_1_4.ships.Ship;
import kz.shyngys.proselyte_course.module_1_4.ships.Type;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private List<Ship> store;
    private static final int maxShipsInTunnel = 5;
    private static final int minShipsInTunnel = 0;
    private int shipsCounter = 0;

    public Tunnel() {
        this.store = new ArrayList<>();
    }

    public synchronized boolean add(Ship element) {
        try {
            if (shipsCounter < maxShipsInTunnel) {
                notifyAll();
                store.add(element);
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s", store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;
            } else {
                System.out.println(store.size() + "> There is no place for a ship in the tunnel: " + Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return true;
    }

    public synchronized Ship get(Type shipType) {
        try {
            if (shipsCounter > minShipsInTunnel) {
                notifyAll();
                for (Ship ship : store) {
                    shipsCounter--;
                    System.out.println(store.size() + "- The ship is taken from the tunnel: " + Thread.currentThread().getName());
                    store.remove(ship);
                    return ship;
                }
            }
            System.out.println("0 < There are no ships in the tunnel");
            wait();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return null;
    }
}
