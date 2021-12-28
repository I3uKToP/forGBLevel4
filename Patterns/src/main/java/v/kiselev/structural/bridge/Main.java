package v.kiselev.structural.bridge;

import v.kiselev.structural.bridge.page.About;
import v.kiselev.structural.bridge.page.Careers;
import v.kiselev.structural.bridge.theme.DarkTheme;
import v.kiselev.structural.bridge.theme.Theme;

public class Main {
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        About about = new About();
        about.setTheme(darkTheme);
        Careers careers = new Careers();
        careers.setTheme(darkTheme);

        about.getContent();
        careers.getContent();

//        output
//        About page in Dark theme
//        Careers page in Dark theme

    }
}
