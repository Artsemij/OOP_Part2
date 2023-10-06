import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your data please: ");
        String input = scanner.nextLine();
        scanner.close();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Error: Incorrect amount of data.");
            return;
        }

        try {
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String dateOfBirth = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            validateData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);

            UserData userData = new UserData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);

            writeToFile(userData);
        } catch (UserDataFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing data to file.");
        }
    }

    private static void validateData(String lastName, String firstName, String middleName, String dateOfBirth, String phoneNumber, String gender) throws UserDataFormatException {
        if (lastName.isEmpty() || firstName.isEmpty() || dateOfBirth.isEmpty() || phoneNumber.isEmpty() || gender.isEmpty()) {
            throw new UserDataFormatException("Wrong format of data.");
        }

        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new UserDataFormatException("Invalid format of birth date.");
        }

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new UserDataFormatException("Invalid format of phone number.");
        }

        if (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")) {
            throw new UserDataFormatException("Invalid format of gender.");
        }
    }

    private static void writeToFile(UserData userData) throws IOException {
        String filename = userData.getLastName() + ".txt";
        FileWriter writer = new FileWriter(filename, true);
        writer.write(userData.getLastName() + userData.getFirstName() + userData.getMiddleName() +
                userData.getDateOfBirth() + " " + userData.getPhoneNumber() + userData.getGender() + "\n");
        writer.close();
        System.out.println("Data successfully written to file " + filename);
    }
}
    

