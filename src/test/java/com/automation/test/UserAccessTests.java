package com.automation.test;

import com.automation.model.User;
import com.automation.page.MainPage;
import com.automation.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAccessTests extends CommonConditions {
    @Test
    public void OneCanLoginFlibusta() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(loggedInUserName, testUser.getUsername());
    }
}
