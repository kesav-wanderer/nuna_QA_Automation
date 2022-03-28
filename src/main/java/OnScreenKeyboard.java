import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class OnScreenKeyboard {
    public void selectKeys(Page page, String letters) {
        Locator rows = page.locator("//div[@id='kbd']/div[2]/div/button");
        char letter[] = letters.toCharArray();
        int count = rows.count();
        for (int j = 0; j < letter.length; j++) {
            for (int i = 0; i < count; ++i) {
                if (rows.nth(i).textContent().contains(String.valueOf(letter[j]))) {
                    rows.nth(i).hover();
                    rows.nth(i).click();
                    continue;
                }
            }
        }
    }
}
