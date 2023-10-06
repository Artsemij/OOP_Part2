

class UserDataFormatException extends Exception {
    public UserDataFormatException(String errorMessage) {
        super(errorMessage);
    }
}

class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;

    public UserData(String lastName, String firstName, String middleName, String dateOfBirth, String phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }
}
