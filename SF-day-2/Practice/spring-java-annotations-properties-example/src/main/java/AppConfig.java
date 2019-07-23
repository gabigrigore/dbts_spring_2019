import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"ro.dbts"})
@PropertySource("app.properties")
public class AppConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer getPropertySourcePlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
