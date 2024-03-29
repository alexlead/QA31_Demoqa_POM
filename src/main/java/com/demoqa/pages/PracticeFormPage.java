package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.CompletionService;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String name, String lastname,
                                              String email, String phone) {
        type(firstName,name);
        type(lastName,lastname);
        type(userEmail,email);
        type(userNumber,phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND,"a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL,"a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubjects(String[] subject) {
        for (int i = 0; i < subject.length; i++) {
            if (subject[i] != null) {
                type(subjectsInput,subject[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;
    public PracticeFormPage selectHobby(String[] hobby) {
        for (int i = 0; i < hobby.length; i++) {


            if (hobby[i].equals("Sports")) {
                click(sports);
            } if (hobby[i].equals("Reading")) {
                click(reading);
            } if (hobby[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }
@FindBy(id="state")
    WebElement stateContainer;
    @FindBy(id="react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String state) {
        clickWithJS(stateContainer, 0, 300);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }
@FindBy(id="city")
    WebElement cityContainer;
    @FindBy(id="react-select-4-input")
    WebElement cityInput;


    public  PracticeFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);

        return this;
    }

@FindBy(id="submit")
    WebElement submitButton;

    public PracticeFormPage submit() {
        click(submitButton);
        return this;
//        clickWithJS(submitButton, 0, 300);
    }

    @FindBy(id="example-modal-sizes-title-lg")
    WebElement modalWindowTitle;
    public PracticeFormPage verifyStudentFormTitle(String title) {
        Assert.assertTrue(modalWindowTitle.getText().contains(title));
        return this;
    }
}
