import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class SalePage extends MainPage {

    public boolean checkSalePrice() {

        SelenideElement oldPrice = $x("//span[@class = 'item-details__old-price']");

        if(oldPrice.exists()){
            return true;
        }
        return false;
    }

}
