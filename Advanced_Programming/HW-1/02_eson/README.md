# ESON (20 points)

_Note_: complete this task only after you wrote the tokenizer.

## Task

In this task, you will need to parse a JSON-like format called _ESON_ and convert it to JSON. To achieve this, you need to:
1. write ESON grammar in `Eson.g4`;
2. write a visitor in `main.py`, which converts your ESON syntax tree into JSON.

## Building

To build your ANTLR grammar, use
```sh
antlr4 Eson.g4 -Dlanguage=Python3 -visitor
```

## Format

ESON document contains exactly one ESON value. ESON value can be one of the following:
- _Integer_. It corresponds to octal, decimal or hexadecimal integer tokens (see the previous task) and is parsed according to Python rules. In JSON, they must appear as numbers.
- _Float_. It corresponds to floating point tokens and is parsed according to Python rules. In JSON, they must appear as numbers.
- _Char_. It corresponds to char tokens and is parsed according to Python rules. In JSON, they must appear as strings.
- _String_. It corresponds to string tokens and is parsed according to Python rules. In JSON, they must appear as strings.
- _Date_.  It corresponds to date tokens. In JSON, they must appear as strings (see `parse_date()` and `format_date()` functions in the code template).
- _Time_.  It corresponds to time tokens. In JSON, they must appear as strings (see `parse_time()` and `format_time()` functions in the code template).
- _Datetime_. It corresponds to datetime tokens. In JSON, they must appear as strings (see `parse_datetime()` and `format_datetime()` functions in the code template).
- _Duration_. It corresponds to duration tokens. In JSON, they must appear as floating point numbers meaning the amount of seconds. The suffixes `ns`, `us`, `ms`, `s`, `m` and `h` mean nanoseconds, microseconds, milliseconds, seconds, minutes and hours respectively. Thus, `300.5ms` should become `0.3005` in the resulting JSON.
- _Bool_. It corresponds to bool tokens. In JSON, they must appear as bool.
- _Null_. It corresponds to null tokens. In JSON, they must appear as `null`.
- _Symbol_. It corresponds to symbol tokens. In JSON, they must appear as strings.
- _List_. Lists are enclosed in square brackets (`[]`). Inside there are one or more ESON values separated by `,`. A trailing comma is allowed. In JSON, they must appear as lists.
- _Dict_. Dicts are enclosed in curly brackets (`{}`). Inside there are one or more key-value pairs separated by `,`. A trailing comma is allowed. Each key-value pair consists of a key (represented with either a symbol or a string) and a value (represented with any ESON value), separated with `=`. In JSON, they must appear as objects.

ESON document can also contain comments. Comments start with `#` and last until the end of the line.

## Testing

The program will read the input from `input.eson` and write the formatted JSON on standard output. To pass the test, your output must exactly match the contents of `output.json`.

## Submitting

You must submit two files: `main.py` and `Eson.g4`.
