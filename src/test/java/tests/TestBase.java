package tests;

import extensions.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    public void setup() {
        Driver.init();
    }

    @AfterEach
    public void teardown() {
        Driver.quit();
    }
}
