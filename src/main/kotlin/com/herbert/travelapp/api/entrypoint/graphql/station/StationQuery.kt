package com.herbert.travelapp.api.entrypoint.graphql.station

import com.herbert.graphql.model.FindStationQueryResolver
import com.herbert.graphql.model.SearchStationQueryResolver
import com.herbert.graphql.model.StationOutput
import com.herbert.graphql.model.StationSearchOutput
import com.herbert.travelapp.api.core.station.StationProvider
import org.springframework.stereotype.Controller

@Controller
class StationQuery(
    val stationProvider: StationProvider
) :FindStationQueryResolver, SearchStationQueryResolver {
    override fun findStation(stationId: String?): StationOutput {
        TODO("Not yet implemented")
    }

    override fun searchStation(query: String?): MutableList<StationSearchOutput> {
        TODO("Not yet implemented")
    }
}