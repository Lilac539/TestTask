import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;


public class BoysDemiSeasonShoesPage extends MainPage {

    public ArrayList<String> checkNameToSneakers(){

        String name;
        MainPage mainPage = new MainPage();
        ArrayList<String> elName = new ArrayList<String>();

        ElementsCollection allEl = mainPage.getAllElOnPage();
        for(SelenideElement el:allEl){
            name = el.$x(".//p[@class = 'item__name']").getText().toLowerCase();
            if (!name.contains("кроссовки")){
                elName.add(el.$x(".//span[@class = 'item__order-number']").getText());
            }
        }
        return elName;
    }

}
