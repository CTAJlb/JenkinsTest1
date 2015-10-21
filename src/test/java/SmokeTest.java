import company.Gigya;
import company.Helper;
import company.LogInPage;
import company.ProfilePage;
import org.junit.*;

public class SmokeTest {
        @BeforeClass
    public static void precondition() {
        Helper.setupChromeAndGo(Gigya.pageQAPGAT);
        Helper.setResolution(1212, 900);
        LogInPage.newAccount();
        Helper.quit();
    }
    @Before
    public void preconditions() {
        Helper.setupChromeAndGo(Gigya.pageQAPGAT);
        Helper.setResolution(1212, 900);
    }
    @After
    public void postconditions() {
        Helper.quit();
    }

    @Ignore
    @Test
    public void should() {
        LogInPage.goToAuthorization();
        LogInPage.passAuthorization();
        ProfilePage.goToProfile();
        System.out.println(Helper.waitElementByCss(".gigya-screen-dialog").getText());
    }

    @Test
    public void shouldMatchLogInFormTexts() {
        LogInPage.goToAuthorization();
        Assert.assertEquals(LogInPage.authFormAllTexts, Helper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchRegFormStep1Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        Assert.assertEquals(LogInPage.regFormStep1AllTexts, Helper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchRegFormStep2Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        Assert.assertEquals(LogInPage.regForm2AllTexts, Helper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchRegFormStep3Texts() {
        LogInPage.goToAuthorization();
        LogInPage.goToRegistration();
        LogInPage.fillRegForm();
        LogInPage.goToRegistrationStep2();
        LogInPage.goToRegistrationStep3();
        Assert.assertEquals(LogInPage.regForm3AllTexts, Helper.waitElementByCss(".gigya-screen-dialog").getText());
    }
    @Test
    public void shouldMatchProfileFormTexts() {
        LogInPage.goToAuthorization();
        LogInPage.passAuthorization();
        ProfilePage.goToProfile();
        Assert.assertEquals(ProfilePage.profileFormAllTexts, Helper.waitElementByCss(".gigya-screen-dialog").getText());
    }
}
