package multiThreading;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiThreading.service.UserService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class MultiThreadingApplicationTests {


    @Test
    public void testFetchDataFromMultipleSources() throws ExecutionException, InterruptedException {
        UserService userService = new  UserService ();

        CompletableFuture<String> combinedDataFuture = userService.fetchDataFromMultipleSources();

        String combinedData = combinedDataFuture.get();
       
        assertEquals("Combined data: Data from source A and Data from source B", combinedData);
    }

    @Test
    public void testFetchDataFromSourceA() throws ExecutionException, InterruptedException {
    	UserService userService = new UserService();

        CompletableFuture<String> dataFromSourceAFuture = userService.fetchDataFromSourceA();

        String dataFromSourceA = dataFromSourceAFuture.get();
        assertEquals("Data from source A", dataFromSourceA);
    }

    @Test
    public void testFetchDataFromSourceB() throws ExecutionException, InterruptedException {
    	UserService userService = new UserService();

        CompletableFuture<String> dataFromSourceBFuture = userService.fetchDataFromSourceB();

        String dataFromSourceB = dataFromSourceBFuture.get(); 
        assertEquals("Data from source B", dataFromSourceB);
}
}
