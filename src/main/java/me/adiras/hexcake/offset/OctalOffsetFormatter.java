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

public class OctalOffsetFormatter implements OffsetFormatter {
    private static OctalOffsetFormatter instance;

    /**
     * Example: 67 (dec) => 103 (oct)
     * @param   offset
     *          Decimal number to be converted to octal form string
     * @return  Octal number
     */
    @Override
    public String format(byte offset) {
        return Integer.toOctalString(offset);
    }

    public static OctalOffsetFormatter getInstance() {
        if (instance == null)
            instance = new OctalOffsetFormatter();
        return instance;
    }
}
