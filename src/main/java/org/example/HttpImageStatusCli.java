package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.example.Utils.*;
public class HttpImageStatusCli {
    public void askStatus(){
        Scanner scanner= new Scanner(System.in);
        System.out.println(ENTER_STATUS_CODE_TEXT);
        String input = scanner.nextLine();
        int code;
        try {
            code = Integer.parseInt(input.trim());
        }catch (NumberFormatException e){
            System.out.println(INVALID_NUMBER_TEXT);
            return;
        }
        try {
            new HttpStatusImageDownloader().downloadStatusImage(code);
        }catch (FileNotFoundException e){
            System.out.println(String.format(NO_IMAGE_FOR_STATUS_TEXT, code));
        }   catch (Exception e){
            e.printStackTrace();
        }
    }
}
