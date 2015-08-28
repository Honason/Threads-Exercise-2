import java.util.concurrent.atomic.AtomicInteger;
import java.net.URL;
import java.io.*;

public class GetSize extends Thread {

	private String Url;
	public static AtomicInteger Sizes = new AtomicInteger();

	public int getSizes() {
	    return Sizes.get();
	}
	public GetSize(String url) {
		Url = url;
	}

	public static byte[] getBytesFromUrl(String url) {
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		try {
			InputStream is = new URL(url).openStream();
			byte[] bytebuff = new byte[4096];
			int read;
			while ((read = is.read(bytebuff)) > 0) {
				bis.write(bytebuff, 0, read);
			}
		} catch (IOException ex) {System.out.println(ex);}
		return bis.toByteArray();
	}

	public void run() {
		int sumOfArray = getSumOfByteArray(getBytesFromUrl(Url));

		Sizes.set(Sizes.get() + sumOfArray);
	}

	public static int getSumOfByteArray(byte[] a) {
		int c = 0;
		for (int i = 0; i < a.length ; i++) {
			c += a[i];
		}
		return c;
	}

}