
package com.kileyowen.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kileyowen.exceptions.ExceptionNull;
import com.kileyowen.utils.NullUtils;

//TODO Document
public class Element {

	// TODO Document
	final static Element make(final WebDriver driver, final By by) throws ExceptionNull {

		// TODO Document
		return new Element(driver, by);

	}

	// TODO Document
	private final By by;

	// TODO Document
	private WebElement webElement;

	// TODO Document
	private final WebDriver driver;

	// TODO Document
	private Element(final WebDriver newDriver, final By newBy) throws ExceptionNull {

		// TODO Document
		this.driver = newDriver;

		// TODO Document
		this.by = newBy;

		// TODO Document
		this.webElement = this.findWebElement();

	}

	// TODO Document
	private final WebElement findWebElement() throws ExceptionNull {

		// TODO Document
		return NullUtils.assertNotNull(this.driver.findElement(this.by));

	}

	// TODO Document
	final boolean isValid() {

		// TODO Document
		return this.webElement.isDisplayed();

	}

	// TODO Document
	final void update() throws ExceptionNull {

		// TODO Document
		this.webElement = this.findWebElement();

	}

}
