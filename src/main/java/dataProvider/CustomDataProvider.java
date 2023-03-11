package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "loginDetails")
	public static Object[][] getData() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("Sheet1");
		return arr;
	}
	
	@DataProvider(name = "addNewUser")
	public static Object[][] getData1() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("Sheet2");
		return arr;
	}
	
	@DataProvider(name = "ViewUser")
	public static Object[][] getData2() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("Sheet3");
		return arr;
	}

}
