package com.ass.observation.ui.screens.main

import com.google.android.gms.maps.model.LatLng

data class ObservationScreenUiState(
    val coordinates: LatLng?,
    val nameOfLocation: String?,
    val date: String?,
) {
    companion object {
        val empty = ObservationScreenUiState(
            coordinates = null,
            nameOfLocation = null,
            date = null
        )
    }
}