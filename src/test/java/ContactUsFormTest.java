import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUsFormTest extends BaseTest {

    @Test
    public void testContactUsForm()  {
        homePage.accessContactForm();
        contactPage.sendForm();
        assertEquals("Success! Your details have been submitted successfully.", contactPage.getSuccessMessage());
    }
}
