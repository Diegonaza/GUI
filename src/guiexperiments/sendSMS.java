 package guiexperiments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sendSMS {
	public String sendSms() {
		try {
                    System.out.println("TRying to send SMS");
			// Construct data
			String apiKey = "apikey=" + "r8dUNfbWqiU-zwKW0Setfa706AyYCBbD57pLY0kVkw";
			String message = "&message=" + "Your Boy Dong and 69 it is baby";
			String sender = "&sender=" + "Harry Dong";
			String numbers = "&numbers=" + "447309916750";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}