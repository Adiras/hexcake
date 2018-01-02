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

public class HexadecimalOffsetFormatter implements OffsetFormatter {
    private static HexadecimalOffsetFormatter instance;

    /**
     * Example: 156 (dec) => A5 (hex)
     * @param   offset
     *          Decimal number to be converted to hexadecimal form string
     * @return  Hexadecimal number
     */
    @Override
    public String format(byte offset) {
        return Integer.toHexString(offset);
    }

    public static HexadecimalOffsetFormatter getInstance() {
        if (instance == null)
            instance = new HexadecimalOffsetFormatter();
        return instance;
    }
}
