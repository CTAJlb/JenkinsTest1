package company;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Helper {
    public static WebDriver driver;

    public static void setupChrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void setupChromeAndGo(String link) {
        setupChrome();
        driver.get(link);
    }

    public static void setupChromeAndGoToCI(String link) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get(link);
    }

    public static void setupFirefox() {
        driver = new FirefoxDriver();
    }

    public static void setupFirefoxAndGo(String link) {
        setupFirefox();
        driver.get(link);
    }

    public static void setupIE() {
        System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    public static void setupIEAndGo(String link) {
        setupIE();
        driver.get(link);
    }

    public static void setupOpera() {
        driver = new OperaDriver();
    }

    public static void setupOperaAndGo(String link) {
        setupOpera();
        driver.get(link);
    }

    //PRECONDITIONS & POSTCONDITIONS
    public static void get(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }

    public static void setResolution(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public static void setFullscreen() {
        driver.manage().window().maximize();
    }

    //WAITING FUNCTIONS
    public static void waitSec(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitMsec(long msec) {
        try {
            Thread.sleep(msec * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Searching and waiting for element in DOM
    public static WebElement waitElementById(String target) {
        for (int i = 0; i < 200; i++) {
            if (driver.findElements(By.id(target)).size() > 0) {
                for (int c = 0; c < 200; c++) {
                    if (driver.findElement(By.id(target)).isDisplayed() &&
                            driver.findElement(By.id(target)).isEnabled()) {
                        break;
                    }
                    waitMsec(1);
                }
                break;
            }
            waitMsec(1);
        }
        return driver.findElement(By.id(target));
    }

    public static WebElement waitElementByCss(String target) {
        for (int i = 0; i < 200; i++) {
            if (driver.findElements(By.cssSelector(target)).size() > 0) {
                for (int c = 0; c < 200; c++) {
                    if (driver.findElement(By.cssSelector(target)).isDisplayed() &&
                            driver.findElement(By.cssSelector(target)).isEnabled()) {
                        break;
                    }
                    waitMsec(1);
                }
                break;
            }
            waitMsec(1);
        }
        return driver.findElement(By.cssSelector(target));
    }

    public static WebElement waitElementByXpath(String target) {
        for (int i = 0; i < 200; i++) {
            if (driver.findElements(By.xpath(target)).size() > 0) {
                for (int c = 0; c < 200; c++) {
                    if (driver.findElement(By.xpath(target)).isDisplayed() &&
                            driver.findElement(By.xpath(target)).isEnabled()) {
                        break;
                    }
                    waitMsec(1);
                }
                break;
            }
            waitMsec(1);
        }
        return driver.findElement(By.xpath(target));
    }

    //Waiting for moment when element doesn't exist in DOM
    public static WebElement waitElementNotExistById(String target) {
        for (int i = 0; i < 200; i++) {
            if (driver.findElements(By.id(target)).size() == 0) {
                break;
            }
            waitMsec(1);
        }
        return null;
    }

    public static WebElement waitElementNotExistByCss(String target) {
        for (int i = 0; i < 200; i++) {
            if (driver.findElements(By.cssSelector(target)).size() == 0) {
                break;
            }
            waitMsec(1);
        }
        return null;
    }

    public static WebElement waitElementNotExistByXpath(String target) {
        for (int i = 0; i < 200; i++) {
            if (driver.findElements(By.xpath(target)).size() == 0) {
                break;
            }
            waitMsec(1);
        }
        return null;
    }

    //Waiting for two elements have equal values of some attribute
    public static boolean waitEqualityById(String attribute, String expected, String actual) {
        waitElementById(actual);
        for (int i = 0; i < 200; i++) {
            if (driver.findElement(By.id(actual)).getAttribute(attribute).equals(expected)) {
                break;
            }
            waitMsec(1);
        }
        return true;
    }

    public static boolean waitEqualityByCss(String attribute, String expected, String actual) {
        waitElementByCss(actual);
        for (int i = 0; i < 200; i++) {
            if (driver.findElement(By.cssSelector(actual)).getAttribute(attribute).equals(expected)) {
                break;
            }
            waitMsec(1);
        }
        return true;
    }

    public static boolean waitEqualityByXpath(String attribute, String expected, String actual) {
        waitElementByXpath(actual);
        for (int i = 0; i < 200; i++) {
            if (driver.findElement(By.xpath(actual)).getAttribute(attribute).equals(expected)) {
                break;
            }
            waitMsec(1);
        }
        return true;
    }

    public static boolean waitInequalityById(String attribute, String expected, String actual) {
        waitElementById(actual);
        for (int i = 0; i < 200; i++) {
            if (driver.findElement(By.id(actual)).getAttribute(attribute).equals(expected)) {
                waitMsec(1);
            }
            break;
        }
        return true;
    }

    public static boolean waitInequalityByCss(String attribute, String expected, String actual) {
        waitElementByCss(actual);
        for (int i = 0; i < 200; i++) {
            if (driver.findElement(By.cssSelector(actual)).getAttribute(attribute).equals(expected)) {
                waitMsec(1);
            }
            break;
        }
        return true;
    }

    public static boolean waitInequalityByXpath(String attribute, String expected, String actual) {
        waitElementByXpath(actual);
        for (int i = 0; i < 200; i++) {
            if (driver.findElement(By.xpath(actual)).getAttribute(attribute).equals(expected)) {
                waitMsec(1);
            }
            break;
        }
        return true;
    }

    //HANDLERS
    public static boolean checkIsAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public static void handleAlert() {
        if (checkIsAlertPresent()) {
            waitMsec(8);
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    //Output files and data generating
    public static void takeScreenshot() {
        try {
            File scrFile =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new
                    File("C:\\Selenium\\Screenshots\\" + generateActualDate() + "\\" + generateStringValue() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateActualDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String FinalDate = dateFormat.format(date);
        return FinalDate;
    }

    public static String generateActualDateDots() {
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
        Date date = new Date();
        String FinalDate = dateFormat.format(date);
        return FinalDate;
    }

    public static String generateStringValue() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String FinalDate = dateFormat.format(date);
        return FinalDate;
    }

    //Attaching files
    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void attachFile(String path) {
        setClipboardData(path);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void getNewWindow(String value) {
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        waitElementByXpath(value).click();

        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindow);
        System.out.println("New window title: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + driver.getTitle());

    }

    public static void selectInDropdownByIndex(String locator, int number) {
        waitElementByXpath(locator);
        WebElement select = Helper.waitElementByXpath(locator);
        Select sel = new Select(select);
        sel.selectByIndex(number);
    }
    public static void selectInDropdownByString(String locator, String text) {
        waitElementByXpath(locator);
        WebElement select = Helper.waitElementByXpath(locator);
        Select sel = new Select(select);
        sel.selectByVisibleText(text);
    }

    public static boolean isElementExist(String locator) {
        if (Helper.driver.findElement(By.xpath(locator)).isDisplayed() &&
                Helper.driver.findElement(By.xpath(locator)).isEnabled()) {
            return true;
        } else {
            return false;
        }
    }
}
