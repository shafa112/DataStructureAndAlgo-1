package batman_test.logger;

public class Test {

	private void psvm() {
		Logger logger = LoggerFactory.getLogger(Test.class.getName());
		logger.logInfo("Hello logger");
	}
}
