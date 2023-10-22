package org.gedha.pages;

import org.gedha.drivers.DriverSingelton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSouceDemo {
    private WebDriver driver;

    public LoginSouceDemo(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //locator;
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement strPageInventory;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorLocked;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement btnBurger;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;


    /*
    *
    *
    * */

    public void quickLogin(String name, String password){
        this.username.sendKeys(name);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    public void quickLogout(){
        btnBurger.click();
        btnLogout.click();
    }

    public void inputUsername(String username){
        this.username.sendKeys(username);
    }
    public void inputPassword(String password){
        this.password.sendKeys(password);
    }
    public void clickBtnLogin(){
        btnLogin.click();
    }
    public void clickBtnHumberger(){
        btnBurger.click();
    }
    public void clickBtnLogout(){
        btnLogout.click();
    }

    /*
    * Assert
    * */
    public String getTextInventory(){
        return strPageInventory.getText();
    }
    public String getErrorLocked(){
        return errorLocked.getText();
    }


}
