package dataHandle;

import java.io.*;
import java.nio.file.*;

public class FileHandler
{
    public byte[] convertFileToBytes(File file) {
        byte[] ret = null;

        if (file.exists() == true) {
            try {
                ret=Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                System.out.println("Error convert file to bytes: "+e.getMessage());

            }
        }

        return ret;
    }

    public static boolean writeFileFromBytes(byte[]data,String path)
    {
        if(data!=null)
        {
            try{
                FileOutputStream fout=new FileOutputStream(path);
                fout.write(data);
                return true;
            }
            catch (IOException e)
            {
                System.out.println("Error write byte to file "+e.getMessage());
                return false;
            }
        }
        return false;
    }



}
