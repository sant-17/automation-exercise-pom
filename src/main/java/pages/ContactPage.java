package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

public class ContactPage extends CommonActionPages{

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    By inputName = By.xpath("//input[@name='name']");
    By inputEmail = By.xpath("//input[@name='email']");
    By inputSubject = By.xpath("//input[@name='subject']");
    By textareaMessage = By.xpath("//textarea[@name='message']");
    By inputFile = By.xpath("//input[@name='upload_file']");
    By btnSubmit = By.xpath("//input[@name='submit']");
    By lblSuccess = By.xpath("//div[@class='status alert alert-success']");

    public void sendForm() {
        String name = "Juan";
        String email = "juan@email.com";
        String subject = "Claim";
        String message = "Hi, I'd like to make a claim.";
        File uploadFile = new File("src/main/resources/lost.jpg");

        writeText(inputName, name);
        writeText(inputEmail, email);
        writeText(inputSubject, subject);
        writeText(textareaMessage, message);
        writeText(inputFile, uploadFile.getAbsolutePath());
        clickElement(btnSubmit);

        Alert alert = waitTimeInSeconds(Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        alert.accept();

        waitElementVisible(lblSuccess, Duration.ofSeconds(5));
    }

    public String getSuccessMessage() {
        return getElementText(lblSuccess);
    }
}
