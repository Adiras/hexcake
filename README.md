# hexcake

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fca7530dff5248f8a0656b8d957a91fc)](https://www.codacy.com/app/Adiras/hexcake?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Adiras/hexcake&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Adiras/hexcake.svg?branch=master)](https://travis-ci.org/Adiras/hexcake)
[![Coverage Status](https://coveralls.io/repos/github/Adiras/hexcake/badge.svg?branch=master)](https://coveralls.io/github/Adiras/hexcake?branch=master)

Utility which displays the specified files, or the standard input in hexadecimal view.

    Usage: haxcake [flags] [options] arguments

    Arguments:
      <file>     file to dump

    Options:
      -o         number system used for offsets
                 accepted values: <bin|dec|hex|oct>

    Flags:
      --help     display help menu
      --version  display version number

## Sample output
    $ hexedit -o hex test.txt
    File name test.txt
    File size 128 bytes
    Offset   Hexadecimal                                     ASCII
    00000000 4C 6F 72 65 6D 20 49 70 73 75 6D 20 69 73 20 73 Lorem Ipsum is s
    00000010 69 6D 70 6C 79 20 64 75 6D 6D 79 20 74 65 78 74 imply dummy text
    00000020 20 6F 66 20 74 68 65 20 70 72 69 6E 74 69 6E 67  of the printing
    00000030 20 61 6E 64 20 74 79 70 65 73 65 74 74 69 6E 67  and typesetting
    00000040 20 69 6E 64 75 73 74 72 79 2E 20 4C 6F 72 65 6D  industry. Lorem
    00000050 20 49 70 73 75 6D 20 68 61 73 20 62 65 65 6E 20  Ipsum has been
    00000060 74 68 65 20 69 6E 64 75 73 74 72 79 27 73 20 73 the industry's s
    00000070 74 61 6E 64 61 72 64 20 64 75 6D 6D 79 20 74 65 tandard dummy te

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [releases on this repository](https://github.com/Adiras/hexcake/releases).

## License

This project is licensed under the Apache License 2.0 License - see the [LICENSE](LICENSE) file for details
