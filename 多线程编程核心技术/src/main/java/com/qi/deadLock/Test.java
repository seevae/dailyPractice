package com.qi.deadLock;



class Pen{
    private String penName = "mark" ;

    public String getPenName() {
        return penName;
    }
}


class Book{
    private String bookName = "TomAndJerry";

    public String getBookName() {
        return bookName;
    }
}


public class Test {

    private static Pen pen = new Pen();
    private static Book book = new Book();

    public static void main(String[] args) {
        Thread threadA =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen){
                    System.out.println("我有笔,我想要书");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (book){
                        System.out.println("我拿到了书");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book){
                    System.out.println("我有书,我想要笔");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (pen){
                        System.out.println("我拿到了笔");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}
