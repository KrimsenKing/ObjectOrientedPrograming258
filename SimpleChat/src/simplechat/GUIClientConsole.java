package simplechat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import static simplechat.ClientConsole.DEFAULT_PORT;
/**
 *
 * @author scherr3143
 */
public class GUIClientConsole extends JFrame implements ChatIF {
    
    private JButton closeB = new JButton("Close");
    private JButton openB = new JButton("Open");
    private JButton sendB = new JButton("Send");
    private JButton quitB = new JButton("Quit");
	
    private JTextField portTxF = new JTextField("5555");
    private JTextField hostTxF = new JTextField("127.0.0.1");
    private JTextField messageTxF = new JTextField("");
    private JTextField userNameTxF = new JTextField("");
	
    private JLabel portLB = new JLabel("Port: ", JLabel.RIGHT);
    private JLabel hostLB = new JLabel("Host: ", JLabel.RIGHT);
    private JLabel messageLB = new JLabel("Message: ", JLabel.RIGHT);
    private JLabel userNameLB = new JLabel("UserName: ", JLabel.RIGHT);
    
    private JTextArea messageList = new JTextArea();
    
    private String host;
    private int port;
    private String userName;
    ChatClient client;
    
    public GUIClientConsole(String host,int port,String userName){
        
        super("Simple Chat GUI");
        setSize(300, 400);
		
	setLayout( new BorderLayout(5,5));
	Panel bottom = new Panel();
	add( "Center", messageList );
	add( "South" , bottom);
		
	bottom.setLayout( new GridLayout(6,2,5,5));
	bottom.add(hostLB); 		
        bottom.add(hostTxF);
	bottom.add(portLB);
        bottom.add(portTxF);
        bottom.add(userNameLB);
        bottom.add(userNameTxF);
	bottom.add(messageLB); 
        bottom.add(messageTxF);
	bottom.add(openB);
        bottom.add(sendB);
	bottom.add(closeB);
        bottom.add(quitB);
		  	 	
	setVisible(true);
        
        sendB.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		send(messageTxF.getText());
		//display(messageTxF.getText()+"\n" );
            }
        });
        closeB.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		send("#logOff");
		//display(messageTxF.getText()+"\n" );
            }
        });
        openB.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                open();
            }
        });
        //do setters
        this.host = host;
        this.port = port;
        this.userName = userName;
    }

    public void displayBoard(TicTacToe ttt){
        int[][] board = ttt.getBoard();
        String line = "";
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] == 1){
                    line+=" X ";
                }
                else if(board[i][j] == 2){
                    line+=" O ";
                }
                else{
                    line+=" [] ";
                }
            }
            messageList.append(line+"\n");
            line="";
        }
    }
    public void send(String message){
        client.handleMessageFromClientUI(message);
    }
    public void display(String message ){
        //if(messageList.getLineCount() != null){
            messageList.append(message+"\n");
        //}    
    }

    public void open(){
        host = hostTxF.getText();
        userName = userNameTxF.getText();
        port = Integer.parseInt(portTxF.getText());
        try{
            client = new ChatClient(host ,port, userName, this);
        }
        catch(IOException exception){
            System.out.println("Error: Can't setup connection!" + " Terminating client.");
            System.exit(1);
        }
    }
    public static void main(String[] args) 
    {
        String host = "";
        String userName = "";
        int port = 0;  //The port number

        try
        {
            host = args[0];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            host = "localhost";
        }
        try
        {
            port = Integer.parseInt(args[1]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            port = DEFAULT_PORT;
        }
        try
        {
            userName = args[2];
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            userName = "Amon";
        }
        GUIClientConsole chat= new GUIClientConsole(host, port, userName);
        //chat.accept();  //Wait for console data
    }
}
