# Exercises

Short tasks designed to map to C/C++/C# experience while practicing idiomatic Scala.

## Core syntax
- Write a function `clamp(x, lo, hi)` using expression‑style Scala.
- Implement `swap` for a tuple; return a new tuple.
- Convert a `for` loop that filters and maps into a for‑comprehension.

## Types and collections
- Implement `distinctPreserveOrder` for a `Seq[Int]`.
- Write `groupByLength` for `List[String]`.
- Create an enum `Result` with `Ok(value)` and `Err(msg)`.

## Functional patterns
- Parse `String` to `Int` returning `Option[Int]`.
- Implement `sequence` for `List[Option[A]]`.
- Implement `map2` for `Option[A]` and `Option[B]`.

## OO Scala
- Create a trait `Loggable` with a default method; mix it into a class.
- Use extension methods to add `isEven` to `Int`.
- Use `given`/`using` to implement a `Show[A]` typeclass.

## Concurrency + interop
- Wrap a Java list and convert it to a Scala `List`.
- Use a `Future` to fetch two values and combine them safely.
- Demonstrate safe handling of nullable Java values.

## Mini‑projects
- Implement a tiny `grep` that supports `--ignore-case` and `--count`.
- Build a command‑line unit converter with pure functions and a small CLI.
- Build a CSV summarizer: count rows, distinct values per column.

## Code‑reading drills (for understanding AI/vibe‑coding output)
- Given a Scala function that uses `Option` and `match`, explain all possible outcomes.
- Identify whether a block is expression‑oriented or statement‑oriented and rewrite it idiomatically.
- Explain the inferred types for a chain of `map`/`flatMap`/`filter`.
