import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoysDemiSeasonShoes extends Settings {

    @Test
    public void checkProductName(){

        int pageNumber = 1;
        ArrayList<String> listNameNotSneakers = new ArrayList<String>();

        BoysDemiSeasonShoesPage boyShoes = new BoysDemiSeasonShoesPage();
        boyShoes.goToSalePage();
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
