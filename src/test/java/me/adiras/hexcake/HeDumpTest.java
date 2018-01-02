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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

public class HeDumpTest {
    private HexDump dump;

    @Before
    public void setUp() {
        byte[] array = {76, 111, 114, 101, 109, 32, 73, 112,
                115, 117, 109, 32, 105, 121, 32, 116,
                101, 120, 116, 32, 111, 102, 32, 116,
                104, 101, 32, 112, 114, 105, 110, 116,
                105, 110, 103, 32, 97, 110, 100};
        dump = new HexDump(ByteBuffer.wrap(array));
    }

    @Test
    public void shouldReturnNumberOfRows() {
        // when
        dump.setBytesPerRow(8);

        // then
        assertEquals(5, dump.getRows());
    }

    @Test
    public void shouldReturnOffsetsArray() {
        // given
        byte[] array = {0, 8, 16, 24, 32};

        // when
        dump.setBytesPerRow(8);

        // then
        assertArrayEquals(array, dump.getOffset());
    }

    @Test
    public void shouldReturnValuesOfSpecifiedRow() {
        // given
        byte[] array = {105, 110, 103, 32, 97, 110, 100, 0};

        // when
        dump.setBytesPerRow(8);

        // then
        assertArrayEquals(array, dump.getOffsetBytes(32));
    }
}
