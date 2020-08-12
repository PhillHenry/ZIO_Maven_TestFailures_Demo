package uk.co.odinconsultants.zio_test_demo

import org.junit.runner.RunWith
import zio.duration._
import zio.test.Assertion.equalTo
import zio.test.TestAspect._
import zio.test.environment.TestEnvironment
import zio.test.junit.{JUnitRunnableSpec, ZTestJUnitRunner}
import zio.test.{ZSpec, assert, suite, testM}

@RunWith(classOf[ZTestJUnitRunner])
class PassingZIOTest extends JUnitRunnableSpec {

  override def spec: ZSpec[TestEnvironment, Any] = suite("Sweetness and light test")(
    testM("11 == 11 as every one knows") {
      for {
        _11 <- ObjectToTest.elevenZIO
      } yield {
        assert(_11)(equalTo(11))
      }
    } @@ timeout(10 seconds)
  )

}
