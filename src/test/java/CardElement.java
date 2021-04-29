import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardElement {

    WebElement card;

    String IMAGE_XPATH = ".//img[contains(@class,\"photo_img\")]";
    String ADDGROUP_XPATH = ".//a[text()='Вступить']";
    String GROUPNAME_XPATH = ".//a[@data-l='t,visit']";


    CardElement(WebElement card){
        this.card = card;
    }


    public boolean imgExist(WebDriver driver){
        return  ExistChecker.checkExist(card, IMAGE_XPATH);
    }

    public String addGroup(){
        //user should not be in group
        card.findElement(By.xpath(ADDGROUP_XPATH)).click();

        String groupHREF = card.findElement(By.xpath(GROUPNAME_XPATH)).getAttribute("href");
        return groupHREF.substring(groupHREF.lastIndexOf('/'));
    }

}
