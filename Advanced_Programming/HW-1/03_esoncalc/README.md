# Math inside ESON (10 points)

_Note_: complete this task only after you wrote the tokenizer and the ESON parser.

## Task

You need to support simple math expressions for integers and floating point numbers. The following operations must be supported:
- `+`, `-`, `*`, `/`
- unary `+` and `-`
- brackets `()`
- `sin()` and `cos()`

See `input.eson` for examples.

## Building

To build the ANTLR grammar, use
```sh
antlr4 Eson.g4 -Dlanguage=Python3 -visitor
```

## Testing

The program will read the input from `input.eson` and write the formatted JSON on standard output. To pass the test, your output must exactly match the contents of `output.json`.

## Submitting

You must submit two files: `main.py` and `Eson.g4`.
