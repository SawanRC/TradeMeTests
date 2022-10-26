package com.nirari.acc.make;

import com.nirari.acc.base.BaseTest;
import com.nirari.acc.pages.TMHome;
import com.nirari.acc.pages.TMMotors;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class VerifyMakeCount extends BaseTest {


    @Test(description = "Verifies the amount of makes on the TradeMe motor page")
    public void Test() {
        given("The TradeMe homepage is open");
            TMHome home = visitor.gotoPage(TMHome.class);

        then("Click the 'Motor' link on the navigation menu");
            home.motorLink.click();

        then("Under the 'Make' dropdown, count number of options (excluding 'Any make' and 'Other')");
            TMMotors motorsPage = visitor.gotoPage(TMMotors.class);
            List<String> makes = motorsPage.makeSelect.getAvailableItems();
            makes.remove("Any make");
            makes.remove("Other");

        and("Assert that number of makes equals 77");
            assertThat(makes.size(), equalTo(77));
    }
}
