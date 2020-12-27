import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.Collections;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage {

    private ElementsCollection allEl = $$x("//div[@class = 'items-list clearfix']/div");
    private SelenideElement MainitemsName = $x("//h1[@class = 'item-details__title']");
    private SelenideElement filterForGirl = $x("//p[contains(., 'ДЛЯ ДЕВОЧКИ')]/..");
    private SelenideElement filterForBoy = $x("//p[contains(., 'ДЛЯ МАЛЬЧИКА')]/..");
    private SelenideElement showFilter = $x("//button[contains(., 'Показать')]");
    private SelenideElement reserFilterbtn = $x("//div[@class = 'filter__buttons']//a[contains(., 'Сбросить фильтр')]");

    public ElementsCollection getAllEl(){
        assertThat("Колекція пуста", !allEl.isEmpty());
        return allEl;
    }

    public ArrayList<Integer> getRndmNumber(ElementsCollection elCol, int quantity){
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < elCol.size(); i++){
            list.add(i);
        }
        Collections.shuffle(list);
        list.subList(quantity, list.size()).clear();
        return list;
    }

    public String getMainItemsName(){
        return MainitemsName.getText();
    }

    public void resetFilter(){
        reserFilterbtn.shouldBe(Condition.visible).click();
    }

    public void applyFilterGirlsShoes(){
        filterForGirl.$x(".//li[contains(., 'Туфли')]").shouldBe(Condition.visible).click();
        showFilter.shouldBe(Condition.visible).click();
    }

    public void applyFilterBoysDemiSShoes(){
        filterForBoy.$x(".//li[contains(., 'Демисезон')]").shouldBe(Condition.visible).click();
        showFilter.shouldBe(Condition.visible).click();
    }

    public boolean pageExist(int pageNumber){
        SelenideElement page = $x("//nav[@class = 'pager']//li[contains(., '" + pageNumber +"')]");
        if (page.exists()){
            return true;
        }else {
            return false;
        }
    }

    public void goNextPage(int pageNumber){
         SelenideElement page = $x("//nav[@class = 'pager']//li[contains(., '" + pageNumber +"')]");
         page.shouldBe(Condition.visible).click();
    }

    public void checkAllElPrice(){
        String name;
        SelenideElement price;

        ElementsCollection allEl = getAllEl();
        for(SelenideElement el:allEl){
            name = el.$x(".//p[@class = 'item__name']").getText();
            price = el.$x(".//span[@class = 'item__price']");
            assertThat("В данної позиції немає ціни: " + name, !price.exists());
        }
    }


}
