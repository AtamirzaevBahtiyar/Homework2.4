package com.company;

import java.util.concurrent.Semaphore;

public class Runner extends Thread {


    Semaphore sem;
    Runner runner;

    public void setRunner(Runner runner) {
        this.runner = runner;
    }



    Runner(Semaphore sem) {
        this.sem = sem;
    }


    public void run() {

        try {
            sem.acquire();
            if (!this.getName().equals("Runner 5")){


                System.out.println( this.getName() + " берет палочку");
            System.out.println( this.getName() + " бежит к " + runner.getName());}


            sleep(2000);
            sem.release();
            if (!this.getName().equals("Runner 5")){
            runner.join();}
            if (this.getName().equals("Runner 5")){
                System.out.println(this.getName()+ " берет палочку");
                System.out.println(this.getName()+ " бежит к финишу ");
                sleep(2000);
            }
            if (this.getName().equals("Runner 4")){
                System.out.println(runner.getName() + " бежит к " + this.getName());
                sleep(2000);
            }

            if (this.getName().equals("Runner 3") || this.getName().equals("Runner 2") ||
                    this.getName().equals("Runner 1")){
                System.out.println( runner.getName() + " берет палочку");
                System.out.println(runner.getName() + " бежит к " + this.getName());
                sleep(2000);
            }

            if (this.getName().equals("Runner 1")){
                System.out.println( this.getName() + " берет палочку");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
