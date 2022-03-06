package bikefind.casestudy.Ujwal.Pradhan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "bikefind.casestudy.Ujwal.Pradhan.database")
public class DatabaseConfig {

}
