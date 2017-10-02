package com.angusleigh.kaggle.cdi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.bson.BSONDecoder;
import org.bson.BSONObject;
import org.bson.BasicBSONDecoder;

import com.angusleigh.kaggle.cdi.bean.Item;
import com.google.gson.Gson;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);
	
    public void bsonDump(String filename) throws FileNotFoundException {

        File file = new File(filename);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        BSONDecoder decoder = new BasicBSONDecoder();

        int count = 0;
        try {
            while (inputStream.available() > 0) {

                BSONObject obj = decoder.readObject(inputStream);
                if(obj == null){
                    break;
                }
                Gson gson = new Gson();
                Item item = gson.fromJson(obj.toString(), Item.class);
                
                File f = new File("/tmp/" + item.getCategoryId());
                if (!f.isDirectory()) {
                		f.mkdirs();
                }

                FileUtils.writeByteArrayToFile(new File(f.getAbsolutePath()+"/"+item.getId()+".jpg"), Base64.decodeBase64(item.getImgs().get(0).getPicture().getBinary().getBytes()));
                
                count++;

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        log.info(String.format("%s objects read", count));
    }
	
	public static void main(String[] args) throws FileNotFoundException {
	       String filename = "/Users/angusleigh/Documents/Projects/Kaggle/cdi/data/train_example.bson";
	        Main main = new Main();
	        main.bsonDump(filename);
	}
	
}