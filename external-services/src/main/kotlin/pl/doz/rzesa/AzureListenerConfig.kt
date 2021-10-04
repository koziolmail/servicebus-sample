package pl.doz.rzesa

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pl.doz.rzesa.availability.AvailabilityAzureService
import pl.doz.rzesa.availability.AvailabilityDto
import pl.doz.rzesa.availability.AvailabilityMessageDto
import java.util.function.Function

@Configuration
class AzureListenerConfig {
    @Bean
    fun availability(service: AvailabilityAzureService): Function<AvailabilityMessageDto, AvailabilityDto> = Function { source -> service.availability(source) }
}