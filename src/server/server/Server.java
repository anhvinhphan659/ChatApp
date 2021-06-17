package server.server;

import dataHandle.ClientHandler;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server
{
    static int count=0;
    private ServerSocket ss;
    private int port;
    public static Vector<ClientHandler> clientList;
    public JTextPane eventDisplayPane;

    public Server(int port)
    {
        clientList=new Vector<>();
        this.port=port;
        Socket socket=null;
        try {
            ss = new ServerSocket(port);
            System.out.println(ss.toString()+" is created!");
        }
        catch (IOException ex)
        {
            System.out.println("Error init server "+ex.getMessage());
        }
    }

    public void runServer()
    {
        Socket socket;
        try {
            while (true) {
                System.out.println("Waiting for client...");

                //listen connect
                socket = ss.accept();

                System.out.println("New client has join server");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                //create handle with client
                ClientHandler ch = new ClientHandler(socket, "Client" + count, dis, dos,this);
                if(eventDisplayPane!=null)
                    ch.setEventDisplayPane(eventDisplayPane);
                Thread cur = new Thread(ch);

                cur.start();

                count++;


            }
        }
        catch (IOException ex)
        {
            System.out.println("Error running server "+ex.getMessage());
        }
    }

    public void closeServer()
    {

        try {
            if(ss!=null)
                ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  notifyEvent(String annouce, JTextPane pane)
    {
        System.out.println(annouce);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(pane!=null)
                    pane.setText(pane.getText()+annouce+"\n");
            }
        });

    }

    public void setEventDisplayPane(JTextPane pane)
    {

        eventDisplayPane=pane;
    }

}

