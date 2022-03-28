import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SetText {
    public void setText(Page page, String element, String value){
        page.fill(element, value);
    }
}
