package pdbp.computation.transformation.reading

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

import pdbp.types.implicitFunctionType.`I=>`

private[pdbp] object readingTransformation {

  type ReadingTransformed = [R, M[+ _]] => [+Z] => (R `I=>` M[Z])

}

import readingTransformation._

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.utils.productUtils._

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.program.transformation.ProgramTransformation

import pdbp.computation.transformation.~>

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait ReadingTransformation[R, M[+ _]: Computation]
    extends Computation[ReadingTransformed[R, M]]
    with Program[Kleisli[ReadingTransformed[R, M]]]
    with Reading[R, Kleisli[ReadingTransformed[R, M]]]
    with ComputationTransformation[M, ReadingTransformed[R, M]] 
    with ProgramTransformation[Kleisli[M], Kleisli[ReadingTransformed[R, M]]] {

  private type RTM = ReadingTransformed[R, M]

  override private[pdbp] def transformComputation = new (M ~> RTM) {
    override private[pdbp] def apply[Z](mz: M[Z]): RTM[Z] = 
      sys.error(
        "Impossible, since, for 'ReadingTransformation', 'transformComputation' is used nowhere")  
  }      

  private[pdbp] val implicitComputation = implicitly[Computation[M]]

  import implicitComputation.{result => resultM}
  import implicitComputation.{bind => bindM}

  override private[pdbp] def result[Z]: Z => RTM[Z] = { z =>
     resultM(z)
  }

  override private[pdbp] def bind[Z, Y](rtmz: RTM[Z], `z>=rtmy`: Z => RTM[Y]): RTM[Y] =
    bindM(rtmz, { z => `z>=rtmy`(z) })

  private type `>=RTK=>` = Kleisli[RTM]   
        
  import implicitProgram.{Environment => EnvironmentK}
  import implicitProgram.{execute => executeK}

  override type Environment = EnvironmentK && R

  override def execute(`u>=rtk=>u`: Unit `>=RTK=>` Unit): Environment `I=>` Unit = { implicit environment =>
    implicit val environmentK: EnvironmentK = environment._1
    implicit val r: R = environment._2
    executeK { u => `u>=rtk=>u`(u) }
  }

  override def `u>-->r`: Unit `>=RTK=>` R = { _ =>
    resultM(implicitly) 
  }  

}
