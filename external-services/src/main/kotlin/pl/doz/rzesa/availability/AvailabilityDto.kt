package pl.doz.rzesa.availability

data class AvailabilityDto(val correlationId: String,
                           val elapsedMillisecond: Long,
                           val products: List<ProductAvailabilityDto>)