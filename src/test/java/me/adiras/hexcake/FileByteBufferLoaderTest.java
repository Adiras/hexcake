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

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class FileByteBufferLoaderTest {

    @Test
    public void shouldLoadByteBufferFromFile() throws IOException {
        // given
        ByteBuffer buffer;
        File file = Resources.getFile("sample.txt");

        // when
        buffer = new FileByteBufferLoader()
                .load(new FileInputStream(file));

        // then
        assertEquals(file.length(), buffer.array().length);
        assertEquals(new String(buffer.array(), "UTF-8"),
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has be" +
                        "en the industry's standard dummy text ever since the 1500s, when an unknown printer took a g" +
                        "alley of type and scrambled it to make a type specimen book. It has survived not only five c" +
                        "enturies, but also the leap into electronic typesetting, remaining essentially unchanged. It" +
                        " was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum pas" +
                        "sages, and more recently with desktop publishing software like Aldus PageMaker including ver" +
                        "sions of Lorem Ipsum.");
    }
}
