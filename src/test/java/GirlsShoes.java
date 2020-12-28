import com.codeborne.selenide.*;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;

public class GirlsShoes extends Settings{

    @Test
    public void checkPrice(){
        int pageNumber = 1;

        Configuration.startMaximized = true;
        open("https://www.perlinka.ua/index.php/component/virtuemart/view/category/category_id/8/s/rasprodazha");

        MainPage girlsShoes = new MainPage();
        girlsShoes.resetFilter();
        girlsShoes.applyFilterGirlsShoes();
        while (girlsShoes.pageExist(pageNumber)){
            girlsShoes.goNextPage(pageNumber);
            girlsShoes.checkAllElPrice();
            pageNumber++;
        }
    }
}
