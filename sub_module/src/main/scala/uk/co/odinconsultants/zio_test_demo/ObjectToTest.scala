package uk.co.odinconsultants.zio_test_demo

import zio.{Task, ZIO}

object ObjectToTest {

  def eleven: Int = 11

  def elevenZIO: Task[Int] = ZIO { eleven }

}
