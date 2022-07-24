package com.task.business.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RefundStatus {

    REFUNDABLE(true), NON_REFUNDABLE(false);

    @Getter
    private final boolean refundable;

}
