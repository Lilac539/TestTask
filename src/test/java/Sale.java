import com.codeborne.selenide.*;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.*;


public class Sale extends Settings{

    @Test
    public void checkForSale(){

        ArrayList<Integer> rndmElList = new ArrayList<Integer>();
        String name;

        SalePage salePage = new SalePage();
        salePage.goToSalePage();
        ElementsCollection allEl = salePage.getAllElOnPage();
        rndmElList = salePage.getRndmNumber(allEl, 3);//отримуємо рандомні номера елементів
        for(Integer elNumber:rndmElList){
           allEl.get(elNumber).shouldBe(Condition.visible).click();
           if (salePage.checkSalePrice()){
               back();
           }else {
               name = salePage.getItemsName();
               back();
               assertThat("В данної позиції немає акційної ціни: " + name, salePage.checkSalePrice());
           }

        }
    }
}
