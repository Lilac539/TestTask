import com.codeborne.selenide.*;
import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.selenide.Selenide.*;

public class SalePage extends MainPage {

    private SelenideElement oldPrice = $x("//span[@class = 'item-details__old-price']");

    public void goToSalePage(){
        $x("//ul[@id = 'menu']//a[contains(., 'РАСПРОДАЖА')]").shouldBe(Condition.visible).click();
    }

    public boolean checkSalePrice() {
        if(oldPrice.exists()){
            return true;
        }
        return false;
    }

}
