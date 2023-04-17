package com.FEPS.genericActions;

import com.FEPS.interfaces.IwebComponent;
import com.FEPS.settings.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptActions implements IwebComponent {

    private WebDriver driver;

    public JavaScriptActions(WebDriver driver) {
        this.driver = driver;
    }

    private final JavascriptExecutor jse = (JavascriptExecutor) ObjectRepo.driver;

    public Object executeScript(String script) {
        return jse.executeScript(script);
    }

    public Object executeScript(String script, Object... args) {
        return jse.executeScript(script, args);
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
    }

    public void scrollByPixel(int x,int y) {
        jse.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void scrollIntoViewAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        scrollIntoView(element);
        element.click();
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
    }

    public boolean jsClick(WebElement element) {
        try {
            executeScript("arguments[0].click();", element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void scrollToPageTop() {
        jse.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToPageBottom() {
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToVisibleElement(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
