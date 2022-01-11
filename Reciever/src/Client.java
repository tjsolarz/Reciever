import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;


public class Client extends JFrame {
   private JButton enterField = new JButton("Send Data");
   private JTextArea displayArea;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private String message = "";
   private String chatServer;
   private Socket client;
   private double Data[][] = new double[3][2];
   private static final String EXCEL_FILE_LOCATION = "C:\\Users\\norbz\\Desktop\\Book1.xls";

   // initialize chatServer and set up GUI
   public Client( String host )
   {
      super( "Client" );

      chatServer = host; // set server to which this client connects

      Container container = getContentPane();

      // create enterField and register listener
      enterField.addActionListener(
         new ActionListener() {

            // send message to server
            public void actionPerformed( ActionEvent event )
            {
               sendData(Data);
               System.out.println(Data.length);
            }
         }  
      ); 

      container.add( enterField, BorderLayout.NORTH );

      // create displayArea
      displayArea = new JTextArea();
      container.add( new JScrollPane( displayArea ),
         BorderLayout.CENTER );

      setSize( 300, 150 );
      setVisible( true );
      Workbook workbook = null;
      try {
    	  workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
    	  
    	  Sheet sheet = workbook.getSheet(0);
    	  for(int x = 0; x<3; x++) {
    		  Cell cell1 = sheet.getCell(0, x);
    		  Cell cell2 = sheet.getCell(1, x);
    		  Data[x][0] = Double.parseDouble(cell1.getContents());
    		  Data[x][1] = Double.parseDouble(cell2.getContents());
    	  }
    	 
          
          
      }catch (IOException e) {
          e.printStackTrace();
      } catch (BiffException e) {
          e.printStackTrace();
      } finally {
          if (workbook != null) {
              workbook.close();
          }
      }
      
   } // end Client constructor

   // connect to server and process messages from server
   private void runClient() 
   {
      // connect to server, get streams, process connection
      try {
         connectToServer(); // Step 1: Create a Socket to make connection
         getStreams();      // Step 2: Get the input and output streams
         processConnection(); // Step 3: Process connection
      }

      // server closed connection
      catch ( EOFException eofException ) {
         System.err.println( "Client terminated connection" );
      }

      // process problems communicating with server
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

      finally {
         closeConnection(); // Step 4: Close connection
      }

   } // end method runClient

   // connect to server
   private void connectToServer() throws IOException
   {      
      displayMessage( "Attempting connection\n" );

      // create Socket to make connection to server
      client = new Socket( InetAddress.getByName( chatServer ), 12345 );
      
      // display connection information
      displayMessage( "Connected to: " + 
         client.getInetAddress().getHostName() );
   }

   // get streams to send and receive data
   private void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream( client.getOutputStream() );      
      output.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream( client.getInputStream() );

      displayMessage( "\nGot I/O streams\n" );
   }

   // process connection with server
   private void processConnection() throws IOException
   {

      do { // process messages sent from server

         // read message and display it
         try {
            message = ( String ) input.readObject();
            displayMessage( "\n" + message );
         }

         // catch problems reading from server
         catch ( ClassNotFoundException classNotFoundException ) {
            displayMessage( "\nUnknown object type received" );
         }

      } while ( !message.equals( "SERVER>>> TERMINATE" ) );

   } // end method processConnection

   // close streams and socket
   private void closeConnection() 
   {
      displayMessage( "\nClosing connection" );

      try {
         output.close();
         input.close();
         client.close();
      }
      catch( IOException ioException ) {
         ioException.printStackTrace();
      }
   }

   // send message to server
   private void sendData( double[][] sheet)
   {
      // send object to server
      try {
    	 for(int x = 0; x<sheet.length; x++) {
         output.writeObject( "CLIENT: " + sheet[x][0]+", "+  sheet[x][1] );
         output.flush();
         displayMessage( "\nCLIENT: " + sheet[x][0] +", "+ sheet[x][1] );
    	 }
      }

      // process problems sending object
      catch ( IOException ioException ) {
         displayArea.append( "\nError writing object" );
      }
   }

   // utility method called from other threads to manipulate 
   // displayArea in the event-dispatch thread
   private void displayMessage( final String messageToDisplay )
   {
      // display message from GUI thread of execution
      SwingUtilities.invokeLater(
         new Runnable() {  // inner class to ensure GUI updates properly

            public void run() // updates displayArea
            {
               displayArea.append( messageToDisplay );
               displayArea.setCaretPosition( 
               displayArea.getText().length() );
            }

         }  // end inner class
      ); // end call to SwingUtilities.invokeLater
   }
  

   public static void main( String args[] )
   {
      Client application;

      if ( args.length == 0 )
         application = new Client( "192.168.1.186" );
      else
         application = new Client( args[ 0 ] );

      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.runClient();
   }

} 
