package client.UI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class ClientUI extends JFrame
{
    private JLabel serverLabel;
    private JLabel serverDetailLabel;
    private JLabel nameLabel;
    private JLabel IPLabel;
    private JLabel portLabel;
    private JLabel stateLabel;
    private JLabel onlineLabel;
    private JLabel userOnlineLabel;
    private JLabel registeredLabel;

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu editMenu;

    private JMenuItem loadMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem editMenuItem;

    private JComboBox serverComboBox;

    private JTextField nameTextField;
    private JTextField IPTextField;
    private JTextField portTextField;
    private JTextField stateTextField;
    private JTextField onlineTextField;
    private JTextField messageTextField;

    private JCheckBox registeredCheckBox;

    private java.util.List<JButton> userButtonList = new LinkedList<>();

    private JButton connectButton;
    private JButton registerButton;
    private JButton createGroupButton;
    private JButton emojiButton;
    private JButton sendFileButton;
    private JButton sendMessageButton;

    private JTextPane messageTextPane;

    private JScrollPane userOnlineScrollPane;
    private JScrollPane messageScrollPane;

    private JPanel userOnlinePanel;
    private JPanel serverChoosePanel;
    private JPanel serverDetailPanel;
    private JPanel activePanel;
    private JPanel eventDisplayPanel;
    private JPanel displayPanel;
    private JPanel topPanel;
    private JPanel centerPanel;

    private final int _WIDTH_SIZE=900;
    public ClientUI()
    {
        //set up frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(900,800));
        setPreferredSize(new Dimension(900,800));


        //initialize
        serverLabel=new JLabel("Server:");
        serverDetailLabel=new JLabel("Server Details:");
        nameLabel=new JLabel("Name: ");
        IPLabel=new JLabel("IP: ");
        portLabel=new JLabel("Port: ");
        stateLabel=new JLabel("State");
        onlineLabel=new JLabel("Online: ");
        userOnlineLabel=new JLabel("User online: ");
        registeredLabel =new JLabel("Registered");


        menuBar=new JMenuBar();

        fileMenu=new JMenu("File");
        editMenu=new JMenu("Edit");

        loadMenuItem=new JMenuItem("Load config");
        saveMenuItem=new JMenuItem("Save config");
        deleteMenuItem=new JMenuItem("Delete... ");
        editMenuItem=new JMenuItem("Edit...");

        serverComboBox=new JComboBox();

        nameTextField=new JTextField();
        IPTextField=new JTextField();
        portTextField=new JTextField();
        stateTextField=new JTextField();
        onlineTextField=new JTextField();
        messageTextField=new JTextField();

        registeredCheckBox=new JCheckBox();

        connectButton=new JButton("Connect");
        registerButton=new JButton("Register");
        createGroupButton=new JButton("Create Group");
        emojiButton=new JButton();
        sendFileButton=new JButton();
        sendMessageButton=new JButton("Send");

        messageTextPane=new JTextPane();
        userOnlineScrollPane=new JScrollPane(userOnlinePanel);
        messageScrollPane=new JScrollPane(messageTextPane);

        userOnlinePanel=new JPanel();
        serverChoosePanel=new JPanel();
        serverDetailPanel=new JPanel();
        activePanel=new JPanel();
        eventDisplayPanel=new JPanel();
        displayPanel=new JPanel();
        topPanel=new JPanel();
        centerPanel=new JPanel();

        //set up top panel
        topPanel.setPreferredSize(new Dimension(_WIDTH_SIZE,300));
        topPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        topPanel.setLayout(new BorderLayout());
        //set up server choose panel
        serverChoosePanel.setPreferredSize(new Dimension(_WIDTH_SIZE,50));
        serverChoosePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        serverChoosePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

//        serverLabel.setBounds(20,20,100,30);
//        serverComboBox.setBounds(130,20,200,30);
//        connectButton.setBounds(340,20,100,30);
        serverComboBox.setPreferredSize(new Dimension(400,30));

        serverChoosePanel.add(serverLabel);
        serverChoosePanel.add(serverComboBox);
        serverChoosePanel.add(connectButton);
        //set up server detail
        serverDetailPanel.setPreferredSize(new Dimension(_WIDTH_SIZE,200));
        serverDetailPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        serverDetailPanel.setLayout(null);

        serverDetailLabel.setBounds(20,20,200,30);
        nameLabel.setBounds(20,70,50,30);
        nameTextField.setBounds(80,70,150,30);
        IPLabel.setBounds(240,70,50,30);
        IPTextField.setBounds(290,70,150,30);
        portLabel.setBounds(450,70,50,30);
        portTextField.setBounds(500,70,100,30);
        stateLabel.setBounds(20,120,50,30);
        stateTextField.setBounds(70,120,100,30);
        onlineLabel.setBounds(180,120,80,30);
        onlineTextField.setBounds(260,120,50,30);
        registeredCheckBox.setBounds(320,120,20,30);
        registeredLabel.setBounds(350,120,100,30);
        registerButton.setBounds(480,120,100,30);

        serverDetailPanel.add(serverDetailLabel);
        serverDetailPanel.add(nameLabel);
        serverDetailPanel.add(nameTextField);
        serverDetailPanel.add(IPLabel);
        serverDetailPanel.add(IPTextField);
        serverDetailPanel.add(portLabel);
        serverDetailPanel.add(portTextField);
        serverDetailPanel.add(stateLabel);
        serverDetailPanel.add(stateTextField);
        serverDetailPanel.add(onlineLabel);
        serverDetailPanel.add(onlineTextField);
        serverDetailPanel.add(registeredCheckBox);
        serverDetailPanel.add(registeredLabel);
        serverDetailPanel.add(registerButton);
        //set up menu
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);

        editMenu.add(editMenuItem);
        editMenu.add(deleteMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //add to top panel
        topPanel.add(menuBar,BorderLayout.NORTH);
        topPanel.add(serverChoosePanel,BorderLayout.CENTER);
        topPanel.add(serverDetailPanel,BorderLayout.SOUTH);

        //set up center panel
        centerPanel.setPreferredSize(new Dimension(_WIDTH_SIZE,500));
        centerPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        centerPanel.setLayout(new BorderLayout());
        //set up active panel
        activePanel.setPreferredSize(new Dimension(200,centerPanel.getHeight()));
        activePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        activePanel.setLayout(new BorderLayout());


        userOnlineLabel.setPreferredSize(new Dimension(200,30));
        userOnlinePanel.setLayout(new FlowLayout());
        userOnlineScrollPane.setPreferredSize(new Dimension(200,400));

        activePanel.add(userOnlineLabel,BorderLayout.NORTH);
        activePanel.add(userOnlineScrollPane,BorderLayout.CENTER);
        activePanel.add(createGroupButton,BorderLayout.SOUTH);
        //set up display panel
        displayPanel.setPreferredSize(new Dimension(_WIDTH_SIZE-200,centerPanel.getHeight()));
        displayPanel.setLayout(new BorderLayout());
        messageTextPane.setPreferredSize(new Dimension(displayPanel.getWidth(),centerPanel.getHeight()));
        messageScrollPane.setPreferredSize(new Dimension(displayPanel.getWidth(),450));
        //set up event panel
        eventDisplayPanel.setPreferredSize(new Dimension(_WIDTH_SIZE-200,50));
        eventDisplayPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        eventDisplayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

//        emojiButton.setBounds(20,10,50,30);
//        messageTextField.setBounds(80,10,350,30);
//        sendFileButton.setBounds(440,10,50,30);
//        sendMessageButton.setBounds(500,10,100,30);
        emojiButton.setPreferredSize(new Dimension(50,30));
        messageTextField.setPreferredSize(new Dimension(400,30));
        sendFileButton.setPreferredSize(new Dimension(50,30));
        sendMessageButton.setPreferredSize(new Dimension(100,30));

        eventDisplayPanel.add(emojiButton);
        eventDisplayPanel.add(messageTextField);
        eventDisplayPanel.add(sendFileButton);
        eventDisplayPanel.add(sendMessageButton);
        //add to display panel
        displayPanel.add(messageScrollPane,BorderLayout.CENTER);
        displayPanel.add(eventDisplayPanel,BorderLayout.SOUTH);

        //add to center panel
        centerPanel.add(activePanel,BorderLayout.WEST);
        centerPanel.add(displayPanel,BorderLayout.CENTER);

        //add to frame
        add(topPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);

    }

    public void showUI()
    {
        setVisible(true);
    }


}
