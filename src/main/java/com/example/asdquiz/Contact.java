package com.example.asdquiz;

record Contact(String firstName, String lastName, String company, String jobTitle, PhoneNumber[] phoneNumbers, EmailAddress[] emailAddresses) implements Comparable<Contact> {
    @Override
    public int compareTo(Contact other) {
        return this.lastName.compareTo(other.lastName);
    }
}
