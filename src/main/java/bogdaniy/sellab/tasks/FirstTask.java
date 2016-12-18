package bogdaniy.sellab.tasks;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstTask extends BaseTask {

    public FirstTask(int i, String listData) {
        super(i, listData);
    }

    @Override
    protected void navigateToList() {
        WebElement linkTag = driver.findElement(By.linkText("Викладачі"));
        linkTag.click();
    }

    @Override
    protected WebElement getTargetElementFromList() {
        List<WebElement> elementsList = driver.findElements(By.cssSelector(".field-item table tr td p a"));
        return elementsList.get(number - 1);
    }

    protected WebElement getPageElement() {
        return driver.findElement(By.id("page-title"));
    }

    protected void validatePageData() {;
        WebElement content = driver.findElement(By.cssSelector("[property=\"content:encoded\"]"));
        if(content.getText().equals("Сторінка в стадії розробки.")) {
            System.out.println("Page in development, still niga");
            return;
        }
        try {
            driver.findElement(By.cssSelector("[property=\"content:encoded\"] img"));
            System.out.println("Page contains avatar of teacher");
        }
        catch (ElementNotFoundException | NoSuchElementException e) {
            System.out.println("This teacher hasn't avatar");
        }
    }
}
