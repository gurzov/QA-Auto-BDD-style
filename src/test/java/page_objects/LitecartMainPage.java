package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

import java.util.List;

public class LitecartMainPage extends AbstractPage{

    @FindBy(className = "tab-content")
    WebElement contentImagesContainer;

    private List<WebElement> getContentImagesContainer() {
        return contentImagesContainer.findElements(By.xpath("//div[contains(@class, 'sticker')]"));
    }

    public LitecartMainPage() {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    public LitecartMainPage open() {
        driver.get("http://localhost/litecart");
        return new LitecartMainPage();
    }

    public boolean listOfImagesWithStickersIsNotEmpty() {
        return !getContentImagesContainer().isEmpty();
    }

    public int listOfImagesWithStickersSize() {
        return getContentImagesContainer().size();
    }

    public boolean campaignPriceIsPresentedForEachSaleSticker() {
        WebElement currentSaleSticker, currentSalePrice;
        List<WebElement> contentCellImagesContainer =
                DriverFactory.getDriver().findElements(By.xpath("//*[@class='product column shadow hover-light']"));
        for (WebElement currentCellImageContainer : contentCellImagesContainer) {
            currentSaleSticker = currentCellImageContainer.findElement(By.xpath("//*[@class='sticker sale']"));
            currentSalePrice = currentCellImageContainer.findElement(By.xpath("//*[@class='campaign-price']"));
            if (!(currentSaleSticker.isDisplayed() && currentSalePrice.isDisplayed())) return false;
        }
        return true;
    }
}
