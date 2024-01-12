package com.github.mkorman9

import io.micrometer.core.instrument.MeterRegistry
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = [])
class StubResource(
    private val meterRegistry: MeterRegistry
) {
    @GET
    fun getStub(): Map<String, String> {
        meterRegistry.counter("requests").increment()

        return mapOf(
            Pair("data", "stub")
        )
    }
}
