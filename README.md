# hash-s - format strings

## installation

Add `hash-s` to your `deps.edn`:
```clojure
{:deps
 {io.github.vollcheck/hash-s {:git/sha "<commit hash here>"}}}
```

## usage

```clojure
(require '[hash-s])

(def who "mike wazowski")

(println #s"\"What can I say? The camera loves me.\" - {who} said.")
```

## what the name?
I wanted to go for `hash-f` to highlight the link to Python's `f-string` but the name is occupied already by the
https://github.com/opqdonut/hash-f

## todo

- [ ] handle the maps (they produce `{}` which is detected as a string to replace
- [X] handle vars defined by `let`
- [ ] create a `clj-kondo` rule for marking defined vars/let vars as used (for now they are highlighted as unused)
