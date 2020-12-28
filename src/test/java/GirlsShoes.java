import org.testng.annotations.Test;

public class GirlsShoes extends Settings{

    @Test
    public void checkPrice(){
        int pageNumber = 1;

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
