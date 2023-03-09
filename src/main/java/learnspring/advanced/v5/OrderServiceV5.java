package learnspring.advanced.v5;

import learnspring.advanced.trace.TraceStatus;
import learnspring.advanced.trace.callback.TraceCallback;
import learnspring.advanced.trace.callback.TraceTemplate;
import learnspring.advanced.trace.hellotrace.HelloTraceV1;
import learnspring.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });

    }
}
