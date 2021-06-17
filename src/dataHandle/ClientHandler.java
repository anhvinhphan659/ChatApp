package dataHandle;

import server.server.Server;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable
{

    private String name;
    public final DataOutputStream dos;
    public final DataInputStream dis;
    Socket socket;
    boolean isLogin=false;
    private JTextPane eventDisplayPane;
    private Server server;

    public ClientHandler(Socket s,String name,DataInputStream din,DataOutputStream dout,Server sv)
    {
        socket=s;
        this.name=name;
        dis=din;
        dos=dout;
        isLogin=true;
        server=sv;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                //get message
                String message = null;
                String writemessage="";
                try {
                    message = dis.readUTF();
                    Server.notifyEvent(name+" send: "+message,eventDisplayPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (message.compareTo("*quit*") == 0) {
                    isLogin = false;
                    String notify=name+" has left server";
                    Server.notifyEvent(notify,eventDisplayPane);

                    socket.close();
                    break;
                }
                else if(message.indexOf("*join*")>=0)
                {
                    name=message.substring(message.indexOf("*join*")+"*join*".length());
                    Server.clientList.add(this);
                    isLogin=true;
                    //update user list to all user
                    writemessage=getOnlineList();

                }

                //handle message
                if(message.indexOf("*join*")<0) {
                    for (ClientHandler ch : Server.clientList) {
                        if (ch != this && ch.isLogin == true) {
                            System.out.println(name + ": " + message);
                            ch.dos.writeUTF(name + ": " + message);
                            ch.dos.flush();

                        }

                    }
                }
                else {
                    for (ClientHandler ch : Server.clientList) {
                        if (ch.isLogin == true) {
                            System.out.println(writemessage);
                            ch.dos.writeUTF(writemessage);
                            ch.dos.flush();

                        }
                    }
                }

            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void setEventDisplayPane(JTextPane eventDisplayPane) {
        this.eventDisplayPane = eventDisplayPane;
    }

    public String getName()
    {
        return name;
    }

    public String getOnlineList()
    {
        if(Server.clientList!=null)
        {
            String update="*update*";
            for(ClientHandler ch:Server.clientList)
            {
                update+="-"+ch.getName();
            }
            update+="\n";
            return update;
        }
        return "";
    }
}
