import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;

public class ConsoleTransmitter extends Thread{
	private OutputStream outputStream;
	private Scanner console;
	PrintWriter writer;
	
	ConsoleTransmitter(OutputStream stream)
	{
		outputStream = stream;
		console = null;
		writer = null;
		System.out.println("Output Transmitter Running");
	}
	
	public void run()
	{
		console = new Scanner(System.in);
		writer = new PrintWriter(outputStream);
		while(true)
		{
			if(console.hasNextLine())
			{
				String line = console.nextLine();
				writer.println(line);
				writer.flush();
			}
			else
			{
				System.out.println("Cannot transmit to serial port while its closed");
			}
			
			try {Thread.sleep(100);} catch(Exception e) {}
			
			if(Thread.interrupted())
			{
				System.out.println("Output Transmitter Stopping");
				writer.close();
				console.close();
				writer = null;
				console = null;
			}
		}
	}
}
