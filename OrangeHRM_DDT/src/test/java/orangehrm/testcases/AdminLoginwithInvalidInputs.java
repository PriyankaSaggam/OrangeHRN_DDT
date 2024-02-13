package orangehrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.Apputils;
import utils.XLUtils;

public class AdminLoginwithInvalidInputs extends Apputils
{
	String datafile="C:\\Users\\priya\\eclipse-workspace\\2023\\Demo1\\OrangeHRM_DDT\\testdatafiles\\TestDataLogin.xlsx";
	String datasheet="AdminLogin_InvalidData";


	@Test
	public void checkAdminLogin() throws IOException 
	{
		int rownum=XLUtils.getRowCount(datafile, datasheet);
		String uid,pwd;

		for(int i=1;i<=rownum;i++)
		{
			uid = XLUtils.getStringData(datafile, datasheet, i, 0);
			pwd = XLUtils.getStringData(datafile, datasheet, i, 1);


			LoginPage lp= new LoginPage();
			lp.login(uid, pwd);
			boolean res= lp.isErrMsgDisplayed();
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

		}



	}








}
