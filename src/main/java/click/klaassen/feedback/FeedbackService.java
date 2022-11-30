package click.klaassen.feedback;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;

public class FeedbackService {

    @Inject
    @Channel("feedback-topic-out")
    Emitter<Feedback> emitter;

    void publishFeedback(Feedback feedback) {
        emitter.send(feedback);
    }
}
