package learnspring.advanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
