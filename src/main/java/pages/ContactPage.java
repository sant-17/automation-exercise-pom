package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

public class ContactPage extends CommonActionPages{

    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement textareaMessage;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement inputFile;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement lblSuccess;

    public void sendForm() {
        String name = "Juan";
        String email = "juan@email.com";
        String subject = "Claim";
        String message = "Hi, I'd like to make a claim.";
        File uploadFile = new File("src/main/resources/lost.jpg");

        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputSubject.sendKeys(subject);
        textareaMessage.sendKeys(message);
        inputFile.sendKeys(uploadFile.getAbsolutePath());
        btnSubmit.click();

        Alert alert = waitTimeInSeconds(Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        alert.accept();

        waitElementVisible(lblSuccess, Duration.ofSeconds(5));
    }

    public String getSuccessMessage() {
        return lblSuccess.getText();
    }
}
