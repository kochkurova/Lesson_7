package fillformdemoqatest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObjects {
    private final String titleText = "Student Registration Form";
    public PageObjects openPage () {
        open("/automation-practice-form");
        $(".practice-form-wrapper h5").shouldHave(text(titleText));
        return this;
    }


    public PageObjects setFirstName (String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PageObjects setLastName (String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PageObjects setUserEmail (String userEmail) {
        $("#userEmail").setValue(userEmail);
        return this;
    }

    public PageObjects setUserNumber (String userNumber) {
        $("#userNumber").setValue(userNumber);
        return this;
    }

    public PageObjects setCurrentAddress (String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public PageObjects setSubjectsInput (String subjectsInput) {
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        return this;
    }

    public PageObjects setState (String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public PageObjects setCity (String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public PageObjects setGender (String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public PageObjects setHobbies (String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        return this;
    }

    public PageObjects setPicture (String picturename) {
        $("#uploadPicture").uploadFromClasspath(picturename);
        return this;
    }

    public PageObjects checkData (String firstColumn, String secondColumn) {
        $(".modal-body").$(byText(firstColumn)).sibling(0)
                .shouldHave(text(secondColumn));
        return this;

    }

    public PageObjects pressSubmit () {
        $("#submit").pressEnter();
        return this;
    }

    public PageObjects setBirthDate (String month, String year, String dayInput) {
        String day = ".react-datepicker__day--0" + dayInput;
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month")
                .$(day + ":not(.react-datepicker__day--outside-month)").click();
        return this;

    }

























































}
