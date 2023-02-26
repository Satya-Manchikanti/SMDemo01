import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.util.List;

public class SauceDemoTest {

    public static void main(String[] args) {

        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "provide path for chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the demo website
        driver.get("https://www.saucedemo.com/");

        // Login using the provided details
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
hg
        // Find all products and their prices
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        // Find the index of the highest priced product
        int highestPriceIndex = 0;
        double highestPrice = 0;
        for (int i = 0; i < prices.size(); i++) {
            String priceString = prices.get(i).getText().substring(1);
            double price = Double.parseDouble(priceString);
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceIndex = i;
            }
        }

        // Click on the highest priced product's "Add to cart" button
        WebElement addToCartButton = products.get(highestPriceIndex)
                .findElement(By.cssSelector("button.btn_inventory"));
        addToCartButton.click();

        // Close the browser
        driver.quit();
    }
}
