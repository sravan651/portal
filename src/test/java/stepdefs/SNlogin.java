package stepdefs;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import locators.SunNxtObjects.ApplyCoupon;
import locators.SunNxtObjects.BottomLinks;
import locators.SunNxtObjects.CancelSubscription;
import locators.SunNxtObjects.ContinueWatching;
import locators.SunNxtObjects.Customer;
import locators.SunNxtObjects.Devices;
import locators.SunNxtObjects.Favourite;
import locators.SunNxtObjects.ForgetPassword;
import locators.SunNxtObjects.GuestUser;
import locators.SunNxtObjects.HDAndSD;
import locators.SunNxtObjects.LiveTV;
import locators.SunNxtObjects.Login;
import locators.SunNxtObjects.Logout;
import locators.SunNxtObjects.More;
import locators.SunNxtObjects.Movies;
import locators.SunNxtObjects.MusicVideos;
import locators.SunNxtObjects.Premium;
import locators.SunNxtObjects.ProfileEdit;
import locators.SunNxtObjects.Searchmovie;
import locators.SunNxtObjects.Share;
import locators.SunNxtObjects.Sigup;
import locators.SunNxtObjects.SubscribeGuest;
import locators.SunNxtObjects.SubscribePlan;
import locators.SunNxtObjects.Subscriptions;
import locators.SunNxtObjects.Subtitles;
import locators.SunNxtObjects.SwitchProfile;
import locators.SunNxtObjects.TVShows;
import locators.SunNxtObjects.UnsubscribedUser;
import utilities.ExcelDataUtil;
import utilities.ExtTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class SNlogin extends KeywordUtil {
	@Given("^Read the test data \"([^\"]*)\" and \"([^\"]*)\" from Excel file$")

	public void given_Read_the_test_data_from_Excel_file(String arg1, String arg2) {
		try {
			dataMap = new ExcelDataUtil().getTestDataWithTestCaseID(arg1, arg2);
		} catch (Throwable e) {
			ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^user Navigate Sun Nxt page$")
	public void sunNxtlogin() {
		try {
			navigateToUrl(config.getTDValue("url"));
		} catch (Throwable e) {
			ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	}

	@Given("^user click on tv shows$")
	public void user_click_on_tv_shows() {
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click tv shows button");
		pause(3000);
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click view all tv shows button");
	}

	@When("^user click on free tv shows$")
	public void user_click_on_free_tv_shows() {
		pause(4000);
		
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(5000);
		moveToElement(GuestUser.freeContentBtn);
		visibilityofElementLocated(GuestUser.freeContentBtn, "free content tvshow displayed");
		click(GuestUser.freeContentBtn, "user click free tv show");
		visibilityofElementLocated(GuestUser.playBtn, "play button displayed");
		click(GuestUser.playBtn, "user click play button");
		pause(5000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
	}

	@Then("^user click on second free content episode$")
	public void user_click_on_second_free_content_episode() {
		visibilityofElementLocated(GuestUser.freeContent2Btn, "episodes are displayed");
		click(GuestUser.freeContent2Btn, "user play second free episode");
		pause(5000);

		/*scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		visibilityofElementLocated(GuestUser.freeContent3Btn, "episodes are displayed");
		click(GuestUser.freeContent3Btn, "user play third free episode");*/
	}

	@And("^user observe sigin page displayed$")
	public void user_observe_sigin_page_displayed() {
		pause(2000);
		String signIn = getElementText(GuestUser.popupSigin, "Sign IN page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("Sign In")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		pause(2000);
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");

	}

	@Then("^user play two free music videos$")
	public void user_play_two_free_music_videos() {
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeSerial_Img, "free videos displayed");
		click(UnsubscribedUser.FreeSerial_Img, "user play 1st free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		back();
		click(UnsubscribedUser.FreeSerial2_Img, "user play 2nd video");
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
	/*	back();
		click(UnsubscribedUser.FreeSerial3_Img, "user play 3rd video");
		click(GuestUser.playBtn, "user click play button");
		pause(3000);*/
		// back();
	}

	@And("^observe sigin page is displayed for playing third free video$")
	public void observe_sigin_page_is_displayed_for_playing_third_free_video() {
		pause(2000);
		String signIn = getElementText(GuestUser.popupSigin, "Sign IN page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("Sign In")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		pause(2000);
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(2000);
		back();
	}

	@Then("^user play two free comedy videos$")
	public void user_play_two_free_comedy_videos() {
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img, " free videos displayed");
		click(UnsubscribedUser.FreeVideo_Img, "user play one free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo2_Img, "user play 2nd free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo3_Img, "user play 3rd free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
	}

	@And("^sigin page is displayed for playing third free video$")
	public void sigin_page_is_displayed_for_playing_third_free_video() {
		String signIn = getElementText(GuestUser.popupSigin, "Sign IN page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("Sign In")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		pause(2000);
		
	}

	@Given("^user play two free tv episode$")
	public void user_play_two_free_tv_episode() {
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv show button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv show button");
		pause(5000);
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv show button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv show button");
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till free TV serial");

		pause(3000);
		moveToElement(GuestUser.freeContentBtn);
		visibilityofElementLocated(GuestUser.freeContentBtn, "free TV serial displayed");
		pause(2000);
		
		click(GuestUser.freeContentBtn, "user click free tv serial");
		pause(2000);
		visibilityofElementLocated(GuestUser.playBtn, "play button displayed");
		click(GuestUser.playBtn, "user click play button");
		pause(5000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		pause(5000);
		visibilityofElementLocated(GuestUser.freeContent2Btn, "episodes are displayed");
		click(GuestUser.freeContent2Btn, "user click second free episode");
		pause(5000);
		/*scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");

		visibilityofElementLocated(GuestUser.freeContent3Btn, "episodes are displayed");
		click(GuestUser.freeContent3Btn, "user click third free episode");
		pause(2000);*/

	}

	@When("^user click skip close mark$")
	public void user_click_skip_close_mark() {
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(2000);
	}

	@Then("^user play another two free episodes$")
	public void user_play_another_two_free_episodes() {
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");

		visibilityofElementLocated(GuestUser.loadMoreBtn, "load more button displayed");
		click(GuestUser.loadMoreBtn, "user click load more button");
		pause(5000);
		visibilityofElementLocated(GuestUser.contentBtn, "episodes displayed");
		click(GuestUser.contentBtn, "user click one free episode");
		pause(5000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		visibilityofElementLocated(GuestUser.content2Btn, "episodes are displayed");
		click(GuestUser.content2Btn, "user click second free episode");
		pause(5000);
		/*scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		visibilityofElementLocated(GuestUser.content3Btn, "episodes are displayed");
		click(GuestUser.content3Btn, "user click third free episode");
		pause(5000);*/
	}

	@And("^user Observe Signin and signup page displayed$")
	public void user_Observe_Signin_and_signup_page_displayed() {

		String signIn = getElementText(GuestUser.popupSigin, "Sign IN page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("Sign In")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		pause(2000);
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(2000);
		back();
	}

	@When("^user playing two free music videos$")
	public void user_playing_two_free_music_videos() {
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		pause(2000);
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeSerial_Img, "free videos displayed");
		click(UnsubscribedUser.FreeSerial_Img, "user play 1st free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
		back();
		click(UnsubscribedUser.FreeSerial2_Img, "user play 2nd video");
		pause(1000);
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
		/*back();
		click(UnsubscribedUser.FreeSerial3_Img, "user play 3rd video");
		pause(1000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);*/
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(1000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeSerial4_Img, "user play 4th free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeSerial5_Img, "user play 5th video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
		/*back();
		pause(5000);
		click(UnsubscribedUser.FreeSerial6_Img, "user play 6th video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(3000);*/
	}

	@Then("^observe sigin page is displayed for playing third free video in music videos and user click skip mark$")
	public void observe_sigin_page_is_displayed_for_playing_third_free_video_in_music_videos_and_user_click_skip_mark() {
		String signIn = getElementText(GuestUser.popupSigin, "Sign IN page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("Sign In")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		pause(2000);
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(2000);
		back();
	}

	@When("^user playing two free comedy videos$")
	public void user_playing_two_free_comedy_videos() {
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(4000);
		visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img, " free videos displayed");
		click(UnsubscribedUser.FreeVideo_Img, "user play one free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo2_Img, "user play 2nd free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo3_Img, "user play 3rd free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo4_Img, "user play 4th free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo5_Img, "user play 5th free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(5000);
		back();
		pause(3000);
		visibilityofElementLocated(UnsubscribedUser.FreeVideo6_Img, " free videos displayed");
		click(UnsubscribedUser.FreeVideo6_Img, "user play 6th free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);

	}

	@Then("^sigin page is displayed for playing third free video in comedy videos and user click skip mark$")
	public void sigin_page_is_displayed_for_playing_third_free_video_in_comedy_videos_and_user_click_skip_mark() {
		String signIn = getElementText(GuestUser.popupSigin, "Sign IN page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("Sign In")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		pause(2000);
		visibilityofElementLocated(GuestUser.closePopupBtn, "SigIN popup window displayed");
		click(GuestUser.closePopupBtn, "user click close mark");
		pause(2000);
		
	}

	@Given("^user observe the unsubscrition login$")
	public void user_observe_the_unsubscrition_login() {
		pause(5000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");

		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered GuestUser");

		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered GuestPassword");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login");
		pause(4000);
	}

	@When("^play two free tv show episodes$")
	public void play_two_free_tv_show_episodes() {
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv show button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv show button");
		pause(2000);
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv show button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv show button");
		pause(3000);
		scrollWindow(4);
		pause(4000);
		moveToElement(GuestUser.freeContentBtn);
		moveToElement(GuestUser.freeContentBtn);
		visibilityofElementLocated(UnsubscribedUser.FreeSerial_Img, "free TV Serial displayed");
		click(UnsubscribedUser.FreeSerial_Img, "user click one free tv serial");
		visibilityofElementLocated(GuestUser.playBtn, "play button displayed");
		click(GuestUser.playBtn, "user click play button");
		pause(5000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		visibilityofElementLocated(UnsubscribedUser.Episode2_Link, "episodes displayed");
		click(UnsubscribedUser.Episode2_Link, "user click second free episode");
		pause(5000);
		/*scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		visibilityofElementLocated(UnsubscribedUser.Episode3_Link, "episodes  displayed");
		click(UnsubscribedUser.Episode3_Link, "user click third free episode");*/
	}

	@Then("^user observe subscription sigin page displayed$")
	public void user_observe_subscription_sigin_page_displayed() {
		pause(5000);
		String signIn = getElementText(GuestUser.subscriptionNow, "Subscribe Now page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("SUBSCRIBE NOW")) {
			System.out.println("Subscribe Now Page Verified Text Successfully");
		}
		pause(2000);
		back();
	}

	@When("^play two free comedy clips$")
	public void play_two_free_comedy_clips() {
		pause(2000);
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img, " free videos displayed");
		click(UnsubscribedUser.FreeVideo_Img, "user play one free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo2_Img, "user play 2nd free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);
		back();
		pause(2000);
		click(UnsubscribedUser.FreeVideo3_Img, "user play 3rd free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(2000);

	}

	@Then("^observe signin page is displayed for unsubscribed user$")
	public void observe_signin_page_is_displayed_for_unsubscribed_user() {
		pause(2000);
		String signIn = getElementText(GuestUser.subscriptionNow, "Subscribe Now page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("SUBSCRIBE NOW")) {
			System.out.println("Subscribe Now Page Verified Text Successfully");
		}
		pause(2000);
		
	}

	@When("^user click on signup button$")
	public void user_click_on_signup_button() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		visibilityOfElementLocated(Sigup.signUpBtn, " signup button displayed");
		click(Sigup.signUpBtn, "user click on sigup button");

	}

	@Then("^user enter email ID for sigup$")
	public void user_enter_email_ID_for_sigup() {
		inputText(Sigup.emailTxt, generateRandomEmail(), "Entered Email ID");

		inputText(Sigup.createPwdTxt, config.getTDValue("EmailIDPwdSigup"), "enter subscribed user password");
		inputText(Sigup.nameTxt, config.getTDValue("EmailIDNameSigUp"), "Entered create user Name");
		visibilityOfElementLocated(Sigup.ageDrpdn, "age drop down is displayed");
		click(Sigup.ageDrpdn, "user click age drop down");
		visibilityOfElementLocated(Sigup.selectAgeDrpdn, "age drop down items displayed");
		click(Sigup.selectAgeDrpdn, "user click  age range from drop down");
		pause(2000);
		click(Sigup.genderFemaleBtn, "user select gender button");
		visibilityOfElementLocated(Sigup.countryDrpdn, "country dropdown displayed");
		click(Sigup.countryDrpdn, "user click country drop down");
		visibilityOfElementLocated(Sigup.selectCountyDrpdn, "country drop down items displayed");
		click(Sigup.selectCountyDrpdn, "user select one country in drop down");
		visibilityOfElementLocated(Sigup.stateDrpdn, "state dropdown displayed");
		click(Sigup.stateDrpdn, "user click state drop down");
		visibilityOfElementLocated(Sigup.selectStateDrpdn, "state drop down items displayed");
		click(Sigup.selectStateDrpdn, "user select one state in drop down");
	}

	@Then("^user click on terms of use link$")
	public void user_click_on_terms_of_use_link() {
		visibilityOfElementLocated1(Sigup.termsLnk, " terms link displayed");
		click(Sigup.termsLnk, "user click on terms link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in terms of use");
		pause(3000);
		window(0);
		pause(3000);
		visibilityOfElementLocated1(Sigup.faqLnk, " FAQ link displayed");
		click(Sigup.faqLnk, "user click on FAQ link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in FAQ Link");
		window(0);
		visibilityOfElementLocated1(Sigup.cookieLnk, " cookie link displayed");
		click(Sigup.cookieLnk, "user click on cookie link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in Cookie policy");
		window(0);
		visibilityOfElementLocated1(Sigup.privacyLnk, " Privacy link displayed");
		click(Sigup.privacyLnk, "user click on Privacy link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in privacy policy");
		window(0);
		visibilityOfElementLocated1(Sigup.checkboxBtn, " Check Box displayed");
		clickOnElementUsingJS(Sigup.checkboxBtn, "user click on check box");

		visibilityOfElementLocated1(Sigup.submitBtn, " Submit button displayed");
		click(Sigup.submitBtn, "user click on Submit button");
		pause(8000);
		
	}

	@When("^user enter mobile Number for sigup$")
	public void user_enter_mobile_Number_for_sigup() {
		pause(2000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		visibilityOfElementLocated(Sigup.signUpBtn, " signup button displayed");
		click(Sigup.signUpBtn, "user click on sigup button");
		inputText(Sigup.emailTxt, config.getTDValue("MobileNumberSigUpNumber"), "Entered Mobile Number");
		inputText(Sigup.createPwdTxt, config.getTDValue("MobilNumberSigUpPwd"), "create user password");
		inputText(Sigup.nameTxt, config.getTDValue("MobileNumberSigUpName"), "Entered user Name");
		visibilityOfElementLocated(Sigup.ageDrpdn, "age drop down displayed");
		click(Sigup.ageDrpdn, "user click age drop down");
		visibilityOfElementLocated(Sigup.selectAgeDrpdn, "age drop down items displayed");
		click(Sigup.selectAgeDrpdn, "user select one age range");
		pause(1000);
		visibilityOfElementLocated(Sigup.genderFemaleBtn, "gender icons displayed");
		click(Sigup.genderFemaleBtn, "user click one gender icon");
		visibilityOfElementLocated(Sigup.countryDrpdn, "country dropdown displayed");
		click(Sigup.countryDrpdn, "user click country drop down");
		visibilityOfElementLocated(Sigup.selectCountyDrpdn, "country drop down items displayed");
		click(Sigup.selectCountyDrpdn, "user select one country in drop down");
		visibilityOfElementLocated(Sigup.stateDrpdn, "state dropdown displayed");
		click(Sigup.stateDrpdn, "user click state drop down");
		visibilityOfElementLocated(Sigup.selectStateDrpdn, "state drop down items displayed");
		click(Sigup.selectStateDrpdn, "user select one state in drop down");
	}

	@Then("^user click on mobile terms of use link$")
	public void user_click_on_mobile_terms_of_use_link() {
		visibilityOfElementLocated1(Sigup.termsLnk, " terms link displayed");
		click(Sigup.termsLnk, "user click on terms link");
		pause(3000);
		window(1);
		pause(3000);
		getDriver().getWindowHandle();

		scrollWindow(6, "swipe page in terms of use");
		pause(3000);
		window(0);
		pause(3000);
		getDriver().getWindowHandle();
		pause(3000);
		visibilityOfElementLocated1(Sigup.faqLnk, " FAQ link displayed");
		click(Sigup.faqLnk, "user click on FAQ link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in FAQ Link");
		window(0);
		visibilityOfElementLocated1(Sigup.cookieLnk, " cookie link displayed");
		click(Sigup.cookieLnk, "user click on cookie link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in Cookie policy");
		window(0);
		visibilityOfElementLocated1(Sigup.privacyLnk, " Privacy link displayed");
		click(Sigup.privacyLnk, "user click on Privacy link");
		pause(3000);
		window(1);
		scrollWindow(6, "swipe page in privacy policy");
		window(0);
		visibilityOfElementLocated1(Sigup.checkboxBtn, " Check Box displayed");
		clickOnElementUsingJS(Sigup.checkboxBtn, "user click on check box");
		visibilityOfElementLocated1(Sigup.submitBtn, " Submit button displayed");
		click(Sigup.submitBtn, "user click on Submit button");
		pause(5000);
		//
	}

	@When("^user click forgotpassword$")
	public void user_click_forgotpassword() {
		visibilityOfElementLocated(Login.profile, " profile button displayed");
		click(Login.profile, "User click on profile icon");
		visibilityOfElementLocated(Login.sigin, " login button displayed");
		click(Login.sigin, "user click on login button");
		visibilityOfElementLocated(ForgetPassword.ForgotPassword_Btn, "forgotpassword button displayed");
		click(ForgetPassword.ForgotPassword_Btn, "user click on forgotpassword button");
		pause(3000);
		window(1);
	}

	@Then("^user enter the mobile number in text box$")
	public void user_enter_the_mobile_number_in_text_box() {
		inputText(ForgetPassword.ForgetEmail_Txt, config.getTDValue("ForgotPhoneNumber"), "Entered Phone Number");
		visibilityOfElementLocated(ForgetPassword.SendRequest_Btn, "send request button displayed");
		click(ForgetPassword.SendRequest_Btn, "user click on send request button");
		pause(5000);
	}

	@And("^user observe OTP send succesfully to mobile$")
	public void user_observe_OTP_send_succesfully_to_mobile() {
		String otp = getElementText(ForgetPassword.ForgotOTP_Txt, "OTP Sent Successfully text is displayed");
		System.out.println(otp);
		if (otp.equalsIgnoreCase("OTP Sent Successfully")) {
			System.out.println("Sign IN Page Verified Text Successfully");
		}
		close();
		pause(3000);
		window(0);
		pause(3000);
	}

	@Then("^user enter the EmailID in text box$")
	public void user_enter_the_EmailID_in_text_box() {
		visibilityOfElementLocated(ForgetPassword.ForgotPassword_Btn, "forgotpassword button displayed");
		click(ForgetPassword.ForgotPassword_Btn, "user click on forgotpassword button");
		pause(3000);
		window(1);
		pause(3000);
		inputText(ForgetPassword.ForgetEmail_Txt, config.getTDValue("forgotemailid"), "user Entered Email ID");
		visibilityOfElementLocated(ForgetPassword.SendRequest_Btn, "send request button displayed");
		click(ForgetPassword.SendRequest_Btn, "user click on send request button");
	}

	@And("^user observe OTP send succesfully to Email$")
	public void user_observe_OTP_send_succesfully_to_Email() {
		String sendrequestlink = getElementText(ForgetPassword.ForgotLinkEmail_Txt,
				"Please check your mail for instructions. text is displayed");
		System.out.println(sendrequestlink);
		if (sendrequestlink.equalsIgnoreCase("Please check your mail for instructions.")) {
			System.out.println("send link to mail ID");
		}
		visibilityOfElementLocated(ForgetPassword.Ok_Btn, "ok button displayed");
		click(ForgetPassword.Ok_Btn, "user click on ok button");
		pause(3000);
		window(0);
		pause(3000);
		// 
	}

	@Then("^user observe the free content is playing in tv shows for subcribed user$")
	public void user_observe_the_free_content_is_playing_in_tv_shows_for_subcribed_user() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		pause(3000);

		inputText(Login.userNameTxt, config.getTDValue("UserID"), "Entered subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "Entered subscribed user password");

		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "user click on login button");
		pause(5000);
		/*
		 * visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		 * click(Favourite.Comedy_Btn, "user click on comedy button"); pause(2000);
		 * visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img,
		 * " free videos displayed"); click(UnsubscribedUser.FreeVideo_Img,
		 * "user click one free video");
		 * 
		 * visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn,
		 * " play button displayed"); click(ContinueWatching.MoviePlay_Btn,
		 * "user click play button"); pause(5000); back();
		 */
		// pause(2000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click view all tv shows button");
		pause(4000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		moveToElement(GuestUser.freeContentBtn);
		visibilityofElementLocated(GuestUser.freeContentBtn, "free content tvshow displayed");
		click(GuestUser.freeContentBtn, "user click free tv show");
		visibilityofElementLocated(GuestUser.playBtn, "play button displayed");
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
		back();
	}

	@When("^user observe the free content is playing in music videos for subcribed user$")
	public void user_observe_the_free_content_is_playing_in_music_videos_for_subcribed_user() {
		pause(2000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeSerial_Img, "free videos displayed");
		click(UnsubscribedUser.FreeSerial_Img, "user play 1st free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(5000);
		back();
		pause(2000);
	}

	@Then("^user observe the free content is playing in live tv for subcribed user$")
	public void user_observe_the_free_content_is_playing_in_live_tv_for_subcribed_user() {
		visibilityOfElementLocated(LiveTV.Livetv_Btn, "live TV button displayed");
		click(LiveTV.Livetv_Btn, "User click Live TV Button");
		pause(2000);
		scrollWindow(5);
		pause(3000);
		click(UnsubscribedUser.FreeSerial_Img, "User click free TV channel show");
		pause(4000);
		click(LiveTV.FreeChannel_Img, "User click and play channel");
		pause(6000);
		
	}

	@And("^user observe the free content is playing in comedy videos for subcribed user$")
	public void user_observe_the_free_content_is_playing_in_comedy_videos_for_subcribed_user() {
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(2000);
		// scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till
		// free Comedy episode displayed");
		scrollWindowforElementclickable(UnsubscribedUser.Freecomedy, 3, "scroll till free Comedy episode displayed");
		// scrollWindow(5);
		pause(5000);
		visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img, " free videos displayed");
		click(UnsubscribedUser.FreeVideo_Img, "user click one free video");

		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(5000);
		
	}

	@Then("^user observe the free content is playing in tv shows for unsubcribed user$")
	public void user_observe_the_free_content_is_playing_in_tv_shows_for_unsubcribed_user() {
		pause(3000);
		refresh();
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered unsubscribed user ID");
		pause(2000);
		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered unsubscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login");
		pause(2000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click view all tv shows button");
		pause(4000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		moveToElement(GuestUser.freeContentBtn);
		visibilityofElementLocated(GuestUser.freeContentBtn, "free content tvshow displayed");
		click(GuestUser.freeContentBtn, "user click free tv show");
		visibilityofElementLocated(GuestUser.playBtn, "play button displayed");
		click(GuestUser.playBtn, "user click play button");
		pause(3000);
		back();
	}

	@When("^user observe the free content is playing in music videos for unsubcribed user$")
	public void user_observe_the_free_content_is_playing_in_music_videos_for_unsubcribed_user() {
		pause(2000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeSerial_Img, "free videos displayed");
		click(UnsubscribedUser.FreeSerial_Img, "user play 1st free video");
		pause(2000);
		click(GuestUser.playBtn, "user click play button");
		pause(5000);
		back();
		pause(2000);
	}

	@Then("^user observe the free content is playing in live tv for unsubcribed user$")
	public void user_observe_the_free_content_is_playing_in_live_tv_for_unsubcribed_user() {
		visibilityOfElementLocated(LiveTV.Livetv_Btn, "live TV button displayed");
		click(LiveTV.Livetv_Btn, "User click Live TV Button");
		pause(2000);
		scrollWindow(5);
		pause(3000);
		click(UnsubscribedUser.FreeSerial_Img, "User click free TV channel show");
		// pause(1000);
		// click(LiveTV.FreeChannel_Img, "User click and play channel");
		// pause(6000);
		// back();
	}

	@And("^user observe the free content is playing in movie trailer for unsunubcribed user$")
	public void user_observe_the_free_content_is_playing_in_movie_trailer_for_unsunubcribed_user() {
		pause(2000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityofElementLocated(Favourite.Movie_Img, "list of movies displayed");
		click(Favourite.Movie_Img, "user click on one movie");
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(8000);
		
	}

	@And("^user observe the free content is playing in comedy videos for unsunubcribed user$")
	public void user_observe_the_free_content_is_playing_in_comedy_videos_for_unsunubcribed_user() {
		pause(5000);
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(2000);
		visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img, " free videos displayed");
		click(UnsubscribedUser.FreeVideo_Img, "user click one free video");

		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(5000);
		back();
		
	}

	@Then("^user select monthly subscription plan from given plan$")
	public void user_select_monthly_subscription_plan_from_given_plan() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered unsubscribed user ID");
		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered unsubscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login button");
		pause(5000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(SubscribePlan.selectmovie_btn, "movies displayed");
		clickOnElementUsingJS(SubscribePlan.selectmovie_btn, "user click movie");
		pause(3000);
		visibilityOfElementLocated(SubscribePlan.clickplay_btn, " play button displayed");
		//clickOnElementUsingJS(SubscribePlan.clickplay_btn, "user click play button");
		click(SubscribePlan.clickplay_btn, "user click play button");
		pause(3000);
		clickOnElementUsingJS(SubscribePlan.monthly_subscribe, "user click on 30 days subscription");
        //click(SubscribePlan.monthly_subscribe, "user click on 30 days subscription");
        pause(3000);
	}

	@Then("^user select payment mode through credit card$")
	public void user_select_payment_mode_through_credit_card() {
		visibilityOfElementLocated(SubscribePlan.credit_card, "display credit card");
		click(SubscribePlan.credit_card, "user select credit card");
		pause(3000);
		back();
	}

	@And("^user select payment mode through debit card$")
	public void user_select_payment_mode_through_debit_card() {
		pause(1000);
		visibilityOfElementLocated(SubscribePlan.debit_card, "display debit card button");
		click(SubscribePlan.debit_card, "user select debit card button");
		pause(3000);
		back();
	}

	@Then("^user select payment mode through paytm$")
	public void user_select_payment_mode_through_paytm() {
		pause(1000);
		visibilityOfElementLocated(SubscribePlan.paytm, "display paytm button");
		click(SubscribePlan.paytm, "user select paytm button");
		pause(3000);
		back();
		
	}

	@Given("^user click logout button$")
	public void user_click_logout_button() {
		pause(5000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered unsubscribed user ID");
		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered unsubscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login button");
		pause(3000);
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile image displayed");
		click(ProfileEdit.showUser_btn, "user click on profile image");
		pause(3000);
		visibilityOfElementLocated(Logout.logoutBtn, "logout button displayed");
		click(Logout.logoutBtn, "user click on logout button");
		pause(3000);
		
	}

	@When("^User enter forine login details$")
	public void User_enter_forine_login_details() {
		pause(5000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("internationaluserid"), "Entered international user ID");
		inputText(Login.passwordTxt, config.getTDValue("internationalIdPwd"), "Entered international user password");
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		pause(2000);
		click(Login.loginBtn, "User click on Login Button");
	}

	@Then("^user observe site login or not$")
	public void user_observe_site_login_or_not() {
		String Notallow = getElementText(Customer.UserNotAllow_Txt, "User Not Allowed In This Location is displayed");
		System.out.println(Notallow);
		if (Notallow.equalsIgnoreCase("User Not Allowed In This Location")) {
			System.out.println("User Not Allowed In This Location Text Successfully");
		}
		pause(5000);
		
	}

	@When("^User click on profile icon$")
	public void User_click_on_profile_icon() {
		pause(5000);
		click(Login.profile, "User click on profile icon");
		if (isWebElementNotPresent(Login.sigin)) {
			pause(3000);
			click(Logout.logoutBtn, "user logout by profile");
		} else {
			assertEquals(getElementText(Login.sigin, "Text Is"), "Sign In", "user verified Sign In button displayed");
			ExtTest.getTest().log(LogStatus.PASS,
					new HTMLReportUtil().passStringGreenColor("user verified Sign In button displayed"));
			pause(3000);
			click(Login.sigin, "User click on signin button");
		}
	}

	@And("^User Login to the Sunnxt portal$")
	public void sunNxtPortal() {
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "Entered subscribed user ID");
		inputText(Login.passwordTxt, config.getTDValue("Password"), "Entered subscribed user password");
		pause(2000);
	}

	@And("^Click on login button$")
	public void clickLogin() {
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		
	}

	@Given("^click movie button$")
	public void click_movie_button() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "Entered subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "Entered subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(4000);
		visibilityOfElementLocated(Movies.movieBtn, " movies button displayed");
		click(Movies.movieBtn, "user click on movies button");

		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");

	}

	@Then("^click genres button$")
	public void click_genres_button() {

		visibilityOfElementLocated(Movies.genresBtn, "genres button displayed");
		click(Movies.genresBtn, "user click on genres button");
		visibilityOfElementLocated(Movies.dramaBtn, "Actions button displayed");
		click(Movies.actionBtn, "user click on actions button");
		pause(3000);
		visibilityOfElementLocated(Movies.dramaApplyBtn, "apply button displayed");
		click(Movies.dramaApplyBtn, "user click on apply button");

	}

	@And("^click movie icon$")
	public void click_movie_icon() {

		visibilityOfElementLocated(Movies.selectMovieIcon, "selected category movies  displayed");
		click(Movies.selectMovieIcon, "user click select movie");
		visibilityOfElementLocated(Movies.selectMoviePlayBtn, "play button displayed");
		click(Movies.selectYearMoviePlayBtn, "user click play button");
		pause(8000);
		back();
		pause(2000);
	}

	@Then("^click actors button$")
	public void click_actors_button() {
		visibilityOfElementLocated(Movies.actorBtn, "actor button displayed");
		click(Movies.actorBtn, "user click on actor button");
		visibilityOfElementLocated(Movies.actorRahmanBtn, "actors categorys displayed");
		click(Movies.actorRahmanBtn, "user click one category button");
		pause(2000);
		visibilityOfElementLocated(Movies.rahmanApplyBtn, "apply button displayed");
		click(Movies.rahmanApplyBtn, "user click on apply button1");
	}

	@And("^click actors movie icon$")
	public void click_actors_movie_icon() {
		visibilityOfElementLocated(Movies.actorMovieIcon, "movies displayed");
		click(Movies.actorMovieIcon, "user click on  one movie");
		visibilityOfElementLocated(Movies.actorMoviePlayBtn, "play button displayed");
		click(Movies.actorMoviePlayBtn, "user click on play button");
		pause(8000);
		back();
	}

	@Then("^click year button$")
	public void click_year_button() {
		pause(3000);
		visibilityOfElementLocated(Movies.yearBtn, "year button displayed");
		click(Movies.yearBtn, "user click on year button");
		visibilityOfElementLocated(Movies.selectYearBtn, " years categorys displayed");
		click(Movies.selectYearBtn, "user click  one year button");
		pause(2000);
		visibilityOfElementLocated(Movies.selectYearApplyBtn, "select year apply button displayed");
		click(Movies.selectYearApplyBtn, "user click on year apply button");
	}

	@And("^click year movie icon$")
	public void click_year_movie_icon() {
		visibilityOfElementLocated(Movies.selectYearMovieBtn, "year movies displayed");
		click(Movies.selectYearMovieBtn, "click one movie");
		visibilityOfElementLocated(Movies.selectYearMoviePlayBtn, " play button displayed");
		click(Movies.selectYearMoviePlayBtn, "click on play button");
		pause(8000);
		back();
		
	}

	@Given("^user click profile image$")
	public void user_click_profile_image() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		pause(2000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "Entered subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "Entered subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(5000);
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile image displayed");
		click(ProfileEdit.showUser_btn, "user click profile image");
	}

	@When("^click profile button$")
	public void click_profile_button() {
		visibilityOfElementLocated(ProfileEdit.Profile_Btn, "profile button displayed");
		click(ProfileEdit.Profile_Btn, "user click profile button");
	}

	@Then("^click edit icon$")
	public void click_edit_icon() {

		click(ProfileEdit.Edit_icon, "user click on edit icon");
	}

	@And("^click edit complete button$")
	public void click_edit_complete_button() {
		click(ProfileEdit.EditComplete_Btn, "user click on edit complete button");
		visibilityOfElementLocated(ProfileEdit.FirstName_Txt, "FirstName text box displayed");
		inputText(ProfileEdit.FirstName_Txt, config.getTDValue("FirstName"), "Entered SigUp First Name");
		visibilityOfElementLocated(ProfileEdit.SecondName_Txt, "SecondName text box displayed");
		inputText(ProfileEdit.SecondName_Txt, config.getTDValue("SecondName"), "Entered SignUp Second Name");
		visibilityOfElementLocated(ProfileEdit.PhoneNo_Txt, "Phone Number text box displayed");
		inputText(ProfileEdit.PhoneNo_Txt, config.getTDValue("PhoneNumber"), "Entered Phone Number");
		visibilityOfElementLocated(ProfileEdit.Age_Drp, "age dropdown displayed");
		click(ProfileEdit.Age_Drp, "user click on age dropdown");
		visibilityOfElementLocated(ProfileEdit.AgeSelect_Btn, "age dropdown items displayed");
		click(ProfileEdit.AgeSelect_Btn, "user click one range in drop down");
		visibilityOfElementLocated(ProfileEdit.Gender_Btn, "genders images displayed");
		click(ProfileEdit.Gender_Btn, "user click one gender button");
		visibilityOfElementLocated(ProfileEdit.Country_Drp, "country dropdown displayed");
		click(ProfileEdit.Country_Drp, "user click country dropdown ");
		visibilityOfElementLocated(ProfileEdit.SelectCountry_btn, "country dropdown items  displayed");
		click(ProfileEdit.SelectCountry_btn, "user select one country in drop down");
		visibilityOfElementLocated(ProfileEdit.State_Drp, "state dropdown  displayed");
		click(ProfileEdit.State_Drp, "user click state dropdown");
		visibilityOfElementLocated(ProfileEdit.SelectState_Btn, "state drop down items  displayed");
		click(ProfileEdit.SelectState_Btn, "user select one state in drop down");
	}

	@And("^click done button$")
	public void click_done_button() {
		visibilityOfElementLocated(ProfileEdit.Done_Btn, "done button displayed");
		click(ProfileEdit.Done_Btn, "user click done button");
		pause(5000);
	}

	@Then("^user check changeing profile is updated or not in my info field$")
	public void user_check_changeing_profile_is_updated_or_not_in_my_info_field() {
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Login.myAccountBtn, "My account button displayed");
		click(Login.myAccountBtn, "user click my account button");
		visibilityOfElementLocated(Login.myInfoBtn, "My Info button displayed");
		click(Login.myInfoBtn, "user click my Info button");
		pause(2000);
		String customerName = getElementText(Login.customerNameTxt, "customer name is displayed");
		System.out.println(customerName);
		if (customerName.equalsIgnoreCase("sravan kumar")) {
			System.out.println("customer name changed profile name is same");
		}
		pause(2000);
		// 
	}

	@When("^user click on apply coupon button$")
	public void user_click_on_apply_coupon_button() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		pause(3000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "Entered subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "Entered subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(8000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(ApplyCoupon.ApplyCoupon_Btn, "Apply coupon code button displayed");
		click(ApplyCoupon.ApplyCoupon_Btn, "user click apply coupon code button");
		inputText(ApplyCoupon.Coupon_Txt, config.getTDValue("ApplyCouponCode"), "Entered coupon code number");
	}

	@Then("^user click on submit button$")
	public void user_click_on_submit_button() {
		pause(3000);
		visibilityOfElementLocated(ApplyCoupon.CouponSubmit_Btn, "submit button displayed");
		click(ApplyCoupon.CouponSubmit_Btn, "user click submit button");
		pause(3000);
		acceptAlert();
		pause(3000);
		
	}

	@Then("^user search one movie in searching field$")
	public void user_search_one_movie_in_searching_field() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(6000);
		visibilityofElementLocated(Searchmovie.search_Btn, " search icon displayed");
		click(Searchmovie.search_Btn, "user click on search icon");
		pause(3000);
		visibilityOfElementLocated(Searchmovie.searchmovie_Txt, "search box displayed");
		inputText(Searchmovie.searchmovie_Txt, config.getTDValue("SearchMovie"), "Entered searching movie name");
		pause(2000);
		pressEnter(Searchmovie.searchmovie_Txt);

		String movieText = getElementText(Searchmovie.SelectMovie_Btn, "searching movie name is displayed");
		System.out.println(movieText);
		if (movieText.equalsIgnoreCase("World Famous Lover")) {
			System.out.println("search movie text is displayed");
		}
		pause(2000);
		visibilityofElementLocated(Searchmovie.SelectMovie_Img, " searching movie is displayed");
		click(Searchmovie.SelectMovie_Img, "user click on searching movie");
		pause(2000);
		visibilityOfElementLocated(Movies.selectYearMoviePlayBtn, " play button displayed");
		click(Movies.selectYearMoviePlayBtn, "click on play button");
		pause(6000);
		back();
	}

	@Then("^user search movies by using actor name in searching field$")
	public void user_search_movies_by_using_actor_name_in_searching_field() {
		pause(3000);
		visibilityofElementLocated(Searchmovie.search_Btn, " search icon displayed");
		click(Searchmovie.search_Btn, "user click on search icon");
		visibilityOfElementLocated(Searchmovie.searchmovie_Txt, "search box displayed");
		inputText(Searchmovie.searchmovie_Txt, config.getTDValue("searchActor"), "Entered searching movie name");
		pause(2000);
		pressEnter(Searchmovie.searchmovie_Txt);
		pause(2000);
		visibilityofElementLocated(Searchmovie.ActorSelectMovie_Btn, "searching actor movies is displayed");
		click(Searchmovie.SelectMovie_Img, "user click one searching movie");
		visibilityOfElementLocated(Movies.selectYearMoviePlayBtn, " play button displayed");
		click(Movies.selectYearMoviePlayBtn, "click on play button");
		pause(6000);
		
	}

	@Given("^user click device button$")
	public void user_click_device_button() {
		click(Login.profile, "User click on profile icon");
		pause(5000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(5000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(5000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Devices.Devices_Btn, "device button displayed");
		click(Devices.Devices_Btn, "user click device button");
		if (isWebElementPresent(Devices.Deactivate_Btn)) {
			pause(3000);
			click(Devices.Deactivate_Btn, "User click on Deactivate button");
		} else {
			pause(2000);
			click(Devices.EnterCOde_Txt, "No devices connected");
		}
		inputText(Devices.EnterCOde_Txt, config.getTDValue("devicename"), "Entered device name");
		click(Devices.DeviceActivate, "user click Activate button");
		pause(5000);
		String deviceText = getElementText(Devices.DeviceMsg, "code is invalid message is displayed");
		System.out.println(deviceText);
		if (deviceText.equalsIgnoreCase("Cannot confirm access to account, entered auth code is not valid")) {
			System.out.println("code is invalid message is displayed");
		}
		
	}

	@Given("^user click swithprofile button$")
	public void user_click_swithprofile_button() {
		click(Login.profile, "User click on profile icon");
		pause(5000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");
		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(5000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(5000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(SwitchProfile.Switchprofile_Btn, " switch pofile button displayed");
		click(SwitchProfile.Switchprofile_Btn, "user click switch profile button");
	}

	@And("^user observe Add profile$")
	public void user_observe_Add_profile() {

		visibilityOfElementLocated(SwitchProfile.AddProfile_Btn, " add pofile button displayed");
		click(SwitchProfile.AddProfile_Btn, "user click add profile button");
		pause(5000);
		visibilityOfElementLocated(SwitchProfile.AddProfileSymbol_Img, " pofile images displayed");
		click(SwitchProfile.AddProfileSymbol_Img, "user select one profile image");
		pause(5000);
		inputText(SwitchProfile.AddProfileUserName_Txt, config.getTDValue("AddProfileName"),
				"user Entered create profile Name");
		visibilityOfElementLocated(SwitchProfile.AddProfileADD_Btn, " ADD button displayed");
		click(SwitchProfile.AddProfileADD_Btn, "user click ADD button");
		visibilityOfElementLocated(SwitchProfile.SwitchProfileEdit_Btn, "created profile edit image displayed");
		click(SwitchProfile.SwitchProfileEdit_Btn, "user click created profile edit image");
		pause(5000);
		visibilityOfElementLocated(SwitchProfile.SwitchAddProfileDone_Btn, "done  displayed");
		click(SwitchProfile.SwitchAddProfileDone_Btn, "user click done button");
	}

	@Then("^user switch previous profile$")
	public void user_switch_previous_profile() {
		pause(5000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");

		visibilityOfElementLocated(SwitchProfile.Switchprofile_Btn, "switch pofile button displayed");
		click(SwitchProfile.Switchprofile_Btn, "user click switchprofile button");
		pause(5000);
		visibilityOfElementLocated(SwitchProfile.BeforeSwith1_Icon, "create new pofiles displayed");
		click(SwitchProfile.BeforeSwith1_Icon, "user click new profile");
		visibilityOfElementLocated(SwitchProfile.Done_Btn, "done button displayed");
		click(SwitchProfile.Done_Btn, "user click done button");

	}

	@Then("^user observe delete profile$")
	public void user_observe_delete_profile() {
		pause(5000);
		visibilityOfElementLocated(ApplyCoupon.ShowUser1_Btn, "profile image displayed");
		click(ApplyCoupon.ShowUser1_Btn, "user click profile image");
		visibilityOfElementLocated(SwitchProfile.Switchprofile_Btn, "switch pofile button displayed");
		click(SwitchProfile.Switchprofile_Btn, "user click switchprofile button");
		pause(5000);
		visibilityOfElementLocated(SwitchProfile.AddProfileDelete_Btn, "create profile delete displayed");
		click(SwitchProfile.AddProfileDelete_Btn, "user click create profile delete button");
		pause(5000);
		visibilityOfElementLocated(SwitchProfile.AddProfileDeleteDone_Btn, "done displayed");
		click(SwitchProfile.AddProfileDeleteDone_Btn, "user click done button");
		pause(5000);
		
	}

	@Given("^user click subscription button$")
	public void user_click_subscription_button() {
		click(Login.profile, "User click on profile icon");
		pause(2000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Subscriptions.Subscription_Btn, "subscription button displayed");
		click(Subscriptions.Subscription_Btn, "user click subscription button");
		scrollingToElementofAPage(Subscriptions.Subscription_Footer, "scrolol page to the particular element");
	}

	@When("^user click invoice button$")
	public void user_click_invoice_button() {
		visibilityOfElementLocated(Subscriptions.Invoice_Btn, "invoice button displayed");
		click(Subscriptions.Invoice_Btn, "user click invoice button");
	}

	@Then("^user observe customer state$")
	public void user_observe_customer_state() {
		assertEquals(getElementText(Subscriptions.State_Txt, "Text Is"), "Telangana",
				"user verified state text displayed");
		pause(5000);
		// 
	}

	@And("^user verify the amount of customer$")
	public void user_verify_the_amount_of_customer() {
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll page till end ");
		pause(2000);
		String amount = getElementText(Subscriptions.Amount_Btn, "total amount is displayed");
		System.out.println(amount);
		if (amount.equalsIgnoreCase("50")) {
			System.out.println("total amount is displayed");
		}
		

	}

	@Given("^user click cancel subscription button$")
	public void user_click_cancel_subscription_button() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Subscriptions.Subscription_Btn, "subscription button displayed");
		click(Subscriptions.Subscription_Btn, "user click subscription button");
	/*	visibilityOfElementLocated(CancelSubscription.CancelSubscription_Btn, "cancel subscription button displayed");
		click(CancelSubscription.CancelSubscription_Btn, "user click cancel subscription button");*/

	}

	@When("^Verify Cancel Subscription confirmation popup$")
	public void Verify_Cancel_Subscription_confirmation_popup() {
		visibilityOfElementLocated(CancelSubscription.cancel_Btn, "cancel button displayed");
		click(CancelSubscription.cancel_Btn, "user click cancel button");
		pause(3000);
		
	}

	@Given("^user click TV Show button$")
	public void user_click_TV_Show_button() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
	}

	@Then("^user observe Load More operation$")
	public void user_observe_Load_More_operation() {
		visibilityofElementLocated(More.TvSerial_Img, "tv serials displayed");
		click(More.TvSerial_Img, "user click one tv serial");
		pause(3000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "serial play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(5000);
		scrollingToElementofAPage(Subscriptions.Subscription_Footer, "scrolol page till end of the page");

		pause(3000);
		highlightelementJS(GuestUser.loadMoreBtn, "highlight the clicked element botton");
		pause(2000);
		visibilityofElementLocated(GuestUser.loadMoreBtn, "load more button displayed");
		click(GuestUser.loadMoreBtn, "user click 1st time load more button");
		pause(2000);
		highlightelementJS(GuestUser.loadMoreBtn, "highlight the clicked element botton");
		pause(3000);
		visibilityofElementLocated(GuestUser.loadMoreBtn, "load more button displayed");
		click(GuestUser.loadMoreBtn, "user click 2nd time load more button");
		pause(3000);
		highlightelementJS(GuestUser.loadMoreBtn, "highlight the clicked element botton");
		pause(3000);
		visibilityofElementLocated(GuestUser.loadMoreBtn, "load more button displayed");
		click(GuestUser.loadMoreBtn, "user click 3rd time load more button");
		pause(3000);
		
	}

	@Given("^user Add Favourite Movie$")
	public void user_Add_Favourite_Movie() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityofElementLocated(Favourite.Movie_Img, "user observe list of movies displayed");
		click(Favourite.Movie_Img, "user click on one movie");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon is displayed");
		click(Favourite.Favourite_Btn, "add movie in favourite list");
		pause(1000);
		back();
		pause(1000);
		back();
		back();
	}

	@When("^user Add Favourite TV Show$")
	public void user_Add_Favourite_TV_Show() {
		pause(4000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		visibilityofElementLocated(Favourite.TVserial_Img, "tv serials displayed");
		click(Favourite.TVserial_Img, "user click on one serial");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon displayed");
		click(Favourite.Favourite_Btn, "add TV Show in favourite list");
		pause(1000);
		back();
		pause(1000);
		back();
		pause(1000);
		back();
	}

	@Then("^user Add Favourite MusicVideo$")
	public void user_Add_Favourite_MusicVideo() {
		pause(4000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		visibilityofElementLocated(Favourite.SelectMusicVideo_Img, "all movies displayed");
		click(Favourite.SelectMusicVideo_Img, "user click on one movie");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon displayed");
		click(Favourite.Favourite_Btn, "add music video in favourite list");
		pause(1000);
		back();
		pause(1000);
		back();
		pause(1000);
		back();
	}

	@And("^user Add Favourite Comedy$")
	public void user_Add_Favourite_Comedy() {
		pause(4000);
		visibilityofElementLocated(Favourite.Comedy_Btn, "comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		visibilityofElementLocated(Favourite.SelectComedyVideo_Btn, "list of comedy videos displayed");
		click(Favourite.SelectComedyVideo_Btn, "user click on one comedy video");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon displayed");
		click(Favourite.Favourite_Btn, "add Comedy clip in favourite list");
		pause(1000);
		back();
	}

	@Then("^user observe the add favourite content visible in profile page$")
	public void user_observe_the_add_favourite_content_visible_in_profile_page() {
		pause(3000);
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile image displayed");
		click(ProfileEdit.showUser_btn, "user click profile image");
		visibilityOfElementLocated(ProfileEdit.Profile_Btn, "profile button displayed");
		click(ProfileEdit.Profile_Btn, "user click profile button");
		pause(2000);
		scrollingToElementofAPage(Favourite.Favorite_Footer, "scrolol page till favourite footer");

		pause(2000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "visible all favourite contents");
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityofElementLocated(Favourite.Movie_Img, "user observe list of movies displayed");
		click(Favourite.Movie_Img, "user click on one movie");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon is displayed");
		click(Favourite.Favourite_Btn, "add movie in favourite list");
		pause(1000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		visibilityofElementLocated(Favourite.TVserial_Img, "tv serials displayed");
		click(Favourite.TVserial_Img, "user click on one serial");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon displayed");
		click(Favourite.Favourite_Btn, "add TV Show in favourite list");
		pause(1000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		visibilityofElementLocated(Favourite.SelectMusicVideo_Img, "all movies displayed");
		click(Favourite.SelectMusicVideo_Img, "user click on one movie");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon displayed");
		click(Favourite.Favourite_Btn, "add music video in favourite list");
		pause(1000);
		pause(4000);
		visibilityofElementLocated(Favourite.Comedy_Btn, "comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		visibilityofElementLocated(Favourite.SelectComedyVideo_Btn, "list of comedy videos displayed");
		click(Favourite.SelectComedyVideo_Btn, "user click on one comedy video");
		visibilityofElementLocated(Favourite.Favourite_Btn, "favourite icon displayed");
		click(Favourite.Favourite_Btn, "add Comedy clip in favourite list");
		pause(1000);
		
	}

	@When("^user observe movie shareing to facebook$")
	public void user_observe_movie_shareing_to_facebook() {
		click(Login.profile, "User click on profile icon");
		pause(2000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		scrollingToElementofAPage(SubscribeGuest.scrollwindow, "scrolol page to the particular element");
		visibilityofElementLocated(Share.ShareMovie_Img, "list of movies displayed");
		click(Share.ShareMovie_Img, "user click on one movie");
		visibilityofElementLocated(Share.Share_Btn, "share button displayed");
		click(Share.Share_Btn, "user click on share button");
		scrollingToElementofAPage(Share.Cancel_Btn, "scrolol down till end of the page");
		visibilityofElementLocated(Share.Facebook_Icon, "user observe facebook icon displayed");
		click(Share.Facebook_Icon, "user click on facebook icon");
		window(1);
		pause(2000);
		inputText(Share.FacebookUserName_Txt, config.getTDValue("sharefacebookid"), "Entered facebook userName");
		inputText(Share.FacebookPassword_Txt, config.getTDValue("ShareFacebookPassword"), "Entered facebook password");
		visibilityofElementLocated(Share.FacebookLogin_Btn, "facebook login displayed");
		pause(4000);
		click(Share.FacebookLogin_Btn, "user click on facebook login");
		pause(4000);
		window(0);
	}

	@Then("^user observe movie shareing to twitter$")
	public void user_observe_movie_shareing_to_twitter() {
		visibilityofElementLocated(Share.Share_Btn, "share button displayed");
		click(Share.Share_Btn, "user click on share button");
		scrollingToElementofAPage(Share.Cancel_Btn, "scroll down till end of the page");
		visibilityofElementLocated(Share.Twitter_Icon, "twitter icon displayed");
		click(Share.Twitter_Icon, "user click on twitter icon");
		pause(4000);
		window(1);
		pause(4000);
		inputText(Share.TwitterUserName_Txt, config.getTDValue("sharetwitterid"), "Entered twitter userName");
		inputText(Share.TwitterPassword_Txt, config.getTDValue("ShareTwitterPassword"), "Entered twitter password");
		pause(2000);
		visibilityofElementLocated(Share.TwitterLogin_Btn, "twitter login displayed");
		click(Share.TwitterLogin_Btn, "user click on twitter login");
		pause(2000);
		window(0);
		pause(1000);
		
	}

	@Then("^user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In homepage$")
	public void user_click_ABOUT_US_FAQS_PRIVACY_POLICY_TERMS_OF_USE_COOKIE_POLICIES_Links_In_homepage() {
		pause(2000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		pause(2000);
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");

		pause(3000);
		visibilityOfElementLocated(BottomLinks.TermsOfUse_Btn, "terms of Use link is displayed");
		click(BottomLinks.TermsOfUse_Btn, "User click on terms of Use Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.AboutUS_Btn, "About US link is displayed");
		click(BottomLinks.AboutUS_Btn, "User click on About US Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till end of page displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.FAQS_Btn, "FAQS link is displayed");
		click(BottomLinks.FAQS_Btn, "User click on FAQS Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.CookiesPolicy_Btn, "CookiesPolicy link is displayed");
		click(BottomLinks.CookiesPolicy_Btn, "User click on CookiesPolicy Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.privacyPolicy_Btn, "privacy Policy link is displayed");
		click(BottomLinks.privacyPolicy_Btn, "User click on privacy Policy_Btn Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
	}

	@And("^user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In movies$")
	public void user_click_ABOUT_US_FAQS_PRIVACY_POLICY_TERMS_OF_USE_COOKIE_POLICIES_Links_In_movies() {
		pause(3000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.TermsOfUse_Btn, "terms of Use link is displayed");
		click(BottomLinks.TermsOfUse_Btn, "User click on terms of Use Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(6000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.AboutUS_Btn, "About US link is displayed");
		click(BottomLinks.AboutUS_Btn, "User click on About US Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till end of page displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.FAQS_Btn, "FAQS link is displayed");
		click(BottomLinks.FAQS_Btn, "User click on FAQS Link in bottom header");
		pause(5000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.CookiesPolicy_Btn, "CookiesPolicy link is displayed");
		click(BottomLinks.CookiesPolicy_Btn, "User click on CookiesPolicy Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.privacyPolicy_Btn, "privacy Policy link is displayed");
		click(BottomLinks.privacyPolicy_Btn, "User click on privacy Policy_Btn Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
	}

	@When("^user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In TVShows$")
	public void user_click_ABOUT_US_FAQS_PRIVACY_POLICY_TERMS_OF_USE_COOKIE_POLICIES_Links_In_TVShows() {
		pause(4000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.TermsOfUse_Btn, "terms of Use link is displayed");
		click(BottomLinks.TermsOfUse_Btn, "User click on terms of Use Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.AboutUS_Btn, "About US link is displayed");
		click(BottomLinks.AboutUS_Btn, "User click on About US Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till end of page displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.FAQS_Btn, "FAQS link is displayed");
		click(BottomLinks.FAQS_Btn, "User click on FAQS Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.CookiesPolicy_Btn, "CookiesPolicy link is displayed");
		click(BottomLinks.CookiesPolicy_Btn, "User click on CookiesPolicy Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.privacyPolicy_Btn, "privacy Policy link is displayed");
		click(BottomLinks.privacyPolicy_Btn, "User click on privacy Policy_Btn Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
	}

	@Then("^user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In music videos$")
	public void user_click_ABOUT_US_FAQS_PRIVACY_POLICY_TERMS_OF_USE_COOKIE_POLICIES_Links_In_music_videos() {
		pause(4000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.TermsOfUse_Btn, "terms of Use link is displayed");
		click(BottomLinks.TermsOfUse_Btn, "User click on terms of Use Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.AboutUS_Btn, "About US link is displayed");
		click(BottomLinks.AboutUS_Btn, "User click on About US Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till end of page displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.FAQS_Btn, "FAQS link is displayed");
		click(BottomLinks.FAQS_Btn, "User click on FAQS Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");

		pause(3000);
		visibilityOfElementLocated(BottomLinks.CookiesPolicy_Btn, "CookiesPolicy link is displayed");
		click(BottomLinks.CookiesPolicy_Btn, "User click on CookiesPolicy Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.privacyPolicy_Btn, "privacy Policy link is displayed");
		click(BottomLinks.privacyPolicy_Btn, "User click on privacy Policy_Btn Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
	}

	@And("^user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In comedy$")
	public void user_click_ABOUT_US_FAQS_PRIVACY_POLICY_TERMS_OF_USE_COOKIE_POLICIES_Links_In_comedy() {
		pause(4000);
		visibilityofElementLocated(Favourite.Comedy_Btn, "comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.TermsOfUse_Btn, "terms of Use link is displayed");
		click(BottomLinks.TermsOfUse_Btn, "User click on terms of Use Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.AboutUS_Btn, "About US link is displayed");
		click(BottomLinks.AboutUS_Btn, "User click on About US Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till end of page displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.FAQS_Btn, "FAQS link is displayed");
		click(BottomLinks.FAQS_Btn, "User click on FAQS Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.CookiesPolicy_Btn, "CookiesPolicy link is displayed");
		click(BottomLinks.CookiesPolicy_Btn, "User click on CookiesPolicy Link in bottom header");
		pause(2000);
		scrollWindow(4);
		back();
		pause(3000);
		scrollingToElementofAPage(GuestUser.tvShowsPageScrollTillEndDrp, "scroll till free TV serial displayed");
		pause(3000);
		visibilityOfElementLocated(BottomLinks.privacyPolicy_Btn, "privacy Policy link is displayed");
		click(BottomLinks.privacyPolicy_Btn, "User click on privacy Policy_Btn Link in bottom header");
		pause(2000);
		scrollWindow(4);
		
	}

	@When("^user play one movie$")
	public void user_play_one_movie() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
	}

	@Then("^user go to home page and observe previous played movie is visible or not$")
	public void user_go_to_home_page_and_observe_previous_played_movie_is_visible_or_not() {
		visibilityOfElementLocated(ContinueWatching.Movie_Img, " all movies displayed");
		click(ContinueWatching.Movie_Img, "user click one  movie of the list");
		pause(5000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "play button displayed");
		click(GuestUser.playBtn, "user click play button");
		pause(8000);
		back();
	}

	@And("^user click previous played movies on continue watching video$")
	public void user_click_previous_played_movies_on_continue_watching_video() {
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile icon  displayed");
		click(ProfileEdit.showUser_btn, "user click on profile icon");
		visibilityOfElementLocated(ProfileEdit.Profile_Btn, "profile button displayed");
		click(ProfileEdit.Profile_Btn, "user click on profile button");
		pause(3000);
		scrollingToElementofAPage(ContinueWatching.ContinueWatching_Footer, "scrolol page to the particular element");

		pause(3000);
		visibilityOfElementLocated(ContinueWatching.Watchmovie_Img, " previous  played movie displayed");
		click(ContinueWatching.Watchmovie_Img, "user click previous played movie");
		pause(3000);
		refresh();
		pause(3000);
		/*visibilityOfElementLocated(ContinueWatching.WatchMoviePlay_Btn, "play button displayed");
		click(ContinueWatching.WatchMoviePlay_Btn, "user click play button");
		pause(8000);*/
		
	}

	@Then("^user observe the premium content playing for unsubscribed user in movie$")
	public void user_observe_the_premium_content_playing_for_unsubscribed_user_in_movie() {
		pause(3000);
		refresh();
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered unsubscribed user ID");
		pause(2000);

		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered unsubscribed user password");

		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login");
		pause(2000);
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityOfElementLocated(ContinueWatching.Movie_Img, " all movies displayed");
		click(ContinueWatching.Movie_Img, "user click one  movie of the list");
		pause(2000);
		/*
		 * visibilityofElementLocated(Favourite.Comedy_Btn, "comedy button displayed");
		 * click(Favourite.Comedy_Btn, "user click on comedy button");
		 * visibilityofElementLocated(UnsubscribedUser.PremiumMovie_Img,
		 * "movies displayed"); click(UnsubscribedUser.PremiumMovie_Img,
		 * "user click on one movie"); pause(4000);
		 */
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "movie play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "user click movie play button");
		pause(5000);
		String signIn = getElementText(GuestUser.subscriptionNow, "Subscribe Now page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("SUBSCRIBE NOW")) {
			System.out.println("Subscribe Now Page Verified Text Successfully");
		}
		pause(3000);
		back();
	}

	@When("^user observe the premium content playing for unsubscribed user in TVShows")
	public void user_observe_the_premium_content_playing_for_unsubscribed_user_in_TVShows() {
		pause(4000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		visibilityofElementLocated(Favourite.TVserial_Img, "tv serials displayed");
		click(Favourite.TVserial_Img, "user click on one serial");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(3000);
		String signIn = getElementText(GuestUser.subscriptionNow, "Subscribe Now page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("SUBSCRIBE NOW")) {
			System.out.println("Subscribe Now Page Verified Text Successfully");
		}
		pause(3000);
		back();
	}

	@Then("^user observe the premium content playing for unsubscribed user in comedy clip$")
	public void user_observe_the_premium_content_playing_for_unsubscribed_user_in_comedy_clip() {
		pause(2000);
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(3000);
		/*
		 * scrollingToElementofAPage(Premium.premiumComedyClip_Img,
		 * "scrolol page to the particular element"); pause(5000);
		 * scrollingToElementofAPage(Premium.premiumComedyFooter_Img,
		 * "scrolol page to the particular element"); pause(3000);
		 */
		click(Premium.PremiumContent_Img, "user click on premium comedy clip");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(3000);
		String signIn = getElementText(GuestUser.subscriptionNow, "Subscribe Now page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("SUBSCRIBE NOW")) {
			System.out.println("Subscribe Now Page Verified Text Successfully");
		}
		pause(3000);
		back();
	}

	@And("^user observe the premium content playing for unsubscribed user in music video$")
	public void user_observe_the_premium_content_playing_for_unsubscribed_user_in_music_video() {
		pause(4000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		visibilityofElementLocated(Premium.premiummusicvideo_Img, "all movies displayed");
		click(Premium.premiummusicvideo_Img, "user click on one music video");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(3000);
		String signIn = getElementText(GuestUser.subscriptionNow, "Subscribe Now page is displayed");
		System.out.println(signIn);
		if (signIn.equalsIgnoreCase("SUBSCRIBE NOW")) {
			System.out.println("Subscribe Now Page Verified Text Successfully");
		}
		
	}

	@Then("^user observe the premium content playing for subscribed user in movies$")
	public void user_observe_the_premium_content_playing_for_subscribed_user_in_movie() {
		pause(3000);
		refresh();
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "Entered unsubscribed user ID");
		pause(2000);

		inputText(Login.passwordTxt, config.getTDValue("Password"), "Entered unsubscribed user password");

		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login");
		pause(2000);
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityOfElementLocated(ContinueWatching.Movie_Img, " all movies displayed");
		click(ContinueWatching.Movie_Img, "user click one  movie of the list");
		pause(2000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "movie play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "user click movie play button");
		pause(5000);
		back();
	}

	@When("^user observe the premium content playing for subscribed user in TVShows")
	public void user_observe_the_premium_content_playing_for_subscribed_user_in_TVShows() {
		pause(4000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		visibilityofElementLocated(Favourite.TVserial_Img, "tv serials displayed");
		click(Favourite.TVserial_Img, "user click on one serial");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(3000);
		back();
	}

	@Then("^user observe the premium content playing for subscribed user in comedy clip$")
	public void user_observe_the_premium_content_playing_for_subscribed_user_in_comedy_clip() {
		pause(2000);
		visibilityofElementLocated(Favourite.Comedy_Btn, " comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(3000);
		// scrollingToElementofAPage(Premium.premiumComedyClip_Img, "scrolol page to the
		// particular element");
		// pause(5000);
		// scrollingToElementofAPage(Premium.premiumComedyFooter_Img, "scrolol page to
		// the particular element");
		// pause(3000);
		click(Premium.PremiumContent_Img, "user click on premium comedy clip");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(3000);
		back();
	}

	@And("^user observe the premium content playing for subscribed user in music video$")
	public void user_observe_the_premium_content_playing_for_subscribed_user_in_music_video() {
		pause(4000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		visibilityofElementLocated(Premium.premiummusicvideo_Img, "all movies displayed");
		click(Premium.premiummusicvideo_Img, "user click on one music video");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(3000);
		
	}

	@Then("^user play one video on continue watching section from home page$")
	public void user_play_one_video_on_continue_watching_section_from_home_page() {
		click(Login.profile, "User click on profile icon");
		pause(5000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);

		if (isWebElementPresent(ContinueWatching.ContinueWatching_Footer)) {
			pause(3000);
			visibilityOfElementLocated(ContinueWatching.continueMovie_Img, "continue watching section displayed");
			click(ContinueWatching.continueMovie_Img, "User click one movie on continue watching section");
			pause(8000);
			visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "movie play button displayed");
			click(ContinueWatching.MoviePlay_Btn, "User click play button");
			pause(8000);
			
		} else {
			isWebElementVisible(SubscribePlan.scrollpage1, "continue watching section is not displayed to user");
			pause(2000);
			
		}
	}

	@Then("^user play one movie in continue watching section from profile page$")
	public void user_play_one_movie_in_continue_watching_section_from_profile_page() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile icon displayed");
		pause(3000);
		click(ProfileEdit.showUser_btn, "user click on profile icon");
		pause(3000);
		visibilityOfElementLocated(ProfileEdit.Profile_Btn, "profile button displayed");
		pause(3000);
		click(ProfileEdit.Profile_Btn, "user click on profile button");
		pause(3000);
		scrollingToElementofAPage(ContinueWatching.ContinueWatching_Footer, "scrolol page to the particular element");
		pause(3000);
		visibilityOfElementLocated(ContinueWatching.Watchmovie_Img, " continue watched movies displayed");
		click(ContinueWatching.Watchmovie_Img, "user click one movie");
		pause(8000);
		
	}

	@Then("^user observe load more option in tvshows$")
	public void user_observe_load_more_option_in_tvshows() {
		click(Login.profile, "User click on profile icon");
		pause(2000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(3000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv show button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");

		visibilityofElementLocated(More.TVserial2_Img, "tv serials displayed");
		click(More.TVserial2_Img, "user click one tv serial");
		pause(3000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "movie play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(5000);
		scrollingToElementofAPage(Subscriptions.Subscription_Footer, "scrolol page to the particular element");
		pause(3000);
		highlightelementJS(GuestUser.loadMoreBtn, "highlight the required element botton");
		String loadmore = getElementText(GuestUser.loadMoreBtn, "load more button is displayed in TVShows");
		System.out.println(loadmore);
		if (loadmore.equalsIgnoreCase("load more")) {
			System.out.println("load more buton is displayed Successfully");
		}
		pause(5000);
		back();
	}

	@And("^user observe load more option in music albums$")
	public void user_observe_load_more_option_in_music_albums() {
		pause(4000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, "music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.SelectMusicVideo2_Img, "latest music albums displayed");
		click(Favourite.SelectMusicVideo2_Img, "user click one latest movie album");
		pause(3000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "movie play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(5000);
		scrollingToElementofAPage(Subscriptions.Subscription_Footer, "scrolol page to the particular element");
		pause(3000);
		highlightelementJS(GuestUser.loadMoreBtn, "highlight the required element botton");
		String loadmore = getElementText(GuestUser.loadMoreBtn, "load more button is displayed in music videos");
		System.out.println(loadmore);
		if (loadmore.equalsIgnoreCase("load more")) {
			System.out.println("load more buton is displayed Successfully");
		}
		pause(2000);
		
	}

	@When("^user play one movie in movies$")
	public void user_play_one_movie_in_movies() {
		pause(5000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityofElementLocated(Favourite.Movie_Img, "list of movies displayed");
		click(Favourite.Movie_Img, "user click on one movie");
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(8000);
		back();
	}

	@Then("^user play one tvshow in TVShows$")
	public void Then_user_play_one_tvshow_in_TVShows() {
		pause(2000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		visibilityofElementLocated(Favourite.TVserial_Img, "tv serials displayed");
		click(Favourite.TVserial_Img, "user click on one serial");
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(8000);
		back();
	}

	@And("^user play one video in music videos$")
	public void user_play_one_video_in_music_videos() {
		pause(2000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, "music videos button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all music videos button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all music videos button");
		visibilityofElementLocated(Favourite.SelectMusicVideo_Img, "all movies displayed");
		click(Favourite.SelectMusicVideo_Img, "user click on one movie");
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, "play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(8000);
		back();
	}

	@And("^user play one comedy movie in comedy$")
	public void user_play_one_comedy_movie_in_comedy() {
		pause(2000);
		visibilityofElementLocated(Favourite.Comedy_Btn, "comedy button displayed");
		click(Favourite.Comedy_Btn, "user click on comedy button");
		pause(3000);
		visibilityofElementLocated(Favourite.SelectComedyVideo_Btn, "list of comedy movies displayed");
		click(Favourite.SelectComedyVideo_Btn, "user click on one comedy movie");
		pause(2000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(8000);
		back();
	}

	@Then("^user play one comedy clip in comedy$")
	public void user_play_one_comedy_clip_in_comedy() {
		pause(2000);
		scrollWindow(4);
		pause(2000);
		// scrollingToElementofAPage(UnsubscribedUser.FreeVideo_Footer, "scroll page
		// till end ");
		visibilityofElementLocated(UnsubscribedUser.FreeVideo_Img, "comedy scenes video displayed");
		click(UnsubscribedUser.FreeVideo_Img, "user click one comedy scenes video");
		pause(5000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "User click play button");
		pause(8000);
		
	}

	@When("^user observe account section options in subscribed user$")
	public void user_observe_account_section_options_in_subscribed_user() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		pause(1000);
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");
		pause(1000);
		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Login.myAccountBtn, "My account button displayed");
		click(Login.myAccountBtn, "user click my account button");
		visibilityOfElementLocated(Login.myAccountMySubBtn, "My subscriptions displayed");
		click(Login.myAccountMySubBtn, "user click my subscriptions button");

		String PackageName = getElementText(Login.myAccountPackageNameBtn, "package Name is displayed");
		System.out.println(PackageName);
		if (PackageName.equalsIgnoreCase("Monthly Subscription Plan (With Ads)")) {
			System.out.println("package Name is visible");
		}
		pause(2000);
		back();
		pause(2000);
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile image displayed");
		click(ProfileEdit.showUser_btn, "user click on profile image");
		visibilityOfElementLocated(Logout.logoutBtn, "logout button displayed");
		click(Logout.logoutBtn, "user click on logout button");
	}

	@Then("^user observe account section options in unsubscribed user$")
	public void user_observe_account_section_options_in_unsubscribed_user() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered unsubscribed user ID");
		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered unsubscribed user password");

		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "signin button displayed");
		click(Login.loginBtn, "click on signin button");
		pause(2000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Login.myAccountBtn, "My account button displayed");
		click(Login.myAccountBtn, "user click my account button");
		visibilityOfElementLocated(Login.myAccountMySubBtn, "My subscriptions displayed");
		click(Login.myAccountMySubBtn, "user click my subscriptions button");
		String PackageName = getElementText(Login.myAccountPackageName1Btn, "package Name is displayed");
		System.out.println(PackageName);
		if (PackageName.equalsIgnoreCase(" No Subscriptions")) {
			System.out.println("package Name is visible");
		}
		pause(3000);
		back();
		pause(2000);
		visibilityOfElementLocated(ProfileEdit.showUser_btn, "profile image displayed");
		click(ProfileEdit.showUser_btn, "user click on profile image");
		visibilityOfElementLocated(Logout.logoutBtn, "logout button displayed");
		click(Logout.logoutBtn, "user click on logout button");
	}

	@And("^user observe account section options in sun direct user$")
	public void user_observe_account_section_options_in_sun_direct_user() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("sunDirectUser"), "Entered Sun Direct User ID");
		inputText(Login.passwordTxt, config.getTDValue("SunDirectPwd"), "Entered Sun Direct User Password");

		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login button displayed");
		click(Login.loginBtn, "click on login button");
		pause(5000);
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Login.myAccountBtn, "My account button displayed");
		click(Login.myAccountBtn, "user click my account button");
		visibilityOfElementLocated(Login.myAccountMySubBtn, "My subscriptions displayed");
		click(Login.myAccountMySubBtn, "user click my subscriptions button");
		String PackageName = getElementText(Login.myAccountPackageNameBtn, "package Name is displayed");
		System.out.println(PackageName);
		if (PackageName.equalsIgnoreCase("SUN_DIRECT")) {
			System.out.println("package Name is visible");
		}
		pause(2000);
		
	}

	@Then("^user choose one movie and play that movie in movies$")
	public void user_choose_one_movie_and_play_that_movie_in_movies() {
		pause(2000);
		click(Login.profile, "User click on profile icon");
		pause(2000);
		click(Login.sigin, "User click on signin button");
		pause(2000);
		inputText(Login.userNameTxt, config.getTDValue("GuestUser"), "Entered unsubscribed user ID");
		pause(2000);
		inputText(Login.passwordTxt, config.getTDValue("GuestPassword"), "Entered unsubscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
	}

	@And("^user apply promo code in SigIn page$")
	public void user_apply_promo_code_in_SigIn_page() {
		visibilityOfElementLocated(Movies.movieSelect4Img, " all movies displayed");
		click(Movies.movieSelect4Img, "user click one movie for the list");
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		visibilityOfElementLocated(Movies.siginCouponCodeBtn, " coupon code button displayed");
		click(Movies.siginCouponCodeBtn, "user click coupon code button");
		inputText(ApplyCoupon.Coupon_Txt, config.getTDValue("ApplyCouponCode"), "Entered coupon code");
		pause(3000);
		visibilityOfElementLocated(ApplyCoupon.CouponSubmit_Btn, " submit button displayed");
		click(ApplyCoupon.CouponSubmit_Btn, "user click  submit button");
		pause(3000);
		acceptAlert();
		pause(3000);
		
	}

	@Then("^user play one HD movie in movies$")
	public void user_play_one_HD_movie_in_movies() {
		click(Login.profile, "User click on profile icon");
		pause(2000);
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(3000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(4000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		pause(2000);
		visibilityOfElementLocated(HDAndSD.HDSelectMovie_Img, "HD movies displayed");
		click(HDAndSD.HDSelectMovie_Img, "user click one movie in HD");
		pause(2000);
		visibilityOfElementLocated(ContinueWatching.MoviePlay_Btn, " play button displayed");
		click(ContinueWatching.MoviePlay_Btn, "user click play button");
		pause(8000);
		back();
	}

	@And("^user play one SD movie in movies$")
	public void user_play_one_SD_movie_in_movies() {
		pause(3000);
		visibilityofElementLocated(Searchmovie.search_Btn, " search icon displayed");
		click(Searchmovie.search_Btn, "user click on search icon");
		visibilityOfElementLocated(Searchmovie.searchmovie_Txt, "search box displayed");
		inputText(Searchmovie.searchmovie_Txt, config.getTDValue("SDMovie"), "Entered SD movie name");
		pause(2000);
		pressEnter(Searchmovie.searchmovie_Txt);
		pause(2000);
		visibilityofElementLocated(HDAndSD.SDMovie_Btn, "searching SD movies is displayed");
		click(HDAndSD.SDMovie_Btn, "user click searching SD movie");
		visibilityOfElementLocated(Movies.selectYearMoviePlayBtn, " play button displayed");
		click(Movies.selectYearMoviePlayBtn, "click on play button");
		pause(6000);
		
	}

	@When("^user click TVShows button$")
	public void user_click_TVShows_button() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
	}

	@Then("^user click geners button in TVShows and select one category and play one content$")
	public void user_click_geners_button_in_TVShows_and_select_one_category_and_play_one_content() {
		pause(2000);
		visibilityofElementLocated(GuestUser.tvShowsBtn, "tv shows button displayed");
		click(GuestUser.tvShowsBtn, "user click on tv shows button");
		visibilityofElementLocated(GuestUser.viewAllTVShowsBtn, "view all tv shows button displayed");
		click(GuestUser.viewAllTVShowsBtn, "user click on view all tv shows button");
		visibilityOfElementLocated(Movies.genresBtn, "genres button displayed");
		click(Movies.genresBtn, "user click on genres button");
		visibilityOfElementLocated(Movies.dramaBtn, "categories are displayed");
		click(Movies.dramaBtn, "user click one category");
		pause(2000);
		visibilityOfElementLocated(Movies.dramaApplyBtn, "apply button displayed");
		click(Movies.dramaApplyBtn, "user click on apply button");
		visibilityOfElementLocated(Movies.selectMovieIcon, "selected category Tvshows displayed");
		click(Movies.selectMovieIcon, "user click one TVshow");
		visibilityOfElementLocated(Movies.selectMoviePlayBtn, "play button displayed");
		click(Movies.selectYearMoviePlayBtn, "user click play button");
		pause(6000);
		/*click(ContinueWatching.Screen_Img, "user click on screen for playing video");
		pause(5000);*/
		back();
	}

	@And("^user click TVchannels button in TVShows and selectt one category and play one content$")
	public void user_click_TVchannels_button_in_TVShows_and_selectt_one_category_and_play_one_content() {
		pause(3000);
		visibilityOfElementLocated(Movies.actorBtn, "TVChannels button displayed");
		click(Movies.actorBtn, "user click TVChannels button");
		visibilityOfElementLocated(TVShows.TVselectCategory_Btn, "observe categorys displayed");
		click(TVShows.TVselectCategory_Btn, "user click one category");
		pause(3000);
		visibilityOfElementLocated(TVShows.TVChannelsApply_Btn, "TVChannels apply button displayed");
		click(TVShows.TVChannelsApply_Btn, "user click apply button");
		visibilityOfElementLocated(Movies.actorMovieIcon, "selected TVChannels category displayed");
		click(Movies.actorMovieIcon, "user click on one TVShows");
		visibilityOfElementLocated(Movies.actorMoviePlayBtn, "TVShow play button displayed");
		click(Movies.actorMoviePlayBtn, "user click play button");
		pause(6000);
		/*click(ContinueWatching.Screen_Img, "user click on screen for playing video");
		pause(5000);*/
		back();
	}

	@Then("^user click year button in TVShows and select one category and play one content$")
	public void user_click_year_button_in_TVShows_and_select_one_category_and_play_one_content() {
		pause(3000);
		visibilityOfElementLocated(Movies.yearBtn, "year button displayed");
		click(Movies.yearBtn, "user click on year button");
		visibilityOfElementLocated(TVShows.TVYearsSelect_Btn, "years categorys displayed");
		click(TVShows.TVYearsSelect_Btn, "user click  one year radio-button");
		pause(3000);
		visibilityOfElementLocated(Movies.selectYearApplyBtn, "select year apply button displayed");
		click(Movies.selectYearApplyBtn, "user click apply button");
		visibilityOfElementLocated(SubscribeGuest.SubscriptionMovie1_Btn, "observe Tv Serial displayed");
		click(SubscribeGuest.SubscriptionMovie1_Btn, "user click one TV serial");
		visibilityOfElementLocated(Movies.actorMoviePlayBtn, "TVShow play button displayed");
		click(Movies.actorMoviePlayBtn, "user click play button");
		pause(6000);
		/*click(ContinueWatching.Screen_Img, "user click on screen for playing video");
		pause(5000);*/
		
	}

	@When("^user click music videos$")
	public void user_click_music_videos() {
		pause(3000);
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
	}

	@Then("^user click music button in music videos and select one category and play one content$")
	public void user_click_music_button_in_music_videos_and_select_one_category_and_play_one_content() {
		pause(2000);
		visibilityofElementLocated(Favourite.MusicVideos_Btn, " music videos  button displayed");
		click(Favourite.MusicVideos_Btn, "user click on music videos button");
		visibilityofElementLocated(Favourite.AllMusicVideos_Btn, "all songs button displayed");
		click(Favourite.AllMusicVideos_Btn, "user click on all songs button");
		visibilityOfElementLocated(Movies.selectMovieIcon, "selected category songs displayed");
		click(Movies.selectMovieIcon, "user click one song");
		visibilityOfElementLocated(Movies.selectMoviePlayBtn, "play button displayed");
		click(Movies.selectYearMoviePlayBtn, "user click play button");
		pause(8000);
		back();
	}

	@And("^user click musicians button in music videos and select one category and play one content$")
	public void user_click_musicians_button_in_music_videos_and_select_one_category_and_play_one_content() {
		pause(3000);
		visibilityOfElementLocated(Movies.actorBtn, "musicians button displayed");
		click(Movies.actorBtn, "user click musician button");
		visibilityOfElementLocated(MusicVideos.MusicianSelectCategory_Btn, "musicians categorys displayed");
		click(MusicVideos.MusicianSelectCategory_Btn, "user click one musician category radio button");
		pause(3000);
		visibilityOfElementLocated(MusicVideos.MusicianSelectApply_Btn, "apply displayed");
		click(MusicVideos.MusicianSelectApply_Btn, "user click apply button");

		visibilityOfElementLocated(SubscribeGuest.SubscriptionMovie1_Btn, "selected category songs displayed");
		click(SubscribeGuest.SubscriptionMovie1_Btn, "user click one song button");
		visibilityOfElementLocated(Movies.selectMoviePlayBtn, "play button displayed");
		click(Movies.selectYearMoviePlayBtn, "user click play button");
		//click(Movies.selectYearMoviePlayBtn, "user click play button");
		pause(8000);
		
	}

	@Given("^user click movies button and select one movie and play that movie$")
	public void user_click_movies_button_and_select_one_movie_and_play_that_movie() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(4000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityofElementLocated(Favourite.Movie_Img, "list of movies displayed");
		click(Favourite.Movie_Img, "user click on one movie");
		visibilityOfElementLocated(ContinueWatching.playbtn, "play button displayed");
		click(ContinueWatching.playbtn, "User click play button");
		pause(5000);
		/*
		 * visibilityOfElementLocated(ContinueWatching.MoviePause_Btn,
		 * "pause button displayed"); click(ContinueWatching.MoviePause_Btn,
		 * "user click pause button");
		 */
		visibilityOfElementLocated(ContinueWatching.playbtn, "play button displayed");
		click(ContinueWatching.playbtn, "User click play button");
	}

	@When("^user extend the screen$")
	public void user_extend_the_screen() {
		visibilityOfElementLocated(ContinueWatching.Screen_Img, "screen is displayed");
		click(ContinueWatching.Screen_Img, "user click on screen");
		pause(3000);
		highlightelementJS(ContinueWatching.ScreenExtend_Img, "highlight the clicked element button");
		visibilityOfElementLocated(ContinueWatching.ScreenExtend_Img, "screen extend image displayed");
		click(ContinueWatching.ScreenExtend_Img, "user click screen extend image");
		pause(3000);
		click(ContinueWatching.ScreenExtend_Img, "user click 2nd time screen extend image");
		pause(3000);
	}

	@Then("^user click play and pause button in screen$")
	public void user_click_play_and_pause_button_in_screen() {
		// visibilityOfElementLocated(ContinueWatching.Screen_Img, "play
		// button is displayed on screen");
		// click(ContinueWatching.Screen_Img, "user click on screen");
		// pause(3000);
		// pause(3000);
		// highlightelementJS(ContinueWatching.ScreenPlay_Img, "highlight
		// the clicked element botton");
		// visibilityOfElementLocated(ContinueWatching.ScreenPlay_Img, "play
		// button is displayed on screen");
		// click(ContinueWatching.ScreenPlay_Img, "user click play button
		// on screen");
		// pause(3000);
		// highlightelementJS(ContinueWatching.ScreenPlay_Img, "highlight
		// the clicked element botton");
		// visibilityOfElementLocated(ContinueWatching.ScreenPlay_Img,
		// "pause button is displayed on screen");
		// click(ContinueWatching.ScreenPlay_Img, "user click pause button
		// on screen");
	}

	@And("^user click 10sec forward and 10sec backward button$")
	public void user_click_10sec_forward_and_10sec_backward_button() {
		highlightelementJS(ContinueWatching.ScreenForward_Img, "highlight the clicked element botton");
		visibilityOfElementLocated(ContinueWatching.ScreenForward_Img, "10sec forward button is  displayed on screen");
		click(ContinueWatching.ScreenForward_Img, "user click 10sec forward button on screen");
		click(ContinueWatching.ScreenForward_Img, "user click 2nd time 10sec forward button on screen");
		pause(5000);
		click(ContinueWatching.Screen_Img, "user play video");
		pause(4000);
		click(ContinueWatching.Screen_Img, "user pause video");
		highlightelementJS(ContinueWatching.ScreenBackward_Img, "highlight the clicked element botton");
		visibilityOfElementLocated(ContinueWatching.ScreenBackward_Img,
				"10sec backward button is  displayed on screen");
		click(ContinueWatching.ScreenBackward_Img, "user click 10sec backward button on screen");
		click(ContinueWatching.ScreenBackward_Img, "user click 2nd time 10sec backward button on screen");
		pause(5000);
		click(ContinueWatching.Screen_Img, "user play video");
		pause(4000);
		click(ContinueWatching.Screen_Img, "user pause video");
	}

	@Then("^user click setting button and select the quality of movie$")
	public void user_click_setting_button_and_select_the_quality_of_movie() {
		highlightelementJS(ContinueWatching.ScreenSetting_Img, "highlight the clicked element botton");
		pause(1000);
		visibilityOfElementLocated(ContinueWatching.ScreenSetting_Img, "settings button displayed on screen");
		click(ContinueWatching.ScreenSetting_Img, "user click settings button on screen");
		click(ContinueWatching.ScreenSettingQuality_Img, "user click low quality button on screen");
		pause(3000);
		
	}

	@Then("^user can give rateing to that played movie and click submit button$")
	public void user_can_give_rateing_to_that_played_movie_and_click_submit_button() {
		pause(3000);
		click(Login.profile, "User click on profile icon");

		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(4000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityOfElementLocated(Movies.movieBtn, "movies button displayed");
		click(Movies.movieBtn, "user click on movies button");
		visibilityOfElementLocated(Movies.viewAllMovieBtn, "view all movies button displayed");
		click(Movies.viewAllMovieBtn, "user click on view all movies button");
		visibilityofElementLocated(Favourite.Movie2_Img, "list of movies displayed");
		click(Favourite.Movie2_Img, "user click on one movie");
		scrollingToElementofAPage(ContinueWatching.ScreenPlay_Img, "scroll the page till [articular element ");
		pause(4000);
		visibilityOfElementLocated(ContinueWatching.StarRateing_Img, "rateing star images displayed");
		click(ContinueWatching.StarRateing_Img, "user click one star rateing image");
		visibilityOfElementLocated(ContinueWatching.RateingSubmit_Btn, "submit button displayed");
		click(ContinueWatching.RateingSubmit_Btn, "user click submit button");
		pause(2000);
		refresh();
		visibilityOfElementLocated(ContinueWatching.StarRateing_Img, "rateing star images displayed");
		click(ContinueWatching.StarRateing_Img, "user edit previously rateing and user click one star rateing image");
		visibilityOfElementLocated(ContinueWatching.RateingSubmit_Btn, "submit button displayed");
		click(ContinueWatching.RateingSubmit_Btn, "user click submit button");
		pause(4000);
		

	}

	
	@When("^user play one movie and stop the subtitles$")
	public void user_play_one_movie_and_stop_the_subtitles() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(2000);
		visibilityofElementLocated(Searchmovie.search_Btn, " search icon displayed");
		click(Searchmovie.search_Btn, "user click on search icon");
		visibilityOfElementLocated(Searchmovie.searchmovie_Txt, "search box displayed");
		inputText(Searchmovie.searchmovie_Txt, config.getTDValue("SubtitlesMovie"), "Entered movie name");
		pause(1000);
		pressEnter(Searchmovie.searchmovie_Txt);
		pause(2000);
		visibilityofElementLocated(Searchmovie.SelectMovie_Img, " movie is displayed");
		click(Searchmovie.SelectMovie_Img, "user click on movie");
		pause(2000);
		visibilityOfElementLocated(Movies.playbtn, "play button displayed");
		click(Movies.playbtn, "click on play button");
		pause(6000);
		click(Movies.playbtn, "click on play button");
		pause(6000);
		click(Subtitles.Subtitles_Img, "click subtitles image");
		visibilityOfElementLocated(Subtitles.OffSubtitles_Img, "off subtitles displayed");
		click(Subtitles.OffSubtitles_Img, "click off subtitles button");
		pause(2000);
		visibilityOfElementLocated(Movies.playbtn, "play button displayed");
		click(Movies.playbtn, "click on play button");

	}

	@Then("^user on subtitles for that movie$")
	public void user_on_subtitles_for_that_movie() {
		pause(2000);
		click(Movies.playbtn, "click on play button");
		pause(4000);
		click(Subtitles.Subtitles_Img, "click subtitles image");
		visibilityOfElementLocated(Subtitles.OnSubtitles_Img, "off subtitles displayed");
		click(Subtitles.OnSubtitles_Img, "click off subtitles button");
		pause(2000);
		visibilityOfElementLocated(Movies.playbtn, "play button displayed");
		click(Movies.playbtn, "click on play button");
		pause(4000);
		
	}

	@Then("^user click my info button and observe the details of customer$")
	public void user_click_my_info_button_and_observe_the_details_of_customer() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Login.myAccountBtn, "My account button displayed");
		click(Login.myAccountBtn, "user click my account button");
		visibilityOfElementLocated(Login.myInfoBtn, "My Info button displayed");
		click(Login.myInfoBtn, "user click my Info button");
		
	}

	@Then("^user click clear my history button and clear the watch list$")
	public void user_click_clear_my_history_button_and_clear_the_watch_list() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		visibilityOfElementLocated(ApplyCoupon.showuser_Btn, "profile image displayed");
		click(ApplyCoupon.showuser_Btn, "user click profile image");
		visibilityOfElementLocated(Login.myAccountBtn, "My account button displayed");
		click(Login.myAccountBtn, "user click my account button");

		if (isWebElementPresent(Login.clearMyHistoryBtn)) {
			pause(3000);
			click(Login.clearMyHistoryBtn, "clear my history button displayed");
			visibilityOfElementLocated(Login.clearMyHistoryBtn, "clear my history button displayed");
			click(Login.clearMyHistoryBtn, "user click clear my history button");
			visibilityOfElementLocated(Login.clearMyHistoryOkBtn, "clear my history button OK displayed");
			click(Login.clearMyHistoryOkBtn, "user click clear my history OK button");
			pause(2000);
			
		} else {
			pause(2000);
			
		}
	}

	@When("^user click telugu language button and select one channel$")
	public void user_click_telugu_language_button_and_select_one_channel() {
		click(Login.profile, "User click on profile icon");
		click(Login.sigin, "User click on signin button");
		inputText(Login.userNameTxt, config.getTDValue("UserID"), "enter subscribed user ID");

		inputText(Login.passwordTxt, config.getTDValue("Password"), "enter subscribed user password");
		pause(2000);
		visibilityOfElementLocated(Login.loginBtn, "login  button displayed");
		click(Login.loginBtn, "User click on Login Button");
		pause(5000);
		visibilityOfElementLocated(LiveTV.Livetv_Btn, "live TV button displayed");
		click(LiveTV.Livetv_Btn, "User click Live TV Button");
		scrollingToElementofAPage(LiveTV.Schedule_Footer, "user scroll the screen particular element");
		click(LiveTV.TeluguLanguage_Btn, "User click telugu language Button");
		pause(1000);
		click(LiveTV.SelectTeluguChannel1_Img, "User click and play one channel in telugu language");
		pause(6000);
		scrollingToElementofAPage(LiveTV.Schedule_Footer, "user scroll the screen particular element");
		pause(1000);
		click(LiveTV.SelectTeluguChannel2_Img, "User click and play second channel in telugu language");
		pause(6000);
	}

	@Then("^user click kannada language button and select one channel$")
	public void user_click_kannada_language_button_and_select_one_channel() {
		scrollingToElementofAPage(LiveTV.Schedule_Footer, "user scroll the screen particular element");
		click(LiveTV.KannadaLanguage_Btn, "User click malayalam language Button");
		pause(1000);
		click(LiveTV.SelectTeluguChannel1_Img, "User click and play one channel in malayalam language");
		pause(6000);
		scrollingToElementofAPage(LiveTV.Schedule_Footer, "user scroll the screen particular element");
		click(LiveTV.SelectTeluguChannel2_Img, "User click and play second channel in malayalam language");
		pause(8000);
		
	}
}
