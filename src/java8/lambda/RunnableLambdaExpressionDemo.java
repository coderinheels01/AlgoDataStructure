package java8.lambda;

public class RunnableLambdaExpressionDemo {
    public static void main(String... args) throws InterruptedException {
         Runnable runnalbeLambda = () -> {
             for(int i=0; i< 3; i++){
                 System.out.println("Hell0 from thrad " + Thread.currentThread().getName());
             }
         };

         Thread t1 = new Thread(runnalbeLambda);
         t1.start();
         t1.join();
    }
}
