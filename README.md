# hash-s - format strings easier

Ehh, it can only works with the compile-time defined vars - so these defined within the `let` block are useless.

## usage

Add `hash-s` to your `deps.edn`:
```clojure
{:deps
 {io.github.vollcheck/hash-s {:git/sha "<commit hash here>"}}}
```

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
- [ ] handle vars defined by `let`
