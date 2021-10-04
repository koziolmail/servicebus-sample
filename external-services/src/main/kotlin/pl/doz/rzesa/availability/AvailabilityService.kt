package pl.doz.rzesa.availability

interface AvailabilityService {
    fun processAvailability(productCentralIds: List<Int>):List<ProductAvailabilityDto>
}