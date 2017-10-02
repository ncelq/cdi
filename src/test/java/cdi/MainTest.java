package cdi;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.angusleigh.kaggle.cdi.Main;

public class MainTest {

	@Test
	public void test() throws FileNotFoundException {
		Main main = new Main();
		
		main.bsonDump("/mnt/disks/sdb/kaggle/test.bson");
	}

}
