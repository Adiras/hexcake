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

package me.adiras.hexcake.offset;

public class BinaryOffsetFormatter implements OffsetFormatter {
    private static BinaryOffsetFormatter instance;

    /**
     * Example: 89 (dec) => 1011001 (bin)
     * @param   offset
     *          Decimal number to be converted to binary form string
     * @return  Binary number
     */
    @Override
    public String format(byte offset) {
        return Integer.toBinaryString(offset);
    }

    public static BinaryOffsetFormatter getInstance() {
        if (instance == null)
            instance = new BinaryOffsetFormatter();
        return instance;
    }
}
