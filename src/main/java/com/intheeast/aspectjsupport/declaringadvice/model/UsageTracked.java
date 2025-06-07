package com.intheeast.aspectjsupport.declaringadvice.model;

public interface UsageTracked {
    void incrementUseCount();
    int getUseCount();
}
