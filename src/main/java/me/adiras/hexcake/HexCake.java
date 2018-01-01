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

import java.io.*;
import java.nio.ByteBuffer;

public class HexCake {
    private File file;

    public HexCake(File file) {
        this.file = file;

        System.out.println(getBuffer().array().length);

        HexDump dump = new HexDump(getBuffer());
        new HexDumpConsoleWriter(file).write(dump);
    }

    private ByteBuffer getBuffer() {
        FileInputStream inStream = null;
        ByteBuffer buffer = null;
        try {
            inStream = new FileInputStream(file);
            buffer = new FileByteBufferLoader()
                    .load(inStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer;
    }
}
