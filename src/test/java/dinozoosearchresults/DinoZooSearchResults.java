package dinozoosearchresults;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class DinoZooSearchResults {

    @DisplayName("Наличие корма Ontario на сайте DinoZoo")

    @ValueSource(strings = {
            "Ontario сухой корм для привередливых кошек курица",
            "Ontario сухой корм для длинношерстных кошек утка/рыба",
            "Ontario сухой корм для короткошерстных кошек утка/курица",
            "Ontario корм сухой для котят с курицей",
            "Ontario корм сухой для котят с рыбой",
            "Ontario сухой корм для взрослых собак мини пород с курицей и картофелем",
            "Ontario Консервы для собак Курица Фрикасе Ontario Culinary",
            "Ontario сухой корм для стерелизованных кошек с ягненком",
            "Ontario сухой корм для пожилых стерелизованных кошек курица/рыба (7+)",
            "Ontario тунец в бульоне для кошек и котят с 4х мес. пауч 80г",
            "Ontario тунец и лосось в бульоне для кошек и котят с 4х мес. пауч 80г",
            "Ontario паштет из свежего мяса курицы для кошек 90г",
            "Ontario паштет из свежего мяса ягнёнка для кошек 90г",
            "Ontario паштет из свежего мяса тунца для котят 90г",
            "Ontario паштет из свежего мяса лосося для кошек 90г",
            "Ontario паштет из свежего мяса утки для кошек 90г",
            "Ontario кусочки курицы и куриные наггетсы для собак банка 200г",
            "Ontario кусочки курицы и хрящики для щенков банка 200г",
            "Ontario с курицей в бульоне для собак и щенков от 2х мес. пауч 100г",
            "Ontario лакомство вяленый цыплёнок для собак 70г",
            "Ontario лакомство вяленый цыплёнок, сухой 70г",
            "Ontario лакомство вяленый цыплёнок с добавкой кальция для собак 70г"
    }
    )


    @ParameterizedTest (name = "Название корма {0}")
    void dinoTest (String searchCheck) {

        open("https://www.dino-zoo.ru");
        $("#title-search-input").setValue("Ontario").pressEnter();
        $(".catalog-products").shouldHave(text(searchCheck));
        sleep(1000);

    }
}
