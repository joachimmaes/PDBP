package examples.program.writing.log

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

import pdbp.types.log.logTypes._

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.program.writing.log.Logging

import examples.program.FactorialTrait

trait PointfulLoggingFactorialTrait
   [>-->[- _, + _]: Program : [>-->[- _, + _]] => Logging[>-->]]
     extends FactorialTrait[>-->] {

  import implicitProgram._

  val implicitLogging = implicitly[Logging[>-->]]

  import implicitLogging._  

  import pdbp.program.compositionOperator._

  import pdbp.utils.productUtils._

  import examples.utils.functionUtils._

  override val isPositive: BigInt >--> Boolean =
    infoFunction("isPositive")(isPositiveFunction)

  override val subtractOne: BigInt >--> BigInt =
    infoFunction("subtractOne")(subtractOneFunction)

  override val multiply: (BigInt && BigInt) >--> BigInt =
    infoFunction("multiply")(multiplyFunction)

  override def one[Z]: Z >--> BigInt =
    infoFunction("one")(oneFunction)  

  def pointfulLoggingFactorial: BigInt >--> BigInt =
    info("factorial") {
      `if`(isPositive) {
        `let` {
          subtractOne >-->
            pointfulLoggingFactorial  
        } `in`
          multiply
      } `else` {
        one
      } 
    }

  val pointfulLoggingFactorialProgram: Unit >--> Unit =
    producer >-->
      pointfulLoggingFactorial >-->
      consumer

  def executePointfulLoggingFactorialProgram: Unit =
    execute(pointfulLoggingFactorialProgram)     

}
