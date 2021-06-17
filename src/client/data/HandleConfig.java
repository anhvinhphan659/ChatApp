package client.data;

import java.io.*;
import java.util.Properties;

class ServerInfo
{
    String name;
    String ip;
    String port;

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(String port) {
        this.port = port;
    }
}


public class HandleConfig
{
    FileInputStream fin;
    HandleConfig(String fileName)
    {
        fin=null;
        try {
            fin=new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void config()
    {
        try {
            Reader reader = new InputStreamReader(fin);
            Properties props = new Properties();
            props.load(reader);
            for (Object obj : props.keySet()) {
                System.out.println(obj.toString());
                System.out.println(props.getProperty(obj.toString()));
            }

            reader.close();
        }
        catch (IOException ie)
        {
            System.out.println("Error read config file "+ie.getMessage());
        }

    }
//    public String[][] getListDataConfig()
//    {
//        HashMap<String,List<String>>
//        try
//        {
//            Reader reader = new InputStreamReader(fin);
//            Properties props = new Properties();
//            props.load(reader);
//            for (Object obj : props.keySet()) {
//                System.out.println(obj.toString());
//                System.out.println(props.getProperty(obj.toString()));
//            }
//        }
//        catch (IOException ex)
//        {
//            System.out.println("Error reading config file "+ex.getMessage());
//        }
//        return ret.toArray(new String[0][]);
//    }

    public static String getExtendString(String filename)
    {
        int find=filename.indexOf(".");
        String extend="";
        if(find>0)
            extend=filename.substring(find,filename.length()-1);
        return extend;

    }
}
