package com.example.asdquiz;

import java.util.Arrays;

public class ContactManager {
    public static void main(String[] args) {
        // Sample contacts
        Contact[] contacts = {
                new Contact("John", "Doe", "Company1", "Developer", new PhoneNumber[]{new PhoneNumber("123-456-7890", "mobile")}, new EmailAddress[]{new EmailAddress("johndoe@example.com", "work")}),
                new Contact("Jane", "Smith", "Company2", "Manager", new PhoneNumber[]{new PhoneNumber("098-765-4321", "work")}, new EmailAddress[]{new EmailAddress("janesmith@example.com", "personal")}),

        };

        Arrays.sort(contacts);


        for (Contact contact : contacts) {
            String json = contactToJson(contact);
            System.out.println(json);
        }
    }

    private static String contactToJson(Contact contact) {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{");
        jsonBuilder.append("\"firstName\": \"").append(contact.firstName()).append("\", ");
        jsonBuilder.append("\"lastName\": \"").append(contact.lastName()).append("\", ");
        jsonBuilder.append("\"company\": \"").append(contact.company()).append("\", ");
        jsonBuilder.append("\"jobTitle\": \"").append(contact.jobTitle()).append("\", ");
        jsonBuilder.append("\"phoneNumbers\": [");
        for (int i = 0; i < contact.phoneNumbers().length; i++) {
            PhoneNumber phone = contact.phoneNumbers()[i];
            jsonBuilder.append("{");
            jsonBuilder.append("\"number\": \"").append(phone.number()).append("\", ");
            jsonBuilder.append("\"label\": \"").append(phone.label()).append("\"");
            jsonBuilder.append("}");
            if (i < contact.phoneNumbers().length - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("], ");
        jsonBuilder.append("\"emailAddresses\": [");
        for (int i = 0; i < contact.emailAddresses().length; i++) {
            EmailAddress email = contact.emailAddresses()[i];
            jsonBuilder.append("{");
            jsonBuilder.append("\"address\": \"").append(email.address()).append("\", ");
            jsonBuilder.append("\"label\": \"").append(email.label()).append("\"");
            jsonBuilder.append("}");
            if (i < contact.emailAddresses().length - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
