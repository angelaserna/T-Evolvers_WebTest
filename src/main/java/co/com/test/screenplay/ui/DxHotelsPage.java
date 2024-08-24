package co.com.test.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DxHotelsPage extends PageObject {

    public static final Target LOGIN = Target.the("Login button")
            .located(By.id("HeaderControl_Login_CD"));

    public static final Target EMAIL = Target.the("Email textbox")
            .located(By.id("HeaderControl_LogonControl_LoginFormLayout_txtEmail_I"));

    public static final Target PASSWORD = Target.the("Password textbox")
            .located(By.xpath("//*[@type='password']"));

    public static final Target LOGIN_BTN = Target.the("Log_in button")
            .located(By.id("HeaderControl_LogonControl_btnLoginNow_CD"));

    public static final Target LOCATION = Target.the("Location selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_LocationComboBox_I"));

    public static final Target CHECKIN = Target.the("Check in selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckInDateEdit_I"));

    public static final Target CALENDAR_CHECKIN = Target.the("Calendar check in option")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckInDateEdit_B-1Img"));

    public static final Target CHECKOUT = Target.the("Check out selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckOutDateEdit_I"));

    public static final Target CALENDAR_CHECKOUT = Target.the("Calendar check out option")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckOutDateEdit_B-1"));

    public static final Target ROOMS = Target.the("Rooms selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_RoomsComboBox_I"));

    public static final Target ADULTS = Target.the("Adults selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_AdultsSpinEdit_I"));

    public static final Target CHILDREN = Target.the("Children selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_ChildrenSpinEdit_I"));

    public static final Target SEARCH = Target.the("Search button")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_SearchButton_CD"));

    public static final Target SLIDER = Target.the("Slider")
            .located(By.cssSelector("dxeTBTrack_Metropolis dxeFocusedMDHSys"));

    public static final Target SLIDER_MIN = Target.the("Slider")
            .located(By.id("MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_MD"));

    public static final Target SLIDER_MAX = Target.the("Slider")
            .located(By.id("MainContentPlaceHolder_FilterFormLayout_NightlyRateTrackBar_SD"));

    public static final Target SCORE_STAR = Target.the("Score")
            .located(By.id("MainContentPlaceHolder_FilterFormLayout_OurRatingCheckBoxList_RB'{0}'_I_D"));

    public static final Target RATE = Target.the("producto en carrito")
            .locatedBy("//*[text()='{0}']");

    public static final Target SCORE = Target.the("producto en carrito")
            .locatedBy("//*[text()='{0}']");

    public static final Target FAILED_MESSAGE = Target.the("Failed message")
            .located(By.id("HeaderControl_LogonControl_LoginFormLayout_Captcha_TB_EC"));


}
