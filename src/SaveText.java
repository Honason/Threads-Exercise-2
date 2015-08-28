import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveText extends Thread {

    public void run() {

        while (TextWriterForm.saveActive) {

            FileWriter writer = null;
            try {
                writer = new FileWriter("backup.txt", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter out = new PrintWriter(writer);

            for (String line : TextWriterForm.lines) {
                out.append(line +"\n");
            }

            out.close();

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
