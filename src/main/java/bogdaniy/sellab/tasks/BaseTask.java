package bogdaniy.sellab.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

abstract public class BaseTask {


    protected int number;
    protected WebDriver driver;
    protected String listData;

    public BaseTask(int i, String listData) {
        number = i;
        driver = new HtmlUnitDriver();
        driver.get("http://pma.fpm.kpi.ua/");
        this.listData = listData;
    }

    abstract protected void navigateToList();

    abstract protected WebElement getTargetElementFromList();

    protected void navigateToPage(WebElement element) {
        element.click();
    }

    abstract protected void validatePageData();

    abstract protected WebElement getPageElement();

    public void execute() {
        try {
            this.navigateToList();

            WebElement listElement = this.getTargetElementFromList();
            String listElementValue = listElement.getText();
            if(listElementValue.equals(listData)) {
                System.out.println("Target table element equals to predefined data : " + listData);
            }
            else {
                System.out.println("Table element doesn't equals to predefined data. Table : " + listElement.getText() +
                        ", predefined : "+ listData);
            }

            this.navigateToPage(listElement);

            this.validatePageData();

            String iDontLikeVarTitleName = driver.getTitle();
            System.out.println("Page title is:" + iDontLikeVarTitleName);

            WebElement pageElement = this.getPageElement();
            if(pageElement.getText().equals(listElementValue)) {
                System.out.println("Target page element equals to data from list: " + listData);
            }
            else {
                System.out.println("Table page element doesn't equals to list data. Page : " + pageElement.getText() +
                        ", list : "+ listElementValue);
            }


        }
        catch (Exception e) {
            System.out.println("Error while executing an testing : " + e.toString());
            for(StackTraceElement line  : e.getStackTrace()) {
                System.out.println(line);
            }

        }

    }
}
