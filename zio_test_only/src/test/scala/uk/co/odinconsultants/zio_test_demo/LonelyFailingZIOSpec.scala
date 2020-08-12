package uk.co.odinconsultants.zio_test_demo

import org.junit.runner.RunWith
import zio.duration._
import zio.test.Assertion.equalTo
import zio.test.TestAspect._
import zio.test.environment.TestEnvironment
import zio.test.junit.{JUnitRunnableSpec, ZTestJUnitRunner}
import zio.test.{ZSpec, assert, suite, testM}

@RunWith(classOf[ZTestJUnitRunner])
class LonelyFailingZIOSpec extends JUnitRunnableSpec {

  override def spec: ZSpec[TestEnvironment, Any] = suite("Note this test won't run as it ends in `Spec` not `Test`")(
    testM("11 != 12, and I damn well know it") {
      for {
        _11 <- ObjectToTest.elevenZIO
      } yield {
        assert(_11)(equalTo(12))
      }
    } @@ timeout(10 seconds)
  )

}
