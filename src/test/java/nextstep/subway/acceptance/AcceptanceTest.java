package nextstep.subway.acceptance;

import static nextstep.subway.acceptance.MemberSteps.*;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import nextstep.subway.utils.DataLoader;
import nextstep.subway.utils.DatabaseCleanup;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceTest {
	public static final String EMAIL = "admin@email.com";
	public static final String PASSWORD = "password";
	String 관리자;
	@Autowired
	private DatabaseCleanup databaseCleanup;
	@Autowired
	private DataLoader dataLoader;

	@BeforeEach
	public void setUp() {
		databaseCleanup.execute();
		dataLoader.loadData();

		관리자 = 베어러_인증_로그인_요청(EMAIL, PASSWORD).jsonPath().getString("accessToken");
	}
}
