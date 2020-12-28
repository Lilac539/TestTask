import com.codeborne.selenide.Configuration;
import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.codeborne.selenide.Selenide.open;

public class BoysDemiSeasonShoes extends Settings {

    @Test
    public void ckeckProductName(){

        int pageNumber = 1;
        ArrayList<String> listNameNotSneakers = new ArrayList<String>();

        Configuration.startMaximized = true;
        open("https://www.perlinka.ua/index.php/component/virtuemart/view/category/category_id/8/s/rasprodazha");

        BoysDemiSeasonShoesPage boyShoes = new BoysDemiSeasonShoesPage();
        boyShoes.resetFilter();
        boyShoes.applyFilterBoysDemiSShoes();
        while (boyShoes.pageExist(pageNumber)){
            boyShoes.goNextPage(pageNumber);
            listNameNotSneakers.addAll(boyShoes.checkNameToSneakers());
            pageNumber++;
        }
        assertThat("Товари без слова Кроссовки: " + listNameNotSneakers.toString(), listNameNotSneakers.isEmpty());


    }

}
