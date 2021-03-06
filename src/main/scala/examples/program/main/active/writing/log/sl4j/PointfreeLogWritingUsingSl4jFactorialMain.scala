package examples.program.main.active.writing.log.sl4j

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library
//  author        Luc Duponcheel        2017-2018

import pdbp.types.active.writing.log.activeLogWritingTypes.`>-alw->`

import pdbp.program.implicits.active.writing.log.sl4j.implicits.implicitActiveLogWritingUsingSl4jProgram

import examples.program.FactorialTrait

import examples.program.writing.log.PointfreeLogWritingFactorialTrait

object PointfreeLogWritingFactorialUsingSl4jMain {

  object pointfreeLogWritingFactorialUsingSl4jObject 
    extends PointfreeLogWritingFactorialTrait[`>-alw->`]() 
    with FactorialTrait[`>-alw->`]()

  import pointfreeLogWritingFactorialUsingSl4jObject._

  def main(args: Array[String]): Unit = {    

    executePointfreeLogWritingFactorialProgram

  }

}
