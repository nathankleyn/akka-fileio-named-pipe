# Akka's `FileIO` Doesn't Work With Named Pipes...

This repository is an example of how Akka does not allow you to use named pipes/FIFOs with the `FileIO.fromPath` method. This means you have to resort to iterating yourself, which feels a little inconsistent.

## Usage

It's an SBT project, and there's only one main method, so you can reproduce the problem with:

```
sbt run
```

Make sure you have `mkfifo /tmp/some-fifo` first before doing this.
