# JI/JO: Java

A Maven archetype, or Gitt8r template or cookie cutter template
to wrap a Java library in a JI/JO shell.

## Layered design
 
1. STDIO
2. JSON-RPC
3. Robot Framework Dynamic Library API
4. Library

## Examples

```json
{"id": 1, "jsonrpc": "2.0", "method": "run_keyword", "params": ["Get Full Name", "john", "doe"]}
```

```json
{"id": 1, "jsonrpc": "2.0", "method": "get_keyword_arguments", "params": ["Get Full Name"]}
```

```json
{"id": 1, "jsonrpc": "2.0", "method": "get_keyword_names", "params": []}
```

```json
{"id": 1, "jsonrpc": "2.0", "method": "get_keyword_documentation", "params": ["__intro__"]}
```
