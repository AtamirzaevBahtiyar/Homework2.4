package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Runner[] runners = new Runner[5];

        Semaphore sem = new Semaphore(1);
        for (int i = 0; i < 5; i++) {
            Runner r = new Runner(sem);
            int l = i+1;
            r.setName("Runner " + l);
            runners[i] = r;
        }

        for (int i = 0; i < 5; i++) {
            if (i<4){
                int k = i+1;
                runners[i].setRunner(runners[k]);  }
            else runners[i].setRunner(runners[3]);

        }
        for (int i = 0; i < 5; i++) {
            runners[i].start();

        }
    }
}