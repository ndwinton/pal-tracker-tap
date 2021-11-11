package test.pivotal.pal.tracker;

import org.junit.jupiter.api.Test;

import java.util.Map;
import io.pivotal.pal.tracker.EnvController;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvControllerTest {
    @Test
    public void getEnv() {
        EnvController controller = new EnvController(
            "Felixstowe",
            "James Corden",
            "Piraeus",
            "#42"
        );

        Map<String, String> env = controller.getEnv();

        assertThat(env.get("PORT")).isEqualTo("Felixstowe");
        assertThat(env.get("HOSTNAME")).isEqualTo("James Corden");
        assertThat(env.get("KUBERNETES_PORT")).isEqualTo("Piraeus");
        assertThat(env.get("K_REVISION")).isEqualTo("#42");
    }

}
