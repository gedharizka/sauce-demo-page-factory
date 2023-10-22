package org.gedha.pages;

import org.gedha.drivers.DriverSingelton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
    private WebDriver driver;

    public Checkout(){
        this.driver = DriverSingelton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement btnAddBackpack;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement btnAddFleece;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement btnShopingCart;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckout;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement inputFirstname;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement inputLastname;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement inputPostal;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContiune;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement elStepTwo;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement elHeader;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement elLastNameReq;

    public void quickAddtoCart(){
        btnAddBackpack.click();
        btnAddFleece.click();
        btnShopingCart.click();
        btnCheckout.click();
    }

    public void setInputFirstname(String name){
        this.inputFirstname.sendKeys(name);
    }
    public void setInputLastname(String lastname){
        this.inputLastname.sendKeys(lastname);
    }
    public void setInputPostal(String postal){
        this.inputPostal.sendKeys(postal);
    }

    public void handleBtnContiune(){
        btnContiune.click();
    }
    public void handleBtnFinish(){
        btnFinish.click();
    }
    public  String getTextFinish(){
        return elHeader.getText();
    }
    public  String getTextStep2(){
        return elStepTwo.getText();
    }
    public String getErrLastName(){
        return elLastNameReq.getText();
    }

}
