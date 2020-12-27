import com.codeborne.selenide.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.*;


public class Sale {

    @Test
    public void checkForSale(){

        ArrayList<Integer> rndmElList = new ArrayList<Integer>();
        Configuration.startMaximized = true;
        open("https://www.perlinka.ua/");

        SalePage salePage = new SalePage();
        salePage.goToSalePage();
        ElementsCollection allEl = salePage.getAllEl();
        rndmElList = salePage.getRndmNumber(allEl, 5);//отримуємо рандомні номера елементів
        for(Integer elNumber:rndmElList){
           allEl.get(elNumber).shouldBe(Condition.visible).click();
           assertThat("В данної позиції немає акційної ціни: " + salePage.getMainItemsName(), salePage.checkSalePrice());
           back();
       }
       System.out.println(rndmElList.toString());
    }
}
