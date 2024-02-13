package orangehrm.library;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.Apputils;

public class AdminUtils extends Apputils
{
LoginPage lp;
String adminid = "Admin";
String adminpwd = "Qedge123!@#";

@BeforeTest
public void adminLogin()
{
	lp=new LoginPage();
	lp.login(adminid, adminpwd);
}
@AfterTest
public void adminLogout()
{
	lp.logout();
}
}
