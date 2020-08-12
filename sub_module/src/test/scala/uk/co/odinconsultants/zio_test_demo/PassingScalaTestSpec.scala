package uk.co.odinconsultants.zio_test_demo

import org.scalatest.{Matchers, WordSpec}

class PassingScalaTestSpec extends WordSpec with Matchers {

  "11" should {
    "definitely equal 11" in {
      ObjectToTest.eleven shouldBe 11
    }
  }

}
