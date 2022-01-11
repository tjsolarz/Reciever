import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Reciever extends JFrame{
	private ServerSocket server;
	private Socket connection;
	private Debug D = new Debug();
	private Message M = new Message();
	private SpecifyPacket SP = new SpecifyPacket();
	private Modulation Mo = new Modulation();
	private Rx R = new Rx();
	private DisImg DI = new DisImg();
	private int counter = 1;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	   
	public static void main(String[] args) {
		Reciever x = new Reciever();
		x.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    x.setSize( 700, 500 );
	    x.setVisible( true );
	    x.runServer();
	}
	
	public Reciever() {
		super("Reciever");
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Rx Display", M);
		tabbedPane.addTab("Specify Packet", SP);
		tabbedPane.addTab("Specify Modulation", Mo);
		tabbedPane.addTab("Rx Parameters", R);
		tabbedPane.addTab("Debug", D);
		tabbedPane.addTab("Image Display",DI);
		add(tabbedPane);
	}
	
	private void runServer() {
		// set up server to receive connections; process connections
	      try {

	         // Step 1: Create a ServerSocket.
	         server = new ServerSocket( 12345, 100 );

	         while ( true ) {

	            try {
	               waitForConnection(); // Step 2: Wait for a connection.
	               getStreams();        // Step 3: Get input & output streams.
	               processConnection(); // Step 4: Process connection.
	            }

	            // process EOFException when client closes connection 
	            catch ( EOFException eofException ) {
	               System.err.println( "Server terminated connection" );
	            }

	            finally {
	               closeConnection();   // Step 5: Close connection.
	               ++counter;
	            }

	         } // end while

	      } // end try

	      // process problems with I/O
	      catch ( IOException ioException ) {
	         ioException.printStackTrace();
	      }

	}
	
	private void waitForConnection() throws IOException
	   {
	      D.sendDM( "Waiting for connection\n" );
	      connection = server.accept(); // allow server to accept connection            
	      D.sendDM( "Connection " + counter + " received from: " +
	         connection.getInetAddress().getHostName() );
	   }
	
	private void getStreams() throws IOException
	   {
	      // set up output stream for objects
	      output = new ObjectOutputStream( connection.getOutputStream() );
	      output.flush(); // flush output buffer to send header information

	      // set up input stream for objects
	      input = new ObjectInputStream( connection.getInputStream() );

	      D.sendDM( "\nGot I/O streams\n" );
	   }
	
	private void processConnection() throws IOException
	   {
	      // send connection successful message to client
	      String message = "Connection successful";
	      D.sendDM( message );

	      do { // process messages sent from client

	         // read message and display it
	         try {
	            message = ( String ) input.readObject();
	            M.sendM( "\n" + message );
	         }

	         // catch problems reading from client
	         catch ( ClassNotFoundException classNotFoundException ) {
	        	 D.sendDM( "\nUnknown object type received" );
	         }

	      } while ( !message.equals( "CLIENT CONNECTION TERMINATED" ) );

	   }
	

	private void closeConnection() 
	   {
	      D.sendDM( "\nTerminating connection\n" );

	      try {
	         output.close();
	         input.close();
	         connection.close();
	      }
	      catch( IOException ioException ) {
	         ioException.printStackTrace();
	      }
	   }
	
	
}
