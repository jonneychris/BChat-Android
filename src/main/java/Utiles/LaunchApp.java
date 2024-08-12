package Utiles;


	

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LaunchApp {
    public static void main(String[] args) {
        String adbCommand = "adb shell am start -n com.example.app/.MainActivity";

        try {
            // Execute the adb command
            Process process = Runtime.getRuntime().exec(adbCommand);

            // Capture the output (optional)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            System.out.println("App launched successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

