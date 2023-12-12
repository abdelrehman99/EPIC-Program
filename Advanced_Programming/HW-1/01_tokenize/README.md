# Tokenizer (10 points)

Given a line consisting of tokens, split it into separate tokens using ANTLR grammar.

Python code for this task is already pre-written, you will just need to write a lexer grammar which defines tokens in order to perform the correct tokenization.

All the different kinds of tokens and their formats are described below.

## Running code

First, compile your grammar:

```sh
antlr4 Tokenize.g4 -Dlanguage=Python3
```

Then, run `main.py`. It will read the input from `input.txt` and print the output into standard output. To pass the tests succesfully, your output must exactly match the provided `output.txt`.

## Tokens

### Integer

Integers can be decimal, octal and hexadecimal.

Decimal integers are just simple integer without leading zeros: `1`, `42`, `-256`, `+256`, `0`.

Octal integers consist of digits from `0` to `7` and start with `0` prefix: `042`, `+042`, `-07777`, `+0003`.

Hexadecimal integers consist of digits from the set `{0..9, a..f, A..F}` and start with `0x` prefix: `0xfd`, `+0xf00d`, `-0x2AbCdEf`, `+0xff`.

### Floating point number

Floating point numbers looks like the ones you can normally expect in Python programming language. Examples: `1.234`, `.234`, `1.`, `-1.234`, `+1.234e56`, `+1.234e+56`, `1.e-2`, `1.234e-2`, `.42e0`, `1e3`, `1e+10`.

### Char

Let's call the following sequences _escaped characters_:
- any character, except for `\`
- any of the following sequences: `\n`, `\t`, `\\`, `\'`, `\"`
- `\u`, immediately followed by 4 hexadecimal symbols (i.e. symbols from the set `{0..9, a..f, A..F}`)

Then, char is one _escaped character_ (except that `'` is not allowed, but `\'` is allowed) enclosed in `'` symbols. Examples: `'d'`, `'\u042e'`, `'\''`, `'\\'`, `'"'`.

### String

String is a sequence of _escaped characters_ (except that `"` is not allowed, but `\"` is allowed) enclosed in `"` symbols. Examples: `"simple string"`, `"\"\\"`, `"\u042e is just \\u042e"`, `"escaping \", \' and \\."`, `"' doesn't need to be escaped"`.

### Date

Date consists of a 4-digit year, 2-digit month (from `01` to `12`) and 2-digit day (from `01` to `31`), separated with `-`. Examples: `2023-11-01`, `2012-12-21`, `1901-01-01`. Note that the following dates are invalid: `10000-01-01`, `2023-13-01`, `2023-12-32`. Still, you don't need to ensure that `2022-02-31` is an invalid date and have to accept this token as a valid date.

### Time

Time consists of 2-digit hour (from `00` to `23`), 2-digit minutes (from `00` to `59`) and 2-digit seconds (from `00` to `59`), separated with `:`. Optionally, there can be second fractional part in the end, separated with `.` from the rest of the date. Examples: `12:34:56`, `01:02:03`, `01:02:03.000000`, `12:34:56.789`.

### Datetime

Datetime consists of date and time, separated with `T`. Example: `2023-11-01T12:34:56.789`.

### Duration

Duration consists of a decimal integer or a floating point number without exponent part and the suffix. The suffix can be one of the following: `ns`, `us`, `ms`, `s`, `m`, `h`. Examples: `1s`, `1.5ns`, `.5ms`, `1.33h`, `15.2us`. Note that `1e2ns` is an invalid duration.

### Boolean

Can be either `true` or `false`.

### Null

Must be `null`.

### Symbol

First character must be a Latin later. All the other characters must be either Latin letters, or digits, or `_`, or `-`. Examples: `test-symbol` `test-_-symbol` `TestSymbol42`, `Symbol-1-2-3-4_127_0_0_1`.

### Spaces

Spaces are not real tokens, but can be used to separate different tokens. Note that spaces between tokens are not mandatory, and there can be more than one space between tokens.

## Greedy matching

The tokens must match greedily, i.e. the tokenizer will scan from the beginning and try to take the longest sequence possible as the next token. For example, the string `2008-12-31T10` in theory can be tokenized as `2028`, `-12`, `-31` and `T10`, but the tokenizer must find the longest valid token, so the string must be tokenized as `2028-12-31` (date) and `T10` (symbol). Note that you cannot take the whole string (`2028-12-31T10`) as a token, because it's not a valid datetime.

You don't need to do anything to enable such greedy matching, ANTLR will handle this itself.

## Submitting

You must write the lexer grammar into `Tokenize.g4` and submit this file.
