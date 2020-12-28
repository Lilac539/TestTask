import com.codeborne.selenide.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.*;


public class Sale{

    @Test
    public void checkForSale(){

        ArrayList<Integer> rndmElList = new ArrayList<Integer>();
        open("https://www.perlinka.ua/");

        SalePage salePage = new SalePage();
        salePage.goToSalePage();
        ElementsCollection allEl = salePage.getAllElOnPage();
        rndmElList = salePage.getRndmNumber(allEl, 3);//отримуємо рандомні номера елементів
        for(Integer elNumber:rndmElList){
           allEl.get(elNumber).shouldBe(Condition.visible).click();
           assertThat("В данної позиції немає акційної ціни: " + salePage.getItemsName(), salePage.checkSalePrice());
           back();
        }
    }
}
