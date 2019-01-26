package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import static org.junit.Assert.*;

public class Steps {

    public WebDriver driver;
    HomePage home;

    @Before
    public void beforeScenario(){
        System.setProperty("webdriver.chrome.driver", "C:\\Projetos\\tools\\drivers\\chromedriver.exe");
         this.driver = new ChromeDriver();
         home= new HomePage(driver);
    }

    @After
    public void afterScenario(){
        this.driver.quit();
    }

    @Given("Seleciono a opção saiba mais da especialização")
    public void seleciono_a_opção_saiba_mais_da_especialização() {
        home.especializacaoClickOn();

    }

    @Given("O usuario acessa a url do cesar")
    public void o_usuario_acessa_a_url_do_cesar() {
        this.driver.get("https://www.cesar.school/");

    }

    @When("Seleciono uma especialização")
    public void seleciono_uma_especializacao() {
        home.resultClick();

    }


    @Then("Valido se a especialização selecionada apareceu")
    public void valido_se_a_especializacao_selecionada_apareceu() {
        Assert.assertEquals("Introdução a Testes Ágeis [Manaus]",home.validSearch());

    }

    @Given("na lateral da tela, clicar na categoria especialização")
    public void na_lateral_da_tela_clicar_na_categoria_especialização() {
        home.categoriaEspecializacao();

    }

    @When("No campo de procura,pesquisar pela especialização {string}")
    public void no_campo_de_procura_pesquisar_pela_especialização(String string) {
        home.fieldInSearch(string);
        home.searchClickOn();

    }
}
