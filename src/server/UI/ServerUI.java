package server.UI;

import javax.crypto.BadPaddingException;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ServerUI extends JFrame
{
    private JLabel chatServerLabel;
    private JLabel serverDetailLabel;
    private JLabel serverNameLabel;
    private JLabel IPLabel;
    private JLabel portLabel;

    private JTextField serverNameTextField;
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

        //initialize label
        chatServerLabel=new JLabel("CHAT SERVER CONTROL");
        serverDetailLabel=new JLabel("Server Details");
        serverNameLabel=new JLabel("Server Name:");
        IPLabel=new JLabel("IP: ");
        portLabel=new JLabel("Port: ");

        //initilaize textfield
        serverNameTextField=new JTextField();
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
        serverNameLabel.setBounds(20,70,100,30);
        serverNameTextField.setBounds(130,70,200,30);
        serverNameTextField.setEditable(false);
        IPLabel.setBounds(20,120,50,30);
        IPTextField.setBounds(80,120,200,30);
        IPTextField.setEditable(false);
        portLabel.setBounds(300,120,50,30);
        portTextField.setBounds(360,120,100,30);
        portTextField.setEditable(false);

        detailPanel.setPreferredSize(new Dimension(500,200));
        detailPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        detailPanel.setLayout(null);

        detailPanel.add(serverDetailLabel);
        detailPanel.add(serverNameLabel);
        detailPanel.add(serverNameTextField);
        detailPanel.add(IPLabel);
        detailPanel.add(IPTextField);
        detailPanel.add(portLabel);
        detailPanel.add(portTextField);

        //set up tabbed panel
        clientScollPane.setBackground(Color.WHITE);
        clientScollPane.add(clientTable);
        eventScrollPane.setBackground(Color.WHITE);
        eventScrollPane.add(eventTextPane);

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

    }

    public void showUI()
    {
        setVisible(true);
    }





}
