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

public class Version {
    public static final String VERSION = "0.1.0";
    public static final int MAJOR;
    public static final int MINOR;
    public static final int PATCH;

    static {
        try {
            String[] v = VERSION.split("\\.");
            MAJOR = v.length < 1 ? 0 : Integer.valueOf(v[0]);
            MINOR = v.length < 2 ? 0 : Integer.valueOf(v[1]);
            PATCH = v.length < 3 ? 0 : Integer.valueOf(v[2]);
        } catch (Throwable t) {
            throw new RuntimeException("Invalid version " + VERSION, t);
        }
    }

    public static boolean isHigher(int major, int minor, int path) {
        return isHigherOrEqual(major, minor, path + 1);
    }

    public static boolean isHigherOrEqual(int major, int minor, int path) {
        if (MAJOR != major)
            return MAJOR > major;
        if (MINOR != minor)
            return MINOR > minor;
        return PATCH >= path;
    }

    public static boolean isLower(int major, int minor, int path) {
        return isLowerOrEqual(major, minor, path - 1);
    }

    public static boolean isLowerOrEqual(int major, int minor, int path) {
        if (MAJOR != major)
            return MAJOR < major;
        if (MINOR != minor)
            return MINOR < minor;
        return PATCH <= path;
    }
}
