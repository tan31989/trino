/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.filesystem.local;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;

final class LocalUtils
{
    private LocalUtils() {}

    static IOException handleException(String location, IOException exception)
            throws IOException
    {
        if (exception instanceof NoSuchFileException) {
            throw new NoSuchFileException(location);
        }
        if (exception instanceof FileAlreadyExistsException) {
            throw new FileAlreadyExistsException(location);
        }
        throw new IOException(exception.getMessage() + ": " + location, exception);
    }
}
