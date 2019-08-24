package com.qi.volatile_01;

class PrintString_02 implements Runnable {
    private boolean tag = true;

    public boolean isContinuePrint() {
        return this.tag;
    }

    public void print() throws InterruptedException {
        while (isContinuePrint() == true) {
            System.out.println("当前线程名称 " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    @Override
    public void run() {
        try {
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test_01_extend {
    public static void main(String[] args) {
        PrintString_02 printString_02 = new PrintString_02();
        Thread thread = new Thread(printString_02);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("尝试停止打印");
        printString_02.setTag(false);
        System.out.println("成功停止");
    }
}
