package com.qi.volatile_01;


class PrintString{
    private boolean tag = true;

    public boolean isContinuePrint(){
        return this.tag;
    }

    public void print() throws InterruptedException {
        while(isContinuePrint() == true){
            System.out.println("当前线程名称 "+Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

    public void setTag(boolean tag){
        this.tag = tag;
    }

}

//此时先要停止打印,但是并不能够,原因是主线程已经在一直执行while中的代码了,他没空改变标识
//解决方法: 使用多线程
public class Test_01 {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        printString.print();
        System.out.println("尝试停止打印");
        printString.setTag(false);
        System.out.println("成功停止打印");
    }
}
