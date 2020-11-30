import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		executor.submit(new Runnable() {
			
			@Override
			public void run() { // De�er D�nmeden kullan�m

				Random random = new Random();
				
				System.out.println("Thread �al���yor...");
				
				int sure = random.nextInt(1000) + 2000;
				
				try {
					Thread.sleep(sure);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread ��k�yor...");
			}
		});
		
		executor.shutdown();
		
	}
}
