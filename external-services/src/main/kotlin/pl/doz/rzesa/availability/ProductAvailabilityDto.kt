package pl.doz.rzesa.availability

import java.math.BigDecimal
import java.time.LocalDate

data class ProductAvailabilityDto(val productCentralId: Int,
                                  val deliveryId: Int,
                                  val purchasePriceNetto: BigDecimal,
                                  val vatRate: Int,
                                  val amountAvailable: Int,
                                  val validDate: LocalDate?)