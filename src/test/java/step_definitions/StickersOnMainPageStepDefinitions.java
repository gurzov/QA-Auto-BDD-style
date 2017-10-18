package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import page_objects.LitecartMainPage;
import utils.DriverFactory;

public class StickersOnMainPageStepDefinitions {

    @When("I open Litecart main page")
    public void openLitecartMainPage() {
        new LitecartMainPage().open();
    }

    @Then("I make sure that at least one duck image with any sticker should be present")
        public void findImagesWithStickersOnMainPage() {
            Assert.assertTrue(new LitecartMainPage().listOfImagesWithStickersIsNotEmpty());
        }

    @Then("I make sure that more than one duck image has a sale sticker")
        public void checkCountOfImagesWithStikersOnMainPage() {
            Assert.assertTrue(new LitecartMainPage().listOfImagesWithStickersSize() > 1);
        }

    @Then("I make sure that sale price is shown for image with sale sticker")
        public void checkAllSaleStickersShowSalePrice() {
            Assert.assertTrue(new LitecartMainPage().campaignPriceIsPresentedForEachSaleSticker());
        }

    @After
        public void tearDown() {
            DriverFactory.shutDown();
        }
}
