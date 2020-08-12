package uk.co.odinconsultants.zio_test_demo

import org.scalatest.{Matchers, WordSpec}

class FailingScalaTestSpec extends WordSpec with Matchers {

  "11" should {
    "cause the build to stop if we assert it equals 12" ignore {
      ObjectToTest.eleven shouldBe 12
    }
  }

}
