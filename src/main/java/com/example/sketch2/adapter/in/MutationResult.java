package com.example.sketch2.adapter.in;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MutationResult {
    private static final MutationResult OK = new MutationResult(true);
    private final boolean ok;

    static MutationResult ok() {
        return OK;
    }
}
