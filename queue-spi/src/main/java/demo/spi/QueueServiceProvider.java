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

package demo.spi;

/**
 * Defines the Queue service provider.
 */
public interface QueueServiceProvider {
    /**
     * Returns the name of the Queue implementation.
     * @return Name of the queue implementation.
     */
    String name();

    /**
     * Places an object on the end of the queue.
     * @param object Object to place on the queue.
     */
    void enqueue(String object);

    /**
     * Retrieves an object from the front of the queue.
     * @return Object from the queue.
     */
    String dequeue();
}
