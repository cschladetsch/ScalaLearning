# AGENTS.md

This repo is for learning Scala as an experienced C/C++/C# developer. Agents should focus on practical, production‑oriented Scala (Scala 3), emphasize differences from C‑family languages, and keep guidance concise and actionable.

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

## Output expectations
- Keep explanations short; provide small, runnable examples.
- When proposing a learning step, point to `LEARNING_PATH.md` or `EXERCISES.md`.
- If adding new materials, update the relevant markdown file and keep sections tidy.

## Files to use
- `LEARNING_PATH.md`: structured roadmap and milestones.
- `EXERCISES.md`: practice problems and mini‑projects.
- `RESOURCES.md`: curated, stable references.

## Scope boundaries
- No deep coverage of legacy Scala 2 features unless explicitly asked.
- Avoid heavy libraries unless needed; default to standard library.
- Only add tools/build steps when asked.
