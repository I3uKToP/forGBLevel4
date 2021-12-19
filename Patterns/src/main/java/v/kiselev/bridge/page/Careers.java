package v.kiselev.bridge.page;

import v.kiselev.bridge.theme.Theme;

public class Careers implements WebPage{
    Theme theme;
    @Override
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.println("Careers page in " + theme.getColor());
    }
}