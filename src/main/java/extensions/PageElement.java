package extensions;

import org.openqa.selenium.By;

public class PageElement {
    public By by;
    public String name;

    public PageElement(By by, String name) {
        this.by = by;
        this.name = name;
    }
}
