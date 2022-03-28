import com.microsoft.playwright.Page;

public class Navigate {
    public void navigateToPage(Page page, String url){
        page.navigate(url);
    }
}
