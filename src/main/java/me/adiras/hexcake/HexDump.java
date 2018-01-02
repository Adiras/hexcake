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

import me.adiras.hexcake.offset.OffsetFormatter;
import me.adiras.hexcake.offset.OffsetFormatterFactory;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class HexDump {
    private ByteBuffer buffer;
    private OffsetFormatter offsetFormatter;

    // Number of bytes per row (line)
    private int bytesPerRow;

    public HexDump(ByteBuffer buffer) {
        this.buffer = buffer;

        offsetFormatter = new OffsetFormatterFactory().create();
        bytesPerRow = 16;
    }

    /**
     * @return  Number of rows (lines)
     */
    public int getRows() {
        int bytesLenght = buffer.array().length;
        return (int) Math.ceil((double) bytesLenght / bytesPerRow);
    }

    /**
     * Example: [0, 16, 32, 48, 64]
     *                  or
     *          [0, 8, 16, 24, 32]
     * @return The offset's array in decimal format
     */
    public byte[] getOffset() {
        int rows = getRows();
        byte[] offset = new byte[rows];
        for (int i = 0; i < rows; i++) {
            offset[i] = (byte) (i * bytesPerRow);
        }
        return offset;
    }

    /**
     * Example: [32, 116, 104, 101, 32, 114]
     * @return The values of line identified by specified offset
     */
    public byte[] getOffsetBytes(int offset) {
        byte[] bytes = buffer.array();
        int from = offset;
        int to = from + bytesPerRow;
        return Arrays.copyOfRange(bytes, from, to);
    }

    /**
     * Example: 32 => 00000020 (if formatter is hexadecimal)
     * @param   offset
     *          Decimal number to be formatted
     * @return  Formatted offset ready for entry
     */
    public String formatOffset(byte offset) {
        String formatted = offsetFormatter.format(offset);
        return String.format("%8s", formatted).replace(' ', '0');
    }

    public void setBytesPerRow(int bytesPerRow) {
        this.bytesPerRow = bytesPerRow;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }
}
