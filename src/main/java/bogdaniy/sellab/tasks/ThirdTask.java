package bogdaniy.sellab.tasks;


import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ThirdTask extends BaseTask {

    String targetNewsItemDate;
    String listNewsItemDate;

    public ThirdTask(int i, String listData, String targetNewsItemDate) {
        super(i, listData);
        this.targetNewsItemDate = targetNewsItemDate;
    }

    protected void navigateToList() {
        WebElement linkTag = driver.findElement(By.linkText("Новини"));
        linkTag.click();
    }

    protected WebElement getTargetElementFromList() {
        List<WebElement> elementsList = driver.findElements(By.cssSelector(".view-content .views-row h2 a"));

        List<WebElement> datesList = driver.findElements(By.cssSelector(".view-content .views-row .date b"));
        listNewsItemDate = datesList.get(number - 1).getText();

        if(listNewsItemDate.equals(targetNewsItemDate)) {
            System.out.println("Target news item date equals to predefined date : " + listNewsItemDate);
        }
        else {
            System.out.println("Target news item date doesn't equals to predefined date. News item : " + listNewsItemDate +
                    ", predefined : "+ targetNewsItemDate);
        }

        return elementsList.get(number - 1);
    }

    protected void validatePageData() {
        WebElement date = driver.findElement(By.cssSelector(".meta.submitted > span"));
        if(date.getText().endsWith(listNewsItemDate)) {
            System.out.println("Target page news item date equals to news list item date: " + listNewsItemDate);
        }
        else {
            System.out.println("Target page news item date doesn't equals to news list item date. Page news item : " + date.getText() +
                    ", news list item : "+ listNewsItemDate);
        }
    }
}
