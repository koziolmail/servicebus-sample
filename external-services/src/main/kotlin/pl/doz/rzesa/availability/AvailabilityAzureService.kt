package pl.doz.rzesa.availability


interface AvailabilityAzureService {
    fun availability(message: AvailabilityMessageDto): AvailabilityDto
}