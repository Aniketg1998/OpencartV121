package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Dataprovider 1
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\OpenCart_Testing.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows][totalcols]; //created for two dimension array which can store data
		
		for (int i =1; i<=totalrows; i++)  //1  //read the data from xl storing data from row 2. first row has header
		{
			for (int j=0; j<totalcols; j++)  //0  i is rows j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1",  i,  j);	//1,0
			}
		}
		
		return logindata;  //returning two dimension array
	}
	
}
