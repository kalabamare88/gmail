import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class email {


    public static void main(String[] args) throws InterruptedException, IOException {

        File gecko = new File("G:\\seleniumLab\\chromedriver.exe");
        System.setProperty("driver.chrome.driver", gecko.getAbsolutePath());
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");

        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("kalabamare88@gmail.com");

        driver.findElement(By.id("identifierNext")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread.sleep(1000);

        driver.findElement(By.name("password")).sendKeys("password");

        Thread.sleep(1000);


        driver.findElement(By.className("CwaK9")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        Thread.sleep(1000);
        List<WebElement> unread = driver.findElements(By.xpath("//*[@class='zA zE']"));
        System.out.println(unread.size() + " Unread Messages");
        var fileWriter=new FileWriter("UnreadNewMessages.txt");
        for (WebElement message: unread ) {
            System.out.println(message.getText());
            fileWriter.write(message.getText()+"\n");
        }
        fileWriter.close();
    }


}
