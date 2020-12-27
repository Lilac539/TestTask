import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.ArrayList;


public class BoysDemiSeasonShoesPage extends MainPage {

    String name;
    MainPage mainPage = new MainPage();
    ArrayList<String> elName = new ArrayList<String>();


    public ArrayList<String> checkNameToSneakers(){

        ElementsCollection allEl = mainPage.getAllEl();
        for(SelenideElement el:allEl){
            name = el.$x(".//p[@class = 'item__name']").getText().toLowerCase();
            if (!name.contains("кроссовки")){
                elName.add(el.$x(".//span[@class = 'item__order-number']").getText());
            }
        }
        return elName;
    }

}
