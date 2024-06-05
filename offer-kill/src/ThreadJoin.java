public class ThreadJoin {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 running");
            }
        });

        thread1.start();

        thread1.join();

        System.out.println("Main 1 running");
    }

}
