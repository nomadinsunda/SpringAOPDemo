package com.intheeast.aspectj.declaringadvice.model;

public interface UsageTracked {
    void incrementUseCount();
    int getUseCount();
}
