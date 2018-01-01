/*
 * Copyright 2018 Kacper Witek
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.adiras.hexcake;

import java.io.File;
import java.io.PrintStream;
import java.util.stream.IntStream;

public class HexDumpConsoleWriter implements HexDumpWriter {
    private PrintStream out = System.out;
    private File file;

    public HexDumpConsoleWriter(File file) {
        this.file = file;
    }

    @Override
    public void write(HexDump dump) {
        writeHeader();

        int rows = dump.getRows();
        IntStream.range(0, rows)
                .forEach(row -> {
                    byte offset = dump.getOffset()[row];
                    byte[] offsetBytes = dump.getOffsetBytes(offset);
                    writeLine(dump, offset, offsetBytes);
                });
    }

    public void writeLine(HexDump dump, byte offset, byte[] offsetBytes) {
        /*
         *  Print Offset section.
         */
        out.printf("%-9s", dump.formatOffset(offset));

        /*
         *  Print Hexadecimal section.
         */
        for (int i = 0; i < offsetBytes.length; i++) {
            String hex = String.format("%2s", Integer.toHexString(offsetBytes[i]))
                    .replace(' ', '0')
                    .toUpperCase();
            out.printf("%-3s", hex);
        }

        /*
         *  Print ASCII section.
         */
        for (int i = 0; i < offsetBytes.length; i++) {
            // Get character as ASCII code
            int character = offsetBytes[i];

            // Replace all control and extended characters
            if (!ASCII.isPrintableCharacter(character))
                character = ASCII.SAFE_CHARACTER;

            out.printf("%c", character);
        }

        // Terminate the line
        out.println();
    }

    public void writeHeader() {
        out.printf("File name %s\nFile size %s bytes\n", file.getName(), file.length());
        out.printf("%-9s%-48s%s\n", "Offset", "Hexadecimal", "ASCII");
    }
}
