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

public class DecimalOffsetFormatter implements OffsetFormatter {
    private static DecimalOffsetFormatter instance;

    /**
     * Example: 89 (dec) => 89 (dec)
     * @param   offset
     *          Decimal number to be converted to decimal form string
     * @return  Decimal number
     */
    @Override
    public String format(byte offset) {
        return Integer.toString(offset);
    }

    public static DecimalOffsetFormatter getInstance() {
        if (instance == null)
            instance = new DecimalOffsetFormatter();
        return instance;
    }
}
