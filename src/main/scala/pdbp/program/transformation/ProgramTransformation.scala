package pdbp.program.transformation

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

import pdbp.program.Program

private[pdbp] trait ProgramTransformation[`>-F->`[- _, + _]: Program, `>-T->`[- _, + _]] {

  private[pdbp] val implicitProgram = implicitly[Program[`>-F->`]]

  private[pdbp] def transformProgram: `>-F->` ~> `>-T->`

}
