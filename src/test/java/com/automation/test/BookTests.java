package com.automation.test;

import com.automation.model.User;
import com.automation.page.BookPage;
import com.automation.page.MainPage;
import com.automation.page.SearchResultsPage;
import com.automation.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTests extends CommonConditions {

    @Test
    public void SearchResultsArePresent() {
        SearchResultsPage searchResultsPage = new MainPage(driver)
                .openPage()
                .searchForBook("Преступление и наказание")
                .AssureBooksAreFound();
        Assert.assertTrue(true);
    }

    @Test
    public void LoggedInUserCanSendBookToEmail() {
        User testUser = UserCreator.withCredentialsFromProperty();
        BookPage bookPage = new MainPage(driver)
                .openPage()
                .login(testUser)
                .searchForBook("Преступление и наказание")
                .navigateToBookPage()
                .assureSentBookToEmailIsAvailable();
        Assert.assertTrue(true);
    }

}
