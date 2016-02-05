import java.text.SimpleDateFormat;
import java.util.Date;



public class TestThread extends Thread {
	public void run(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
	}
}
