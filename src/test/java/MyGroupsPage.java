import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyGroupsPage {
    WebDriver myGroups;

    String MYGROUPSELMENT_XPATH = ".//div[@id='listBlockPanelDetailedUserGroupsListBlock']";

    MyGroupsPage(WebDriver driver){
        this.myGroups = driver;
    }


    public OnlyMyGroupsSubpage getMyGroupsSubpage(){

        return  new OnlyMyGroupsSubpage(myGroups.findElement(By.xpath(MYGROUPSELMENT_XPATH)));
    }

}
