import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class SelectLanguageDD {
    public void selectSourceLang(Page page, String language){
        MouseClicks click=new MouseClicks();
        click.mouseClicks(page,"//div[@jsname='gnoFo']//button[@aria-label='More source languages']//div[3]");
        //Get all the source languages
        // Locate elements, this locator points to a list.
        Locator rows = page.locator("(//div[@data-auto-open-search='true']/div/div[@jsname='JpRUfc']/div[3])[1]/div");
        int count = rows.count();
        for (int i = 0; i < count; ++i) {

            if(rows.nth(i).textContent().contains(language)){
                rows.nth(i).hover();
                rows.nth(i).click();
            }
        }
    }
    public void selectTargetLang(Page page, String language){
        MouseClicks click=new MouseClicks();
        click.mouseClicks(page,"//div[@jsname='gnoFo']//button[@aria-label='More target languages']//div[3]");
        //Get all the source languages
        // Locate elements, this locator points to a list.
        Locator rows = page.locator("(//c-wiz[1]/div[2]/div[1]/div[3]/div[1]/div[2])[1]/div");
        int count = rows.count();
        for (int i = 0; i < count; ++i) {

            if(rows.nth(i).textContent().contains(language)){
                rows.nth(i).hover();
                rows.nth(i).click();
            }
        }
    }
}
