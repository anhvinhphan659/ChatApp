package client.UI;

import client.client.Client;
import server.server.Server;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class ClientUI extends JFrame
{
    //set up for client
    Client client=null;
    private boolean isActive=false;

    //set up for swing
    private JLabel serverLabel;
    private JLabel serverDetailLabel;
    private JLabel stateLabel;
    private JLabel IPLabel;
    private JLabel portLabel;
    private JLabel nameDisplayLabel;
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

    private JTextField stateTextField;
    private JTextField IPTextField;
    private JTextField portTextField;
    private JTextField nameDisplayTextField;
    private JTextField onlineTextField;
    private JTextField messageTextField;

    private JCheckBox registeredCheckBox;

    private DefaultListModel userListModel;
    private JList userList;

    private String[] userOnlineArray={};

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
        stateLabel=new JLabel("State: ");
        IPLabel=new JLabel("IP: ");
        portLabel=new JLabel("Port: ");
        nameDisplayLabel =new JLabel("Name Display: ");
        onlineLabel=new JLabel("Online: ");
        userOnlineLabel=new JLabel("User online: ");
        registeredLabel =new JLabel("Registered");


        menuBar=new JMenuBar();

        fileMenu=new JMenu("File");
        editMenu=new JMenu("Edit");

        loadMenuItem=new JMenuItem("Load...");
        saveMenuItem=new JMenuItem("Save...");
        deleteMenuItem=new JMenuItem("Delete... ");
        editMenuItem=new JMenuItem("Edit...");

        serverComboBox=new JComboBox();

        stateTextField =new JTextField();
        IPTextField=new JTextField("localhost");
        portTextField=new JTextField();
        nameDisplayTextField =new JTextField();
        onlineTextField=new JTextField();
        messageTextField=new JTextField();

        userListModel=new DefaultListModel();
        userListModel.addElement("test");
        userList=new JList(userListModel);

        registeredCheckBox=new JCheckBox();

        connectButton=new JButton("Connect");
        registerButton=new JButton("Register");
        createGroupButton=new JButton("Create Group");
        emojiButton=new JButton();
        sendFileButton=new JButton();
        sendMessageButton=new JButton("Send");

        messageTextPane=new JTextPane();
        userOnlineScrollPane=new JScrollPane(userList);


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
        stateLabel.setBounds(20,70,50,30);
        stateTextField.setBounds(80,70,150,30);
        stateTextField.setEditable(false);
        stateTextField.setText("not Running");
        IPLabel.setBounds(240,70,50,30);
        IPTextField.setBounds(290,70,150,30);
        IPTextField.setEditable(false);
        portLabel.setBounds(450,70,50,30);
        portTextField.setBounds(500,70,100,30);
        nameDisplayLabel.setBounds(20,120,100,30);
        nameDisplayTextField.setBounds(100,120,150,30);
        onlineLabel.setBounds(260,120,80,30);
        onlineTextField.setBounds(340,120,50,30);
        registeredCheckBox.setBounds(400,120,20,30);
        registeredCheckBox.setEnabled(false);
        registeredLabel.setBounds(430,120,100,30);
        registerButton.setBounds(540,120,100,30);

        serverDetailPanel.add(serverDetailLabel);
        serverDetailPanel.add(stateLabel);
        serverDetailPanel.add(stateTextField);
        serverDetailPanel.add(IPLabel);
        serverDetailPanel.add(IPTextField);
        serverDetailPanel.add(portLabel);
        serverDetailPanel.add(portTextField);
        serverDetailPanel.add(nameDisplayLabel);
        serverDetailPanel.add(nameDisplayTextField);
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

        //set up action
        setupAction();

    }

    public void showUI()
    {
        setVisible(true);
    }

    private void  setupAction()
    {
        loadMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMenuItemActionperformed(e);
            }

            private void loadMenuItemActionperformed(ActionEvent e)
            {
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.setFocusable(true);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result=fileChooser.showOpenDialog(null);
                if(result==JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile=fileChooser.getSelectedFile();
                    //TODO: process file
                    System.out.println("File selected: "+selectedFile.getName());
                }

            }
        });

        sendFileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.setFocusable(true);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result=fileChooser.showOpenDialog(null);
                if(result==JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile=fileChooser.getSelectedFile();
                    //TODO: process file
                    System.out.println("File selected: "+selectedFile.getName());
                }

            }
        });

        connectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //TODO: Get data and connect to server
                if(connectButton.getText().compareTo("Connect")==0)
                {
                    String host=IPTextField.getText();
                    int port=Integer.parseInt(portTextField.getText());
                    if(client==null) {
                        Thread clientRun = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                client = new Client(host, port);
                                client.setClientUI(ClientUI.this);

                            }
                        });
                        clientRun.start();
                    }
                    connectButton.setText("Disconnect");

                }
                else
                {
                    connectButton.setText("Connect");
                    //TODO: disconnect to server
                }
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //check name
                String name=nameDisplayTextField.getText();
                if(name.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please fill name to display");
                    return;
                }
                registeredCheckBox.setSelected(true);
                registerButton.setEnabled(false);

                client.setMessageTextPane(messageTextPane);
                client.joinServer(name);
                Thread read=new Thread(client.new ReadThread());
                read.start();


            }
        });

        sendMessageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String message=messageTextField.getText();
                if(message.isEmpty())
                    return;
                if(client!=null)
                {
                    Thread send=new Thread(client.new WriteThread(message));
                    send.start();
                    Server.notifyEvent(message,messageTextPane);
                }
                messageTextField.setText("");

            }
        });

        userList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount()==2)
                {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            messageTextPane.setText("");
                        }
                    });
                }
            }
        });


    }

    public void setUserOnlineArray(String[] data)
    {
        userOnlineArray=data;
        userList.setListData(data);
        setVisible(true);
        onlineTextField.setText(String.valueOf(data.length));
    }

}
