# Java SPI Demo

This sample project was designed to illustrate how Java can load and
instantiate modules on-demand using the built-in facility known as
`ServiceLoader`. This has existed since Java 6 and can allow for a pluggable
interface implementation. This is the same mechanism used by the 
[Slf4j](https://www.slf4j.org) project to load a specific logging
implementation.

## Interface

For SPI to work, first an interface is needed. This may be found as
`demo/spi/QueueServiceProvider.java`. In addition to the `enqueue` and
`dequeue` methods, a method that returns the name of the implementation
is required. This will be used by the loader to allow for loading an
implementation by name when multiple implementation exist on the classpath.

## Loader

The loader may be found as `demo/QueueServiceLoader`. There are two static
methods used to load an implementation of `QueueServiceProvider`. The first
iterates through any implementations found on the classpath and returns the
first one. The second loader iterates through the implementations found on
the classpath and selects one that matches the name provided based on the
`name()` method that was defined in `QueueServiceProvider`.

The trick used by Java to find the implementation class is a resource
file added to the JAR using the naming convention,
`META-INF/services/{interface-package-name}`. All this file contains is the
package name of the class that implements the interface.

## Implementations

For the purposes of this demonstration, there are two implementations of the
`QueueServiceProvider` interface. The NOP implementation doesn't do anything
at all, and the Simple implementation stores values in a Java `LinkedList<T>`
object. Either one of these can be included on the classpath and loaded
on-demand.

## Build and Run

There is a script named `build.sh` that builds and runs the application with
an on-demand loaded queue implementation. The important thing to note is that
the application was not compiled against any of the implementations. They're
specified on the classpath, and with the `loadByName()` method in the loader,
multiple implementations can be included and any one of them loaded as needed. 

## Contributing

1. Fork it
2. Create a feature branch (`git checkout -b new-feature`)
3. Commit changes (`git commit -am "Added new feature xyz"`)
4. Push the branch (`git push origin new-feature`)
5. Create a new pull request.

## Maintainers

[Paul Howes](https://github.com/PaulHowes)

## License

`java-spi-demo` Copyright 2018 Paul howes and is licensed under the Apache
License.
