package headHunterSearchResultsWithExceptionShouldHaveAnyResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HeadHunterSearchResultsWithExceptionShouldHaveAnyResults {

    @DisplayName("Поиск работы, исключение результатов выдачи слов")

    @CsvFileSource (resources = "/Annotation_2.csv")

    @ParameterizedTest (name = "Вставляем в поиск {0} исключаем {1}")

    void workSearchTest (String prof, String wordExclude) {

        open("https://hh.kz/?hhtmFrom=vacancy_search_list");
        $("[data-qa=search-input]").setValue(prof).pressEnter();
        $("[data-qa=novafilters-excluded-text-input]").setValue(wordExclude).pressEnter();

        sleep(2000);

        $("[data-qa=vacancies-search-header]").shouldNotHave(text("ничего не найдено"));
    }
}
