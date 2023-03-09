package Annotation3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class Annotation3 extends BasicClass {
    static Stream<Arguments> methodSourceExampleTest() {
        return Stream.of(
                Arguments.of("Elena", "Semenova", "kochkurova.en@gmail.com", "9829306853", "Russia",
                        "English", "Haryana", "Karnal", "Music", "Female", "fdf.jpg", "30 November,1995", "30", "November", "1995"),

                Arguments.of("Valeriy", "Karpov", "123123@mail.ru", "9859656565", "Kazakhstan", "Chemistry",
                        "NCR", "Delhi", "Sports", "Male", "ftf.jpg", "11 May,1988", "11", "May", "1988"),

                Arguments.of("Svetlana", "Krasnova", "545454@mail.ru", "9565655656", "America", "Economics",
                        "Uttar Pradesh", "Agra", "Reading", "Other", "dsd.jpg", "15 April,1999", "15", "April", "1999")
        );

    }

    PageObjects megaClass = new PageObjects();

    @DisplayName("Заполнение формы demoqa")

    @MethodSource("methodSourceExampleTest")


    @ParameterizedTest(name = "Заполняем форму тестовыми данными {1} {0}")

    void homework(String firstName, String lastName, String userEmail, String userNumber, String currentAddress,
                  String subjectsInput, String state, String city, String hobbies, String gender, String pictureName,
                  String dateOfBirth, String day, String month, String year) {


        megaClass.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)
                .setSubjectsInput(subjectsInput)
                .setState(state)
                .setCity(city)
                .setGender(gender)
                .setHobbies(hobbies)
                .setPicture(pictureName)
                .setBirthDate(month, year, day)
                .pressSubmit();


        megaClass.checkData("Student Name", firstName + " " + lastName)
                .checkData("Student Email", userEmail)
                .checkData("Gender", gender)
                .checkData("Mobile", userNumber)
                .checkData("Date of Birth", dateOfBirth)
                .checkData("Subjects", subjectsInput)
                .checkData("Hobbies", hobbies)
                .checkData("Picture", pictureName)
                .checkData("Address", currentAddress)
                .checkData("State and City", state + " " + city);
    }
}
