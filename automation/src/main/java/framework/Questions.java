package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Questions {

    Product oProduct;

    public Questions(Product pProduct){
        oProduct = pProduct;
    }

    //region Title
    public WebElement title() throws Exception{
        String sCss = "header[class='header']";
        return oProduct.findElement(new By.ByCssSelector(sCss));
    }

    public WebElement description() throws Exception{
        String sCss = "div[class='col-md-3']";
        return oProduct.findElement(new By.ByCssSelector(sCss));
    }

    //endregion

    //region Created questions
    public WebElement created_q_div() throws Exception{
        String sCss = "div[class='questions']";
        return oProduct.findElement(new By.ByCssSelector(sCss));
    }

    public WebElement created_q_title() throws Exception{
        String sCss = "div[class='tooltipped-title']";
        return created_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement created_q_alert() throws Exception{
        String sCss = "div[class='alert alert-danger']";
        return created_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement created_q_sort() throws Exception{
        String sCss = "button[class='btn btn-primary']";
        return created_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement created_q_remove() throws Exception{
        String sCss = "button[class='btn btn-danger']";
        return created_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement created_q_cards() throws Exception{
        String sCss = "div[class='card']";
        return created_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public List<WebElement> created_q_card_lst() throws Exception{
        String sCss = "li[class='list-group-item question']";
        return created_q_cards().findElements(new By.ByCssSelector(sCss));
    }

    public WebElement findCard(String pQuestion) throws Exception {
        return created_q_card_lst().stream().filter(x -> x.getText().contains(pQuestion)).findFirst().get();
    }

    public boolean questionFound(String pQuestion) throws Exception {
        return findCard(pQuestion).getText().contains(pQuestion);
    }

    public boolean isAnswer(String pQuestion, boolean pHide) {
        try{
            String sCss = "p[class='question__answer ']";
            if (pHide)
                sCss = "p[class='question__answer hidden-xl-down']";
            WebElement oElem = findCard(pQuestion);
            WebElement oAnswer = oElem.findElement(new By.ByCssSelector(sCss));
            return pHide ? !oAnswer.isDisplayed() : oAnswer.isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }

    //endregion

    //region Create a new question
    public WebElement new_q_div() throws Exception{
        String sCss = "div[class='question-maker']";
        return oProduct.driver.findElement(new By.ByCssSelector(sCss));
    }

    public WebElement new_q_title() throws Exception{
        String sCss = "div[class='tooltipped-title']";
        return new_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement new_q_form() throws Exception{
        String sCss = "form[class='form']";
        return new_q_div().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement new_q_question() throws Exception{
        String sCss = "input[id='question']";
        return new_q_form().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement new_q_answer() throws Exception{
        String sCss = "textarea[id='answer']";
        return new_q_form().findElement(new By.ByCssSelector(sCss));
    }

    public WebElement new_q_create_btn() throws Exception{
        String sCss = "button[class='btn btn-success']";
        return new_q_form().findElement(new By.ByCssSelector(sCss));
    }
    //endregion

}
