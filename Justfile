export concurrently_colors := "blue,green,yellow,magenta,cyan,white"

help:
    just --list

dev:
    npx shadow-cljs watch app portfolio

all:
    concurrently \
    --names "test,lint" \
    --prefix-colors ${concurrently_colors} \
        "just test" \
        "just lint"
