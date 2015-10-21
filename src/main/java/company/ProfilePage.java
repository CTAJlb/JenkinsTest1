package company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProfilePage {
    public static String avatarArea = "//*[contains(@class,'user-menu')]/div";
    public static String welcomeMessage = "//span[@class='welcome-user-name']";
    public static String manageProfileLink = "//*[contains(@class,'user-menu')]//a[@data-action='profile']";
    public static String notificationsLink = "//*[contains(@class,'user-menu')]//a[@data-action='notification-settings']";
    public static String favoritesLink = "//*[contains(@class,'user-menu')]//a[@data-action='favorite-players']";
    public static String changePassLink = "//*[contains(@class,'user-menu')]//a[@data-action='change-password']";
    public static String logoutLink = "//*[contains(@class,'user-menu')]//a[@data-action='logout']";

    public static String emailInput = "//*[@id='gigya-profile-form']//input[@name='email']";
    public static String firstnameInput = "//*[@id='gigya-profile-form']//input[@name='profile.firstName']";
    public static String lastnameInput = "//*[@id='gigya-profile-form']//input[@name='profile.lastName']";
    public static String passwordInput = "//*[@id='gigya-profile-form']//input[@name='password']";
    public static String passConfirmInput = "//*[@id='gigya-profile-form']//input[@name='passwordRetype']";
    public static String nicknameInput = "//*[@id='gigya-profile-form']//input[@name='profile.nickname']";
    public static String zipcodeInput = "//*[@id='gigya-profile-form']//input[@name='profile.zip']";
    public static String checkbox = "//*[@id='gigya-profile-form']//input[@name='data.terms']";
    public static String birthYearSelect = "//*[@id='gigya-profile-form']//select[@name='profile.birthYear']";
    public static String birthMonthSelect = "//*[@id='gigya-profile-form']//select[@name='profile.birthMonth']";
    public static String birthDaySelect = "//*[@id='gigya-profile-form']//select[@name='profile.birthDay']";
    public static String countrySelect = "//*[@id='gigya-profile-form']//select[@name='profile.country']";
    public static String submitProfileButton = "//*[@id='gigya-profile-form']//*[@class='gigya-input-submit']";

    public static String findPlayerInput = "//*[@id='gigya-profile-form3']//input[@name='data.findPlayer']";
    public static String selectPlayersSelect = "//*[@id='gigya-profile-form3']//select[@name='data.players']";
    public static String favoritesList = "//*[@id='myFavoritePlayersList']/following::div[@class='player-item']";
    public static String anyFavoriteInList = "//*[@class='player-item']";


    public static void cursorOverAvatar() {
        Helper.waitSec(2);
        Helper.waitElementByXpath(avatarArea);
        Actions actions = new Actions(Helper.driver);
        actions.moveToElement(Helper.waitElementByXpath(avatarArea)).build().perform();
    }
    public static String getWelcomeMessage() {
        cursorOverAvatar();
        return Helper.waitElementByXpath(welcomeMessage).getText();
    }
    public static void goToProfile() {
        cursorOverAvatar();
        Helper.waitElementByXpath(manageProfileLink).click();
        Helper.waitElementByXpath(emailInput);
    }
    public static void goToNotifications() {
        cursorOverAvatar();
        Helper.waitElementByXpath(notificationsLink).click();
    }
    public static void goToFavorites() {
        cursorOverAvatar();
        Helper.waitElementByXpath(favoritesLink).click();
    }
    public static void goToChangePass() {
        cursorOverAvatar();
        Helper.waitElementByXpath(changePassLink).click();
    }
    public static void clearInput(String input) {
        Helper.waitElementByXpath(input).clear();
    }
    public static void submitChangesInProfile() {
        Helper.waitElementByXpath(submitProfileButton);
        Helper.waitElementByXpath(submitProfileButton).click();
        Helper.waitElementNotExistByXpath(submitProfileButton);
    }
    public static void logOut() {
        cursorOverAvatar();
        Helper.waitElementByXpath(logoutLink).click();
    }
    public static boolean favoritesListEmpty() {
        Helper.waitElementByXpath(selectPlayersSelect);
        Helper.waitSec(2);
        if (Helper.driver.findElements(By.xpath(favoritesList)).size() == 0) {
            return true;
        } else {
            System.out.println("FAIL: List isn't empty!");
            return false;
        }
    }
    public static int sizeOfList() {
        Helper.waitElementByXpath(anyFavoriteInList);
        List<WebElement> list = Helper.driver.findElements(By.xpath(anyFavoriteInList));
        return list.size();
    }
    public static boolean checkPlayerNamesInDropdown() {
        String[] expected =
                {"Blake Adams", "John Adams", "Sam Adams", "Joe Affrunti", "Steven Alker", "Manage/Add favorites"};
        List<WebElement> actualPlayers = Helper.driver.findElements(By.xpath("//*[@class='players-list']/li"));
        cursorOverAvatar();
        for(int i = 0; i <= 5; i++) {
            if(expected[i].equals(actualPlayers.get(i).getText().replace("\n?", ""))) {
            } else {
                return false;
            }
        }
        return true;
    }
    public static void delExpectedFavoritePlayers(int totalnumber) {
        Helper.waitElementByXpath(anyFavoriteInList);
        for (int i = totalnumber; i > 1; i--) {
            Helper.driver.findElement(By.xpath(LogInPage.deleteFavPlayerButton)).click();
        }
    }


    public static String profileFormAllTexts = "Edit Your Profile Details\n" +
            "Personal Info\n" +
            "Notification Settings\n" +
            "Favorite Players\n" +
            "Change Password\n" +
            "Logout\n" +
            "Email:*\n" +
            "First name:*\n" +
            "Last name:*\n" +
            "Country:*\n" +
            "United States\n" +
            "Afghanistan\n" +
            "Albania\n" +
            "Algeria\n" +
            "American Samoa\n" +
            "Andorra\n" +
            "Angola\n" +
            "Anguilla\n" +
            "Antarctica\n" +
            "Antigua and Barbuda\n" +
            "Argentina\n" +
            "Armenia\n" +
            "Aruba\n" +
            "Australia\n" +
            "Austria\n" +
            "Azerbaijan\n" +
            "Bahamas\n" +
            "Bahrain\n" +
            "Bangladesh\n" +
            "Barbados\n" +
            "Belarus\n" +
            "Belgium\n" +
            "Belize\n" +
            "Benin\n" +
            "Bermuda\n" +
            "Bhutan\n" +
            "Bolivia\n" +
            "Bosnia and Herzegovina\n" +
            "Botswana\n" +
            "Bouvet Island\n" +
            "Brazil\n" +
            "British Indian Ocean Territory\n" +
            "Brunei Darussalam\n" +
            "Bulgaria\n" +
            "Burkina Faso\n" +
            "Burundi\n" +
            "Cambodia\n" +
            "Cameroon\n" +
            "Canada\n" +
            "Cape Verde\n" +
            "Cayman Islands\n" +
            "Central African Republic\n" +
            "Chad\n" +
            "Chile\n" +
            "China\n" +
            "Christmas Island\n" +
            "Cocos (Keeling) Islands\n" +
            "Colombia\n" +
            "Comoros\n" +
            "Congo\n" +
            "Cook Islands\n" +
            "Costa Rica\n" +
            "Cote Divoire\n" +
            "Croatia\n" +
            "Cuba\n" +
            "Cyprus\n" +
            "Czech Republic\n" +
            "Denmark\n" +
            "Djibouti\n" +
            "Dominica\n" +
            "Dominican Republic\n" +
            "Easter Island\n" +
            "Ecuador\n" +
            "Egypt\n" +
            "El Salvador\n" +
            "Equatorial Guinea\n" +
            "Eritrea\n" +
            "Estonia\n" +
            "Ethiopia\n" +
            "Falkland Islands (Malvinas)\n" +
            "Faroe Islands\n" +
            "Fiji\n" +
            "Finland\n" +
            "France\n" +
            "French Guiana\n" +
            "French Polynesia\n" +
            "French Southern Territories\n" +
            "Gabon\n" +
            "Gambia\n" +
            "Georgia\n" +
            "Germany\n" +
            "Ghana\n" +
            "Gibraltar\n" +
            "Greece\n" +
            "Greenland\n" +
            "Grenada\n" +
            "Guadeloupe\n" +
            "Guam\n" +
            "Guatemala\n" +
            "Guinea\n" +
            "Guinea-bissau\n" +
            "Guyana\n" +
            "Haiti\n" +
            "Heard Island and Mcdonald Islands\n" +
            "Honduras\n" +
            "Hong Kong\n" +
            "Hungary\n" +
            "Iceland\n" +
            "India\n" +
            "Indonesia\n" +
            "Iran\n" +
            "Iraq\n" +
            "Ireland\n" +
            "Israel\n" +
            "Italy\n" +
            "Jamaica\n" +
            "Japan\n" +
            "Jordan\n" +
            "Kazakhstan\n" +
            "Kenya\n" +
            "Kiribati\n" +
            "Korea + North\n" +
            "Korea + South\n" +
            "Kosovo\n" +
            "Kuwait\n" +
            "Kyrgyzstan\n" +
            "Laos\n" +
            "Latvia\n" +
            "Lebanon\n" +
            "Lesotho\n" +
            "Liberia\n" +
            "Libyan Arab Jamahiriya\n" +
            "Liechtenstein\n" +
            "Lithuania\n" +
            "Luxembourg\n" +
            "Macau\n" +
            "Macedonia\n" +
            "Madagascar\n" +
            "Malawi\n" +
            "Malaysia\n" +
            "Maldives\n" +
            "Mali\n" +
            "Malta\n" +
            "Marshall Islands\n" +
            "Martinique\n" +
            "Mauritania\n" +
            "Mauritius\n" +
            "Mayotte\n" +
            "Mexico\n" +
            "Micronesia + Federated States of\n" +
            "Moldova + Republic of\n" +
            "Monaco\n" +
            "Mongolia\n" +
            "Montenegro\n" +
            "Montserrat\n" +
            "Morocco\n" +
            "Mozambique\n" +
            "Myanmar\n" +
            "Namibia\n" +
            "Nauru\n" +
            "Nepal\n" +
            "Netherlands\n" +
            "Netherlands Antilles\n" +
            "New Caledonia\n" +
            "New Zealand\n" +
            "Nicaragua\n" +
            "Niger\n" +
            "Nigeria\n" +
            "Niue\n" +
            "Norfolk Island\n" +
            "Northern Mariana Islands\n" +
            "Norway\n" +
            "Oman\n" +
            "Pakistan\n" +
            "Palau\n" +
            "Palestinian Territory\n" +
            "Panama\n" +
            "Papua New Guinea\n" +
            "Paraguay\n" +
            "Peru\n" +
            "Philippines\n" +
            "Pitcairn\n" +
            "Poland\n" +
            "Portugal\n" +
            "Puerto Rico\n" +
            "Qatar\n" +
            "Reunion\n" +
            "Romania\n" +
            "Russia\n" +
            "Rwanda\n" +
            "Saint Helena\n" +
            "Saint Kitts and Nevis\n" +
            "Saint Lucia\n" +
            "Saint Pierre and Miquelon\n" +
            "Saint Vincent and The Grenadines\n" +
            "Samoa\n" +
            "San Marino\n" +
            "Sao Tome and Principe\n" +
            "Saudi Arabia\n" +
            "Senegal\n" +
            "Serbia and Montenegro\n" +
            "Seychelles\n" +
            "Sierra Leone\n" +
            "Singapore\n" +
            "Slovakia\n" +
            "Slovenia\n" +
            "Solomon Islands\n" +
            "Somalia\n" +
            "South Africa\n" +
            "South Georgia and The South Sandwich Islands\n" +
            "Spain\n" +
            "Sri Lanka\n" +
            "Sudan\n" +
            "Suriname\n" +
            "Svalbard and Jan Mayen\n" +
            "Swaziland\n" +
            "Sweden\n" +
            "Switzerland\n" +
            "Syria\n" +
            "Taiwan\n" +
            "Tajikistan\n" +
            "Tanzania + United Republic of\n" +
            "Thailand\n" +
            "Timor-leste\n" +
            "Togo\n" +
            "Tokelau\n" +
            "Tonga\n" +
            "Trinidad and Tobago\n" +
            "Tunisia\n" +
            "Turkey\n" +
            "Turkmenistan\n" +
            "Turks and Caicos Islands\n" +
            "Tuvalu\n" +
            "Uganda\n" +
            "Ukraine\n" +
            "United Arab Emirates\n" +
            "United Kingdom\n" +
            "United States Minor Outlying Islands\n" +
            "Uruguay\n" +
            "Uzbekistan\n" +
            "Vanuatu\n" +
            "Vatican City\n" +
            "Venezuela\n" +
            "Vietnam\n" +
            "Virgin Islands + British\n" +
            "Virgin Islands + U.S.\n" +
            "Wallis and Futuna\n" +
            "Western Sahara\n" +
            "Yemen\n" +
            "Zambia\n" +
            "Zimbabwe\n" +
            "Display name\n" +
            "Year of birth:*\n" +
            "1920\n" +
            "1921\n" +
            "1922\n" +
            "1923\n" +
            "1924\n" +
            "1925\n" +
            "1926\n" +
            "1927\n" +
            "1928\n" +
            "1929\n" +
            "1930\n" +
            "1931\n" +
            "1932\n" +
            "1933\n" +
            "1934\n" +
            "1935\n" +
            "1936\n" +
            "1937\n" +
            "1938\n" +
            "1939\n" +
            "1940\n" +
            "1941\n" +
            "1942\n" +
            "1943\n" +
            "1944\n" +
            "1945\n" +
            "1946\n" +
            "1947\n" +
            "1948\n" +
            "1949\n" +
            "1950\n" +
            "1951\n" +
            "1952\n" +
            "1953\n" +
            "1954\n" +
            "1955\n" +
            "1956\n" +
            "1957\n" +
            "1958\n" +
            "1959\n" +
            "1960\n" +
            "1961\n" +
            "1962\n" +
            "1963\n" +
            "1964\n" +
            "1965\n" +
            "1966\n" +
            "1967\n" +
            "1968\n" +
            "1969\n" +
            "1970\n" +
            "1971\n" +
            "1972\n" +
            "1973\n" +
            "1974\n" +
            "1975\n" +
            "1976\n" +
            "1977\n" +
            "1978\n" +
            "1979\n" +
            "1980\n" +
            "1981\n" +
            "1982\n" +
            "1983\n" +
            "1984\n" +
            "1985\n" +
            "1986\n" +
            "1987\n" +
            "1988\n" +
            "1989\n" +
            "1990\n" +
            "1991\n" +
            "1992\n" +
            "1993\n" +
            "1994\n" +
            "1995\n" +
            "1996\n" +
            "1997\n" +
            "1998\n" +
            "1999\n" +
            "2000\n" +
            "2001\n" +
            "2002\n" +
            "2003\n" +
            "2004\n" +
            "2005\n" +
            "2006\n" +
            "2006\n" +
            "2007\n" +
            "2008\n" +
            "2009\n" +
            "2010\n" +
            "2011\n" +
            "2012\n" +
            "2013\n" +
            "2014\n" +
            "2015\n" +
            "Month of birth*\n" +
            "January\n" +
            "February\n" +
            "March\n" +
            "April\n" +
            "May\n" +
            "June\n" +
            "July\n" +
            "August\n" +
            "September\n" +
            "October\n" +
            "November\n" +
            "December\n" +
            "Day of birth*\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "6\n" +
            "7\n" +
            "8\n" +
            "9\n" +
            "10\n" +
            "11\n" +
            "12\n" +
            "13\n" +
            "14\n" +
            "15\n" +
            "16\n" +
            "17\n" +
            "18\n" +
            "19\n" +
            "20\n" +
            "21\n" +
            "22\n" +
            "23\n" +
            "24\n" +
            "25\n" +
            "26\n" +
            "27\n" +
            "28\n" +
            "29\n" +
            "30\n" +
            "31\n" +
            "Zip code:\n" +
            "Avatar\n" +
            "Choose File No file chosen\n" +
            "Maximum size of 3MB. JPG + GIF + PNG.";
}
