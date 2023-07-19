package page.UI;

public class AddCustomerUI {

    public static final String MENU_DROP_LIST = "(//a[@href='#menu'])[1]";
    public static final String ADD_CUSTOMER = "(//a[contains(text(), 'Add Customer')])[2]";
    public static final String BTN_SUBMIT = "//input[@type='submit']";
    public static final String BTN_RESET = "//input[@type='reset']";
    public static final String BTN_DONE = "//input[@id='done']";
    public static final String BTN_PENDING = "//input[@id='pending']";
    public static final String TXT_FIRSTNAME = "//input[@id='fname']";
    public static final String TXT_LASTNAME = "//input[@id='lname']";
    public static final String TXT_EMAIL = "//input[@id='email']";
    public static final String TXT_ADDRESS = "//textarea[@id='message']";
    public static final String TXT_PHONENO = "//input[@id='telephoneno']";

    //Xpath System Messages
    public static String successAddCustomer = "//h1[contains(text(), 'Access Details to Guru99 Telecom')]";
    public static String emptyFName = "//label[@id='message']";
    public static String specialCharFName = "//label[contains(text(), 'Special characters are not allowed') and @id='message']";
    public static String emptyLName = "//label[@id='message50']";
    public static String specialCharLName = "//label[contains(text(), 'Special characters are not allowed') and @id='message50']";
    public static String emptyEmail = "//label[@id='message9']";
    public static String invalidEmail = "//label[contains(text(), 'Email-ID is not valid') and @id='message9']";
    public static String atCharEmail = "//label[contains(text(), 'Email-ID is not valid') and @id='message9']"; //input email with @ before @mail.vn
    public static String otherSpecCharEmail = "//h1[contains(text(), 'Access Details to Guru99 Telecom')]";
    public static String emptyAddress = "//label[@id='message3']";
    public static String specialCharAddress = "//label[contains(text(), 'Special characters are not allowed') and @id='message3']";
    public static String emptyMobileNo = "//label[@id='message7']";
    public static String normalCharMoblieNo = "//label[contains(text(), 'Characters are not allowed') and @id='message7']";
    public static String specilaCharMobileNo= "//label[contains(text(), 'Special characters are not allowed') and @id='message7']";
    public static String normalAndSpecialCharMobileNo = "//label[contains(text(), 'Special characters are not allowed') and @id='message7']";

    //Column Titles in Excel File
    public static String backGroundCheck = "Background Check";
    public static String colFName = "First Name *";
    public static String colLName = "Last Name *";
    public static String colEmail = "Email *";
    public static String colAddress = "Address *";
    public static String colMobileNo = "Mobile Number *";
    public static String colXpathMessage = "Xpath Message";
    public static String colExpectedMessage = "Expected Message";
}
