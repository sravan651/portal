Feature: validate sunnxt app operation

@signuppopupdisplayedtwocontextplay @web
Scenario: TC-001-Verify for guest user and Sign up/sign in popup is displayed after every 2 content playback sessions operation 
Given user Navigate Sun Nxt page
Given user click on tv shows
When user click on free tv shows
Then user click on second free content episode
And user observe sigin page displayed
Then user play two free music videos
And observe sigin page is displayed for playing third free video
#Then user play two free comedy videos
#And sigin page is displayed for playing third free video





@siguppopupdisplayeverythreecontextplay @web @prasad
Scenario: TC-002-Verify if user skip click on close mark on sign up/sign in popup After 3 contents playback and again Sign up/Sign in popup is shown operation 
Given user Navigate Sun Nxt page
Given user play two free tv episode
When user click skip close mark
Then user play another two free episodes
And user Observe Signin and signup page displayed
When user playing two free music videos
Then observe sigin page is displayed for playing third free video in music videos and user click skip mark
#When user playing two free comedy videos
#Then sigin page is displayed for playing third free video in comedy videos and user click skip mark






@subscriptionpopupdisplayedeverytwocontentplay @web
Scenario: TC-003-verify Subscription popup is shown After every 2 content Playback sessions in Unsubscribed user operation
Given user Navigate Sun Nxt page
Given user observe the unsubscrition login
When play two free tv show episodes
Then user observe subscription sigin page displayed
#When play two free comedy clips
#Then observe signin page is displayed for unsubscribed user

@continueWatching @web @sravan
Scenario: TC-007-Verify partially played contents are shown under home continue watching section and from Profile section and check user is able to playback from last stop point of video operation
Given user Navigate Sun Nxt page
When user play one movie
Then user go to home page and observe previous played movie is visible or not
And user click previous played movies on continue watching video








@applycoupon @web
Scenario: TC-010-verify apply coupon operation
Given user Navigate Sun Nxt page
When user click on apply coupon button
Then user click on submit button 



@mobilesigup @web
Scenario: TC-011-verify Mobile Sign up operation
Given user Navigate Sun Nxt page
When user enter mobile Number for sigup
Then user click on mobile terms of use link


@verifyplayFreeContentforUnsubscribedUser @web
Scenario: TC-015-Content Playback for free contents for unsubscribed users operation
Given user Navigate Sun Nxt page
Then user observe the free content is playing in tv shows for unsubcribed user
When user observe the free content is playing in music videos for unsubcribed user
Then user observe the free content is playing in live tv for unsubcribed user
#And user observe the free content is playing in comedy videos for unsunubcribed user

@verifyplayFreeContentforsubscribedUser @web
Scenario: TC-016-Content Playback for free contents for subscribed users operation
Given user Navigate Sun Nxt page
Then user observe the free content is playing in tv shows for subcribed user
When user observe the free content is playing in music videos for subcribed user
Then user observe the free content is playing in live tv for subcribed user
#And user observe the free content is playing in comedy videos for subcribed user

@premiumcontentPlayForUnsubscribeUser @web
Scenario: TC-017-verify Content Playback for premium contents for unsubscribed users operations
Given user Navigate Sun Nxt page
Then user observe the premium content playing for unsubscribed user in movie
When user observe the premium content playing for unsubscribed user in TVShows
Then user observe the premium content playing for unsubscribed user in comedy clip
And user observe the premium content playing for unsubscribed user in music video




@premiumcontentPlayForsubscribeUser @web
Scenario: TC-018-verify Content Playback for premium contents for subscribed users opertions
Given user Navigate Sun Nxt page
Then user observe the premium content playing for subscribed user in movies
When user observe the premium content playing for subscribed user in TVShows
Then user observe the premium content playing for subscribed user in comedy clip
And user observe the premium content playing for subscribed user in music video

 
@emailsigin @web
Scenario: TC-20 verify by using Email id sigin
Given user Navigate Sun Nxt page
When User click on profile icon
And User Login to the Sunnxt portal
And Click on login button

@editprofile @web
Scenario: Tc-021-verify edit profile changeing operation
Given user Navigate Sun Nxt page
Given user click profile image
When click profile button
Then click edit icon 
And click edit complete button
And click done button
Then user check changeing profile is updated or not in my info field


@emailsigup @web
Scenario: TC-022-verify Email Sign Up and profile Update operation
Given user Navigate Sun Nxt page
When user click on signup button
Then user enter email ID for sigup
Then user click on terms of use link

 
@internationalUser @web
Scenario: TC-025-verify International user not allowed to login on indian region operation
Given user Navigate Sun Nxt page
When User enter forine login details
Then user observe site login or not


 

@monthlysubscriptionplan @web
Scenario: TC-027-subscribe application using payment mode
Given user Navigate Sun Nxt page
Then user select monthly subscription plan from given plan
Then user select payment mode through credit card
And user select payment mode through debit card
Then user select payment mode through paytm

@switchprofile 
Scenario: Tc-028-user verify switch profile and delete profile and add profile operation
Given user Navigate Sun Nxt page
Given user click swithprofile button
And user observe Add profile
Then user switch previous profile
Then user observe delete profile


@cancelsubscription @web @sravan
Scenario: TC-029-Verify Cancel Subscription confirmation popup and cancel subscription operation
Given user Navigate Sun Nxt page
Given user click cancel subscription button
#When Verify Cancel Subscription confirmation popup



@subscriptions @web @sravan
Scenario: TC-031-Verify Invoice for Switch Plan Subscription and observe customer in TN and other status operation
Given user Navigate Sun Nxt page
Given user click subscription button
When user click invoice button
Then user observe customer state
And user verify the amount of customer




@applypromecodeInSiginPage @web
Scenario: TC-033-verify Email sign up - select any pack apply promo code and subscribe using CC operation
Given user Navigate Sun Nxt page
Then user choose one movie and play that movie in movies
And user apply promo code in SigIn page







@forgotpassword @web
Scenario: Tc-034-user verify Forgot Password for Email and Mobile operation
Given user Navigate Sun Nxt page
When user click forgotpassword
Then user enter the mobile number in text box
And user observe OTP send succesfully to mobile
Then user enter the EmailID in text box
And user observe OTP send succesfully to Email



@playAllControls @web
Scenario: TC-035-Verify Player controls for Movies and tv shows and movie trailers and music videos and comedy clips and comedy movies operation
Given user Navigate Sun Nxt page
When user play one movie in movies
Then user play one tvshow in TVShows
And user play one video in music videos
#And user play one comedy movie in comedy
#Then user play one comedy clip in comedy



 
@playvideoincontinuewatchingfromhomepage @web
Scenario: TC-036-verify Play contents from Watch Now sections operation
Given user Navigate Sun Nxt page
Then user play one video on continue watching section from home page





@playHDContentAndSDContent @web
Scenario: TC-037-verify filters and play 2 content SD/HD(movies-view all movies) operation
Given user Navigate Sun Nxt page
Then user play one HD movie in movies
And user play one SD movie in movies

@searchpage @web
Scenario: TC-039-Verify Search contents by using alphabitical order
Given user Navigate Sun Nxt page
Then user search one movie in searching field
When user search movies by using actor name in searching field
 


@filterInTVShows @web @sravan
Scenario: TC-040-Verify filter - TV Shows - View all Shows - apply filter and play two tv shows and its episodes in full screen and stretch mode operation
Given user Navigate Sun Nxt page
When user click TVShows button
Then user click geners button in TVShows and select one category and play one content
And user click TVchannels button in TVShows and selectt one category and play one content
Then user click year button in TVShows and select one category and play one content





@filterInMusicVideos @web
Scenario: TC-041-Verify Filter Music videos-view all songs-apply filter and play all songs in full screen and stretch mode operation
Given user Navigate Sun Nxt page
When user click music videos
Then user click music button in music videos and select one category and play one content
And user click musicians button in music videos and select one category and play one content



 
 
@movies @web
Scenario: Tc-042-check Movie operation 
Given user Navigate Sun Nxt page
Given click movie button
Then click genres button
And click movie icon
Then click actors button
And click actors movie icon
Then click year button
And click year movie icon



@share @web @sravan
Scenario: TC-43-Verify Share contents twitter and facebook operation
Given user Navigate Sun Nxt page
When user observe movie shareing to facebook
Then user observe movie shareing to twitter

@addfavourite @web
Scenario: TC-044-verify Add to Favourite and play content from favourite in movies tv shows music video movie trailer comedy clips comedy movie Operation
Given user Navigate Sun Nxt page
Given user Add Favourite Movie
When user Add Favourite TV Show
Then user Add Favourite MusicVideo
And user Add Favourite Comedy
Then user observe the add favourite content visible in profile page
 
@screen @web @sravan
Scenario: Tc-45 verify the screen
Given user Navigate Sun Nxt page
Given user click movies button and select one movie and play that movie
When user extend the screen
Then user click play and pause button in screen
And user click 10sec forward and 10sec backward button
Then user click setting button and select the quality of movie

@profilecontinuewatching @web
Scenario: TC-046-verify Play contents from profile and continue watching section operation
Given user Navigate Sun Nxt page
Then user play one movie in continue watching section from profile page

@rateing @web
Scenario: TC-51 verify the movie rateing and edit the rateing of the movie
Given user Navigate Sun Nxt page
Then user can give rateing to that played movie and click submit button





@subtitles @web @sravan
Scenario: Tc-52 verify the subtitles enable and disable operation
Given user Navigate Sun Nxt page
When user play one movie and stop the subtitles
Then user on subtitles for that movie

 @logout @web 
Scenario: TC-053-verify logout operation
Given user Navigate Sun Nxt page
Given user click logout button



 

@myInfo @web
Scenario: TC-54 verify the My Info operation
Given user Navigate Sun Nxt page
Then user click my info button and observe the details of customer




@clearMyWatchHistory @web
Scenario: TC-55 verify the clear my watch history operation
Given user Navigate Sun Nxt page
Then user click clear my history button and clear the watch list



@liveTV @web
Scenario: Tc-56 verify the live TV channels playing operation
Given user Navigate Sun Nxt page
When user click telugu language button and select one channel
Then user click kannada language button and select one channel
 
 



@devicesDeactivates @web
Scenario: TC-057-verify Device Deactivate operation
Given user Navigate Sun Nxt page
Given user click device button 


 


@myAccountSection @web @sravan
Scenario: TC-059-verify profile-my account section options tentkotta and subscribed user unsubscribed user sun direct user operation
Given user Navigate Sun Nxt page
When user observe account section options in subscribed user
Then user observe account section options in unsubscribed user
And user observe account section options in sun direct user

@loadmoreInTVsowsAndMusicAlbums @web
Scenario: TC-060-Verify Load more option is shown in the Tv show and music Albums details page operation
Given user Navigate Sun Nxt page
Then user observe load more option in tvshows
And user observe load more option in music albums

@loadmore @web @sravan
Scenario: TC-061-verify TV Shows Load More operation
Given user Navigate Sun Nxt page
Given user click TV Show button
Then user observe Load More operation 

@bottomlinks @web
Scenario: TC-058-Verify link at the bottom"terms of use and cookie policy operation
Given user Navigate Sun Nxt page
Then user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In homepage
And user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In movies
When user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In TVShows
Then user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In music videos
And user click ABOUT US FAQS PRIVACY POLICY TERMS OF USE COOKIE POLICIES Links In comedy 