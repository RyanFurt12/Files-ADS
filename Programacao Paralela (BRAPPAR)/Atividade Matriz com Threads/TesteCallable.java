import java.util.Random;
import java.util.concurrent.Callable;

public class TesteCallable implements Callable<Integer> { 
    @Override
    public Integer call() throws Exception{
        Random rand = new Random();
        Integer number = rand.nextInt(100);
        return number;
    }
}