package Actions;

import PageObjects.HomePO;
import PageObjects.LoginPO;
import PageObjects.NewCustomerPO;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    protected static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }

    protected static HomePO getHomePage(WebDriver driver){
        return new HomePO(driver);
    }

    protected static NewCustomerPO getNewCustomerPage(WebDriver driver){ return new NewCustomerPO(driver);}
}
