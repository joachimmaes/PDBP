package pdbp.types.active.writing.log.free

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.log.logTypes._

import pdbp.types.active.writing.free.activeWritingWithFreeTypes._ 

object activeLogWritingWithFreeTypes {

  type ActiveLogWritingWithFree = ActiveWritingWithFree[Log]

  type `>-alwf->`= `>-awf->`[Log]

}