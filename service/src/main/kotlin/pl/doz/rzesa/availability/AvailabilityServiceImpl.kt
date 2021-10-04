package pl.doz.rzesa.availability

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
//import javax.transaction.Transactional

@Service
//@Transactional
class AvailabilityServiceImpl(//private val deliveryRepository: DeliveryRepository

) : AvailabilityService {
    override fun processAvailability(productCentralIds: List<Int>): List<ProductAvailabilityDto> {
        return listOf(ProductAvailabilityDto(100, 200, BigDecimal.valueOf(300L), 400, 500, LocalDate.of(2022,12,31)))
        //database connection
        //return deliveryRepository
//                .fetchProductsAvailability(productCentralIds)
//                .map { mapProductAvailabilityDto(it) }
    }
/*
    private fun mapProductAvailabilityDto(it: Delivery): ProductAvailabilityDto {
        return ProductAvailabilityDto(it.product.productCentral!!.id,
                it.id,
                it.purchasePriceInBaseUnit,
                it.product.vatRate.toInt(),
                it.availableStoreQuantity(),
                it.validDate)
    }

 */
}
