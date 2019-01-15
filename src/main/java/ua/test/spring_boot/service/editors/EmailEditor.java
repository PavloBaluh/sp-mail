package ua.test.spring_boot.service.editors;

import org.springframework.stereotype.Component;
import ua.test.spring_boot.Models.Email;

import java.beans.PropertyEditorSupport;

@Component
public class EmailEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Email email = new Email();
        email.setEmail(text);
        setValue(email);
    }
}
