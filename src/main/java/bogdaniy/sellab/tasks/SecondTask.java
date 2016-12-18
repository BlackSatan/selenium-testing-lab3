package bogdaniy.sellab.tasks;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecondTask extends BaseTask {

    public SecondTask(int i, String listData) {
        super(i, listData);
    }

    @Override
    protected void navigateToList() {
        driver.findElement(By.linkText("Випускники")).click();
        driver.findElement(By.linkText("Список випускників")).click();
        driver.findElement(By.linkText("1991-2000")).click();
        driver.findElement(By.linkText("1998")).click();
    }

    @Override
    protected WebElement getTargetElementFromList() {
        List<WebElement> elementsList = driver.findElements(By.cssSelector(".view-graduates-list table tr td h3 a"));
        return elementsList.get(number - 1);
    }

    protected WebElement getPageElement() {
        return driver.findElement(By.id("page-title"));
    }

    protected void validatePageData() {
        try {
            WebElement avatar = driver.findElement(By.cssSelector(".profile table tr td.image img"));
            String title = avatar.getAttribute("title");
            if(!title.equals("No photo")) {
                System.out.println("Page contains avatar of student");
            }
            else {
                System.out.println("This student has no photo (?)");
            }

        }
        catch (ElementNotFoundException | NoSuchElementException e) {
            System.out.println("This student hasn't avatar");
        }
    }
}
