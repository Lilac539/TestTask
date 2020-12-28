import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;

public class Settings {
    static {
        Configuration.startMaximized = true;
        open("https://www.perlinka.ua/");
    }
}
