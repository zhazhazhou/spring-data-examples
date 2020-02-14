package example.springdata.mongodb.so;

import static org.assertj.core.api.Assertions.*;

import example.springdata.mongodb.so.UserRepo.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@DataMongoTest(
		includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MongoTransactionService.class))
@ImportAutoConfiguration(TransactionAutoConfiguration.class)
class MongoTransactionServiceTest {

	@Autowired UserRepo userRepo;
	@Autowired MongoTransactionService mongoTransactionService;

	@Test
	void testTransactional() {
		try {
			mongoTransactionService.boundToFail();
		} catch (Exception e) {
			// do something
		}
		User user = userRepo.findById("1").orElse(null);
		assertThat(user).isNull();
	}
}
