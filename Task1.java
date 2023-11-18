import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class Task1 {

	public static void main(String[] args) {
		logToNode("Hello from Java");
		logToNode(true);
		logToNode(21);

	}
	
	public static void logToNode(Object obj) {
		String data = String.valueOf(obj);
		try{
			HttpURLConnection conn = (HttpURLConnection) new URL("http://localhost:2000/log").openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty( "Content-Type", "text/plain" );

			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes("utf-8"));
			
			String msg = conn.getResponseMessage();
			
			if(msg.equals("OK")) {
				System.out.println("Message Sent Successfully");
			}else {
				System.out.println("Something went wrong");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	  }
}