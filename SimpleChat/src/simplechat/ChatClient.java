package simplechat;

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *

 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
    ChatIF clientUI; 

    TicTacToe game;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
    public ChatClient(String host, int port, ChatIF clientUI) throws IOException 
    {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
    }

    public ChatClient(String host, int port, String userName, ChatIF clientUI) throws IOException 
    {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
        sendToServer("#join commons");
        sendToServer("#login " + userName);
    }
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
    @Override
    public void handleMessageFromServer(Object msg) 
    {
        if(msg instanceof TicTacToe){
            TicTacToe ttt = (TicTacToe)(msg);
            game = ttt;
            ((GUIClientConsole)clientUI).displayBoard(ttt);
            clientUI.display("Your move Chum!");
        }
        else{
            clientUI.display(msg.toString());
        }
    }
  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
    public void handleMessageFromClientUI(String message)
    {
        if(message.charAt(0)=='#'){
            handleClientCommand(message);
        }
        else{
            try
            {
                sendToServer(message);
            }
            catch(IOException e)
            {
                clientUI.display
                ("Could not send message to server.  Terminating client.");
                quit();
            }
        }
    }
  
    public void handleClientCommand(String message)
    {
        if(message.startsWith("#getPort")){
            clientUI.display(String.valueOf(getPort()));
        }
        else if(message.startsWith("#setPort")){
            if(!isConnected())
                setPort(Integer.parseInt(message.split(" ")[1]));
            else
                clientUI.display("Please #logOff to change.");
        }
        else if(message.startsWith("#logOff")){
            try{
                closeConnection();
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        else if(message.startsWith("#sendTicTacToe")){
            try{
                String recipient = message.split(" ")[1];
                int[][] board = new int[3][3];
                Envelope e = new Envelope(recipient,board);
                sendToServer(e);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(message.startsWith("#ttt")){
            try{
                int move = Integer.parseInt(message.split(" ")[1]);
                if(game.getActivePlayer().equals(game.getPlayer1())){
                    
                   game.move(move, 1);
                }
                else{
                    game.move(move, 2);
                }
                //Envelope e = new Envelope(null,game);
                sendToServer(game);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(message.startsWith("#logOn")){
            try{
                openConnection();
            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        else if(message.startsWith("#getHost")){
            clientUI.display(getHost());
        }
        else if(message.startsWith("#setHost")){
            if(!isConnected())
                setHost(message.split(" ")[1]);
            else
                clientUI.display("Please #logOff to change.");
        }
        else if(message.startsWith("#quit")){
            quit();
        }
        else{
            try{
                sendToServer(message);
            }
            catch(IOException ex){
                clientUI.display("Could not send message to server. Terminate");
                ex.printStackTrace();
                quit(); 
            }
        }
    }
  /**
   * This method terminates the client.
   */
    public void quit()
    {
        try
        {
            closeConnection();
        }
        catch(IOException e) {}
            System.exit(0);
    }
  
    @Override
    protected void connectionException(Exception exception){
        System.out.println("Server shutdown");
      //After implementing connection closed, call it here...
        connectionClosed();
    }
}
//End of ChatClient class