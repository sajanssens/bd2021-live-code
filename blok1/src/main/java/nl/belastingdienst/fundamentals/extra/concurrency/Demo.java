package nl.belastingdienst.fundamentals.extra.concurrency;

import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class Demo {

    private Person p = new Person();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Demo demo = new Demo();
        // demo.classicThreadAndRunnable();
        // demo.threadPool();
        // demo.future();
        demo.completableFuture();

    }

    private void classicThreadAndRunnable() throws InterruptedException {
        Runnable task1 = () -> haveBirthDay(10_000, p);
        Runnable task2 = () -> haveBirthDay(20_000, p);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        HaveBirthDayThread hbt = new HaveBirthDayThread(30_000, p);

        t1.start();
        t2.start();
        hbt.start();

        t1.join(); // wait, blocks
        t2.join();
        hbt.join();

        int age = p.getAge();
        System.out.println(age);
    }

    private void threadPool() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.submit(new HaveBirthDay(10_000, p));
        pool.submit(new HaveBirthDay(20_000, p));
        pool.submit(new HaveBirthDay(30_000, p));

        pool.shutdown();
        if (pool.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println(p.getAge());
        }
    }

    private void future() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Callable<Integer> task1 = () -> haveBirthDayAndGetResult(10_000, p);
        Callable<Integer> task2 = () -> haveBirthDayAndGetResult(20_000, p);
        Callable<Integer> task3 = () -> haveBirthDayAndGetResult(30_000, p);
        Future<Integer> task1Result = pool.submit(task1);
        Future<Integer> task2Result = pool.submit(task2);
        Future<Integer> task3Result = pool.submit(task3);

        // doing other stuff in the meantime...
        sleep(1000);

        Integer result1 = task1Result.get();  // blocking/waiting for result
        Integer result2 = task2Result.get();  // blocking/waiting for result
        Integer result3 = task3Result.get();  // blocking/waiting for result

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        pool.shutdown();
        if (pool.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println(p.getAge());
        }
    }

    private void completableFuture() {
        supplyAsync(() -> haveBirthDayAndGetResult(10_000, p))
                .thenApply(age -> writeToDb(age))
                .thenAccept(System.out::println)
                .thenApply(v -> haveBirthDayAndGetResult(20_000, p))
                .thenAccept(System.out::println);

        supplyAsync(() -> haveBirthDayAndGetResult(30_000, p))
                .thenApply(age -> writeToDb(age))
                .thenAccept(System.out::println);

        System.out.println("completableFutures started");
        sleep(2000);
        System.out.println("completableFuture end");

    }

    static class HaveBirthDay implements Runnable { // is een taak die door een thread opgepakt kan worden

        private final int n;
        private final Person p;

        public HaveBirthDay(int n, Person p) {
            this.n = n;
            this.p = p;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                p.haveBirthday();
            }

            System.out.println("HaveBirthDay #" + Thread.currentThread().getId() + " done.");
        }
    }

    static class HaveBirthDayThread extends Thread {  // dit is een thread die gestart kan worden.

        private final int n;
        private final Person p;

        public HaveBirthDayThread(int n, Person p) {
            this.n = n;
            this.p = p;
        }

        public void run() {
            for (int i = 0; i < n; i++) {
                p.haveBirthday();
            }

            System.out.println("HaveBirthDayThread #" + Thread.currentThread().getId() + " is done.");
        }
    }

    private String writeToDb(Integer age) {
        System.out.println("writeToDb");
        sleep(1000);
        return "INSERTED age " + age;
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void haveBirthDay(int n, Person p) {
        for (int i = 0; i < n; i++) {
            p.haveBirthday();
        }

        System.out.println("haveBirthDay #" + Thread.currentThread().getId() + " done.");
    }

    private int haveBirthDayAndGetResult(int n, Person p) {
        System.out.println("haveBirthDayAndGetResult start");
        for (int i = 0; i < n; i++) {
            p.haveBirthday();
        }

        return p.getAge();
    }

}
