package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path="C:\\Automation\\myworkspace\\OpenCart121\\testData\\Book1.xlsx";
		
		ExcelUtils xlutil=new ExcelUtils();
		
		int totalRow=xlutil.getRowCount(path,"sheet1");
		int totalcol=xlutil.getCellCount(path, "sheet1", totalRow);
		
		String logindata[][]=new String[totalRow][totalcol];
		
		for (int i=1;i<=totalRow;i++) {
			for (int j=0;j<totalcol;j++) {
				logindata[i-1][j]=xlutil.getCellData(path, "sheet1", i, j);
			}
		}
		return logindata;
	}

}
