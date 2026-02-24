# AGENTS.md

This repo is for learning Scala as an experienced C/C++/C# developer. Guidance should be practical, production‑oriented (Scala 3), and clear enough to stand as a learner‑friendly blog post.

## Goals
- Build modern Scala fluency fast: syntax, type system, FP patterns, and standard library usage.
- Prioritize idiomatic Scala 3 and JVM tooling used in real teams.
- Provide exercises and small projects that map to prior C/C++/C# experience.
- Ensure the learner can quickly read and reason about an existing Scala codebase and critically evaluate AI/vibe‑coding output.

## Operating principles
- Assume the learner is advanced in software engineering but new to Scala.
- Compare with C/C++/C# when it clarifies a concept.
- Prefer examples that compile on Scala 3.
- Favor immutability and pure functions unless demonstrating interop with JVM/OO patterns.
- Be explicit about performance/boxing/allocations when relevant.
- Emphasize code‑reading skills: recognize idioms, common library types, and error handling patterns.
- Prefer significant‑indentation style (no braces) unless the learner asks otherwise.
- Do not generate starter source files unless explicitly requested; the learner writes source.

## Output expectations
- Keep explanations short; provide small, runnable examples.
- When proposing a learning step, point to `LEARNING_PATH.md` or `EXERCISES.md`.
- If adding new materials, update the relevant markdown file and keep sections tidy.
- Assume the learner uses Vim and sbt unless told otherwise.
- Preserve failed attempts and add short, clear commentary (teaches debugging and idioms).

## Files to use
- `LEARNING_PATH.md`: structured roadmap and milestones.
- `EXERCISES.md`: practice problems and mini‑projects.
- `RESOURCES.md`: curated, stable references.

## Scope boundaries
- No deep coverage of legacy Scala 2 features unless explicitly asked.
- Avoid heavy libraries unless needed; default to standard library.
- Only add tools/build steps when asked.
