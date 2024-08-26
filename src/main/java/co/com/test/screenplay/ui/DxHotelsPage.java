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

    public static final Target CHECKOUT = Target.the("Check out selector")
            .located(By.id("MainContentPlaceHolder_SearchPanel_SearchPanelLayout_CheckOutDateEdit_I"));

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

    public static Target SCORE_STAR = Target.the("Score star")
            .locatedBy("//*[@id='MainContentPlaceHolder_FilterFormLayout_OurRatingCheckBoxList_RB{0}_I_D']");

    public static final Target FAILED_MESSAGE = Target.the("Failed message")
            .located(By.id("HeaderControl_LogonControl_LoginFormLayout_Captcha_TB_EC"));

    public static final Target APPLY = Target.the("Apply button")
            .located(By.id("MainContentPlaceHolder_FilterFormLayout_ApplyFilterButton_CD"));

    public static final Target HOTELS = Target.the("Hotels list")
            .locatedBy("//*[@id='MainContentPlaceHolder_HotelsDataView_ICell']/table/tbody/tr");

    public static final Target NEXTPAGE = Target.the("Next page")
            .locatedBy("//*[@id='MainContentPlaceHolder_HotelsDataView_PGB_PBN']/img");

    public static final Target PREVIOUSPAGE = Target.the("Previous page")
            .locatedBy("//*[@id='MainContentPlaceHolder_HotelsDataView_PGB_PBP']/img");

    public static final Target BOOKIT = Target.the("Book it button")
            .locatedBy("//*[@id='MainContentPlaceHolder_HotelsDataView_IT{0}_BookItButton_{0}_CD']");

    public static final Target RESERVATION = Target.the("Reservation data")
            .locatedBy("//*[@id='form1']/div[3]/div[2]/div[4]/div[2]/div/div[1]/h5");
}
