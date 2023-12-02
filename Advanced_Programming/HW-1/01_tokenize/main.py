from antlr4 import InputStream
import Tokenize

f = open('input.txt')
results = []
for line in f.readlines():
    in_stream = InputStream(line.strip())
    lexer = Tokenize.Tokenize(in_stream)
    results.append('---' + '\n')
    for token in lexer.getAllTokens():
        results.append(token.text + '\n')
    # results.append('\n')
    
with open('results.txt', 'w') as f:
    f.writelines(results)
    