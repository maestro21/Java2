package HW5;

import Lessons.online.MyThread;

import java.util.Arrays;

public class HW5 {


    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        Arrays.fill(arr, 10);
        HW5 hw5 = new HW5();
        hw5.fillArrayOneThread(arr);
        hw5.fillArrayTwoThreads(arr);
    }

    public void fillArrayOneThread(float[] arr) {
        long a = System.currentTimeMillis();
        System.out.print("Setting values to array in one thread. Time elapsed (in Milliseconds): ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = getValue(i);
        }
        System.out.println(System.currentTimeMillis() - a);
    }


    public void fillArrayTwoThreads(float[] arr) {
        long a = System.currentTimeMillis();
        float[] a1 = new float[h], a2 = new float[h];
        System.out.println("Setting values to array in two threads.");
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        ArrThread at1 = new ArrThread("Thread #1", a1);
        ArrThread at2 = new ArrThread("Thread #2", a2);
        try {
            at1.join();
            at2.join();
        } catch(InterruptedException e) {
            return;
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.print("Time elapsed (in Milliseconds): ");
        System.out.println(System.currentTimeMillis() - a);
    }

    private static float getValue(int i) {
        return (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public class ArrThread extends Thread {
        float[] arr;
        public ArrThread(String name, float[] arr) {
            super(name);
            this.arr = arr;
            start();
        }

        @Override
        public void run() {
            System.out.println(getName() + " started");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = getValue(i);
            }
            System.out.println(getName() + " stopped");
        }
    }
}
