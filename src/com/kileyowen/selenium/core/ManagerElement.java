
package com.kileyowen.selenium.core;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.kileyowen.exceptions.ExceptionNope;
import com.kileyowen.exceptions.ExceptionNull;
import com.kileyowen.utils.NullUtils;

//TODO Document
public class ManagerElement {

	// TODO Document
	public static final ManagerElement init(final WebDriver driver) {

		// TODO Document
		return new ManagerElement(driver);

	}

	// TODO Document
	private final WebDriver driver;

	// TODO Document
	private final HashMap<By, Element> elements;

	// TODO Document
	private ManagerElement(final WebDriver newDriver) {

		// TODO Document
		this.driver = newDriver;

		// TODO Document
		this.elements = new HashMap<>();

	}

	// TODO Document
	public final Element getElement(final By by) throws ExceptionNull, ExceptionNope {

		// TODO Document
		if (this.getElements().containsKey(by)) {

			// TODO Document
			final Element element = NullUtils.assertNotNull(this.getElements().get(by));

			// TODO Document
			if (element.isValid()) {

				// TODO Document
				return element;

			}

		}

		// TODO Document
		return this.setElementWithReturn(by);

	}

	// TODO Document
	public HashMap<By, Element> getElements() {

		// TODO Document
		return this.elements;

	}

	// TODO Document
	public final void setElement(final By by) throws ExceptionNope, ExceptionNull {

		// TODO Document
		this.setElementWithReturn(by);

	}

	// TODO Document
	private final Element setElementWithReturn(final By by) throws ExceptionNope, ExceptionNull {

		// TODO Document
		if (this.getElements().containsKey(by)) {

			// TODO Document
			final Element elementOld = NullUtils.assertNotNull(this.getElements().get(by));

			// TODO Document
			if (elementOld.isValid()) {

				// TODO Document
				throw new ExceptionNope("Element was valid after set element was called");

			}

			// TODO Document
			elementOld.update();

			// TODO Document
			return elementOld;

		}

		// TODO Document
		final Element element = Element.make(this.driver, by);

		// TODO Document
		this.getElements().put(by, element);

		// TODO Document
		return element;

	}

}
