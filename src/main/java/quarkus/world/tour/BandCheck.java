package quarkus.world.tour;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Liveness
public class BandCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.builder()
                .name("let's rock")
                .up()
                .withData("bands", Band.listAll().await().indefinitely().size())
                .build();
    }
}
