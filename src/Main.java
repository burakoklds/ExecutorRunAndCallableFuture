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
		
		// Herhangi bir deper gelebilir (?) yeri i�in
	    Future<?> future	= executor.submit(new Callable<Integer>() { // De�er D�d�rebilmek i�in Future kullan�l�yor

			@Override
			public Integer call() throws Exception {

				Random random = new Random();	
				
				System.out.println("Thread �al���yor...");
				
				int sure = random.nextInt(1000) + 2000;
				
				if (sure > 2500) {
					System.out.println("Thread �ok uzun uyudu..."); 
				}
				
				Thread.sleep(sure);
				
				System.out.println("Thread ��k�yor...");
				
				return sure;
			}
		});
		
		executor.shutdown();
		
		try {
			System.out.println("D�nen de�er : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
