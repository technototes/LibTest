package com.technototes.library.hardware;

public interface Followable<T extends HardwareDevice> {
    void follow(T d);
}
