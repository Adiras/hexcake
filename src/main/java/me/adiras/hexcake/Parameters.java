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

import com.beust.jcommander.Parameter;

public class Parameters {
    /*
     *  Arguments
     */
    @Parameter
    public static String file = "";

    /*
     *  Options
     */
    @Parameter(names = "-o")
    public static String offset = "hex";

    /*
     *  Flags
     */
    @Parameter(names = "--help")
    public static boolean help;

    @Parameter(names = "--version")
    public static boolean version;
}
