import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

////*[@id="K16"] //*[@id="kbd"]/div[2] vkochetkov@nuna.com
public class OnScreenKeyboard {

    public void selectKeys(Page page, String letters) {
        Locator rows = page.locator("//div[@id='kbd']/div[2]/div/button");
        char letter[] = letters.toCharArray();

        int count = rows.count();
        for (int j = 0; j < letter.length; j++) {
            if(!clickKey(page,rows,count,letter,j)){
                clickShift(page);
                clickKey(page,rows,count,letter,j);
            }
        }
    }
    public void clickShift(Page page){
        Locator locator = page.locator("//*[@id='K16'][1]");
        locator.hover();
        locator.click();
    }
    public boolean clickKey(Page page,Locator rows,int count,char[] letter,int j){
        for (int i = 0; i < count; ++i) {
            if(String.valueOf(letter[j]).equals(".")){
                Locator locator = page.locator(" //*[@id='K190']");
                locator.hover();
                locator.click();
                return true;
            }
            else if(String.valueOf(letter[j]).equals(" ")){
                Locator locator = page.locator(" //*[@id='K32']");
                locator.hover();
                locator.click();
                return true;
            }
            if (rows.nth(i).textContent().contains(String.valueOf(letter[j]))) {
                rows.nth(i).hover();
                rows.nth(i).click();
                return true;
            }

        }
        return false;
    }
}
