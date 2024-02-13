package orangehrm.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.Apputils;
import utils.XLUtils;


public class AdminLoginwithValidInputs extends Apputils
{
	String datafile="C:\\Users\\priya\\eclipse-workspace\\2023\\Demo1\\OrangeHRM_POM\\testdatafiles\\TestDataLogin.xlsx";
	String datasheet="AdminLogin_ValidData";


	@Test
	public void checkAdminLogin() throws IOException 
	{
		int rowcount = XLUtils.getRowCount(datafile, datasheet);
		String uid,pwd;

		for(int i=1;i<=rowcount;i++) 
		{
			uid= XLUtils.getStringData(datafile, datasheet, i, 0);
			pwd= XLUtils.getStringData(datafile, datasheet, i, 1);

			LoginPage lp= new LoginPage();
			lp.login(uid, pwd);
		boolean res=lp.isAdminModuleDisplayed();
	Assert.assertTrue(res);
	
	if(res)
	{
		XLUtils.setCellData(datafile, datasheet, i, 2, "pass");
	XLUtils.fillGreenColor(datafile, datasheet, i, 2);
	}else
	{
		XLUtils.setCellData(datafile, datasheet, i, 2, "fail");
		XLUtils.fillRedColor(datafile, datasheet, i, 2);
	}
	lp.logout();
		
		}

	}






}
