import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		// Herhangi bir deper gelebilir (?) yeri için
	    Future<?> future	= executor.submit(new Callable<Integer>() { // Deðer Dödürebilmek için Future kullanýlýyor

			@Override
			public Integer call() throws Exception {

				Random random = new Random();	
				
				System.out.println("Thread çalýþýyor...");
				
				int sure = random.nextInt(1000) + 2000;
				
				if (sure > 2500) {
					System.out.println("Thread çok uzun uyudu..."); 
				}
				
				Thread.sleep(sure);
				
				System.out.println("Thread çýkýyor...");
				
				return sure;
			}
		});
		
		executor.shutdown();
		
		try {
			System.out.println("Dönen deðer : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
