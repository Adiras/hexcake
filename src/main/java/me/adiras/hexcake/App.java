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

import com.beust.jcommander.JCommander;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class App {

    public App(String... args) {
        JCommander.newBuilder()
                .addObject(new Parameters())
                .build()
                .parse(args);

        // Verify flags
        if (Parameters.help) {
            try {
                Files.lines(Resources.getFile("help.txt").toPath())
                        .forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }
        }

        if (Parameters.version) {
            System.out.println("Version: " + Version.VERSION);
            System.exit(0);
        }

        // Verify file main parameter
        if (Parameters.file.isEmpty()) {
            System.err.println("No file to dump was defined!");
            System.exit(0);
        }

        new HexCake(new File(Parameters.file));
    }

    public static void main(String... args) throws IOException {
        new App(args);
    }
}
