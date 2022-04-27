import com.microsoft.playwright.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;
//Main Class for running Assessment Test Cases
public class googleTranslate {
    JsonReader JsonReader=new JsonReader();
    Navigate Navigate=new Navigate();
    SelectLanguageDD SelectLangDD= new SelectLanguageDD();
    MouseClicks clicks=new MouseClicks();
    SetText SetText=new SetText();
    OnScreenKeyboard OnScreenKeyboard=new OnScreenKeyboard();
    String srcLang= JsonReader.getField("source language");
    String tarLang=JsonReader.getField("translation language");
    String url="https://translate.google.com/";
    String initialTxt=(JsonReader.getField("initial text")).toLowerCase();
    String finalTxt=(JsonReader.getField("expected result")).toLowerCase();
    String srcTextArea="//textarea[@aria-label='Source text']";
    String resultArea="//c-wiz[@role='region']/div[@aria-live='polite']/div/div/span[1]/span[1]/span";
    Page page;
    Browser browser;
    Playwright playwright;

    public googleTranslate() throws IOException, ParseException {
    }

    @BeforeSuite
    public void initializeBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500));
        page = browser.newPage();
        Navigate.navigateToPage(page,url);
        SelectLangDD.selectSourceLang(page,srcLang);
        SelectLangDD.selectTargetLang(page,tarLang);
        SetText.setText(page,srcTextArea,initialTxt);
    }
    @Test(priority = 1)
    public void verifyResult(){
        page.waitForSelector(resultArea);
        Locator locator = page.locator(resultArea);
        Assert.assertEquals(locator.textContent().toLowerCase(),finalTxt);
    }
    @Test(priority = 2)
    public void clickSwap() throws IOException, ParseException {
//        String swapBtn="(//c-wiz[@jsrenderer='chbWbf']//div[@jscontroller='HwavCb']//div[3])[1]";
        String swapBtn= JsonReader.getPageObjects("swapBtn");
        clicks.mouseClicks(page,swapBtn);
        String resultPane=JsonReader.getPageObjects("resultArea");
        Locator locator = page.locator(resultPane);
        Assert.assertEquals(locator.textContent().toLowerCase(),initialTxt);
    }
    @Test(priority = 3)
    public void useScreenKeyboard() throws InterruptedException {
        page.fill(srcTextArea,"");
        SelectLangDD.selectTargetLang(page,tarLang);
        String onScreenKeyboard="//a[@aria-label='Show the Input Tools menu']";
        clicks.mouseClicks(page,onScreenKeyboard);
        Locator locator = page.locator("//body//ul//li");
        int count = locator.count();
        for (int i = 0; i < count; ++i)
        {
            if((locator.nth(i).textContent()).equals("US International")){
                locator.nth(i).click();
                break;
            }
        }
        String enterStr="Hi!";
        OnScreenKeyboard.selectKeys(page,enterStr);
        page.waitForSelector("//div[@dir='ltr']//div//div//div");
        clicks.mouseClicks(page,"//div[@dir='ltr']//div//div//div");
//        Locator field = page.locator(resultArea);

    }
    @AfterSuite
    public void closeAll(){
        browser.close();
        playwright.close();
    }

}
