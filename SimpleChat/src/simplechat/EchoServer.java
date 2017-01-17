package simplechat;

import java.io.*;


/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.

 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient(Object msg, ConnectionToClient client)
  {
      String message = msg.toString();
    if(message.charAt(0)=='#'){
        System.out.println("Command found");
        handleServerCommand(msg,client);
    }
    else{
        System.out.println("Message received: " + msg + " from " + client);
        this.sendToAllClientsInRoom(msg,client);
    }
  }
    
  public void handleServerCommand(Object msg, ConnectionToClient client){
      String message = msg.toString();
      if(message.startsWith("#login")){
          String userName = message.split(" ")[1];
          client.setInfo("userName", userName);
          this.sendToAllClients(userName + " has arrived!");
      }
      else if(message.startsWith("#w")){
          String target = message.split(" ")[1];
          sendToAClient(msg,target);
      }
      else if(message.startsWith("#join")){
          System.out.println("Joining room");
          String room = message.split(" ")[1];
          client.setInfo("room", room);
      }
  }
  
  public void sendToAClient(Object msg, String target){
      
      String message = msg.toString();
      
      String privateMessage = message.substring(message.indexOf(" "),message.length());
      privateMessage = privateMessage.trim();
      privateMessage = privateMessage.substring(privateMessage.indexOf(" "),privateMessage.length());
      privateMessage = privateMessage.trim();
      
      Thread[] clientThreadList = getClientConnections();
      
      for(int i = 0; i< clientThreadList.length; i++){
          ConnectionToClient clientProxy = ((ConnectionToClient) clientThreadList[i]);
          if(clientProxy.getInfo("userName").equals(target)){
              try{
                  clientProxy.sendToClient(privateMessage);
              }
              catch(Exception ex){
                  System.out.println("Failed to send PM");
                  ex.printStackTrace();
              }
          }
      }   
  }
  
  public void sendToAllClientsInRoom(Object msg, ConnectionToClient client)
  {
      String room = client.getInfo("room").toString();
      String message = msg.toString();
          
    //Send to all clients in the same room as sender
    Thread[] clientThreadList = getClientConnections();

    for (int i=0; i<clientThreadList.length; i++)
    {
        
      ConnectionToClient clientProxy = ((ConnectionToClient)clientThreadList[i]);
      
      if(clientProxy.getInfo("room").equals(room))
        {
        try
        {
          clientProxy.sendToClient(message);
        }
        catch (Exception ex) {
            System.out.println("Failed to send message ");
            ex.printStackTrace();
        }
      }
      
    }
  }
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
  //programming problem #5
  @Override
  protected void clientConnected(ConnectionToClient client)
  {
      System.out.println(client.toString() + " has connected to server.");
  }
  @Override
  synchronized protected void clientException(ConnectionToClient client, Throwable exception)
  {
      System.out.println(client.toString() + " has disconnected from server.");
      clientDisconnected(client);
  }
  //
}
//End of EchoServer class
