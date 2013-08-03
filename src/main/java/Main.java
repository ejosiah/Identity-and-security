import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class Main {
	
	public static void main(String...args) throws Exception{
		URL url = new URL("http://s.ytimg.com/yts/swfbin/watch_as3-vfl7hLwyN.swf");
		URLConnection connection = url.openConnection();
		byte[] data = new byte[connection.getContentLength()];
		connection.connect();
		InputStream stream = connection.getInputStream();
		DataInputStream dataIn = new DataInputStream(stream);
		dataIn.readFully(data);
		OutputStream out = new FileOutputStream(new File("c:/watch.swf"));
		out.write(data);
		out.flush();
		System.out.println("done");
		

	}
}
