package com.example.sample;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SampleTest {

	private WebClient client = new WebClient();
	private WebDriver driver = new HtmlUnitDriver();
	
	private String url = "http://localhost:8080/htmlunit-bugs2011/sample";
	
	@Test
	public void testWebClient() throws Exception {
		HtmlPage page = client.getPage(url);
		DomElement element = page.getElementById("target");
		
		assertThat(element.getAttribute("href"), containsString("/sample?string=a&int=1"));
		assertThat(element.asText(), is("/sample?string=a&int=1"));
	}
	
	@Test
	public void testHtmlUnitDriver() {
		driver.get(url);
		WebElement element = driver.findElement(By.id("target"));
		
		assertThat(element.getAttribute("href"), containsString("/sample?string=a&int=1"));
		assertThat(element.getText(), is("/sample?string=a&int=1"));
	}
}
