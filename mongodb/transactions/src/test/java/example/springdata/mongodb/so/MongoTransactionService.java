package example.springdata.mongodb.so;

import example.springdata.mongodb.so.UserRepo.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MongoTransactionService {

	private final UserRepo userRepo;

	public void boundToFail() throws RuntimeException {
		userRepo.save(User.builder().id("1").build());
		throw new RuntimeException();
	}

}
