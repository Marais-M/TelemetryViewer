import java.io.OutputStream;

public interface SerialPortListener {
	
	public void connectionOpened(int sampleRate, Packet packet, String portName, int baudRate, OutputStream outputStream);
	
	public void connectionClosed();
	
	public void connectionLost();

}
