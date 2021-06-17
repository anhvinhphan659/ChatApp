package server.UI;

import server.server.Server;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class ServerUI extends JFrame
{
    //set up member for server
    private Server server;
    private boolean isActive=false;

    //set up for swing
    private JLabel chatServerLabel;
    private JLabel serverDetailLabel;
    private JLabel serverStateLabel;
    private JLabel IPLabel;
    private JLabel portLabel;

    private JTextField serverStateTextField;
    private JTextField IPTextField;
    private JTextField portTextField;

    private JScrollPane clientScollPane;
    private JScrollPane eventScrollPane;

    private JTabbedPane displayTabbedPane;

    private JTextPane eventTextPane;

    private JTable clientTable;

    private JPanel topPanel;
    private JPanel detailPanel;
    private JPanel centerPanel;
    private JPanel buttonPanel;

    private JSeparator separatorTopCenter;
    private JSeparator separatorCenterButton;

    private JButton startButton;
    private JButton stopButton;
    private JButton loadButton;
    private JButton exitButton;

    public ServerUI()
    {
        //initialize frame
        super("Server Chat Control");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(500,800));
        setPreferredSize(new Dimension(500,800));
        setLayout(new BorderLayout());

        //set up server
        server=null;

        //initialize label
        chatServerLabel=new JLabel("CHAT SERVER CONTROL");
        serverDetailLabel=new JLabel("Server Details");
        serverStateLabel =new JLabel("Server State:");
        IPLabel=new JLabel("IP: ");
        portLabel=new JLabel("Port: ");

        //initilaize textfield
        serverStateTextField =new JTextField();
        IPTextField=new JTextField();
        portTextField=new JTextField();

        //initizlize scrollpane
        clientScollPane=new JScrollPane();
        eventScrollPane=new JScrollPane();

        //intitalize tabbedpane
        displayTabbedPane=new JTabbedPane();

        //initialize textarea
        eventTextPane=new JTextPane();

        //initalize table
        clientTable=new JTable();

        //intialize panel
        topPanel=new JPanel();
        detailPanel=new JPanel();
        centerPanel=new JPanel();
        buttonPanel=new JPanel();

        //intialize seperator
        separatorTopCenter=new JSeparator();
        separatorCenterButton=new JSeparator();

        //initalize button
        startButton=new JButton("START");
        stopButton=new JButton("STOP");
        loadButton=new JButton("LOAD");
        exitButton=new JButton("EXIT");

        //set up and add to top panel
        chatServerLabel.setFont(new Font("Arial",Font.PLAIN,30));
        chatServerLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setLayout(new BorderLayout());
        topPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        topPanel.add(chatServerLabel,BorderLayout.CENTER);

        //set up and add to center panel
        centerPanel.setPreferredSize(new Dimension(500,500));
        centerPanel.setLayout(new BorderLayout());
        //set up detail panel
        serverDetailLabel.setBounds(20,20,200,30);
        serverStateLabel.setBounds(20,70,100,30);
        serverStateTextField.setBounds(130,70,200,30);
        serverStateTextField.setEditable(false);
        serverStateTextField.setText("Not running...");
        IPLabel.setBounds(20,120,50,30);
        IPTextField.setBounds(80,120,200,30);
        IPTextField.setEditable(false);
        portLabel.setBounds(300,120,50,30);
        portTextField.setBounds(360,120,100,30);
        portTextField.setText("8888");

        detailPanel.setPreferredSize(new Dimension(500,200));
        detailPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        detailPanel.setLayout(null);

        detailPanel.add(serverDetailLabel);
        detailPanel.add(serverStateLabel);
        detailPanel.add(serverStateTextField);
        detailPanel.add(IPLabel);
        detailPanel.add(IPTextField);
        detailPanel.add(portLabel);
        detailPanel.add(portTextField);

        //set up tabbed panel
        clientScollPane.setBackground(Color.WHITE);
        clientScollPane.setViewportView(clientTable);
        eventScrollPane.setBackground(Color.WHITE);
        eventScrollPane.setViewportView(eventTextPane);
        eventTextPane.setEditable(false);

        displayTabbedPane.setPreferredSize(new Dimension(500,200));
        displayTabbedPane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        displayTabbedPane.add("Client",clientScollPane);
        displayTabbedPane.add("Event",eventScrollPane);

        //add to center panel
        centerPanel.add(detailPanel,BorderLayout.NORTH);
        centerPanel.add(displayTabbedPane, BorderLayout.CENTER);

        //set up and add button panel;

        startButton.setPreferredSize(new Dimension(100,50));
        stopButton.setPreferredSize(new Dimension(100,50));
        loadButton.setPreferredSize(new Dimension(100,50));
        exitButton.setPreferredSize(new Dimension(100,50));

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exitButton);

        //add to frame
        add(topPanel,BorderLayout.NORTH);

        add(centerPanel,BorderLayout.CENTER);

        add(buttonPanel,BorderLayout.SOUTH);

        //decorate UI
        clientScollPane.setBackground(Color.WHITE);
        eventScrollPane.setBackground(Color.WHITE);

        //set up button action
        setupAction();

    }

    public void showUI()
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });

    }

    private void setupAction()
    {
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    IPTextField.setText(Inet4Address.getLocalHost().getHostAddress());

                }
                catch (UnknownHostException ue)
                {
                    System.out.println("Error set IP "+ue.getCause());
                }
                int port=Integer.parseInt(portTextField.getText());
                //start server
                server=new Server(port);
                Server.notifyEvent("ServerStarted",eventTextPane);
                serverStateTextField.setText("Running");
                //set up eventPanel
                server.setEventDisplayPane(eventTextPane);
                isActive=true;
                Thread serverThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        server.runServer();
                    }
                });
                serverThread.start();

            }
        });


        stopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(server!=null&&isActive)
                {
                    server.closeServer();
                    server=null;


                serverStateTextField.setText("Not Running...");
                IPTextField.setText("");
                Server.notifyEvent("Server stopped",eventTextPane);
                }
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(server!=null)
                {
                    server.closeServer();
                }
                dispose();
            }
        });
    }






}
