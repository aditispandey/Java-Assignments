class NumberPrinter{
    private int turn = 1;
    public synchronized void print(int threadNumber){
        for(int i = 1 ; i <= 5 ; i++){
            while(turn != threadNumber){
                try{
                    wait();
                } catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread " + threadNumber + " : " + i);
            // Move to next thread
            turn = (turn % 3) + 1;
            notifyAll();
        }
    }
}

public class Numbers {
    public static void main(String[] args){
        NumberPrinter printer = new NumberPrinter();
        Thread t1 = new Thread(() -> printer.print(1));
        Thread t2 = new Thread(() -> printer.print(2));
        Thread t3 = new Thread(() -> printer.print(3));
        t1.start();
        t2.start();
        t3.start();
    }
}