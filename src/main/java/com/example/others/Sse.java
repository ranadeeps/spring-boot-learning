package com.example.others;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public enum Sse{
    INSTANCE;
    private SseEmitter emitter;

    public SseEmitter getEmitter() {
        // If we don't have one, or the old one is finished, create it
        if (this.emitter == null) {
            this.emitter = new SseEmitter(Long.MAX_VALUE); // Avoid quick timeouts

            // Clean up when the connection closes
            this.emitter.onCompletion(() -> this.emitter = null);
            this.emitter.onTimeout(() -> this.emitter = null);
        }
        return this.emitter;
    }
}
