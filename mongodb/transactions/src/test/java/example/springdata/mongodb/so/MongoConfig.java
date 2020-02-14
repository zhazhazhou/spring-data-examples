package example.springdata.mongodb.so;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@SpringBootApplication
public class MongoConfig {

	@Bean
	MongoTransactionManager transactionManager(MongoDbFactory mongoDbFactory) {
		return new MongoTransactionManager(mongoDbFactory);
	}
}
