import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import java.util.ArrayList;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;


public class DoubleFilter extends Settings {

    @Test
    public void checkAmountOfElement(){
        open("https://www.perlinka.ua/index.php/component/virtuemart/view/category/category_id/8/s/rasprodazha");

        ArrayList<String> jointFilterSum = new ArrayList<>();//сума товарів окремих фільтрів
        ArrayList<String> separateFilterSum = new ArrayList<>();//сума товарів двох фільтрів разом
        ArrayList<String> outOfFilter = new ArrayList<String>();//товари, які не виявлені в одній з колекцій
        ArrayList<Integer> rndmElList = new ArrayList();
        MainPage mainPage = new MainPage();

        ElementsCollection allFilters = mainPage.getAllFilters();
        rndmElList = mainPage.getRndmNumber(allFilters, 2);//отримуємо два рандомних фільтра

        //-----------заповнюємо колекцію товарами, окремо від кожного фільтра
        for( int filter: rndmElList){
            mainPage.resetFilter();
            allFilters.get(filter).shouldBe(Condition.visible).click();
            mainPage.showFilter();
            separateFilterSum.addAll(mainPage.getAllElOrderNumber());
        }
        //---------заповнюємо колекцію товарами від обох фільтрів разом
        mainPage.resetFilter();
        allFilters.get(rndmElList.get(0)).shouldBe(Condition.visible).click();
        allFilters.get(rndmElList.get(1)).shouldBe(Condition.visible).click();
        mainPage.showFilter();
        jointFilterSum.addAll(mainPage.getAllElOrderNumber());

        jointFilterSum.stream().filter(f-> !separateFilterSum.contains(f)).forEach(s-> outOfFilter.add(s));
        separateFilterSum.stream().filter(f-> !jointFilterSum.contains(f)).forEach(s-> outOfFilter.add(s));
        assertThat("Данні позиції не співпадають: "+ outOfFilter.toString(), outOfFilter.isEmpty());

    }

}
