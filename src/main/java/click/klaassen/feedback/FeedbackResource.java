package click.klaassen.feedback;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/feedback")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class FeedbackResource {

    @Inject FeedbackService service;

    @POST
    public Feedback add(Feedback feedback) {
        log.info("Feedback form got rating from Bausparkasse demo: {}", feedback);
        service.publishFeedback(feedback);
        return feedback;
    }
}