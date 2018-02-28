package pdbp.computation.transformer.reading.writing.log

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

import pdbp.types.kleisli.kleisliFunctionType._

import pdbp.program.writing.log.LogWriting

import pdbp.computation.Computation

import pdbp.computation.transformer.reading.writing.ReadingWithWritingTransformer

private[pdbp] trait ReadingWithLogWritingTransformer[
  R, M[+ _]: Computation : [M[+ _]] => LogWriting[Kleisli[M]]]
    extends ReadingWithWritingTransformer[R, Log, M]