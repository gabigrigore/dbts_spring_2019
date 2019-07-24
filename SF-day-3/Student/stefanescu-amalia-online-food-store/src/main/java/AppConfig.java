import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import store.model.Order;

@Configuration
@ComponentScan({"store"})
public class AppConfig {

    @Bean(name = "specialOrder")
    public Order specialOrder() {
        Order o = new Order();
        o.setId(1);
        o.setName("Order");
        return o;
    }
}
