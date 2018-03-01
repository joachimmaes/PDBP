package pdbp.program.instances.active.writing

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library

import pdbp.types.active.activeTypes._

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.program.transformer.ProgramTransformer

import pdbp.computation.transformer.NaturalComputationTransformer

import pdbp.computation.transformer.writing.WritingTransformer

import pdbp.program.implicits.active.implicits.implicitActiveProgram

trait ActiveWritingProgram[W]
    extends Computation[ActiveWriting[W]]
    with Program[`>-aw->`[W]]
    with ProgramTransformer[`>-a->`, `>-aw->`[W]]
    with NaturalComputationTransformer[Active, ActiveWriting[W]]
    with WritingTransformer[W, Active]

