package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static final String NO_IMAGE_FOR_STATUS_TEXT = "There is not image for HTTP status %s";
    public static final String ENTER_STATUS_CODE_TEXT = "Enter HTTP status code";
    public static final String INVALID_NUMBER_TEXT = "Please enter valid number";

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_STATUS_CODE_TEXT);
        String input = scanner.nextLine();
        int code;
        try {
            code = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println(INVALID_NUMBER_TEXT);
            return;
        }
        try {
            new HttpStatusImageDownloader().downloadStatusImage(code);
        } catch (FileNotFoundException e) {
            System.out.println(String.format(NO_IMAGE_FOR_STATUS_TEXT, code));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
