package pdbp.computation.transformer

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.computation.lifting.LiftingObject

import pdbp.program.Execution

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

private[pdbp] trait NaturalTransformer[D[+ _], U[+ _]] {

  private[pdbp] def liftComputation[Z](dz: D[Z]): U[Z]

}

private[pdbp] trait ComputationTransformer[D[+ _]: LiftingObject: [N[+ _]] => Execution[Kleisli[N]], U[+ _]]
    extends NaturalTransformer[D, U]
    with ProgramTransformer[Kleisli[D], Kleisli[U]]
    with LiftingObject[U] {

  private[pdbp] val implicitLiftingObject = implicitly[LiftingObject[D]]

  private[pdbp] val implicitExecution = implicitly[Execution[Kleisli[D]]]

  override private[pdbp] def liftObject[Z]: Z => U[Z] = { z =>
    liftComputation(implicitLiftingObject.liftObject(z))
  }

  private type `>-D->` = Kleisli[D]

  private type `>-U->` = Kleisli[U]

  override private[pdbp] def liftProgram[Z, Y](
      `z>-d->y`: Z `>-D->` Y): Z `>-U->` Y = { z =>
    liftComputation[Y](`z>-d->y`(z))
  }

}
