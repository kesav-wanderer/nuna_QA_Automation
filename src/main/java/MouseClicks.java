import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MouseClicks {
    public void mouseClicks(Page page,String element){
        Locator locator = page.locator(element);
        locator.hover();
        locator.click();
    }
    public void mouseClicksFirst(Page page,String element){
        Locator locator = page.locator(element);
        locator.hover();
        locator.first().click();
    }
}
