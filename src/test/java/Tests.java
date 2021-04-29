import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Tests extends BaseTest{


    String username = "79267612747";
    String password = "";

    String groupHREF = null;
    String subGroup = "automoto";

    List<CardElement> groupList;


    @Test
    public void start(){

        UserPage userPage = new LoginPage(this.driver).logIn(username, password);
        GroupPage group = userPage.moveToGroups();

        group.selectCategory(subGroup); //need to wait



        groupList = group.getGroupsList();

        Assert.assertTrue("Cards not found", groupList.size() != 0);

        for(CardElement card : groupList){
            Assert.assertTrue("Image not loaded", card.imgExist(driver));
        }


        //Попытка вступить в группу, для дальнейшей проверки, что группа появилась на странице "мои группы"
        //нужен униукальный идентификатор, например - ссылка на группу.
        //Нужно добавить проверку на то, что бот не состоит в данной группе
        groupHREF = groupList.get(0).addGroup();


        Assert.assertTrue("Group not in My Groups",
                group.selectMyGroups()
                        .getMyGroupsSubpage()
                        .findGroupByHref(groupHREF));




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
