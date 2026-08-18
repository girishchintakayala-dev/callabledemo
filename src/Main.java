import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello world!");

        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<Integer> future1 = service.submit(()->{
            Thread.sleep(1000);
            return 100;
        });
        Future<Integer> future2 = service.submit(()->{
            Thread.sleep(2000);
            return 200;
        });
        Future<Integer> future3 = service.submit(()->{
            Thread.sleep(3000);
            throw new RuntimeException("Some issue with task");

        });
        Future<Integer> future4 = service.submit(()->{
            Thread.sleep(4000);
           return 400;

        });
        Future<Integer> future5= service.submit(()->{
            Thread.sleep(4000);
            return 500;

        });

        try
        {
            Integer result1 = future1.get();
            System.out.println(result1);
            Integer result2 = future2.get();
            System.out.println(result2);

            Integer result4 = future4.get();
            System.out.println(result4);
            Integer result5 = future5.get();
            System.out.println(result5);
            Integer result3 = future3.get();
            System.out.println(result3);

        }
        catch (ExecutionException e)
        {
            System.out.println("A task failed! Reason :"+e.getMessage());
        }
    }
}