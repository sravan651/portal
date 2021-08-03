
package locators;

import org.openqa.selenium.By;

public interface SunNxtObjects {
	public interface GuestUser {

		public By tvShowsBtn = By.xpath("//a[text()='TV SHOWS']");
		public By viewAllTVShowsBtn = By.xpath("//*[@href='/tv/inside/']");
		
		public By freeContentBtn = By.xpath("(//*[@class='freemium'])[1]");
		public By FreeContentBtn = By.xpath("(//*[@class='freemium'])");
		public By playBtn = By.xpath("//*[@class='movie_details-btn-div']/child::button");
		public By freeContent2Btn = By.xpath("(//*[@class='col-md-8 col-xs-7 episode_name'])[5]");
		public By freeContent3Btn = By.xpath("(//*[@class='col-md-8 col-xs-7 episode_name'])[4]");
		public By tvShowsPageScrollTillEndDrp = By.xpath("//*[@class='footer']");
		public By loadMoreBtn = By.xpath("//*[@class='load_act col-md-12']/a");
		// public By clickoncontent = By.xpath("//*[@class='home_movie_wrap
		// col-xs-4 col-md-5ths home_movie_wrap item-watching'])[1]");
		public By closePopupBtn = By.xpath("(//*[@class='close'])[2]");
		public By contentBtn = By.xpath("(//*[@class='col-md-8 col-xs-7 episode_name'])[10]");
		public By content2Btn = By.xpath("(//*[@class='col-md-8 col-xs-7 episode_name'])[9]");
		public By content3Btn = By.xpath("(//*[@class='col-md-8 col-xs-7 episode_name'])[8]");
		public By popupSigin = By.xpath("//*[@class='signin_label']");
		public By subscriptionNow = By.xpath("//*[@class='offer_plan_body domestic subscribe_coupon']/h2");
		public By skip = By.xpath("//*[text()='Skip']");
	}

	public interface Sigup {
		public By signUpBtn = By.xpath("//*[text()='SIGN UP']");
		public By emailTxt = By.xpath("(//*[@class='form-control log-auto-focus'])[2]");
		// public By createPwdTxt=By.xpath("(//*[@class='form-control'])[2]");
		public By createPwdTxt = By.xpath("(//*[@class='form-group input-group'])[2]/child::input");
		public By nameTxt = By.xpath("(//*[@class='form-control log-auto-focus'])[3]");
		public By ageDrpdn = By.xpath("(//*[text()='Age'])[1]");
		public By selectAgeDrpdn = By.xpath("(//*[text()='36-40 Years'])[1]");
		public By genderMaleBtn = By.xpath("//span[@class='gender-title male-color']");
		public By genderFemaleBtn = By.xpath("//span[@class='gender-title female-color']");
		public By countryDrpdn = By.xpath("(//*[contains(@class,'chosen-container-single')])[1]");
		public By selectCountyDrpdn = By.xpath("(//*[@class='chosen-results'])[1]/child::li[2]");
		public By stateDrpdn = By.xpath("(//*[contains(@class,'chosen-container-single')])[2]");
		public By selectStateDrpdn = By.xpath("(//*[@class='chosen-results'])[2]/child::li[5]");
		public By termsLnk = By.xpath("(//*[@class='links'])[1]");
		public By privacyLnk = By.xpath("(//*[@class='links'])[2]");
		public By faqLnk = By.xpath("(//*[@class='links'])[3]");
		public By cookieLnk = By.xpath("(//*[@class='links'])[4]");
		public By checkboxBtn = By.xpath("//*[@for = 'term1']");
		public By submitBtn = By.xpath("//*[text()='submit']");
		public By closeBtn = By.xpath("//*[@class='close']");
	}

	public interface Logout {
		public By logoutBtn = By.xpath("//*[@class='onLogout']");
		// public By logoutBtn = By.cssSelector(" #signin_form_section
		// button[type=submit]");
		// public By
		// AfterLoginProfile_Btn=By.xpath("(//*[contains(@class,'icon-icn_profile')])[1]");
	}

	public interface Login {
		public By moviesBtn = By.xpath("//*[text()='MOVIES']");
		public By profile = By.xpath("//li[@id='show_sign']");
		public By profile1 = By.xpath("(//span[@class='icomoon icon-icn_profile'])[2]");
		public By sigin = By.xpath("//a[text()='Sign In']");
		public By userNameTxt = By.xpath("//input[@id='email-up']");
		public By passwordTxt = By.xpath("//input[@id='password']");
		public By loginBtn = By.cssSelector(" #signin_form_section button[type=submit]");
		public By forgotPasswordBtn = By.xpath("//a[@class='redlink callforgotpass']");
		public By myAccountBtn = By.xpath("(//*[text()='My Account'])[1]");
		public By myAccountMySubBtn = By.xpath("(//*[@class='fa fa-chevron-right'])[3]");
		public By myAccountPackageNameBtn = By.xpath("//*[@class='collapse in']/table/tbody/tr[2]/td[2]");
		public By myAccountPackageName1Btn = By.xpath("//*[@class='collapse in']");
		public By myInfoBtn = By.xpath("(//*[@class='panel panel-info panel_accr'])[2]");
		public By clearMyHistoryBtn = By.xpath("(//*[@class='panel panel-info panel_accr'])[4]");
		public By clearMyHistoryOkBtn = By.xpath("//*[@class='btn btn-redclr']");
		public By myInfoInformationTxt = By.xpath("//*[@class='myinfo']");
		public By selectMovieBtn = By.xpath("(//*[@class='hm_movie_img '])[3]/img");
		public By customerNameTxt = By.xpath("(//*[@class='user_data'])[1]");
	}

	public interface Movies {
		public By movieSelect4Img = By.xpath("(//*[@class='hm_movie_img '])[4]");
		public By movieBtn = By.xpath("//*[text()='MOVIES']");
		public By viewAllMovieBtn = By.xpath("//*[@class='view_cta_wrap']/descendant::a");
		public By genresBtn = By.xpath("//span[text()='Genres']//parent::button");
	//	public By dramaBtn = By.cssSelector("[for='Drama']");
		public By dramaBtn = By.xpath("//*[text()='Drama']");
		
		public By actionBtn = By.xpath("//*[text()='Action']");
		public By dramaApplyBtn = By.xpath("(//*[text()='Apply'])[1]");
		public By selectMovieIcon = By.xpath("(//*[contains(@class,'movie_img')])[23]/child::img");
		public By selectMoviePlayBtn = By.xpath("(//*[contains(@class,'btn-red')])[1]");
		public By actorBtn = By.xpath("(//*[contains(@class,'filter-trigger')])[2]");
		public By actorRahmanBtn = By.xpath("//*[text()='A.R.Rahman']");
		public By rahmanApplyBtn = By.xpath("(//*[contains(@class,'filter-apply')])[2]");
		public By actorMovieIcon = By.xpath("(//*[contains(@class,'movie_img')])[23]");
		public By actorMoviePlayBtn = By.xpath("//*[contains(@class,'btn-red')]");
		public By yearBtn = By.xpath("(//*[contains(@class,'filter-trigger')])[3]");
		public By selectYearBtn = By.xpath("(//input[@name='year'])[4]");
		public By selectYearApplyBtn = By.xpath("(//*[@type='button'])[12]");
		public By selectYearMovieBtn = By.xpath("(//*[contains(@class,'hm_movie_img ')])[2]/child::img");
		public By selectYearMoviePlayBtn = By.xpath("(//*[contains(@class,'btn-red')])[1]");
		public By siginCouponCodeBtn = By.xpath("(//*[@class='plan_wrap'])[4]/child::a");
		public By playbtn = By.xpath("(//*[@class='btn btn-red'])[1]");
		public By pausebtn = By.xpath("//*[text()='PAUSE']");
	}

	public interface TVShows {
		public By TVselectCategory_Btn = By.xpath("(//*[text()='Sun News'])[1]");
		public By TVChannelsApply_Btn = By.xpath("(//*[contains(@class,'btn-red')])[2]");
		public By TVYearsSelect_Btn = By.xpath("(//input[@name='year'])[37]");

	}

	public interface MusicVideos {
		public By MoviesSelectCategory_Btn = By.xpath("(//*[@type='radio'])[6]");
		public By MusicianSelectCategory_Btn = By.xpath("//*[text()='Anirudh Ravichander']");
		public By MusicianSelectApply_Btn = By.xpath("(//*[text()='Apply'])[2]");
	}

	public interface ProfileEdit {
		public By showUser_btn = By.xpath("(//*[@class='icomoon icon-icn_profile'])[1]");
		// public By
		// showuser_Btn=By.xpath("(//*[contains(@class,'icon-icn_profile')])[1]");
		public By Profile_Btn = By.xpath("(//*[@href='/profile'])[1]");
		public By Edit_icon = By.xpath("//*[@class='edit']");
		public By EditComplete_Btn = By.xpath("(//*[@class='btn btn-default'])[5]");
		public By FirstName_Txt = By.xpath("(//*[@class='form-control'])[1]");
		public By SecondName_Txt = By.xpath("(//*[@class='form-control'])[2]");
		public By PhoneNo_Txt = By.xpath("(//*[@class='form-control'])[3]");
		public By Age_Drp = By.xpath("//*[contains(@class,'filter-option')]");
		public By AgeSelect_Btn = By.xpath("(//*[@class='dropdown-menu inner']/child::li)[5]");
		public By Gender_Btn = By.xpath("(//*[@class='gender_radio'])[2]");
		public By Country_Drp = By.xpath("(//a[@class='chosen-single'])[1]");
		public By SelectCountry_btn = By.xpath("(//*[@class='chosen-results'])[1]/li[4]");
		public By State_Drp = By.xpath("(//a[@class='chosen-single'])[2]");
		public By SelectState_Btn = By.xpath("(//*[@class='chosen-results'])[2]/li[4]");
		public By Done_Btn = By.xpath("//*[text()='Done']");
		public By ChangeProfile_icon = By.xpath("//*[@class='user-info']");
	}

	public interface SubscribePlan {
		public By movieSelect_Btn = By.xpath("(//*[@class='nav navbar-nav navbar-left']/li/a)[1]");
		public By scrollpage1 = By.xpath("(//*[@class='title'])[2]");
		public By scrollpage2 = By.xpath("(//*[@class='title'])[3]");
		public By viewall_btn = By.xpath("(//*[@class='title'])[3]/a/span");
		public By selectmovie_btn1 = By.xpath("//*[@class='downlad_play_container']/a");
		
		public By selectmovie_btn = By.xpath("(//*[@class='hm_movie_img'])[30]");
		
		public By clickplay_btn = By.xpath("//*[@id='vidPlayBtn']");
		public By monthly_subscribe = By.xpath("(//*[@class='plan_wrap'])[1]/a[1]");
		public By quarterly_subscribe = By.xpath("//*[text()='90 Days']");
		public By yearly_subscribe = By.xpath("//*[text()='365 Days']");
		public By coupon_code = By.xpath("//*[text()='Have a Coupon Code?']");
		public By credit_card = By.xpath("//*[@class='CreditCard']/a");
		public By debit_card = By.xpath("//*[text()='Debit Card']");
		public By paytm = By.xpath("//*[text()='Paytm']");
		public By creditcard_number = By.xpath("//*[@name='frm_cc_num']");
		public By creditcard_name = By.xpath("//*[@id='frm_cc_name']");
		public By creditcard_clickMonth = By.xpath("(//*[@class='caret'])[1]");
		public By creditcard_selectMonth = By.xpath("(//*[@class='dropdown-menu inner']/li)[5]");
		public By creditcard_clickyear = By.xpath("(//*[@class='caret'])[2]");
		public By creditcard_selectyear = By.xpath("(//ul[@class='dropdown-menu inner'])[2]/li[4]");
		public By creditcard_cvv = By.xpath("//*[@name='frm_cc_cvv']");
		public By creditcard_checkbox = By.id("checkbox5");
		public By credit_paynow = By.xpath("//*[@id='frm_cc_pay_btn']");
		public By debitcard_clicktype = By.xpath("(//*[@class='caret'])[1]");
		// ("(//*[text()='Select Debit Card Type'])[1]");
		public By debitcard_selecttype = By.xpath("(//*[text()='Master Cards'])[1]");
		public By debitcard_cardnumber = By.xpath("//*[@name='frm_cc_num']");
		public By debitcard_name = By.xpath("//*[@id='frm_cc_name']");
		public By debitcard_clickmonth = By.xpath("(//*[@class='caret'])[2]");
		public By debitcard_selectmonth = By.xpath("(//*[@class='selected'])[2]/following-sibling::li[4]");
		public By debitcard_clickyear = By.xpath("(//*[@class='caret'])[3]");
		public By debitcard_selectyear = By.xpath("(//*[@class='text'])[23]");
		public By debitcard_cvv = By.xpath("//*[text()='CVV']");
		public By debitcard_checkbox = By.xpath("//*[@name='frm_cc_save']");
		public By debit_paynow = By.xpath("//*[@id='frm_cc_pay_btn']");
		public By paytm_entermobile = By.id("inp");
		public By paytm_proceed = By.xpath("//*[text()='Proceed']");
		public By coupon_entercouponcode = By.xpath("//*[@placeholder='Enter Coupon Code']");
		public By coupon_cancel = By.xpath("(//*[@class='btn form-inline'])[1]");
		public By coupon_submit = By.xpath("(//*[@class='btn form-inline'])[2]");
	}

	public interface SubscribeGuest {
		public By subscribemovie_btn = By.xpath("(//*[@class='hm_movie_img'])[41]");
		public By SubscriptionMovie1_Btn = By.xpath("(//*[@class='hm_movie_img '])[1]");
		public By Subscribemovie_play_btn = By.xpath("//*[@id='vidPlayBtn']");
		public By verify_Subscribe_txt = By.xpath("//*[text()='SUBSCRIBE NOW']");
		public By scrollwindow = By.xpath("(//*[@class='title'])[2]");
		public By scrollwindow1 = By.xpath("//*[contains(@class,'home_banner')]");
	}

	public interface ApplyCoupon {
		public By showuser_Btn = By.xpath("(//*[contains(@class,'icon-icn_profile')])[1]");
		public By ShowUser1_Btn = By.xpath("(//*[contains(@class,'icon-icn_profile')])[1]");
		public By ApplyCoupon_Btn = By.xpath("(//*[text()='Apply Coupon'])[1]");
		public By Coupon_Txt = By.xpath("//*[@class='form-control']");
		public By CouponSubmit_Btn = By.xpath("//input[@type='submit']");
	}

	public interface Searchmovie {
		public By search_Btn = By.xpath("(//*[@class='call_search_update'])[1]");
		public By searchmovie_Txt = By.xpath("//*[@name='query']");
		public By Listofmovies = By.xpath("//*[@class='live-search-result']");
		public By SelectMovie_Btn = By.xpath("(//*[@class='hm_movie_img'])[29]/following::h2");
		public By ActorSelectMovie_Btn = By.xpath("(//*[@class='hm_movie_img'])[29]");

		public By SelectMovie_Img = By.xpath("(//*[@class='hm_movie_img'])[29]");
	}

	public interface ForgetPassword {
		public By ForgotPassword_Btn = By.xpath("//*[text()='Forgot Password?']");
		public By ForgetEmail_Txt = By.xpath("(//*[@class='form-control'])[2]");
		public By ForgotOTP_Txt = By.xpath("(//*[@class='reset-password-error'])[1]");
		public By SendRequest_Btn = By.xpath("//*[text()='send request']");
		public By ForgotLinkEmail_Txt = By.xpath("(//*[@class='sub_title'])[1]");
		public By Ok_Btn = By.xpath("//*[text()='Ok']");
	}

	public interface Devices {
		public By Devices_Btn = By.xpath("(//*[text()='Devices'])[1]");
		public By Deactivate_Btn = By.xpath("(//*[text()='Deactivate'])[1]");
		public By EnterCOde_Txt = By.name("auth_code");
		public By DeviceActivate = By.xpath("//*[text()='Activate']");
		public By DeviceMsg = By.xpath("//*[@class='msg_error']");

	}

	public interface SwitchProfile {
		public By Switchprofile_Btn = By.xpath("(//*[text()='Switch Profile'])[1]");
		public By BeforeSwith1_Icon = By.xpath("(//*[@class='hm_movie_img'])[23]");
		public By Switch1_icon = By.xpath("(//*[@class='hm_movie_img'])[58]");
		public By Switch2_icon = By.xpath("(//*[@class='hm_movie_img'])[59]");
		public By Done_Btn = By.xpath("(//*[text()='Done'])[1]");
		public By SwitchProfileEdit_Btn = By.xpath("(//*[@class='profile-tool-btn'])[1]");
		public By SwitchAddProfileDone_Btn = By.xpath("(//*[text()='Done'])[4]");
		public By MovieSelect_Btn = By.xpath("(//*[@class='hm_movie_img'])[46]");
		public By AddProfile_Btn = By.xpath("//*[@class='add-icon']");
		public By AddProfileUserName_Txt = By.xpath("(//*[@class='form-control'])[3]");
		public By AddProfileSymbol_Img = By.xpath("(//*[@class='hm_movie_img'])[60]");
		public By AddProfileADD_Btn = By.xpath("(//*[@class='btn btn-red'])[7]");
		public By AddProfileDelete_Btn = By.xpath("//*[@class='fa fa-trash']");
		public By AddProfileDeleteDone_Btn = By.xpath("(//*[text()='Done'])[2]");
		public By NewAddProfile_Btn = By.xpath("(//*[@class='home_movie_wrap'])[3]");
	}

	public interface CancelSubscription {
		public By CancelSubscription_Btn = By.xpath("//*[@class='cta_subsucribe']/child::a");
		public By SubscriptionTxt_Btn = By.xpath("(//*[@class='subscibe_modal_cont'])[4]/child::h2");
		public By cancel_Btn = By.xpath("//*[text()='cancel subscription']");
	}

	public interface Subscriptions {
		public By Subscription_Btn = By.xpath("(//*[text()='Subscriptions'])[1]");
		public By Subscription_Footer = By.xpath("//*[@class='footer']");
		public By Invoice_Btn = By.xpath("(//*[@class='subscribe_footer'])[2]/child::ul/child::li/child::a");
		public By State_Txt = By.xpath("(//*[text()='Telangana'])[2]");
		public By Amount_Btn = By.xpath("//*[@class='colns-received']");
	}

	public interface More {
		public By TvSerial_Img = By.xpath("(//*[@class='hm_movie_img '])[1]");
		public By TVserial2_Img = By.xpath("(//*[@class='hm_movie_img '])[2]");

	}

	public interface Favourite {
		public By Movie_Img = By.xpath("(//*[@class='hm_movie_img '])[1]");
		public By Favorite_Footer = By.xpath("//*[text()='Favourites']");
		public By Movie2_Img = By.xpath("(//*[@class='hm_movie_img '])[8]");
		public By Favourite_Btn = By.xpath("//*[text()='Favourite']");
		public By TVShowFavourite_Btn = By.xpath("//*[@class='icomoon icon-icn_favourite']");
		public By MusicVideoFavourite_Btn = By.xpath("//*[@class='icomoon icon-icn_favourite']");
		public By ComdeyFavourite_Btn = By.xpath("//*[@class='icomoon icon-icn_favourite']");
		public By MusicVideos_Btn = By.xpath("//*[text()='MUSIC VIDEOS']");
		public By AllMusicVideos_Btn = By.xpath("//*[@class='view_cta_wrap']/child::a");
		public By SelectMusicVideo_Img = By.xpath("(//*[@class='hm_movie_img '])[1]");
		public By SelectMusicVideo2_Img = By.xpath("(//*[@class='hm_movie_img'])[30]");
		public By Comedy_Btn = By.xpath("//*[text()='COMEDY']");
		public By SelectComedyVideo_Btn = By.xpath("(//*[@class='hm_movie_img'])[45]/child::img");
		public By TVserial_Img = By.xpath("(//*[@class='hm_movie_img '])[2]");
	}

	public interface Share {
		public By ShareMovie_Img = By.xpath("(//*[@class='hm_movie_img'])[41]");
		public By Share_Btn = By.xpath("//div[text()='Share']");
		public By Cancel_Btn = By.xpath("(//*[text()='Cancel'])[2]");
		public By Facebook_Icon = By.xpath("(//*[@class='facebok_icon'])[2]");
		public By Twitter_Icon = By.xpath("(//*[@class='twitter_icon'])[2]");
		public By TwitterUserName_Txt = By.name("session[username_or_email]");
		public By TwitterPassword_Txt = By.name("session[password]");
		public By TwitterLogin_Btn = By.xpath("(//*[text()='Log in'])[2]");
		public By FacebookUserName_Txt = By.name("email");
		public By FacebookPassword_Txt = By.name("pass");
		public By FacebookLogin_Btn = By.name("login");
	}

	public interface Customer {
		public By UserNotAllow_Txt = By.xpath("//*[@class='error']");
	}

	public interface BottomLinks {
		public By TermsOfUse_Btn = By.xpath("(//*[text()='Terms of Use'])[1]");
		public By AboutUS_Btn = By.xpath("(//*[text()='about us'])[1]");
		public By FAQS_Btn = By.xpath("(//*[text()='faq’s'])[1]");
		public By privacyPolicy_Btn = By.xpath("(//*[text()='privacy policy'])[1]");
		public By CookiesPolicy_Btn = By.xpath("(//*[text()='Cookie Policies'])[1]");
	}

	public interface Premium {
		public By PremiumContent_Img = By.xpath("(//*[@class='hm_movie_img'])[41]/img");
		public By premiumComedyClip_Img = By.xpath("(//*[@class='title'])[4]");
		public By premiumComedyFooter_Img = By.xpath("(//*[@class='title'])[6]");

		public By premiummusicvideo_Img = By.xpath("(//*[@class='hm_movie_img '])[5]");
	}

	public interface UnsubscribedUser {
		public By FreeSerial_Img = By.xpath("(//*[@class='freemium'])[1]");
		public By FreeSerial2_Img = By.xpath("(//*[@class='freemium'])[2]");
		public By FreeSerial3_Img = By.xpath("(//*[@class='freemium'])[3]");
		public By FreeSerial4_Img = By.xpath("(//*[@class='freemium'])[4]");
		public By FreeSerial5_Img = By.xpath("(//*[@class='freemium'])[5]");
		public By FreeSerial6_Img = By.xpath("(//*[@class='freemium'])[6]");

		public By Serial_Img = By.xpath("(//*[@class='hm_movie_img '])[53]");
		public By Episode2_Link = By.xpath("(//*[@class='col-md-12 previous_col preEpisodeList'])[4]");
		public By Episode3_Link = By.xpath("(//*[@class='col-md-12 previous_col preEpisodeList'])[5]");
		public By FreeVideo_Footer = By.xpath("(//*[@class='title'])[3]");
		public By Freecomedy =By.xpath("(//*[contains(text(),'Back 2 Back Comedies')])[3]");
		public By FreeVideo_Img  = By.xpath("(//*[@class='freemium'])[1]/img");
		public By FreeVideo2_Img = By.xpath("(//*[@class='freemium'])[2]/img");
		public By FreeVideo3_Img = By.xpath("(//*[@class='freemium'])[3]/img");
		public By FreeVideo4_Img = By.xpath("(//*[@class='freemium'])[4]/img");
		public By FreeVideo5_Img = By.xpath("(//*[@class='freemium'])[15]/img");
		public By FreeVideo6_Img = By.xpath("(//*[@class='freemium'])[16]/img");
		public By FreeVideo7_Img = By.xpath("(//*[@class='freemium'])[17]/img");
		public By FreeVideo8_Img = By.xpath("(//*[@class='freemium'])[18]/img");
		public By FreeVideo9_Img = By.xpath("(//*[@class='freemium'])[19]/img");

		public By PremiumMovie_Img = By.xpath("(//*[@class='hm_movie_img'])[30]");

	}

	public interface ContinueWatching {
		public By ContinueWatching_Footer = By.xpath("//*[text()='Continue Watching ']");
		public By Watchmovie_Img = By.xpath("(//*[@class='thumb-image'])[1]");
		public By WatchMoviePlay_Btn = By.xpath("(//*[@class='fp-icon fp-playbtn'])[3]");

		public By Movie_Img = By.xpath("(//*[@class='hm_movie_img '])[1]");
		public By MoviePlay_Btn = By.xpath("//*[text()='Play']");
		public By MoviePause_Btn = By.xpath("//*[text()='Pause']");
		public By continueMovie_Img = By.xpath("(//*[@class='hm_movie_img thumb-image'])[1]");
		public By ScreenExtend_Img = By.xpath("//*[@class='fp-fullscreen fp-icon']");
		public By ScreenForward_Img = By.xpath("//*[@class='video-pn prev']");
		public By ScreenBackward_Img = By.xpath("//*[@class='video-pn next']");
		public By ScreenPlay_Img = By.xpath("(//*[@class='fp-icon fp-playbtn'])[3]");
		public By Screen_Img = By.xpath("//*[@class='video_player_wrap player-left']/child::div[1]");
		public By ScreenSetting_Img = By.xpath("//*[@class='fa fa-cog']");
		public By ScreenSettingQuality_Img = By.xpath("//*[@class='fp-menu fp-qsel-menu fp-active']/child::a[3]");
		public By StarRateing_Img = By.xpath("(//*[@class='rating-symbol'])[14]");
		public By StarRateing2_Img = By.xpath("(//*[@class='rating-symbol'])[12]");
		public By RateingSubmit_Btn = By.xpath("(//*[text()='Submit'])[1]");
		public By playbtn= By.xpath("(//*[@class='btn btn-red'])[1]");

	}

	public interface HDAndSD {
		public By SDSelectMovie_Img = By.xpath("(//*[@class='hm_movie_img'])[55]");
		public By HDSelectMovie_Img = By.xpath("(//*[@class='hm_movie_img'])[31]");
		public By HDFooter_Btn = By.xpath("(//*[@class='title'])[5]");
		public By SDMovie_Btn = By.xpath("//*[text()='Aaradhana']");
	}

	public interface Subtitles {
		public By Subtitles_Img = By.xpath("//*[text()='CC']");
		public By EditMovie_Line = By.xpath("//*[@class='markers container fp-bar active']/child::div[3]");
		public By Sreen_Img = By.xpath("//*[@class='fp-engine dash-engine']");
		public By OnSubtitles_Img = By.xpath("//*[@class='fp-menu fp-subtitle-menu fp-active']/child::a[2]");
		public By OffSubtitles_Img = By.xpath("//*[@class='fp-menu fp-subtitle-menu fp-active']/child::a[1]");
	}

	public interface LiveTV {
		public By Livetv_Btn = By.xpath("//*[@class='nav navbar-nav navbar-left']/child::li[3]");
		public By Schedule_Footer = By.xpath("(//*[@class='title'])[1]");
		public By TeluguLanguage_Btn = By.xpath("(//*[@class='tab-slider-cell'])[2]");
		public By KannadaLanguage_Btn = By.xpath("(//*[@class='tab-slider-cell'])[3]");
		public By SelectTeluguChannel1_Img = By.xpath("//*[@class='channels']/child::li[2]");
		public By SelectTeluguChannel2_Img = By.xpath("//*[@class='channels']/child::li[4]");
		public By Arrow_Img = By.xpath("//*[@class='flickity-prev-next-button next']");
		public By Reminderclock_Img = By.xpath("(//*[@class='program-wrapper clearfix'])[9]/child::a");
		public By Reminder15min_Btn = By.xpath("(//*[@class='radio'])/child::label[2]");
		public By Reminder30min_Btn = By.xpath("(//*[@class='radio'])/child::label[3]");
		public By ReminderOk_Btn = By.xpath("(//*[@class='btn btn-red'])[1]");
		public By ok_Btn = By.xpath("//*[text()='ok']");
		public By FreeChannel_Img = By.xpath("//*[@class='chanel_logo']");
	}
}