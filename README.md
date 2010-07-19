# stakeout

A Clojure version of [Topfunky](http://github.com/topfunky)'s [Ruby Stakeout script](http://github.com/topfunky/stakeout).

Stakeout monitors a set of directories for modifications to their files. When a modification
is detected Stakeout executes the command you gave it.

## Usage

An example usage would be to run all tests whenever a change is made to a clojure file:

    lein stakeout 'src/*/*.clj test/*/*.clj' 'lein test'

## Installation

Stakeout is a leiningen plugin. To install it, modify your project.clj file to include:

    :dev-dependencies [[lein-stakeout "0.1.0"]]

Run `lein deps` to download the plugin from clojars.

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
