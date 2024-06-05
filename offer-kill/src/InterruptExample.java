public class InterruptExample {


    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程
        Thread thread = new Thread(() -> {
            while (true) {
                // 定期检查中断状态
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("中断请求已收到，正在退出...");
                    break; // 退出循环，结束线程执行
                }
                // 做一些工作
                System.out.println("线程正在工作...");
                try {
                    // 休眠一段时间，模拟工作负载
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 如果在休眠时收到中断，清除中断状态
                    Thread.currentThread().interrupt(); // 再次中断以保持中断状态
                    System.out.println("在休眠时收到中断，重新设置中断状态");
                }
            }
        });

        // 启动线程
        thread.start();

        // 主线程休眠一段时间，然后请求中断
        Thread.sleep(5000);
        thread.interrupt(); // 发送中断请求
    }

}
