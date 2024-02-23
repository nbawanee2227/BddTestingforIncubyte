package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComposeStepDef {

	WebDriver driver = null;
	String gmailBox;
	WebElement composeButton;
	WebElement recipients;
	WebElement sendButton;
	WebElement CC;
	WebElement BCC;


	@Given("user is on G-mail login page")
	public String invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://accounts.google.com");
		return gmailBox;

	}

	@When("user enters valid User-Id")
	public void enter_valid_email_id(String emailId) {
		driver.findElement(By.id("email")).sendKeys("abc@example.com");

	}

	@When("user enter valid password")
	public void enter_valid_password(String pswd) {
		driver.findElement(By.id("pass")).sendKeys("abc@123");	
	}

	@When("click on sign in button")
	public void click_login_button() {
		driver.findElement(By.id("u_0_2")).click();
	}

	@Then("user logged in successfully")
	public void verifyLoginIsSuccessful() {
		System.out.println("Logged in successful");
	}

	@Given("user is on the G-mail account page")
	public void user_is_on_the_g_mail_account_page() {
		driver.get(gmailBox);
		System.out.println("user is on authenticated google account ");
	}

	@Then("compose button should be displayed or available  in G-mail box")
	public Boolean compose_button_should_be_displayed_or_available_in_g_mail_box() {
		composeButton = driver.findElement(By.className("T-I T-I-KE L3"));
		Boolean flag = composeButton.isDisplayed();
		return flag;
	}

	@When("click on compose button")
	public void click_on_compose_button1() {
		composeButton.click();
		System.out.println("Compose button is clicked");
	}


	@Then("Compose button should be clickable")
	public void compose_button_should_be_clickable() {
		System.out.println("Compose button is clickable");
	}


	@Then("user should create and send a new email successfully")
	public void user_should_create_and_send_a_new_email_successfully() {
		recipients = driver.findElement(By.xpath("//div[@id=\":xg\"]"));
		recipients.sendKeys("user1@example.com","user2@example.com");
		sendButton = driver.findElement(By.xpath("//div[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]"));
		sendButton.click();
	}

	@When("logged in user click on compose button")
	public void logged_in_user_click_on_compose_button() {
		composeButton.click();
		System.out.println("Compose button is clicked");
	}

	@When("redirected to new email box screen")
	public void redirected_to_new_email_box_screen() {
		driver.get(gmailBox);
		System.out.println("user is on authenticated google account ");
	}

	@Then("user should be able to add {string} separated by comma to an email")
	public void user_should_be_able_to_add_separated_by_comma_to_an_email(String string) {
		recipients.sendKeys("user1@example.com","user2@example.com", "user3@example.com");
		sendButton.click();
		System.out.println("user is able to send multiple recipients seperated by comma ");
	}

	@When("user clicks on compose button")
	public void user_clicks_on_compose_button() {
		composeButton.click();
		System.out.println("composeButton is clicked and new email box screen is appeared");
	}

	@When("navigate to new email box")
	public void navigate_to_new_email_box() {
		System.out.println("composeButton is clicked and new email box screen is appeared");;
	}

	@Then("G-mail supports CC and BCC function")
	public void g_mail_supports_cc_and_bcc_function() {
		CC = driver.findElement(By.xpath("//span[@class=\"aB gQ pE\"]"));
		CC.click();
		BCC = driver.findElement(By.xpath("//span[@class=\"aB  gQ pB\"]"));
		BCC.click();
	}

	@AfterTest
	public void user_close_browser() {
		driver.close();
		System.out.println("browser is closed");
	}
}
