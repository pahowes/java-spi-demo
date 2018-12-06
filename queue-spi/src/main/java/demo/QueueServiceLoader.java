/*
 * Copyright 2018 Paul Howes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo;

import java.util.ServiceLoader;

import demo.spi.QueueServiceProvider;

public class QueueServiceLoader {
    /**
     * Returns the first implementation of {@see QueueServiceProvider} found by the loader.
     * @return An implementation of {@see QueueServiceProvider}.
     */
    public static QueueServiceProvider load() {
        ServiceLoader<QueueServiceProvider> queueServiceLoader = ServiceLoader.load(QueueServiceProvider.class);
        if (queueServiceLoader == null) {
            return null;
        }

        if (!queueServiceLoader.iterator().hasNext()) {
            return null;
        }

        return queueServiceLoader.iterator().next();
    }

    /**
     * Returns an implementation of {@see QueueServiceProvider} by querying loaded implementation by name.
     * @return An implementation of {@see QueueServiceProvider}.
     */
    public static QueueServiceProvider loadByName(String name) {
        ServiceLoader<QueueServiceProvider> queueServiceLoader = ServiceLoader.load(QueueServiceProvider.class);
        for (QueueServiceProvider provider : queueServiceLoader) {
            if (provider.name().equals(name)) {
                return provider;
            }
        }

        return null;
    }
}
