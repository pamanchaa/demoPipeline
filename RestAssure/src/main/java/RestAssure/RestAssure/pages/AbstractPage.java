package RestAssure.RestAssure.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

abstract class AbstractPage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
