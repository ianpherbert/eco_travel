package com.herbert.travelapp.api.entrypoint

import com.herbert.travelapp.api.core.city.City
import com.herbert.travelapp.api.core.city.CityProvider
import com.herbert.travelapp.api.core.flight.Flight
import com.herbert.travelapp.api.core.flight.FlightProvider
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/flights/routes")
class FlightController(
    val flightProvider: FlightProvider,
    val cityProvider: CityProvider
) {

    @GetMapping("/all")
    fun getAllDirectFlights(
        @RequestParam(name = "from", required = true) from: String,
        @RequestParam(name = "fromDate", required = false) fromDate: String?
    ) : List<Flight?> {
        return flightProvider.findAllRoutesFromAirport(from, fromDate ?: formatDate(LocalDate.now()), fromDate?.let { oneDayFromString(it) } ?: formatDate(LocalDate.now().plusDays(1)))
    }

    @GetMapping("/")
    fun getFlightsBetweenCities(
        @RequestParam(name = "to", required = false) to: String,
        @RequestParam(name = "toDate", required = false) toDate: String?,
        @RequestParam(name = "from", required = true) from: String,
        @RequestParam(name = "fromDate", required = false) fromDate: String?
    ): List<Flight?> {
        return flightProvider.findRoutesBetweenCities(from,to,fromDate ?: formatDate(LocalDate.now()),toDate ?: fromDate ?: formatDate(LocalDate.now().plusDays(1)))
    }

    @GetMapping("/test")
    fun testSaveData() : City? {
        return cityProvider.findCityById("62d02351a28bff57433701e5")
    }

    private fun formatDate(date: LocalDate): String {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"))
    }

    private fun oneDayFromString(date: String) : String{
        return formatDate(date.split("/").map{it.toInt()}.let{
            LocalDate.of(it[2],it[1],it[0]).plusDays(1)
        })
    }
}