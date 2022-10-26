package com.nirari.acc.tests.cars;

import com.nirari.acc.base.BaseTest;
import com.nirari.acc.pages.TMHome;
import com.nirari.acc.pages.TMMotors;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VerifyFerrariSearchResultCount extends BaseTest {

    @Test(description = "Verifies the amount of Ferrari's returned from a search")
    public void verifyFerrariSearchResultCount() {
        given("The TradeMe homepage is open");
            TMHome home = visitor.gotoPage(TMHome.class);

        then("Click the 'Motor' link");
            home.motorLink.click();

        and("From the 'Make' dropdown, select Ferrari and click search");
            TMMotors motors = visitor.gotoPage(TMMotors.class);
            motors.makeSelect.selectItem("Ferrari");
            motors.searchButton.click();

        and("Verify the number of results displayed");
            int resultCount = Integer.parseInt(motors.resultCountLabel.getText().split(" ")[1]
                    .replace(",", ""));
            assertThat(resultCount, equalTo(34)); //Could use less strict assertion, such as n > 0 or n > x
    }
}
