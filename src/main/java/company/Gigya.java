package company;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Gigya {
    public static String pageQAPGAT = "http://qa-www.pgatour.ctmsp.com/";
    public static String pageQAWEBCOM = "http://qa-www.pgatour.ctmsp.com/webcom.html";
    public static String pageQACHAMP = "http://qa-www.pgatour.ctmsp.com/champions.html";
    public static String pageQAWGC = "http://qa-wgc.pgatour.ctmsp.com/";
    public static String pageQAPCUP = "http://qa-pcup.pgatour.ctmsp.com/";

    public static String newLogin = Helper.generateStringValue() + "@testmail.com";

    public static String pageUATPGAT = "http://uat-www.pgatour.ctmsp.com/";
    public static String pageUATWEBCOM = "http://uat-www.pgatour.ctmsp.com/webcom.html";
    public static String pageUATCHAMP = "http://uat-www.pgatour.ctmsp.com/champions.html";
    public static String pageUATWGC = "http://uat-wgc.pgatour.ctmsp.com/";
    public static String pageUATPCUP = "http://uat-pcup.pgatour.ctmsp.com/";

    //NEW ACCOUNT VALUE GENERATION
    public static void generateNewEmail() {
        Helper.generateStringValue();
        newLogin = Helper.generateStringValue() + "@testmail.com";
    }
    //SCREENSHOTS
    public static void takeRegScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) Helper.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new
                    File("C:\\Selenium\\Screenshots\\" + Helper.generateActualDate() + "\\" + newLogin + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
