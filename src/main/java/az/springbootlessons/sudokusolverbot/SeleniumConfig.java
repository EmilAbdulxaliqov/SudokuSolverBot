package az.springbootlessons.sudokusolverbot;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {
    @Bean
    public ChromeDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
