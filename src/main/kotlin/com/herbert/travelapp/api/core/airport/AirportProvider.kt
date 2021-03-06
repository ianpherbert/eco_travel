package com.herbert.travelapp.api.core.airport

interface AirportProvider {

    fun findAirportById(id: String) : Airport?

    fun findAirportByName(name: String) : Airport?

    fun findAirportByIATACode(iata: String) : Airport?

    fun findAirportByICAOCode(icao: String) : Airport?
}