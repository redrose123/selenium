package kdf;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.ReadExcel;

public class Application {

	@Test
	public void testWebsite() throws IOException {

		String[][] data1 = ReadExcel.getData("readexl.xlsx","Sheet1");
		String[][] data5 = ReadExcel.getData("readexl.xlsx","Sheet5");
		for (int k = 1; k<data5.length; k++) {
			for (int i = 1; i < data1.length; i++) {

				switch (data1[i][3]) {
				case "open Browser":
					Methods.openbrowser();
					break;
				case "navigate To":
					Methods.navigateto(data1[i][6]);
					break;
				case "enter User":
					Methods.enterusername(data1[i][4], data1[i][5], data5[k][0]);
					Methods.getscreenshot();
					break;
				case "enter Password":
					Methods.enterpassword(data1[i][4], data1[i][5], data5[k][1]);
					Methods.getscreenshot();
					break;
				case "click Submit":
					Methods.Submit(data1[i][4], data1[i][5]);
					break;
				case "verifyMessage":
					Methods.verifyMessage(data1[i][5], data1[i][6]);
					break;
				case "close Browser":
					Methods.closeBrowser();
					break;
				}

			}
		}
	}

}