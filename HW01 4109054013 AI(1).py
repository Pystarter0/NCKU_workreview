#!/usr/bin/env python
# coding: utf-8

import numpy as np
from tensorflow import keras
from tensorflow.keras import layers


# Model / data parameters
num_classes = 10
input_shape = ( 28 , 28 , 1 )

# the data, split between train and test sets
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

# Scale images to the [0, 1] range
x_train = x_train.reshape( 60000 , 28, 28 ).astype('float32') / 255
x_test = x_test.reshape( 10000 , 28, 28 ).astype('float32') / 255

# Make sure images have shape (28, 28, 1)
x_train = np.expand_dims(x_train, -1)
x_test = np.expand_dims(x_test, -1)
print("x_train shape:", x_train.shape)
print(x_train.shape[0], "train samples")
print(x_test.shape[0], "test samples")

# convert class vectors to binary class matrices
y_train = keras.utils.to_categorical(y_train.astype("float32"))
y_test = keras.utils.to_categorical(y_test.astype("float32"))

# construct neural network+
# Flatten -> dense -> dropout -> dense
model = keras.Sequential(
    [
      keras.Input(shape=input_shape),
      layers.Flatten(),
      layers.Dense(512 , activation='relu'),
      layers.Dropout(0.1),
      layers.Dense(10, activation='softmax')
    ]
)

model.summary()

batch_size = 256
epochs = 15

# training
model.compile(loss='categorical_crossentropy',
              optimizer="adam",
              metrics=["accuracy"])

model.fit(x_train, y_train, batch_size=batch_size, epochs=epochs, validation_split=0.01)

score = model.evaluate(x_test, y_test, verbose=0)
print("Test loss:", score[0])
print("Test accuracy:", score[1])