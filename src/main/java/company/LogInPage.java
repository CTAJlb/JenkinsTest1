package company;

import org.openqa.selenium.By;

public class LogInPage {
    public static String loginButton = "//*[@class='login-button log-in']";
    public static String loginFatNavButton = "//*[@id='navtab-0']//a[text()='LOG IN / REGISTER']";
    public static String footerLoginButton =
            "//*[@class='links-simple clearfix']//span[@class='link-logo link-logo-media-room']";
    public static String loginInput = "//*[@id='gigya-login-form']//input[@name='username']";
    public static String passInput = "//*[@id='gigya-login-form']//input[@name='password']";
    public static String submitAuthButton = "//*[@id='gigya-login-form']//input[@class='gigya-input-submit']";
    public static String regButton = "//*[@id='gigya-login-form']//a[@data-switch-screen='gigya-register-screen']";
    public static String forgotPassButton = "//*[@id='gigya-login-form']//*[@class='forgotPassword']";
    public static String forgotPassInput = "//*[@id='gigya-forgot-password-screen']//input[@name='username']";
    public static String forgotPassExitButton =
            "//*[@id='gigya-forgot-password-screen']//a[@data-switch-screen='gigya-login-screen']";
    public static String forgotPassSubmitButton = "//*[@id='gigya-forgot-password-screen']//input[@type='submit']";
    public static String fatNavButton = "//*[@class='header-btn']";

    public static String emailInputReg = "//*[@id='gigya-r-form1']//input[@name='email']";
    public static String firstnameInputReg = "//*[@id='gigya-r-form1']//input[@name='profile.firstName']";
    public static String lastnameInputReg = "//*[@id='gigya-r-form1']//input[@name='profile.lastName']";
    public static String passwordInputReg = "//*[@id='gigya-r-form1']//input[@name='password']";
    public static String passConfirmInputReg = "//*[@id='gigya-r-form1']//input[@name='passwordRetype']";
    public static String nicknameInputReg = "//*[@id='gigya-r-form1']//input[@name='profile.nickname']";
    public static String zipcodeInputReg = "//*[@id='gigya-r-form1']//input[@name='profile.zip']";
    public static String checkboxReg = "//*[@id='gigya-r-form1']//input[@name='data.terms']";
    public static String birthYearSelectReg = "//*[@id='gigya-r-form1']//select[@name='profile.birthYear']";
    public static String birthMonthSelectReg = "//*[@id='gigya-r-form1']//select[@name='profile.birthMonth']";
    public static String birthDaySelectReg = "//*[@id='gigya-r-form1']//select[@name='profile.birthDay']";
    public static String countrySelectReg = "//*[@id='gigya-r-form1']//select[@name='profile.country']";
    public static String continueButton1 = "//*[@id='gigya-r-form1']//span[@class='gigya-input-button blue right']";

    public static String continueButton2 = "//*[@id='gigya-r-form2']//span[@class='gigya-input-button blue right']";

    public static String findPlayerInputReg = "//*[@id='gigya-r-form3']//input[@name='data.findPlayer']";
    public static String selectPlayersSelectReg = "//*[@id='gigya-r-form3']//select[@name='data.players']";
    public static String addPlayerButton = "//*[@id='addPlayerButton']";
    public static String submitFavoriteButton = "//*[@id='submitFavoritePlayer']";
    public static String anyFavoriteInList = "//*[@class='player-item']";
    public static String deleteFavPlayerButton = "//*[@id='myFavoritePlayersList']/following::div[@class='delete'][1]";

    public static boolean isLoginButtonDisplayed() {
        if (Helper.driver.findElement(By.xpath(loginButton)).isDisplayed() &&
                Helper.driver.findElement(By.xpath(loginButton)).isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public static void goToAuthorization() {
        Helper.waitSec(4);
        Helper.waitElementByXpath(loginButton).click();
    }
    public static void goToRegistration() {
        Helper.waitElementByXpath(regButton).click();
        Helper.waitElementByXpath(continueButton1);
    }

    public static void passAuthorization() {
        goToAuthorization();
        Helper.waitElementByXpath(loginInput).sendKeys(Gigya.newLogin);
        Helper.waitElementByXpath(passInput).sendKeys("123123123");
        Helper.waitElementByXpath(submitAuthButton).click();
        Helper.waitElementByXpath(ProfilePage.avatarArea);
        waitLoginButtonNotDisplayed();
    }

    public static void fillRegForm() {
        Helper.waitElementByXpath(emailInputReg).sendKeys(Gigya.newLogin);
        Helper.waitElementByXpath(firstnameInputReg).sendKeys("Firstname");
        Helper.waitElementByXpath(lastnameInputReg).sendKeys("Lastname");
        Helper.waitElementByXpath(nicknameInputReg).sendKeys("Nickname");
        Helper.waitElementByXpath(zipcodeInputReg).sendKeys("12345");
        Helper.waitElementByXpath(passwordInputReg).sendKeys("123123123");
        Helper.waitElementByXpath(passConfirmInputReg).sendKeys("123123123");
        Helper.waitElementByXpath(checkboxReg).click();
        Helper.selectInDropdownByIndex(birthYearSelectReg, 2);
        Helper.selectInDropdownByIndex(birthMonthSelectReg, 2);
        Helper.selectInDropdownByIndex(birthDaySelectReg, 2);
        Helper.selectInDropdownByIndex(countrySelectReg, 1);
        Gigya.takeRegScreenshot();
    }
    public static void goToRegistrationStep2() {
        Helper.waitElementByXpath(continueButton1).click();
        Helper.waitElementByXpath(continueButton2);
    }
    public static void goToRegistrationStep3() {
        Helper.waitElementByXpath(continueButton2).click();
        Helper.waitElementByXpath(submitFavoriteButton);
    }
    public static void finishReg() {
        Helper.waitElementByXpath(submitFavoriteButton).click();
        Helper.waitElementByXpath(ProfilePage.avatarArea);
        waitLoginButtonNotDisplayed();
    }
    public static void waitLoginButtonNotDisplayed() {
        for (int i = 0; i < 200; i++) {
            if (Helper.driver.findElement(By.xpath(loginButton)).isDisplayed()) {
                Helper.waitMsec(1);
            } else {
                break;
            }
        }
    }
    public static void addFavoritePlayer(int number) {
        Helper.selectInDropdownByIndex(selectPlayersSelectReg, number);
        Helper.waitElementByXpath(addPlayerButton).click();
        Helper.waitElementByXpath(anyFavoriteInList);
    }
    public static void addSomeFavoritePlayers(int number) {
        for (int i = 1; i <= number; i++) {
            Helper.selectInDropdownByIndex(selectPlayersSelectReg, i);
            Helper.waitElementByXpath(addPlayerButton).click();
            Helper.waitElementByXpath(anyFavoriteInList);
        }
    }
    public static void addFavoritePlayerByName(String name) {
        Helper.selectInDropdownByString(selectPlayersSelectReg, name);
        Helper.waitElementByXpath(addPlayerButton).click();
        Helper.waitElementByXpath(anyFavoriteInList);
    }
    public static void delFavoritePlayer() {
        Helper.waitElementByXpath(deleteFavPlayerButton).click();
    }
    public static void newAccount() {
        Gigya.generateNewEmail();
        goToAuthorization();
        goToRegistration();
        fillRegForm();
        goToRegistrationStep2();
        goToRegistrationStep3();
        finishReg();
        Helper.waitElementByXpath(ProfilePage.avatarArea);
    }
    public static void passRegistrationTill3rdStep() {
        Gigya.generateNewEmail();
        goToAuthorization();
        goToRegistration();
        fillRegForm();
        goToRegistrationStep2();
        goToRegistrationStep3();
    }
    public static void newAccountSixFavorites() {
        Gigya.generateNewEmail();
        goToAuthorization();
        goToRegistration();
        fillRegForm();
        goToRegistrationStep2();
        goToRegistrationStep3();
        addFavoritePlayer(1);
        addFavoritePlayer(2);
        addFavoritePlayer(3);
        addFavoritePlayer(4);
        addFavoritePlayer(5);
        addFavoritePlayer(6);
        finishReg();
    }
    public static String alreadyUsedEmailMessage() {
        return Helper.waitElementByXpath("//span[text()='Email already exists']")
                .getText();
    }
    public static String alreadyUsedEmailNotAvailable() {
        return Helper.waitElementByXpath("//div[text()='Not available']")
                .getText();
    }
    public static boolean alreadyUsedEmailBlockRegStep2() {
        Helper.waitElementByXpath(continueButton1).click();
        Helper.waitSec(3);
        if (Helper.driver.findElement(By.xpath(continueButton2)).isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }
    public static String getNameFirstFavoriteInList() {
        Helper.waitElementByXpath(anyFavoriteInList);
        return Helper.waitElementByXpath("//*[@id='myFavoritePlayersList']/following::div[1]")
                .getText();
    }
    public static String getNameSecondFavoriteInList() {
        Helper.waitElementByXpath(anyFavoriteInList);
        return Helper.waitElementByXpath("//*[@id='myFavoritePlayersList']/following::div[3]")
                .getText();
    }
    public static String getNameThirdFavoriteInList() {
        Helper.waitElementByXpath(anyFavoriteInList);
        return Helper.waitElementByXpath("//*[@id='myFavoritePlayersList']/following::div[5]")
                .getText();
    }

    public static String authFormAllTexts = "Login\n" +
            "Register or login with your social network:\n" +
            "Or, login with your email here:\n" +
            "Email:\n" +
            "Password:\n" +
            " Forgot password\n" +
            " Remember me\n" +
            "Don't have an account yet?\n" +
            "Register with a social network or Click here";

    public static String regFormStep1AllTexts = "Registration\n"+
            "1. Personal Info\n"+
            "2. Notification Settings\n"+
            "3. Favorite Players\n"+
            "Email:*\n"+
            "First name:*\n"+
            "Last name:*\n"+
            "Country:*\n"+
            "United States\n"+
            "Afghanistan\n"+
            "Albania\n"+
            "Algeria\n"+
            "American Samoa\n"+
            "Andorra\n"+
            "Angola\n"+
            "Anguilla\n"+
            "Antarctica\n"+
            "Antigua and Barbuda\n"+
            "Argentina\n"+
            "Armenia\n"+
            "Aruba\n"+
            "Australia\n"+
            "Austria\n"+
            "Azerbaijan\n"+
            "Bahamas\n"+
            "Bahrain\n"+
            "Bangladesh\n"+
            "Barbados\n"+
            "Belarus\n"+
            "Belgium\n"+
            "Belize\n"+
            "Benin\n"+
            "Bermuda\n"+
            "Bhutan\n"+
            "Bolivia\n"+
            "Bosnia and Herzegovina\n"+
            "Botswana\n"+
            "Bouvet Island\n"+
            "Brazil\n"+
            "British Indian Ocean Territory\n"+
            "Brunei Darussalam\n"+
            "Bulgaria\n"+
            "Burkina Faso\n"+
            "Burundi\n"+
            "Cambodia\n"+
            "Cameroon\n"+
            "Canada\n"+
            "Cape Verde\n"+
            "Cayman Islands\n"+
            "Central African Republic\n"+
            "Chad\n"+
            "Chile\n"+
            "China\n"+
            "Christmas Island\n"+
            "Cocos (Keeling) Islands\n"+
            "Colombia\n"+
            "Comoros\n"+
            "Congo\n"+
            "Cook Islands\n"+
            "Costa Rica\n"+
            "Cote Divoire\n"+
            "Croatia\n"+
            "Cuba\n"+
            "Cyprus\n"+
            "Czech Republic\n"+
            "Denmark\n"+
            "Djibouti\n"+
            "Dominica\n"+
            "Dominican Republic\n"+
            "Easter Island\n"+
            "Ecuador\n"+
            "Egypt\n"+
            "El Salvador\n"+
            "Equatorial Guinea\n"+
            "Eritrea\n"+
            "Estonia\n"+
            "Ethiopia\n"+
            "Falkland Islands (Malvinas)\n"+
            "Faroe Islands\n"+
            "Fiji\n"+
            "Finland\n"+
            "France\n"+
            "French Guiana\n"+
            "French Polynesia\n"+
            "French Southern Territories\n"+
            "Gabon\n"+
            "Gambia\n"+
            "Georgia\n"+
            "Germany\n"+
            "Ghana\n"+
            "Gibraltar\n"+
            "Greece\n"+
            "Greenland\n"+
            "Grenada\n"+
            "Guadeloupe\n"+
            "Guam\n"+
            "Guatemala\n"+
            "Guinea\n"+
            "Guinea-bissau\n"+
            "Guyana\n"+
            "Haiti\n"+
            "Heard Island and Mcdonald Islands\n"+
            "Honduras\n"+
            "Hong Kong\n"+
            "Hungary\n"+
            "Iceland\n"+
            "India\n"+
            "Indonesia\n"+
            "Iran\n"+
            "Iraq\n"+
            "Ireland\n"+
            "Israel\n"+
            "Italy\n"+
            "Jamaica\n"+
            "Japan\n"+
            "Jordan\n"+
            "Kazakhstan\n"+
            "Kenya\n"+
            "Kiribati\n"+
            "Korea, North\n"+
            "Korea, South\n"+
            "Kosovo\n"+
            "Kuwait\n"+
            "Kyrgyzstan\n"+
            "Laos\n"+
            "Latvia\n"+
            "Lebanon\n"+
            "Lesotho\n"+
            "Liberia\n"+
            "Libyan Arab Jamahiriya\n"+
            "Liechtenstein\n"+
            "Lithuania\n"+
            "Luxembourg\n"+
            "Macau\n"+
            "Macedonia\n"+
            "Madagascar\n"+
            "Malawi\n"+
            "Malaysia\n"+
            "Maldives\n"+
            "Mali\n"+
            "Malta\n"+
            "Marshall Islands\n"+
            "Martinique\n"+
            "Mauritania\n"+
            "Mauritius\n"+
            "Mayotte\n"+
            "Mexico\n"+
            "Micronesia, Federated States of\n"+
            "Moldova, Republic of\n"+
            "Monaco\n"+
            "Mongolia\n"+
            "Montenegro\n"+
            "Montserrat\n"+
            "Morocco\n"+
            "Mozambique\n"+
            "Myanmar\n"+
            "Namibia\n"+
            "Nauru\n"+
            "Nepal\n"+
            "Netherlands\n"+
            "Netherlands Antilles\n"+
            "New Caledonia\n"+
            "New Zealand\n"+
            "Nicaragua\n"+
            "Niger\n"+
            "Nigeria\n"+
            "Niue\n"+
            "Norfolk Island\n"+
            "Northern Mariana Islands\n"+
            "Norway\n"+
            "Oman\n"+
            "Pakistan\n"+
            "Palau\n"+
            "Palestinian Territory\n"+
            "Panama\n"+
            "Papua New Guinea\n"+
            "Paraguay\n"+
            "Peru\n"+
            "Philippines\n"+
            "Pitcairn\n"+
            "Poland\n"+
            "Portugal\n"+
            "Puerto Rico\n"+
            "Qatar\n"+
            "Reunion\n"+
            "Romania\n"+
            "Russia\n"+
            "Rwanda\n"+
            "Saint Helena\n"+
            "Saint Kitts and Nevis\n"+
            "Saint Lucia\n"+
            "Saint Pierre and Miquelon\n"+
            "Saint Vincent and The Grenadines\n"+
            "Samoa\n"+
            "San Marino\n"+
            "Sao Tome and Principe\n"+
            "Saudi Arabia\n"+
            "Senegal\n"+
            "Serbia and Montenegro\n"+
            "Seychelles\n"+
            "Sierra Leone\n"+
            "Singapore\n"+
            "Slovakia\n"+
            "Slovenia\n"+
            "Solomon Islands\n"+
            "Somalia\n"+
            "South Africa\n"+
            "South Georgia and The South Sandwich Islands \n"+
            "Spain\n"+
            "Sri Lanka\n"+
            "Sudan\n"+
            "Suriname\n"+
            "Svalbard and Jan Mayen\n"+
            "Swaziland\n"+
            "Sweden\n"+
            "Switzerland\n"+
            "Syria\n"+
            "Taiwan\n"+
            "Tajikistan\n"+
            "Tanzania, United Republic of\n"+
            "Thailand\n"+
            "Timor-leste\n"+
            "Togo\n"+
            "Tokelau\n"+
            "Tonga\n"+
            "Trinidad and Tobago\n"+
            "Tunisia\n"+
            "Turkey\n"+
            "Turkmenistan\n"+
            "Turks and Caicos Islands\n"+
            "Tuvalu\n"+
            "Uganda\n"+
            "Ukraine\n"+
            "United Arab Emirates\n"+
            "United Kingdom\n"+
            "United States Minor Outlying Islands \n"+
            "Uruguay\n"+
            "Uzbekistan\n"+
            "Vanuatu\n"+
            "Vatican City\n"+
            "Venezuela\n"+
            "Vietnam\n"+
            "Virgin Islands, British\n"+
            "Virgin Islands, U.S.\n"+
            "Wallis and Futuna\n"+
            "Western Sahara\n"+
            "Yemen\n"+
            "Zambia\n"+
            "Zimbabwe\n"+
            "Display name\n"+
            "Year of birth:*\n"+
            "1920\n"+
            "1921\n"+
            "1922\n"+
            "1923\n"+
            "1924\n"+
            "1925\n"+
            "1926\n"+
            "1927\n"+
            "1928\n"+
            "1929\n"+
            "1930\n"+
            "1931\n"+
            "1932\n"+
            "1933\n"+
            "1934\n"+
            "1935\n"+
            "1936\n"+
            "1937\n"+
            "1938\n"+
            "1939\n"+
            "1940\n"+
            "1941\n"+
            "1942\n"+
            "1943\n"+
            "1944\n"+
            "1945\n"+
            "1946\n"+
            "1947\n"+
            "1948\n"+
            "1949\n"+
            "1950\n"+
            "1951\n"+
            "1952\n"+
            "1953\n"+
            "1954\n"+
            "1955\n"+
            "1956\n"+
            "1957\n"+
            "1958\n"+
            "1959\n"+
            "1960\n"+
            "1961\n"+
            "1962\n"+
            "1963\n"+
            "1964\n"+
            "1965\n"+
            "1966\n"+
            "1967\n"+
            "1968\n"+
            "1969\n"+
            "1970\n"+
            "1971\n"+
            "1972\n"+
            "1973\n"+
            "1974\n"+
            "1975\n"+
            "1976\n"+
            "1977\n"+
            "1978\n"+
            "1979\n"+
            "1980\n"+
            "1981\n"+
            "1982\n"+
            "1983\n"+
            "1984\n"+
            "1985\n"+
            "1986\n"+
            "1987\n"+
            "1988\n"+
            "1989\n"+
            "1990\n"+
            "1991\n"+
            "1992\n"+
            "1993\n"+
            "1994\n"+
            "1995\n"+
            "1996\n"+
            "1997\n"+
            "1998\n"+
            "1999\n"+
            "2000\n"+
            "2001\n"+
            "2002\n"+
            "2003\n"+
            "2004\n"+
            "2005\n"+
            "2006\n"+
            "2006\n"+
            "2007\n"+
            "2008\n"+
            "2009\n"+
            "2010\n"+
            "2011\n"+
            "2012\n"+
            "2013\n"+
            "2014\n"+
            "2015\n"+
            "Month of birth*\n"+
            "January\n"+
            "February\n"+
            "March\n"+
            "April\n"+
            "May\n"+
            "June\n"+
            "July\n"+
            "August\n"+
            "September\n"+
            "October\n"+
            "November\n"+
            "December\n"+
            "Day of birth*\n"+
            "1\n"+
            "2\n"+
            "3\n"+
            "4\n"+
            "5\n"+
            "6\n"+
            "7\n"+
            "8\n"+
            "9\n"+
            "10\n"+
            "11\n"+
            "12\n"+
            "13\n"+
            "14\n"+
            "15\n"+
            "16\n"+
            "17\n"+
            "18\n"+
            "19\n"+
            "20\n"+
            "21\n"+
            "22\n"+
            "23\n"+
            "24\n"+
            "25\n"+
            "26\n"+
            "27\n"+
            "28\n"+
            "29\n"+
            "30\n"+
            "31\n"+
            "Zip code:\n"+
            "Avatar\n"+
            "Choose File No file chosen\n"+
            "Maximum size of 3MB. JPG, GIF, PNG.\n"+
            "Password:*\n"+
            "Re-enter Password:*\n"+
            "I have read and understood the Terms of Service*\n"+
            "Continue";

    public static String regForm2AllTexts = "Registration\n" +
            "1. Personal Info\n" +
            "2. Notification Settings\n" +
            "3. Favorite Players\n" +
            "The Starter - PGA TOUR's Weekly Newsletter\n" +
            "Yes, I would like to receive The Starter newsletter from PGA TOUR.\n" +
            "Email list for PGA TOUR Product Updates and Partner Offers\n" +
            "Yes, I would like to receive information from the PGA TOUR and its partners regarding special promotions, new products and/or services.\n" +
            "Commenting Settings\n" +
            "Someone comments in a conversation I m following:\n" +
            "Never\n" +
            "Immediately\n" +
            "Hourly Digest\n" +
            "Someone likes one of my comments:\n" +
            "Never\n" +
            "Immediately\n" +
            "Hourly Digest\n" +
            "Someone replies to one of my comments:\n" +
            "Never\n" +
            "Immediately\n" +
            "Hourly Digest\n" +
            "Auto-follow conversations when I leave a comment:\n" +
            "Immediately\n" +
            "Continue";

    public static String regForm3AllTexts = "Registration\n" +
            "1. Personal Info\n" +
            "2. Notification Settings\n" +
            "3. Favorite Players\n" +
            "Manage Your Favorites\n" +
            "Select Tour:\n" +
            "PGA TOUR\n" +
            "Champions Tour\n" +
            "Web.com Tour\n" +
            "Your Favorites:\n" +
            "Add More Players\n" +
            "Find a Player:\n" +
            "Or Select Player from the List:\n" +
            "Select Player\n" +
            "Adams, Blake\n" +
            "Adams, John\n" +
            "Adams, Sam\n" +
            "Affrunti, Joe\n" +
            "Aiken, Thomas\n" +
            "Aldridge, Tyler\n" +
            "Allem, Fulton\n" +
            "Allen, Michael\n" +
            "Allenby, Robert\n" +
            "Ames, Stephen\n" +
            "Ancer, Abraham\n" +
            "Andrade, Billy\n" +
            "Aoki, Isao\n" +
            "Appleby, Stuart\n" +
            "Armour III, Tommy\n" +
            "Armstrong, Wally\n" +
            "Atwal, Arjun\n" +
            "Austin, Woody\n" +
            "Axley, Eric\n" +
            "Azinger, Paul\n" +
            "Baddeley, Aaron\n" +
            "Bae, Sangmoon\n" +
            "Baird, Briny\n" +
            "Baker-Finch, Ian\n" +
            "Barber, Blayne\n" +
            "Barlow, Craig\n" +
            "Barnes, Ricky\n" +
            "Barr, Dave\n" +
            "Bateman, Brian\n" +
            "Bean, Andy\n" +
            "Beck, Chip\n" +
            "Beckman, Cameron\n" +
            "Beem, Rich\n" +
            "Begay III, Notah\n" +
            "Beljan, Charlie\n" +
            "Beman, Deane\n" +
            "Benepe, Jim\n" +
            "Berger, Daniel\n" +
            "Bertsch, Shane\n" +
            "Besselink, Al\n" +
            "Bettencourt, Matt\n" +
            "Black, Ronnie\n" +
            "Blackburn, Woody\n" +
            "Blackmar, Phil\n" +
            "Blair, Zac\n" +
            "Blake, Jay Don\n" +
            "Blancas, Homero\n" +
            "Blanks, Kris\n" +
            "Blixt, Jonas\n" +
            "Blocker, Chris\n" +
            "Bohn, Jason\n" +
            "Boros, Guy\n" +
            "Bowditch, Steven\n" +
            "Bradley, Keegan\n" +
            "Bradley, Michael\n" +
            "Brooks, Mark\n" +
            "Brown, Billy Ray\n" +
            "Brown, Ken\n" +
            "Brown, Pete\n" +
            "Brown, Scott\n" +
            "Browne, Olin\n" +
            "Bryant, Bart\n" +
            "Bryant, Brad\n" +
            "Burgoon, Bronson\n" +
            "Burke, Jr., Jack\n" +
            "Burns, Bob\n" +
            "Burns, George\n" +
            "Byman, Bob\n" +
            "Byrd, Jonathan\n" +
            "Byrum, Curt\n" +
            "Byrum, Tom\n" +
            "Cabrera, Angel\n" +
            "Calcavecchia, Mark\n" +
            "Caldwell, Rex\n" +
            "Campbell, Chad\n" +
            "Cantlay, Patrick\n" +
            "Carballo, Miguel Angel\n" +
            "Carnevale, Mark\n" +
            "Carter, Jim\n" +
            "Casey, Paul\n" +
            "Castro, Roberto\n" +
            "Cauley, Bud\n" +
            "Cejka, Alex\n" +
            "Cerrudo, Ron\n" +
            "Chalmers, Greg\n" +
            "Chamblee, Brandel\n" +
            "Chappell, Kevin\n" +
            "Chen, T.C.\n" +
            "Choi, K.J.\n" +
            "Chopra, Daniel\n" +
            "Cink, Stewart\n" +
            "Clampett, Bobby\n" +
            "Clark II, Michael\n" +
            "Clark, Tim\n" +
            "Clarke, Darren\n" +
            "Claxton, Will\n" +
            "Clearwater, Keith\n" +
            "Clements, Lennie\n" +
            "Coceres, Jose\n" +
            "Cochran, Russ\n" +
            "Colbert, Jim\n" +
            "Cole, Bobby\n" +
            "Collins, Chad\n" +
            "Compton, Erik\n" +
            "Conner, Frank\n" +
            "Coody, Charles\n" +
            "Cook, John\n" +
            "Couch, Chris\n" +
            "Couples, Fred\n" +
            "Crampton, Bruce\n" +
            "Crane, Ben\n" +
            "Crenshaw, Ben\n" +
            "Curl, Rod\n" +
            "Curran, Jon\n" +
            "Curtis, Ben\n" +
            "Daly, John\n" +
            "Damron, Robert\n" +
            "Davis, Brian\n" +
            "Dawson, Marco\n" +
            "Day, Glen\n" +
            "Day, Jason\n" +
            "DeLaet, Graham\n" +
            "Delsing, Jay\n" +
            "Dent, Jim\n" +
            "Devlin, Bruce\n" +
            "DiMarco, Chris\n" +
            "Dickson, Bob\n" +
            "Diehl, Terry\n" +
            "Dill, Terry\n" +
            "Dodds, Trevor\n" +
            "Donald, Luke\n" +
            "Donald, Mike\n" +
            "Donaldson, Jamie\n" +
            "Dougherty, Ed\n" +
            "Douglass, Dale\n" +
            "Dufner, Jason\n" +
            "Duke, Ken\n" +
            "Durant, Joe\n" +
            "Duval, David\n" +
            "Eastwood, Bob\n" +
            "Edwards, Danny\n" +
            "Edwards, David\n" +
            "Edwards, Joel\n" +
            "Eichelberger, Dave\n" +
            "Elder, Lee\n" +
            "Elkington, Steve\n" +
            "Els, Ernie\n" +
            "English, Harris\n" +
            "Ernst, Derek\n" +
            "Estes, Bob\n" +
            "Every, Matt\n" +
            "Fabel, Brad\n" +
            "Fathauer, Derek\n" +
            "Faxon, Brad\n" +
            "Fehr, Rick\n" +
            "Fergus, Keith\n" +
            "Ferree, Jim\n" +
            "Fezler, Forrest\n" +
            "Finau, Tony\n" +
            "Finsterwald, Dow\n" +
            "Fiori, Ed\n" +
            "Fitzsimons, Pat\n" +
            "Fleckman, Marty\n" +
            "Fleisher, Bruce\n" +
            "Flesch, Steve\n" +
            "Floyd, Raymond\n" +
            "Ford, Doug\n" +
            "Forsman, Dan\n" +
            "Fought, John\n" +
            "Fowler, Rickie\n" +
            "Franco, Carlos\n" +
            "Frazar, Harrison\n" +
            "Freeman, Robin\n" +
            "Frost, David\n" +
            "Funk, Fred\n" +
            "Furyk, Jim\n" +
            "Gainey, Tommy\n" +
            "Gallagher, Jr., Jim\n" +
            "Gamez, Robert\n" +
            "Garcia, Sergio\n" +
            "Gardner, Buddy\n" +
            "Garnett, Brice\n" +
            "Garrigus, Robert\n" +
            "Gates, Bobby\n" +
            "Gay, Brian\n" +
            "Geiberger, Al\n" +
            "Geiberger, Brent\n" +
            "Gibson, Kelly\n" +
            "Gibson, Rhein\n" +
            "Gilbert, Gibby\n" +
            "Gilder, Bob\n" +
            "Gillis, Tom\n" +
            "Glasson, Bill\n" +
            "Glover, Lucas\n" +
            "Glover, Randy\n" +
            "Goalby, Bob\n" +
            "Gogel, Matt\n" +
            "Gomez, Fabian\n" +
            "Gonzales, Andres\n" +
            "Gonzalez, Ernie\n" +
            "Goosen, Retief\n" +
            "Gore, Jason\n" +
            "Gossett, David\n" +
            "Goydos, Paul\n" +
            "Graham, David\n" +
            "Green, Hubert\n" +
            "Green, Ken\n" +
            "Green, Nathan\n" +
            "Grillo, Emiliano\n" +
            "Groh, Gary\n" +
            "Gump, Scott\n" +
            "Guthrie, Luke\n" +
            "Haas, Bill\n" +
            "Haas, Jay\n" +
            "Hadley, Chesson\n" +
            "Hadwin, Adam\n" +
            "Hahn, James\n" +
            "Hallberg, Gary\n" +
            "Halldorson, Dan\n" +
            "Hamilton, Todd\n" +
            "Hammer, Laurie\n" +
            "Hammond, Donnie\n" +
            "Hancock, Phillip\n" +
            "Harman, Brian\n" +
            "Harrington, Padraig\n" +
            "Harris, Labron\n" +
            "Hart, Dudley\n" +
            "Hatalsky, Morris\n" +
            "Hayes, J.P.\n" +
            "Hayes, Mark\n" +
            "Heard, Jerry\n" +
            "Hearn, David\n" +
            "Heinen, Mike\n" +
            "Henke, Nolan\n" +
            "Henley, Russell\n" +
            "Henninger, Brian\n" +
            "Henry, Bunky\n" +
            "Henry, J.J.\n" +
            "Hensby, Mark\n" +
            "Herman, Jim\n" +
            "Herron, Tim\n" +
            "Hicks, Justin\n" +
            "Hinkle, Lon\n" +
            "Hinson, Larry\n" +
            "Hiskey, Babe\n" +
            "Hjertstedt, Gabriel\n" +
            "Hoch, Scott\n" +
            "Hoffman, Charley\n" +
            "Hoffmann, Morgan\n" +
            "Hoge, Tom\n" +
            "Holmes, J.B.\n" +
            "Horschel, Billy\n" +
            "Howell III, Charles\n" +
            "Hubbard, Mark\n" +
            "Huh, John\n" +
            "Hulbert, Mike\n" +
            "Hurley III, Billy\n" +
            "Huston, John\n" +
            "Imada, Ryuji\n" +
            "Immelman, Trevor\n" +
            "Inman, Joe\n" +
            "Inman, John\n" +
            "Irwin, Hale\n" +
            "Ishikawa, Ryo\n" +
            "Iverson, Don\n" +
            "Iwata, Hiroshi\n" +
            "Jacklin, Tony\n" +
            "Jacobs, Tommy\n" +
            "Jacobsen, Peter\n" +
            "Jacobson, Freddie\n" +
            "Jaeckel, Barry\n" +
            "Jamieson, Jim\n" +
            "January, Don\n" +
            "Janzen, Lee\n" +
            "Jenkins, Tom\n" +
            "Jobe, Brandt\n" +
            "Johnson, Dustin\n" +
            "Johnson, Howie\n" +
            "Johnson, Richard\n" +
            "Johnson, Zach\n" +
            "Johnston, Al\n" +
            "Johnston, Bill\n" +
            "Jones, Grier\n" +
            "Jones, Kent\n" +
            "Jones, Matt\n" +
            "Jones, Steve\n" +
            "Kang, Sung\n" +
            "Karl, Richie\n" +
            "Kaufman, Smylie\n" +
            "Kaye, Jonathan\n" +
            "Kelly, Jerry\n" +
            "Kelly, Troy\n" +
            "Kendall, Skip\n" +
            "Kim, Anthony\n" +
            "Kim, Michael\n" +
            "Kim, Si Woo\n" +
            "Kim, Whee\n" +
            "Kirk, Chris\n" +
            "Kisner, Kevin\n" +
            "Kite, Tom\n" +
            "Kizzire, Patton\n" +
            "Knost, Colt\n" +
            "Knox, Kenny\n" +
            "Knox, Russell\n" +
            "Koch, Gary\n" +
            "Koepka, Brooks\n" +
            "Kokrak, Jason\n" +
            "Kraft, Greg\n" +
            "Kraft, Kelly\n" +
            "Kratzert, Billy\n" +
            "Kuchar, Matt\n" +
            "Lahiri, Anirban\n" +
            "Laird, Martin\n" +
            "Lamely, Derek\n" +
            "Lancaster, Neal\n" +
            "Landry, Andrew\n" +
            "Langer, Bernhard\n" +
            "Langley, Scott\n" +
            "Lee, D.H.\n" +
            "Lee, Danny\n" +
            "Lee, Lucas\n" +
            "Lee, Richard\n" +
            "Leggatt, Ian\n" +
            "Lehman, Tom\n" +
            "Leishman, Marc\n" +
            "Leonard, Justin\n" +
            "Levi, Wayne\n" +
            "Levin, Spencer\n" +
            "Lewis, J.L.\n" +
            "Lickliter II, Frank\n" +
            "Lietzke, Bruce\n" +
            "Lindsey, Pat\n" +
            "Lingmerth, David\n" +
            "List, Luke\n" +
            "Littler, Gene\n" +
            "Lohr, Bob\n" +
            "Lonard, Peter\n" +
            "Lott, Lyn\n" +
            "Loupe, Andrew\n" +
            "Love III, Davis\n" +
            "Lovemark, Jamie\n" +
            "Lowery, Steve\n" +
            "Lowry, Shane\n" +
            "Lunde, Bill\n" +
            "Lunn, Bob\n" +
            "Lye, Mark\n" +
            "Lyle, Jarrod\n" +
            "Lyle, Sandy\n" +
            "MacKenzie, Will\n" +
            "Magee, Andrew\n" +
            "Maggert, Jeff\n" +
            "Mahaffey, John\n" +
            "Mahan, Hunter\n" +
            "Malnati, Peter\n" +
            "Maltbie, Roger\n" +
            "Manassero, Matteo\n" +
            "Marino, Steve\n" +
            "Marti, Fred\n" +
            "Martin, Ben\n" +
            "Maruyama, Shigeki\n" +
            "Massengale, Rik\n" +
            "Mast, Dick\n" +
            "Matsuyama, Hideki\n" +
            "Matteson, Troy\n" +
            "Mattiace, Len\n" +
            "Maxwell, Billy\n" +
            "Mayfair, Billy\n" +
            "McCallister, Blaine\n" +
            "McCallister, Bob\n" +
            "McCarron, Scott\n" +
            "McCord, Gary\n" +
            "McCullough, Mike\n" +
            "McCumber, Mark\n" +
            "McDowell, Graeme\n" +
            "McGee, Jerry\n" +
            "McGirt, William\n" +
            "McGovern, Jim\n" +
            "McGowan, Pat\n" +
            "McIlroy, Rory\n" +
            "McLachlin, Parker\n" +
            "McLendon, Mac\n" +
            "McNeill, George\n" +
            "McRoy, Spike\n" +
            "Mediate, Rocco\n" +
            "Merrick, John\n" +
            "Merritt, Troy\n" +
            "Micheel, Shaun\n" +
            "Mickelson, Phil\n" +
            "Miller, Allen\n" +
            "Miller, Johnny\n" +
            "Mitchell, Bobby\n" +
            "Mitchell, Jeff\n" +
            "Mize, Larry\n" +
            "Molder, Bryce\n" +
            "Molinari, Francesco\n" +
            "Moore, Ryan\n" +
            "Morgan, Gil\n" +
            "Morley, Mike\n" +
            "Morse, John\n" +
            "Murphy, Bob\n" +
            "Na, Kevin\n" +
            "Nelford, Jim\n" +
            "Nelson, Larry\n" +
            "Nevil, Dwight\n" +
            "Newton, Jack\n" +
            "Nichols, Bobby\n" +
            "Nicklaus, Jack\n" +
            "Nicolette, Mike\n" +
            "Nieporte, Tom\n" +
            "Nobilo, Frank\n" +
            "Noh, Seung-Yul\n" +
            "Norlander, Henrik\n" +
            "Norman, Greg\n" +
            "Norris, Tim\n" +
            "North, Andy\n" +
            "O'Grady, Mac\n" +
            "O'Hair, Sean\n" +
            "O'Meara, Mark\n" +
            "Oberholser, Arron\n" +
            "Ogilvie, Joe\n" +
            "Ogilvy, Geoff\n" +
            "Ogrin, David\n" +
            "Olazabal, Jose Maria\n" +
            "Oosterhuis, Peter\n" +
            "Oosthuizen, Louis\n" +
            "Oppenheim, Rob\n" +
            "Ortiz, Carlos\n" +
            "Overton, Jeff\n" +
            "Owen, Greg\n" +
            "Pace, Roy\n" +
            "Palmer, Arnold\n" +
            "Palmer, Ryan\n" +
            "Pampling, Rod\n" +
            "Park, S.J.\n" +
            "Parnevik, Jesper\n" +
            "Parry, Craig\n" +
            "Pate, Jerry\n" +
            "Pate, Steve\n" +
            "Paulson, Dennis\n" +
            "Pavin, Corey\n" +
            "Peoples, David\n" +
            "Percy, Cameron\n" +
            "Perez, Pat\n" +
            "Perks, Craig\n" +
            "Pernice Jr., Tom\n" +
            "Perry, Chris\n" +
            "Perry, Kenny\n" +
            "Peterson, John\n" +
            "Petrovic, Tim\n" +
            "Pettersson, Carl\n" +
            "Pfeil, Mark\n" +
            "Piercy, Scott\n" +
            "Piller, Martin\n" +
            "Pinckney, Scott\n" +
            "Player, Gary\n" +
            "Pohl, Dan\n" +
            "Points, D.A.\n" +
            "Pooley, Don\n" +
            "Pott, Johnny\n" +
            "Potter, Jr., Ted\n" +
            "Poulter, Ian\n" +
            "Powers, Greg\n" +
            "Price, Nick\n" +
            "Pride, Dicky\n" +
            "Prugh, Alex\n" +
            "Purdy, Ted\n" +
            "Purtzer, Tom\n" +
            "Putnam, Michael\n" +
            "Quigley, Brett\n" +
            "Ragan, Dave\n" +
            "Randolph, Sam\n" +
            "Reavie, Chez\n" +
            "Reed, Patrick\n" +
            "Regalado, Victor\n" +
            "Reid, Mike\n" +
            "Reid, Steve\n" +
            "Reifers, Kyle\n" +
            "Renner, Jack\n" +
            "Riley, Chris\n" +
            "Rinker, Larry\n" +
            "Roach, Wes\n" +
            "Roberts, Loren\n" +
            "Rodriguez, Chi Chi\n" +
            "Rogers, Bill\n" +
            "Rollins, John\n" +
            "Romero, Andres\n" +
            "Rose, Clarence\n" +
            "Rose, Justin\n" +
            "Rummells, Dave\n" +
            "Sabbatini, Rory\n" +
            "Sander, Bill\n" +
            "Sanders, Doug\n" +
            "Sauers, Gene\n" +
            "Saunders, Sam\n" +
            "Scherrer, Tom\n" +
            "Schroeder, John\n" +
            "Schulz, Ted\n" +
            "Schwartzel, Charl\n" +
            "Scott, Adam\n" +
            "Senden, John\n" +
            "Shaw, Tom\n" +
            "Shearer, Bob\n" +
            "Short, Jr., Wes\n" +
            "Sieckmann, Tom\n" +
            "Sikes, R.H.\n" +
            "Sills, Tony\n" +
            "Simpson, Scott\n" +
            "Simpson, Tim\n" +
            "Simpson, Webb\n" +
            "Sindelar, Joey\n" +
            "Singh, Vijay\n" +
            "Slocum, Heath\n" +
            "Sluman, Jeff\n" +
            "Smith, Bob\n" +
            "Smith, Chris\n" +
            "Smith, Mike\n" +
            "Snead, J.C.\n" +
            "Snedeker, Brandt\n" +
            "Sneed, Ed\n" +
            "Spieth, Jordan\n" +
            "Spray, Steve\n" +
            "Springer, Mike\n" +
            "Stadler, Craig\n" +
            "Stadler, Kevin\n" +
            "Stallings, Scott\n" +
            "Standly, Mike\n" +
            "Stankowski, Paul\n" +
            "Stanley, Kyle\n" +
            "Steele, Brendan\n" +
            "Stefani, Shawn\n" +
            "Stegmaier, Brett\n" +
            "Stenson, Henrik\n" +
            "Sterne, Richard\n" +
            "Stiles, Darron\n" +
            "Stockton, Dave\n" +
            "Stolz, Andre\n" +
            "Strange, Curtis\n" +
            "Streb, Robert\n" +
            "Streck, Ron\n" +
            "Streelman, Kevin\n" +
            "Stricker, Steve\n" +
            "Stroud, Chris\n" +
            "Stuard, Brian\n" +
            "Sullivan, Mike\n" +
            "Summerhays, Daniel\n" +
            "Sutherland, Kevin\n" +
            "Sutton, Hal\n" +
            "Swafford, Hudson\n" +
            "Tataurangi, Phil\n" +
            "Taylor, Nick\n" +
            "Taylor, Vaughn\n" +
            "Ten Broeck, Lance\n" +
            "Tewell, Doug\n" +
            "Thomas, Justin\n" +
            "Thompson, Leonard\n" +
            "Thompson, Michael\n" +
            "Thompson, Nicholas\n" +
            "Thompson, Rocky\n" +
            "Thorpe, Jim\n" +
            "Todd, Brendon\n" +
            "Toms, David\n" +
            "Toski, Bob\n" +
            "Trahan, D.J.\n" +
            "Trevino, Lee\n" +
            "Tringale, Cameron\n" +
            "Triplett, Kirk\n" +
            "Tryba, Ted\n" +
            "Turnesa, Marc\n" +
            "Tway, Bob\n" +
            "Twiggs, Greg\n" +
            "Twitty, Howard\n" +
            "Uresti, Omar\n" +
            "Utley, Stan\n" +
            "Van Aswegen, Tyrone\n" +
            "Van Pelt, Bo\n" +
            "Varner III, Harold\n" +
            "Vegas, Jhonattan\n" +
            "Verplank, Scott\n" +
            "Villegas, Camilo\n" +
            "Wadkins, Bobby\n" +
            "Wadkins, Lanny\n" +
            "Wadsworth, Fred\n" +
            "Wagner, Johnson\n" +
            "Waite, Grant\n" +
            "Waldorf, Duffy\n" +
            "Walker, Jimmy\n" +
            "Watney, Nick\n" +
            "Watson, Bubba\n" +
            "Watson, Denis\n" +
            "Watson, Tom\n" +
            "Weaver, Bert\n" +
            "Weaver, DeWitt\n" +
            "Weekley, Boo\n" +
            "Weibring, D.A.\n" +
            "Weir, Mike\n" +
            "Weiskopf, Tom\n" +
            "Wetterich, Brett\n" +
            "Wheatcroft, Steve\n" +
            "Wi, Charlie\n" +
            "Wiebe, Mark\n" +
            "Wiechers, Jim\n" +
            "Wilcox, Will\n" +
            "Wilkinson, Tim\n" +
            "Williams, Lee\n" +
            "Williamson, Jay\n" +
            "Willis, Garrett\n" +
            "Wilson, Dean\n" +
            "Wilson, Mark\n" +
            "Wood, Willie\n" +
            "Woodland, Gary\n" +
            "Woods, Tiger\n" +
            "Yang, Y.E.\n" +
            "Zoeller, Fuzzy\n" +
            "Zokol, Richard\n" +
            "de Jonge, Brendon\n" +
            "van der Walt, Dawie\n" +
            "Add Player\n" +
            "Did you know your favorites will be saved across all your digital devices and platforms, including desktop, tablet and phone?";
}
