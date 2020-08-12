package uk.co.odinconsultants.zio_test_demo

import zio.duration._
import zio.test.Assertion.equalTo
import zio.test.TestAspect._
import zio.test.environment.TestEnvironment
import zio.test.junit.JUnitRunnableSpec
import zio.test.{ZSpec, assert, suite, testM}

class Test2Spec extends JUnitRunnableSpec  {

  override def spec: ZSpec[TestEnvironment, Any] = suite("Naughty test")(
    testM("11 != 12, and I damn well know it") {
      for {
        _11 <- ObjectToTest.eleven
      } yield {
        assert(_11)(equalTo(12))
      }
    } @@ timeout(10 seconds)
  )

}
