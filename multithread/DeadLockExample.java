package com.multithread;
public class DeadLockExample {

    public static void main(String[] args) {
        DeadLockExample test = new DeadLockExample();

        final AClass objA = test.new AClass();
        final BClass objB= test.new BClass();
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (objB) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have A but need B also
                    synchronized (objA) {
                        System.out.println("In block 1");
                    }
                }
            }
        };

        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (objB) {
                    // Thread-2 have B but need A also
                    synchronized (objA) {
                        System.out.println("In block 2");
                    }
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }

    private class AClass {
        private int i = 10;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    private class BClass {
        private int i = 20;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}