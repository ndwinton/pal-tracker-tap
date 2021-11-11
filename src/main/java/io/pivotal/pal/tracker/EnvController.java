package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String hostname;
    private final String kubernetesPort;
    private final String kRevision;

    public EnvController(
        @Value("${port:NOT SET}") String port,
        @Value("${hostname:NOT SET}") String hostname,
        @Value("${kubernetes.port:NOT SET}") String kubernetesPort,
        @Value("${k.revision:NOT SET}") String kRevision
    ) {
        this.port = port;
        this.hostname = hostname;
        this.kubernetesPort = kubernetesPort;
        this.kRevision = kRevision;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("HOSTNAME", hostname);
        env.put("KUBERNETES_PORT", kubernetesPort);
        env.put("K_REVISION", kRevision);

        return env;
    }
}
