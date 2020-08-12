package uk.co.odinconsultants.zio_test_demo

import zio.duration._
import zio.test.Assertion.equalTo
import zio.test.TestAspect._
import zio.test.environment.TestEnvironment
import zio.test.junit.JUnitRunnableSpec
import zio.test.{ZSpec, assert, suite, testM}

//@RunWith(classOf[ZTestJUnitRunner])
class Test1Spec extends JUnitRunnableSpec  {

    override def spec: ZSpec[TestEnvironment, Any] = suite("Processing files (good, empty and non-existent)")(
      testM("should collect errors") {

        for {
          _11 <- ObjectToTest.eleven
        } yield {
          assert(_11)(equalTo(11))
        }
      } @@ timeout(10 seconds)
    )
}
