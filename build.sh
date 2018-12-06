#!/bin/sh

# First build the entire project
./gradlew build

APP_PATH=./queue-app/build/libs/queue-app.jar:./queue-spi/build/libs/queue-spi.jar
NOP_PATH=./queue-nop/build/libs/queue-nop.jar
SIMPLE_PATH=./queue-simple/build/libs/queue-simple.jar

# Attempt to run the application with no queue implementation. This will throw an exception.
java -cp $APP_PATH demo.App

# Attempt to run the application with the NOP queue implementation.
java -cp $APP_PATH:$NOP_PATH demo.App

# Attempt to run the application with the Simple queue implementation.
java -cp $APP_PATH:$SIMPLE_PATH demo.App

# Attempt to run the application with all queue implementation, but provide the name on the command line.
java -cp $APP_PATH:$NOP_PATH:$SIMPLE_PATH demo.App nop

# Attempt to run the application with all queue implementation, but provide the name on the command line.
java -cp $APP_PATH:$NOP_PATH:$SIMPLE_PATH demo.App simple

# The output from the above should look like this:
#
# No queue implementation found
# Found queue implementation nop
# Found queue implementation simple
# Found queue implementation nop
# Found queue implementation simple
#
