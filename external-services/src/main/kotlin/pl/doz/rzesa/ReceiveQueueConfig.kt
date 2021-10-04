package pl.doz.rzesa

import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClient
import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClientBuilder
import com.azure.messaging.servicebus.administration.models.CreateQueueOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
@ConfigurationProperties(prefix = "spring.cloud.stream")
class ReceiveQueueConfig {
    @Value("\${spring.cloud.azure.servicebus.connection-string}")
    lateinit var connectionString: String

    lateinit var bindings: Map<String, Destination>

    @Bean
    fun managementClient(): ServiceBusAdministrationClient {
        val managementClient = ServiceBusAdministrationClientBuilder().connectionString(connectionString).buildClient()
        bindings.map { bind -> bind.value }
            .forEach { binding -> createQueue(managementClient, binding.destination) }

        return managementClient
    }

    private fun createQueue(managementClient: ServiceBusAdministrationClient, queue: String) {
        if (!managementClient.getQueueExists(queue)) {
            managementClient.createQueue(
                queue,
                CreateQueueOptions()
                    .setDefaultMessageTimeToLive(Duration.ofSeconds(5))
                    .setAutoDeleteOnIdle(null)
            )
        }
    }
}

class Destination {
    var destination: String = ""
}