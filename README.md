# stakeout

A Clojure version of Topfunky's Ruby Stakeout script.

Stakeout executes a given shell command whenever it detects a modification of
a file in one of the directories it is monitoring.

## Usage

> java -jar stakeout-standalone.jar 'src/*/*.clj' 'lein test'

## Installation

Building requires leinigen.

> lein deps
> lein compile
> lein uberjar

> java -jar stakeout-standalone.jar 'src/*/*.clj' 'lein test'

## TODO

1. Convert to actual lein plugin
2. Add support for 

## License

(The MIT License)

Copyright (c) 2010 John Kane

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
'Software'), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
