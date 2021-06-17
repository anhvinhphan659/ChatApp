package client.clientRun;

import client.UI.ClientUI;

import java.io.IOException;

public class ClientRun
{
    public static void main(String[] args) throws IOException
    {
//        Client client=new Client("localhost",8888);
//
        ClientUI clientUI=new ClientUI();
        clientUI.showUI();
    }
}
