import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testyselenium {

    private WebDriver driver;


    // tag before oznacza, że setup() wykona się przed testem
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }
    //quit() - wychodzenie z przeglądarki
    // taka metoda zawsze powinna być na końcu kazdego tekstu
    // tag after oznacza ze wykona sie po tescie

    @After
    public void tearDown() {
        driver.quit();
    }

    @Ignore
    @Test
    public void dodanieTekstuDoInitial() throws InterruptedException {
        //get otwiera nam strone internetową
        driver.get("http://executeautomation.com/demosite/index.html");
        // Do wyszukiwania elementów służy metoda findElement
        WebElement initial = driver.findElement(By.id("Initial"));
        // sendKeys wstawia elementy do txtboxa-(pole do wpisywania)
        initial.sendKeys("Test");
        Thread.sleep(3000);

    }

    @Ignore
    @Test
    public void WstawImieINazwisko() throws InterruptedException {
        driver.get("http://executeautomation.com/demosite/index.html");
        // krok 1 wstaw tekst do first name
        WebElement imie = driver.findElement(By.id("FirstName"));
        imie.sendKeys("Imie");
        Thread.sleep(3000);
        //krok 2 wstaw tekst do middle name
        WebElement nazwisko = driver.findElement(By.id("MiddleName"));
        nazwisko.sendKeys("Nazwisko");

    }

    @Ignore
    @Test
    public void Zaznaczcheckbox() throws InterruptedException {
        driver.get("http://executeautomation.com/demosite/index.html");
        // krok 1  odznacz checkbox english
        // najpierw szukamy element englishcheckbox
        WebElement checkboxEnglish = driver.findElement(By.name("english"));
        //odznaczamy element
        checkboxEnglish.click();
        Thread.sleep(3000);
        // krok 2 zaznacz checkbox hindi
        WebElement checkboxHindi = driver.findElement(By.name("Hindi"));
        //zaznaczamy checkbox hindi
        checkboxHindi.click();
        Thread.sleep(3000);


    }

    @Ignore
    @Test
    public void TestStrony() throws InterruptedException {

        driver.get("newtours.demoaut.com/index.php");
        WebElement name = driver.findElement(By.name("userName"));
        name.sendKeys("test");
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1234");
        Thread.sleep(3000);


    }

    @Ignore
    @Test

    public void dropDown() throws InterruptedException {

        // dropdown - rozwijana lista
        // dropdown = select
        driver.get("http://executeautomation.com/demosite/index.html");
        // polaczemoe do selecta na stronie internetowej
        Select dropdown = new Select(driver.findElement(By.id("TitleId")));
        // wybieramy konkretny tekst z naszego selecta
        //dropdown.deselectByVisibleText("Mr."); - powinno byc bez komentarza!!!
        //wybieramy tekst za pomoca numeru index
        //dropdown.selectByIndex(1); - bez komentarza!!!
        dropdown.selectByValue("1");
        Thread.sleep(3000);


    }

    @Ignore
    @Test
    public void wieokrotnywybor() throws InterruptedException {
        driver.get("http://output.jsbin.com/osebed/2");
        // stworzyc element selecta
        // wybrac cos po value
        // wybrac cos po visible
        Select dropdown = new Select(driver.findElement(By.id("fruits")));
        dropdown.selectByValue("orange");
        Thread.sleep(3000);
        dropdown.selectByVisibleText("Grape");
        Thread.sleep(3000);

    }

    @Ignore
    @Test
    public void link_Test() throws InterruptedException {

        driver.get("http://executeautomation.com/demosite/index.html");
        // znalezlismy element ktory jest podlinkowany, jest to jedno słowo
        WebElement linkText = driver.findElement(By.linkText("HtmlPopup"));
        // A nastepnie kliknelismy w ten element
        linkText.click();
        Thread.sleep(3000);

    }

    @Ignore
    @Test
    public void partial_link() throws InterruptedException {

        driver.get("http://newtours.demoaut.com/index.php");
        // tworzymy element partial link
        WebElement partiallink = driver.findElement(By.partialLinkText("SIGN"));
        //klikamy w partial link
        partiallink.click();
        Thread.sleep(3000);

    }

    @Ignore
    @Test
    public void alert_Accepted() throws InterruptedException {

        driver.get("http://executeautomation.com/demosite/index.html");
        // Musimy stworzyć element dla buttona Generate
        WebElement buttonGenerate = driver.findElement(By.name("generate"));
        // Klikamy na button
        buttonGenerate.click();
        Thread.sleep(3000);
        // Musimy sie przelaczyc na alert
        Alert alertElement = driver.switchTo().alert();
        // chcemy kliknac OK na alercie
        alertElement.accept();
        //chcemy zaakcepyowac nastepnego alerta
        alertElement.accept();
        Thread.sleep(3000);


    }
    @Ignore
    @Test
    public void alert_Dismiss() throws InterruptedException {

        driver.get("http://executeautomation.com/demosite/index.html");
        // Musimy stworzyć element dla buttona Generate
        WebElement buttonGenerate = driver.findElement(By.name("generate"));
        // Klikamy na button
        buttonGenerate.click();
        Thread.sleep(3000);
        // Musimy sie przelaczyc na alert
        Alert alertElement = driver.switchTo().alert();
        // chcemy kliknac OK na alercie
        alertElement.dismiss();
        //chcemy zaakcepyowac nastepnego alerta
        alertElement.accept();
        Thread.sleep(3000);


    }
    @Ignore
    @Test
    public void radio_Buttonu() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/radio.html");
        //stworzmy 3 elementy (radio buttony)
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radio3 = driver.findElement(By.id("vfb-7-3"));
        // Chcemy kliknac na radio3 a potem na radio 2
        radio3.click();
        Thread.sleep(3000);
        radio2.click();
        Thread.sleep(3000);

    }

    @Test
    public void wyczysc_okno() throws InterruptedException {

        driver.get("http://executeautomation.com/demosite/index.html");
        //stworz dwa elementy dla initial i first name
        WebElement initial = driver.findElement(By.id("Initial"));
        WebElement firstname = driver.findElement(By.id("FirstName"));
        // wstaw tekst do tych elementów
        initial.sendKeys("Tekst");
        firstname.sendKeys("tekst");
        Thread.sleep(3000);
        // wyczysc te dwa textBoxy
        initial.clear();
        firstname.clear();
        Thread.sleep(3000);

    }


}