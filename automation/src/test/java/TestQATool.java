import framework.Product;
import framework.Questions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQATool {

    static Product oProduct;
    Questions oQuestions;
    WebElement oElem;
    String sQ;

    @BeforeClass
    public static void setUp(){
        oProduct = new Product();
    }

    @Test
    public void testQATool() throws Exception {
        oProduct = new Product();
        s1_launch();
        s2_create_new_q();
        s3_add_more_q();
        s4_sort_q();
        s5_click_q();
        s6_hide_q();
        s7_remove_q();
        s8_close();
    }

    private void s1_launch() throws Exception {
        oProduct.launch();
        oQuestions = new Questions(oProduct);

        //Validate Title and description
        Assert.assertTrue(oQuestions.title().isDisplayed());
        //Validate "Created questions" section
        Assert.assertTrue(oQuestions.created_q_div().isDisplayed());
        //Validate Title
        Assert.assertTrue(oQuestions.created_q_title().isDisplayed());
        //Validate Question´s list
        Assert.assertTrue(oQuestions.created_q_cards().isDisplayed());
        //Validate Sort questions button (should be displayed in blue)
        Assert.assertTrue(oQuestions.created_q_sort().isDisplayed());
        //Validate Remove questions (should be displayed in red)
        Assert.assertTrue(oQuestions.created_q_remove().isDisplayed());
        //Validate "Create a new question" section
        Assert.assertTrue(oQuestions.new_q_div().isDisplayed());
        //Validate title
        Assert.assertTrue(oQuestions.new_q_title().isDisplayed());
        //Validate Question input
        Assert.assertTrue(oQuestions.new_q_question().isDisplayed());
        //Validate Answer input
        Assert.assertTrue(oQuestions.new_q_answer().isDisplayed());
        //Validate Create question button (should be displayed in green)
        Assert.assertTrue(oQuestions.new_q_create_btn().isDisplayed());
    }

    private void s2_create_new_q() throws Exception {
        //Introduce a question
        oQuestions.new_q_question().sendKeys("question1");
        //Introduce an answer
        oQuestions.new_q_answer().sendKeys("answer1");
        //Click on "Create question" button
        oQuestions.new_q_create_btn().click();
        //Validate question was added to the list
        Assert.assertTrue(oQuestions.questionFound("question1"));
    }

    private void s3_add_more_q() throws Exception {
        //Introduce a question3
        oQuestions.new_q_question().sendKeys("question3");
        oQuestions.new_q_answer().sendKeys("answer3");
        oQuestions.new_q_create_btn().click();

        //Introduce a question5
        oQuestions.new_q_question().sendKeys("question5");
        oQuestions.new_q_answer().sendKeys("answer5");
        oQuestions.new_q_create_btn().click();

        //Introduce a question4
        oQuestions.new_q_question().sendKeys("question4");
        oQuestions.new_q_answer().sendKeys("answer4");
        oQuestions.new_q_create_btn().click();

        //Introduce a question2
        oQuestions.new_q_question().sendKeys("question2");
        oQuestions.new_q_answer().sendKeys("answer2");
        oQuestions.new_q_create_btn().click();
    }

    private void s4_sort_q() throws Exception {
        List<String> lstBefore = oQuestions.created_q_card_lst().stream().map(WebElement::getText).toList();
        oQuestions.created_q_sort().click();
        //Validate list is sorted ascending
        List<String> lstCurrent = oQuestions.created_q_card_lst().stream()
                .sorted(Comparator.comparing(WebElement::getText)).toList()
                .stream().map(WebElement::getText).toList();
        Assert.assertNotEquals(lstBefore, lstCurrent);
    }

    private void s5_click_q() throws Exception {
        sQ = "question2";
        oElem = oQuestions.findCard(sQ);
        oElem.click();
        //Validate its answer is displayed
        Assert.assertTrue(oQuestions.isAnswer(sQ, false));
    }

    private void s6_hide_q() throws Exception {
        oElem = oQuestions.findCard(sQ);
        oElem.findElement(new By.ByCssSelector("div")).click();
        //Validate answer is not displayed anymore
        Assert.assertTrue(oQuestions.isAnswer(sQ, true));
    }

    private void s7_remove_q() throws Exception {
        oQuestions.created_q_remove().click();
        //Validate "No questions yet :-(" is displayed
        Assert.assertTrue(oQuestions.created_q_alert().isDisplayed());
    }

    private void s8_close(){
        oProduct.close();
    }
}
