package quarkus.world.tour;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Readiness
public class BandCheck implements HealthCheck {

    @Override public HealthCheckResponse call() {
        final int size = Band.listAll().await().indefinitely().size();
        return HealthCheckResponse.builder()
                .name("The bands are in the place!")
                .state(size > 0)
                .withData("bands", size)
                .build();
    }
}
