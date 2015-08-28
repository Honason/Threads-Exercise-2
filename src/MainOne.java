public class MainOne {

	public static void main(String[] args) throws Exception {
		System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());

		GetSize t1 = new GetSize("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
		GetSize t2 = new GetSize("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
		GetSize t3 = new GetSize("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");

		//Parallel Execution
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		long end = System.currentTimeMillis();
		System.out.println("Time Parallel: " + (end - start));
		System.out.println(t3.getSizes());

		//Sequential Execution
		start = System.currentTimeMillis();
		t1.run();
		t2.run();
		t3.run();
		t1.join();
		t2.join();
		t3.join();
		end = System.currentTimeMillis();
		System.out.println("Time Sequential: " + (end-start));

		// Sequential execution is faster in this case, surprisingly, because threads are not used concurrently.
	}

	
}