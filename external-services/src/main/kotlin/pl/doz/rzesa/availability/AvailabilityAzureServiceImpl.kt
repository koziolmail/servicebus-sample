package pl.doz.rzesa.availability

import com.google.common.base.Stopwatch
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import java.util.function.Function

@Service
class AvailabilityAzureServiceImpl(private val availabilityService: AvailabilityService) : AvailabilityAzureService {
    private val logger: Logger = LoggerFactory.getLogger(AvailabilityAzureServiceImpl::class.java)

    override fun availability(message: AvailabilityMessageDto): AvailabilityDto {
        val stopwatch = Stopwatch.createStarted()
        val productsAvailability: List<ProductAvailabilityDto> = try {
            val productAvailability = availabilityService.processAvailability(message.value)
            logger.info("Availability {}", stopwatch.stop().toString())
            productAvailability
        } catch (ex: Exception) {
            stopwatch.stop()
            logger.error("Availability error", ex)
            emptyList()
        }

        return AvailabilityDto(message.correlationId, stopwatch.elapsed(TimeUnit.MILLISECONDS), productsAvailability)
    }
}
