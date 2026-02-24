# Exercises

Short tasks designed to map to C/C++/C# experience while practicing idiomatic Scala. Failed attempts are preserved with brief commentary to make the learning path transparent.

## Container + idiom notes (quick reference)
- `List`: immutable, singly‑linked; fast prepend (`x :: list`), slow random access.
- `Vector`: immutable, indexed, good general‑purpose default when you need random access.
- `Array`: fixed size, mutable elements, contiguous storage.
- `ArrayBuffer`: growable, mutable, contiguous storage (like `std::vector`).
- `Set`: used for membership tests; immutable by default; `mutable.Set` exists.
- `Option`: `Some`/`None` instead of null; use `map/flatMap` for flow.
- `for ... yield`: expression that builds a new collection (desugars to `map/flatMap`).
- `for` without `yield`: side‑effect loop (desugars to `foreach`).

## Core syntax
- Write a function `clamp(x, lo, hi)` using expression‑style Scala.
- Implement `swap` for a tuple; return a new tuple.
- Convert a `for` loop that filters and maps into a for‑comprehension.

## Exercise 1 (in progress)
### Task
Implement `clamp(x, lo, hi)` using expression‑style Scala (no early returns). Assume `x`, `lo`, `hi` are `Int`.

### Hints
- Use a single expression with `if/else` or `match`.
- No mutation; return the value directly.

### Your solution
- Submitted:
```scala
object Exercise1 {
  // TODO: Implement clamp using expression-style Scala (no early returns).
  def clamp(x: Int, lo: Int, hi: Int): Int =
    // doesn't work in Scala? return x < lo ? lo : x > hi ? hi : x
    var min = (a,b) => a < b ? a : b
    var max = (a,b) => a > b ? b : a
    min(max(hi, lo), x)
}
```

### Feedback
- Scala does not have the `?:` ternary operator; use `if/else` expressions instead.
- `var` is rarely needed here; prefer `val` for functions.
- Your `max` function returns the smaller value; it should return the larger one.
- `min(max(hi, lo), x)` is not a correct clamp; proper clamp is `max(lo, min(x, hi))`.

### Idiom notes
- Scala uses expression‑style `if/else`; no ternary operator.
- Favor `val` and pure expressions unless mutation is required.

### Revised solution (correct)
```scala
object Exercise1 {
  def clamp(x: Int, lo: Int, hi: Int): Int =
    if (x < lo) lo
    else if (x > hi) hi
    else x
}
```

### Reference solution
```scala
def clamp(x: Int, lo: Int, hi: Int): Int =
  if (x < lo) lo
  else if (x > hi) hi
  else x
```

## Exercise 2 (complete)
### Task
Implement `swap` for a tuple. Given `(A, B)` return `(B, A)`. Use a generic method.

### Hints
- Use pattern matching or tuple accessors.
- Keep it expression‑style (no mutation).

### Your solution
- Submitted:
```scala
def swapi[T]((a: T,b : T)): (T,T) =>
    (b,a)
```

### Feedback
- Use `=` not `=>` for method definitions.
- Tuple parameter syntax is `def swap[T](t: (T, T)) = ...` or pattern matching in the parameter list.
- This version only handles `(T, T)`; the task asks for generic `(A, B)` → `(B, A)`.

### Idiom notes
- Tuple accessors `_1`/`_2` are fine for small, obvious transforms.
- Generic tuples are commonly `(A, B)`; don’t assume same‑type pairs.

### Most idiomatic (no match)
```scala
def swap[A, B](t: (A, B)): (B, A) =
  (t._2, t._1)
```

### Reference solution
```scala
def swap[A, B](t: (A, B)): (B, A) = t match
  case (a, b) => (b, a)
```

### Code
- Implemented in `src/main/scala/Exercise2.scala`.

## Exercise 3 (complete)
### Task
Duplicate each element in a passed sequence using a `for`‑comprehension.
Example: `List(1,2,3)` → `List(1,1,2,2,3,3)`.

### Hints
- Use a nested generator or `flatMap` logic.
- Keep it expression‑style (no mutation).

### Your solution
- Submitted:
```scala
def dupe[T](a : List[T]): List[T] =
    var result : List[T]
    for (x <- a)
        result += x
        result += x
    result

def dupe2[T](a : List[T]): List[T] =
    var result : ArrayBuffer[T]
    a.map(a => { result += a; result += a; })
    result
```

### Feedback
- `List` is immutable; `result += x` does not work.
- `var result` is uninitialized; this won’t compile.
- `map` should be pure; using it only for side effects is not idiomatic.
- `ArrayBuffer` needs an import and initialization, and you must convert back to `List`.

### Idiom notes
- Use `for ... yield` or `flatMap` to build new collections, not side‑effect mutation.
- If you need mutation for performance, use a buffer (`ListBuffer`/`ArrayBuffer`) then convert.

### Most idiomatic (for‑comprehension)
```scala
def dupe[T](a: List[T]): List[T] =
  (for
    x <- a
    y <- List(x, x)
  yield y)
```

### Equivalent using flatMap
```scala
def dupe[T](a: List[T]): List[T] =
  a.flatMap(x => List(x, x))
```

### Additional attempt
```scala
def dupe3[T](list : List[T]): List[T] =
  var result = ArrayBuffer[T]()
  return for (x : list) yield { result += x; result += x }
```

### Feedback
- `for (x : list)` is invalid syntax; use `for (x <- list)`.
- `return for (...) yield ...` returns the *yielded collection*, not your `result`.
- The yielded collection here would be `List[Unit]` because the body is side effects.
- Avoid `return` in Scala; use the expression directly.

### Idiom notes
- `return` is rarely used; the last expression is the result.
- `yield` produces values; side effects there lead to `Unit`.

### Final answer
```scala
def dupe[T](list: List[T]): List[T] =
  for
    x <- list
    y <- List(x, x)
  yield y
```

### Summary (why this works)
- `for ... yield` builds a new collection (like `map`/`flatMap`), not a side‑effect loop.
- `List` is immutable, so the result is produced by transformation, not mutation.
- `y <- List(x, x)` duplicates each element without manual appends.

### Code
- Implemented in `src/main/scala/Exercise3.scala`.

## Types and collections
- Implement `distinctPreserveOrder` for a `Seq[Int]`.
- Write `groupByLength` for `List[String]`.
- Create an enum `Result` with `Ok(value)` and `Err(msg)`.

## Exercise 4 (in progress)
### Task
Implement `distinctPreserveOrder(xs: Seq[Int]): Seq[Int]` that removes duplicates but keeps the first occurrence order.
Example: `Seq(3,1,3,2,1)` → `Seq(3,1,2)`.

### Hints
- Track seen elements in a `Set[Int]`.
- Keep it expression‑style; avoid `var` if you can.

### Your solution
- TODO

## Functional patterns
- Parse `String` to `Int` returning `Option[Int]`.
- Implement `sequence` for `List[Option[A]]`.
- Implement `map2` for `Option[A]` and `Option[B]`.

## Exercise (map vs flatMap)
### Task
Given `List(1,2,3)`, show the difference between `map` and `flatMap` when each element is expanded to a list of two elements.
Compute both results and explain why the shapes differ.

### Hints
- Use `x => List(x, x)` as the mapping function.
- Observe the difference between `List[List[Int]]` and `List[Int]`.

### Your solution
- TODO

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
