package uk.co.odinconsultants.zio_test_demo

import zio.{Task, ZIO}

object ObjectToTest {

  type ApiType = Task[Int]

  def eleven: ApiType = ZIO { 11 }

}
