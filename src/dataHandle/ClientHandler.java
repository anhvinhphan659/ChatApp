package dataHandle;

import server.server.Server;

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
    boolean isLogin;

    public ClientHandler(Socket s,String name,DataInputStream din,DataOutputStream dout)
    {
        socket=s;
        this.name=name;
        dis=din;
        dos=dout;
        isLogin=true;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                //get message
                String message = null;
                try {
                    message = dis.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (message.compareTo("*quit*") == 0) {
                    isLogin = false;
                    socket.close();
                    break;
                }
                //handle message
                for(ClientHandler ch: Server.clientList)
                {
                    if(ch!=this&& ch.isLogin==true)
                    {
                        System.out.println(name+": "+message);
                        ch.dos.writeUTF(name+": "+message);
                        ch.dos.flush();

                    }
                }


            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
